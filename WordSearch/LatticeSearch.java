/**
*	LatticeSearch.java
*
*	search through lattice class
*
*  @author Simonas Petkevičius
*/

import java.util.*;

public class LatticeSearch extends Search {

  private WordLattice lattice; // WordLattice we're searching
  private LM bigram; // bigram language model

  public WordLattice getLattice(){
    return lattice;
  }
  
  public LM getBigram(){
    return bigram;
  }

  public LatticeSearch(WordLattice l, LM b){
    lattice=l;
    bigram=b;
  }
}







