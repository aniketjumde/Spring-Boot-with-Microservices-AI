package com.tca;

import java.util.HashMap;
import java.util.Map;

public class StudentManager 
{
	
    HashMap<String, Student> map = new HashMap<>();

	public void creation()
	{
		map.put("RBT01",new Student(101,"Pradeep jadhav",85.67));
		map.put("RBT02",new Student(101,"Kaushal Agale",55.87));
		map.put("RBT03",new Student(101,"Omkar kshirsagar",95.27));
		map.put("RBT04",new Student(101,"Suyash Divate",65.67));
		map.put("RBT05",new Student(101,"Anuj Sawant",88.27));
		map.put("RBT06",new Student(101,"Shubham Desai",75.66));

	}
	
	public void displayAll()
	{
        System.out.println("Student Details");

        for (Map.Entry<String, Student> entry : map.entrySet()) 
        {

            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }	
    }
	
	public Student getById(String key) {

        return map.get(key);
    }

}
