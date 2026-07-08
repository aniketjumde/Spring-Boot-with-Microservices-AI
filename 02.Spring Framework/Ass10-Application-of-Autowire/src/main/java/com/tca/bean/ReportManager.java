package com.tca.bean;

public class ReportManager 
{
	private ReportCreator reportCreator;

	


	public void setReportCreator(ReportCreator reportCreator)
	{
		this.reportCreator = reportCreator;
		System.out.println("Setter Injection");
	}
	
	public void printReport()
	{
		reportCreator.create();
	}
}
