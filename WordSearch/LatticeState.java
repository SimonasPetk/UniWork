/**
* LatticeSearch.java
*
*   Lattice State class 
*
*  @author Simonas Petkevičius
*/

import java.util.*;

public class LatticeState extends SearchState{

  // Word for this state
  private WordH word;

  // Subclass Constructor
  public LatticeState(WordH w, int lc){

    word = w;
    localCost = lc;
  }

  // Word Accessor method
  public WordH getWord(){

    return word;
  }

  // The goalP method
  public boolean goalP(Search searcher) {

    LatticeSearch lsearcher = (LatticeSearch) searcher;
    WordLattice lattice = lsearcher.getLattice();

    if(lattice.getEndTime() == word.getEnd()) {
    
      return true;
    }

    return  false; 
  }

  // The getSuccessors method
  public ArrayList<SearchState> getSuccessors (Search searcher) {

    LatticeSearch lsearcher = (LatticeSearch) searcher;
    WordLattice lattice = lsearcher.getLattice();
    LM howLikely = lsearcher.getBigram();
    ArrayList<WordH> hypotheses = lattice.wordsAtT(word.getEnd());
    ArrayList<SearchState> successors = new ArrayList<SearchState>();

    for(WordH h: hypotheses){

      successors.add((SearchState) new LatticeState( h, h.getCost() + howLikely.getCost(word.getWord(), h.getWord() )));
    }

    return successors;
    }

  // The sameState method
  public boolean sameState(SearchState s2) {

    LatticeState ls2 = (LatticeState) s2;
    boolean stateComparison = (word.getWord().compareTo( ls2.getWord().getWord() ) == 0 && word.getCost() == ls2.getWord().getCost());

    return stateComparison;
  }

  // The toString method
  public String toString () {

    String text = "Lattice State: " + word;
    
    return text;
  }



}



