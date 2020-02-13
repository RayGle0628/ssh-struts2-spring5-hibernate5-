package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Loader;
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
// ����insert��SQL���
@SQLInsert(sql="insert into news_inf(content , title) values(upper(?), ?)")
// ����update��SQL���
@SQLUpdate(sql="update news_inf set content=upper(?), title=? where news_id=?")
// ����delete��SQL���
@SQLDelete(sql="delete from news_inf where news_id=?")
// ����ɾ������ʵ���SQL���
@SQLDeleteAll(sql="delete from news_inf")
// ָ��ʹ��news_loader������ѯ��Ϊ���Ʋ�ѯ�Ĳ�ѯ���
@Loader(namedQuery = "news_loader")
// ����һ������SQL��ѯ
@NamedNativeQuery(name="news_loader"
	, query="select news_id , concat('===' , concat(title , '===')) as title"
		+ " , content from news_inf n where news_id=?"
	, resultClass = News.class)
@Entity
@Table(name="news_inf")
public class News
{
	@Id @Column(name="news_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
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