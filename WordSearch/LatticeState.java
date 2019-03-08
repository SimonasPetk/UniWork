/**
* LatticeSearch.java
*
*   Lattice state class 
*
*  @author Simonas Petkevičius
*/

import java.util.*;

public class LatticeState extends SearchState{

  //word for this state
  private WordH word;

  //constructor
  public LatticeState(WordH w, int lc){
    word = w;
    localCost = lc;
  }
  //accessor
  public WordH getWord(){
    return word;
  }

  // goalP
  public boolean goalP(Search searcher) {
    LatticeSearch lsearcher = (LatticeSearch) searcher;
    //System.out.println(localCost);
    WordLattice lattice = lsearcher.getLattice();
    if(lattice.getEndTime() == word.getEnd()) {
      return true;
    }
    return  false; 
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    LatticeSearch lsearcher = (LatticeSearch) searcher;
    WordLattice lattice = lsearcher.getLattice();
    LM howLikely = lsearcher.getBigram();
    ArrayList<WordH> hypotheses = lattice.wordsAtT(word.getEnd());
    ArrayList<SearchState> succs = new ArrayList<SearchState>();

    for (WordH h: hypotheses){

      //System.out.println( "  1word:  " +word.getWord() + " 2Word: " + h.getWord() +"  Bigram COST:  " + howLikely.getCost(word.getWord(), h.getWord() ));
      succs.add((SearchState)new LatticeState(h,h.getCost() + howLikely.getCost(word.getWord(), h.getWord() )));
    }
    return succs;
    }

  // sameState

  public boolean sameState(SearchState s2) {
    LatticeState ls2= (LatticeState) s2;

    //System.out.println(word.getWord() + " ==" + ls2.getWord().getWord() + " is it the same? " + (word.getWord().compareTo(ls2.getWord().getWord())==0));

    return (word.getWord().compareTo(ls2.getWord().getWord())==0);
  }


// toString
    public String toString () {
      return ("Lattice State: "+word);
    }



}



