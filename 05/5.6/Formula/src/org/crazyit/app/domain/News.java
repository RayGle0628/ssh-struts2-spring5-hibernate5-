package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.Formula;
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// ��Ϣ����
	private String title;
	// ��Ϣ����
	private String content;
	// ��Ϣȫ�����ݣ���ϵͳ���ݹ�ʽ����
	@Formula("(select concat(nt.title,nt.content)"
		+ "from news_inf nt where nt.id= id)")
	private String fullContent;

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

	// fullContent��setter��getter����
	public void setFullContent(String fullContent)
	{
		this.fullContent = fullContent;
	}
	public String getFullContent()
	{
		return this.fullContent;
	}
}