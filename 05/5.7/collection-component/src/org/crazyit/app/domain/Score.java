package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.Parent;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Embeddable
public class Score
{
	// ����first��Ա����
	@Column(name="score_level")
	private String level;
	// ����last��Ա����
	@Column(name="score_mark")
	private Integer mark;
	// ����ӵ�и�Name��Person����
	@Parent
	private Person owner;

	// �޲����Ĺ�����
	public Score()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Score(String level , Integer mark)
	{
		this.level = level;
		this.mark = mark;
	}

	// level��setter��getter����
	public void setLevel(String level)
	{
		this.level = level;
	}
	public String getLevel()
	{
		return this.level;
	}

	// mark��setter��getter����
	public void setMark(Integer mark)
	{
		this.mark = mark;
	}
	public Integer getMark()
	{
		return this.mark;
	}

	// owner��setter��getter����
	public void setOwner(Person owner)
	{
		this.owner = owner;
	}
	public Person getOwner()
	{
		return this.owner;
	}

}