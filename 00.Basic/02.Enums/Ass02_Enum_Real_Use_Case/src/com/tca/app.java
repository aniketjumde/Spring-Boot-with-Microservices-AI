package com.tca;

import com.tca.enums.HttpsStatus;

public class app {

	public static void main(String[] args) 
	{
		
		HttpsStatus h1=HttpsStatus.Ok;
		System.out.println(h1);
		System.out.println("Code : "+h1.getCode());
		System.out.println("Message : "+h1.getMessage());
		System.out.println("----------------------------");
		
		HttpsStatus h2=HttpsStatus.NOT_FOUND;
		System.out.println(h2);
		System.out.println("Code : "+h2.getCode());
		System.out.println("Message : "+h2.getMessage());
		System.out.println("----------------------------");
		
		HttpsStatus h3=HttpsStatus.INTERNAL_SERVER_ERROR;
		System.out.println(h3);
		System.out.println("Code : "+h3.getCode());
		System.out.println("Message : "+h3.getMessage());
		System.out.println("----------------------------");
		
		System.out.println("=============================================");
		for(HttpsStatus h:HttpsStatus.values())
		{
			System.out.println(h+" Code : "+h.getCode()+" Message : "+h.getMessage());
						
		}
	}

}
