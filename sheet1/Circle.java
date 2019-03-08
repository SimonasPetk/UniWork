/*
 * Circle.java  	1.2 30/01/2019
 * 
 * This is a template for problem sheet 1
 * 
 * Copyright (c) University of Sheffield 2019
 */

/** 
* Circle.java
* 
* 
* @version 1.2 19/02/2019
* 
* @author Maria-Cruz Villa-Uriol/Richard Clayton
* @author Simonas Petkevicius
*/

//package uk.ac.sheffield.com1003.problemsheet1;

public class Circle {

	// instance variables
	private double radius;
	private int xPosition;
	private int yPosition;

	/**
    * Constructor
    * @param r circle radius
    * @param x x coordinate of circle center
    * @param y y coordinate of circle center
    */
	public Circle( double r, int x, int y ){
		radius = r;
		xPosition = x;
		yPosition = y;
	}
	
	/**
    * Gets circle radius
    * @return circle radius
    */
	public double getRadius(){

		return radius;
	}
	/**
    * Gets x coordinate of the circle center
    * @return x coordinate of the circle center
    */
	public int getPositionX(){

		return xPosition;
	}
	/**
    * Gets y coordinate of the circle center
    * @return y coordinate of the circle center
    */
	public int getPositionY(){

		return yPosition;
	}
	/**
    * Sets new circle radius
    * @param newRadius new wanted circle radius
    */
	public void setRadius( double newRadius ){
		
		radius = newRadius;
	}
	/**
    * Sets new circle center coordinates
    * @param newX new wanted circle x coordinate
    * @param newY new wanted circle y coordinate
    */
	public void setPosition( int newX, int newY ){
		
		xPosition = newX;
		yPosition = newY;
	}	
}