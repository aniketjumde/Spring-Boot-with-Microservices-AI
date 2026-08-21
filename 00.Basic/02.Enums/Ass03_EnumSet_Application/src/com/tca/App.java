package com.tca;

import java.util.EnumSet;

import com.tca.enums.Day;

public class App {

	public static void main(String[] args) 
	{
		
		//Requirement : Weekends Day
		//But enums give only one vale
		//thats the Collections are used 
		//EnumSet Internally used Bit-Vector
		
		EnumSet<Day> set=EnumSet.of(Day.SATURDAY,Day.SUNDAY);
		System.out.println(set);
		
		EnumSet<Day> remaining=EnumSet.complementOf(set);
		System.out.println(remaining);
		
		EnumSet<Day> s=EnumSet.allOf(Day.class);
		
		for(Day d:s)
		{
			System.out.println(d);
		}
		
		EnumSet<Day> x=EnumSet.noneOf(Day.class);
		System.out.println(x);
	}

}
