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
// ��������SQL��ѯ
@NamedNativeQueries({
// ����һ������SQL��ѯ��������ΪsimpleQuery
@NamedNativeQuery(name="simpleQuery"
	// ָ������SQL��ѯ��Ӧ��SQL���
	, query="select s.student_id , s.name from student_inf s"
	// ָ������ѯ���ת��ΪStudentʵ��
	, resultClass=Student.class),
// ����һ������SQL��ѯ��������ΪqueryTest
@NamedNativeQuery(name="queryTest"
	// ����SQL���
	, query="select s.*,e.*,c.* from student_inf s,enrolment_inf e,"
	+ " course_inf c where s.student_id = e.student_id and"
	+ " e.course_code = c.course_code and e.year=:targetYear"
	// ָ��ʹ����ΪfirstMapping��@SqlResultSetMapping��ɽ��ӳ��
	, resultSetMapping = "firstMapping"),
// ����һ�����ô洢���̵�����SQL��ѯ
@NamedNativeQuery(name="callProcedure"
	, query="{call select_all_student()}"
	, resultSetMapping = "secondMapping")
})
@SqlResultSetMappings({
@SqlResultSetMapping(name="firstMapping"
	, entities={@EntityResult(entityClass=Student.class),
		@EntityResult(entityClass=Enrolment.class),
		@EntityResult(entityClass=Course.class , fields=
		{
			@FieldResult(name="courseCode" , column="c.course_code"),
			@FieldResult(name="name" , column="c.name")
		})
	}
	, columns={@ColumnResult(name="s.name" , type=String.class)}
),
@SqlResultSetMapping(name="secondMapping"
	, entities={@EntityResult(entityClass=Student.class , fields=
		{
			@FieldResult(name="studentNumber" , column="student_id"),
			@FieldResult(name="name" , column="name")
		})
	})
})
@Entity
@Table(name="student_inf")
public class Student
{
	// ����ѧ��ѧ�ŵĳ�Ա����������Ϊ��ʶ����
	@Id @Column(name="student_id")
	private Integer studentNumber;
	// ����ѧ�������ĳ�Ա����
	private String name;
	// ��ѧ��������ѡ�μ�¼��Ӧ�Ĺ���ʵ��
	@OneToMany(targetEntity=Enrolment.class
		, mappedBy="student" , cascade=CascadeType.REMOVE)
	private Set<Enrolment> enrolments
		= new HashSet<>();

	// �޲����Ĺ�����
	public Student()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Student(Integer studentNumber , String name)
	{
		this.studentNumber = studentNumber;
		this.name = name;
	}

	// studentNumber��setter��getter����
	public void setStudentNumber(Integer studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	public Integer getStudentNumber()
	{
		return this.studentNumber;
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

	// enrolments��setter��getter����
	public void setEnrolments(Set<Enrolment> enrolments)
	{
		this.enrolments = enrolments;
	}
	public Set<Enrolment> getEnrolments()
	{
		return this.enrolments;
	}
}