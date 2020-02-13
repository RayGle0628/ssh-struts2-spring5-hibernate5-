package org.crazyit.app.dto;

/**
 * Description:<br>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a><br>
 * Copyright (C), 2001-2018, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 * @author Yeeku.H.Lee kongyeeku@163.com<br>
 * @version 1.0
 */
public class EnrolmentDto
{
	private int year;
	private int sem;
	public EnrolmentDto(int year, int sem)
	{
		this.year = year;
		this.sem = sem;
	}

	// year��setter��getter����
	public void setYear(int year)
	{
		this.year = year;
	}
	public int getYear()
	{
		return this.year;
	}

	// sem��setter��getter����
	public void setSem(int sem)
	{
		this.sem = sem;
	}
	public int getSem()
	{
		return this.sem;
	}
}
