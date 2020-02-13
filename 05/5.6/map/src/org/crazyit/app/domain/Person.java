package org.crazyit.app.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import org.hibernate.annotations.CollectionType;
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
	// �������ԣ������ö�������Ŀ��Գɼ�
	@ElementCollection(targetClass=Float.class)
	// ӳ�䱣�漯�����Եı�
	@CollectionTable(name="score_inf", // ָ������Ϊscore_inf
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@MapKeyColumn(name="subject_name")
	// ָ��Map key������ΪString����
	@MapKeyClass(String.class)
	// ӳ�䱣��Map value��������
	@Column(name="mark")
	private Map<String , Float> scores
		= new HashMap<>();

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

	// scores��setter��getter����
	public void setScores(Map<String , Float> age)
	{
		this.scores = scores;
	}
	public Map<String , Float> getScores()
	{
		return this.scores;
	}
}