/**
* LatticeSearch.java
*
*   Lattice State class 
*
*  @author Simonas Petkevičius
*/

import java.util.*;

public class LatticeState extends SearchState{

  // instance variables
  // Word for this state
  private WordH word;

  /**
  * SearchState subclass's LatticeState Constructor
  * @param w word for this state
  * @param lc local word costs
  */
  public LatticeState(WordH w, int lc){

    word = w;
    localCost = lc;
  }

  // LatticeState Accessor methods
  /**
  * returns the word of the current state
  * @return WordH the current's state word
  */
  public WordH getWord(){

    return word;
  }

  // LatticeState methods
  /**
  * The goalP method 
  * @param searcher Search class object
  * @return boolean returns if the goal of the searcher is reached
  */
  public boolean goalP(Search searcher) {

    LatticeSearch lsearcher = (LatticeSearch) searcher;
    WordLattice lattice = lsearcher.getLattice();

    if(lattice.getEndTime() == word.getEnd()) {
    
      return true;
    }

    return  false; 
  }

  /**
  * The getSuccessors method, get all possible successors of the word
  * @param searcher Search class object
  * @return ArrayList of type SearchState that has all of the possible successors of the word
  */
  public ArrayList<SearchState> getSuccessors (Search searcher) {

    LatticeSearch lsearcher = (LatticeSearch) searcher;
    WordLattice lattice = lsearcher.getLattice();
    ArrayList<WordH> hypotheses = lattice.wordsAtT(word.getEnd());
    ArrayList<SearchState> successors = new ArrayList<SearchState>();
    LM howLikely = lsearcher.getBigram();

    for(WordH h: hypotheses){

      successors.add((SearchState) new LatticeState( h,
                                                     h.getCost() +
                                                     howLikely.getCost(word.getWord(),
                                                     h.getWord() )));
    }

    return successors;
    }

  /**
  * The sameState method, compares two states ad returns if they are the same
  * @param s2 SearchState class object
  * @return boolean value true if the state is the same, false otherwise
  */
  public boolean sameState(SearchState s2) {

    LatticeState ls2 = (LatticeState) s2;
    boolean stateComparison = (word.getWord().compareTo( ls2.getWord().getWord() ) == 0 &&
                               word.getCost() == ls2.getWord().getCost());

    return stateComparison;
  }

  /**
  * toString method of the class
  * @return String of the current Lattice state
  */
  public String toString () {

    String text = "Lattice State: " + word;
    
    return text;
  }



}



