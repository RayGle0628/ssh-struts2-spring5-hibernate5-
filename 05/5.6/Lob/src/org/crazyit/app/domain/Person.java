package org.crazyit.app.domain;

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
	@Id // �������α�ʶ����
	// ָ���������е��������ɲ���
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// @Columnָ��������ӳ�������Ϣ���˴�ָ��������������
	@Column(name="person_name" , length=50)
	private String name;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(nullable=true)
	private byte[] pic;

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

	// pic��setter��getter����
	public void setPic(byte[] pic)
	{
		this.pic = pic;
	}
	public byte[] getPic()
	{
		return this.pic;
	}
}