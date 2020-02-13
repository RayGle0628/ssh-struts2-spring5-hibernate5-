package org.crazyit.app.domain;

import java.util.*;

import javax.persistence.*;
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
@Entity
@Table(name="person_inf")
public class Person
{
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private int age;
	// Map����Ԫ�������
	@ElementCollection(targetClass=Score.class)
	@CollectionTable(name="score_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@MapKeyColumn(name="subject_name")
	@MapKeyClass(String.class)
	private Map<String , Score> scores
		= new HashMap<>();
	// List����Ԫ�������
	@ElementCollection(targetClass=Name.class)
	@CollectionTable(name="nick_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@OrderColumn(name="list_order")
	private List<Name> nicks
		= new ArrayList<>();

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// age��setter��getter����
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// nicks��setter��getter����
	public void setNicks(List<Name> nicks)
	{
		this.nicks = nicks;
	}
	public List<Name> getNicks()
	{
		return this.nicks;
	}

	// scores��setter��getter����
	public void setScores(Map<String , Score> scores)
	{
		this.scores = scores;
	}
	public Map<String , Score> getScores()
	{
		return this.scores;
	}
}