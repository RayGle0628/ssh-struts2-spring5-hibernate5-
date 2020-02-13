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
	// ��ʶ����
	private Integer id;
	private String name;
	private int age;
	// ���򼯺�����
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="training_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@Column(name="training_name" , nullable=false)
	@OrderBy("training_name desc")
	private Set<String> trainings
		= new HashSet<>();

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
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

	// trainings��setter��getter����
	public void setTrainings(Set<String> trainings)
	{
		this.trainings = trainings;
	}
	public Set<String> getTrainings()
	{
		return this.trainings;
	}
}