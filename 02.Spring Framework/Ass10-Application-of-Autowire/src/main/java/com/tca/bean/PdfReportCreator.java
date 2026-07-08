package com.tca.bean;

public class PdfReportCreator implements ReportCreator
{

	@Override
	public void create() 
	{
		System.out.println("Pdf Report Generated");		
	}

}
