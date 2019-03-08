/*
 * Line.java  	1.1 30/01/2018
 * 
 * This is a template for problem sheet 1
 *
 * Copyright (c) University of Sheffield 2019
 */

/** 
* Line.java
*  
* @version 1.2 19/02/2019
* 
* @author Maria-Cruz Villa-Uriol
* @author Simonas Petkevicius
*/
//package uk.ac.sheffield.com1003.problemsheet1;

public class Line {

	// instance variables
	private int xStart;
	private int yStart;
	private int xEnd;
	private int yEnd;

	/**
    * Constructor
    * @param x1 Line's start x coordinate
    * @param y1 Line's start y coordinate
    * @param x2 Line's end x coordinate
    * @param y2 Line's end y coordinate
    */
	public Line( int x1, int y1, int x2, int y2 ){
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;
	}
	
	/**
    * Gets line's start x coordinate
    * @return start x coordinate
    */
	public int getStartPointX(){

		return xStart;
	}
	/**
    * Gets line's start y coordinate
    * @return start y coordinate
    */
	public int getStartPointY(){

		return yStart;
	}
	/**
    * Gets line's end x coordinate
    * @return end x coordinate
    */
	public int getEndPointX(){

		return xEnd;
	}
	/**
    * Gets line's end y coordinate
    * @return end y coordinate
    */
	public int getEndPointY(){

		return yEnd;
	}
	/**
    * Gets line's length
    * @return line's rounded length
    */
	public double getLength(){

		return Math.round(Math.sqrt(Math.pow((xEnd - xStart), 2) + Math.pow((yEnd - yStart), 2)));
	}

	/**
    * Sets new line's start points
    * @param x1 new wanted x start coordinate
    * @param y1 new wanted y start coordinate
    */
	public void setStartPoint( int x1, int y1 ){

		xStart = x1;
		yStart = y1;
	}
	/**
    * Sets new line's start points
    * @param x1 new wanted x end coordinate
    * @param y1 new wanted y end coordinate
    */
	public void setEndPoint( int x1, int y1 ){

		xEnd = x1;
		yEnd = y1;
	}
}