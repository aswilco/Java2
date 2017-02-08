/*
 * Building.java
 *
 * Copyright 2017 Aaron Wilcoxon <Aaron Wilcoxon@HOSTNAME>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


public class Building {

private int squareFeet;
private int numWindows;
protected String location;

public Building(){
	squareFeet = 1000;
	numWindows = 4;
	location = "Baltimore";
}

public Building(int squareFeet, int numWindows, String location){
	this.squareFeet = squareFeet;
	this.numWindows = numWindows;
	this.location = location;
}

public String toString() {
	return "Square Feet: " + squareFeet
	+ ", Location: " + location
	+ ", Number of Windows: " + numWindows;
}

}
