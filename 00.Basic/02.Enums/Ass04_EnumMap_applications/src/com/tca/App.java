package com.tca;

import java.util.EnumMap;

import com.tca.enums.Signal;

public class App 
{
	 public static void main(String[] args)
	 {
		 EnumMap<Signal,Integer> duration=new EnumMap<>(Signal.class);
		 duration.put(Signal.RED, 60);
		 duration.put(Signal.YELLOW, 5);
		 duration.put(Signal.GREEN, 45);

	 }

}
