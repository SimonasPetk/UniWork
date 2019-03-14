 /**
   * RunLatticeSearchTest.java
   *
   * Test harness for
   * @author <a href="mailto: "Phil Green</a>
   * modified by Simonas Petkevicius
   * for test harness
   *
 */

import sheffield.*;
import java.util.*;

public class RunLatticeSearchTest {

  public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    // create a WordLattice

    WordLattice latt= new WordLattice();

    // download the word lattice data from file

    latt.latticeFromFile("latt1.txt");

    // exaample vocabulary for Language Model

    String [] vocab= {"please","lettuce","know","flea","use","throw","freeze","let","useless","us"};

    // example costMatrix for LM

    int [][] costs ={{500,100, 80,120, 20, 40, 60, 20,120, 30},
                     { 50,500,100,120, 90, 60, 90, 70,110,120},
                     { 50, 80,500, 90,100, 80, 70, 80,100, 40},
                     { 60,120,110,500,100, 90, 80, 60,100,100},
                     { 30, 70, 80, 90,500, 50,100, 70, 90, 40},
                     { 50, 60, 90, 80, 80,500,120, 90,100, 40},
                     { 60, 80,120,100,110,100,500, 70,120, 70},
                     { 70, 50, 70, 60, 40, 80, 90,500, 90, 20},
                     {100, 90, 80, 60, 80, 40, 90, 80,500, 90},
                     { 20,100, 60,100, 70, 60, 80, 40, 90,500}};

    // create a bigram language model
    LM bg = new LM(vocab,costs);

    // once you've written LatticeSearch you can create an instance like so
    // a LatticeSearch is defined by the lattice and LM

    LatticeSearch lsearch = new LatticeSearch(latt,bg);

    // Testing LatticeSearch if it got all the information
    System.out.println("Test for LatticeSearch: \nBigram model: " + bg +
                      "\nLattice:\n" + latt.toString());

    System.out.println("\nRecieving Bigram model from lsearch: " + lsearch.getBigram() + 
                       "\nRecieving Lattice from lsearch: \n" + lsearch.getLattice());

    // Test for LatticeState for goalP and sameState methods

    LatticeState testState1 = new LatticeState(new WordH("test",0,latt.getEndTime(),30),0);
    LatticeState testState2 = new LatticeState(new WordH("test2",0,0,20),0);
    LatticeState testState3 = new LatticeState(new WordH("*start*",0,0,0),0);

    System.out.println("Test for Lattice State: \nLatticeState word should get \"test 0 36 30\": " + testState1.getWord());

    System.out.println("LatticeState check for goal should return \"true\": "
                        + testState1.goalP(lsearch));
    System.out.println("LatticeState check for goal should return \"false\": "
                        + testState2.goalP(lsearch)); 

    System.out.println("LatticeState check if testState2 and testState3" +
                        " have the same state should return \"false\": "
                        + testState2.sameState(testState3));
    System.out.println("LatticeState check if testState3 and testState2" +
                       " have the same state should return \"false\": "
                        + testState3.sameState(testState2));
    System.out.println("LatticeState check if testState1 and testState1" +
                       " have the same state should return \"true\": "
                        + testState1.sameState(testState1));
  }
}










