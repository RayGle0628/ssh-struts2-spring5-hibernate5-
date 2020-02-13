package org.crazyit.app.domain;

import java.util.*;

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
public class Address
{
	// �����ַ��ϸ��Ϣ�ĳ�Ա����
	@Column(name="address_detail")
	private String addressDetail;
	// ���������������ڵİ���ʵ��
	@Parent
	private Person person;
	// ���屣������ʵ���Set����
	@OneToMany(targetEntity=School.class)
	// ӳ������У��˴�����Hibernate��Schoolʵ���Ӧ�ı������������
	// ������е�����Ϊaddress_id������person_inf���peron_id������
	@JoinColumn(name="address_id", referencedColumnName="person_id")
	private Set<School> schools
		= new HashSet<>();

	public Address(){}

	public Address(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}

	// addressDetail��setter��getter����
	public void setAddressDetail(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}
	public String getAddressDetail()
	{
		return this.addressDetail;
	}

	// person��setter��getter����
	public void setPerson(Person person)
	{
		this.person = person;
	}
	public Person getPerson()
	{
		return this.person;
	}

	// schools��setter��getter����
	public void setSchools(Set<School> schools)
	{
		this.schools = schools;
	}
	public Set<School> getSchools()
	{
		return this.schools;
	}
}