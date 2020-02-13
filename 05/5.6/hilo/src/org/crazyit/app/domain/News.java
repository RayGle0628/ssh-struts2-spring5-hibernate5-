package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
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
@Table(name="news_inf")
public class News
{
	// ��Ϣ��ı�ʶ����
	@Id @Column(name="news_id")
	// ʹ��@GenericGenerator����������������
	// ��������������Ϊfk_hilo��ʹ��Hibernate��hilo���ԣ�
	@GenericGenerator(name="fk_hilo",
		strategy="org.hibernate.id.MultipleHiLoPerTableGenerator")
	// ָ��ʹ��fk_hilo����������
	@GeneratedValue(generator="fk_hilo")
	private Integer id;
	// ��Ϣ����
	private String title;
	// ��Ϣ����
	private String content;

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// title��setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// content��setter��getter����
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}
}