package com.tca;

import com.tca.enums.Gender;

public class Demo 
{
	public static void main(String args[])
	{
		Gender g=Gender.MALE;
		System.out.println(g);
		System.out.println(g.getValue());
		System.out.println(g.ordinal());
		
		Gender m=Gender.FEMALE;
		System.out.println(m);
		System.out.println(m.getValue());
		System.out.println(m.ordinal());
		
		Gender o=Gender.OTHER;
		System.out.println(o);
		System.out.println(o.getValue());
		System.out.println(o.ordinal());
		
		Gender gender = Gender.MALE;

		switch (gender) {
		    case MALE:
		        System.out.println("Male");
		        break;

		    case FEMALE:
		        System.out.println("Female");
		        break;

		    case OTHER:
		        System.out.println("Other");
		        break;
		}
	}

}
