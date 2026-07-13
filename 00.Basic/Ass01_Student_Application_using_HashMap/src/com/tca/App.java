package com.tca;

public class App {

	public static void main(String[] args) 
	{
		StudentManager studentManager=new StudentManager();
		studentManager.creation();
		studentManager.displayAll();
		
		
		Student student=studentManager.getById("RBT03");
		
		if(student==null)
		{
			System.out.println("Student not found");
		}
		else
		{
			System.out.println("Student found "+student.getId()+"-->"+student.getName()+"-->"+student.getPer());
			

		}
	}

}
