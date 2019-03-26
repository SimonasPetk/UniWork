/**
*	LatticeSearch.java
*
*	LatticeSearch class that speficies WordLattice to search in
*
*  @author Simonas Petkevičius
*/

import java.util.*;

public class LatticeSearch extends Search {

  // Instance variables
  private WordLattice lattice; // WordLattice we're searching
  private LM bigram; // bigram language model

  /**
  * Search subclass's LatticeSearch Constructor
  * @param L WordLattice to search in
  * @param b bigram language model of the lattice
  */
  public LatticeSearch(WordLattice l, LM b){

    lattice = l;
    bigram = b;
  }

  // Lattice Search Accessor methods
  /**
  * returns the lattice 
  * @return WordLattice lattice
  */
  public WordLattice getLattice(){

    return lattice;
  }
  
  /**
  * returns the bigram language model
  * @return LM bigram
  */
  public LM getBigram(){

    return bigram;
  }
}







