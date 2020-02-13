package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.*;
//import org.hibernate.service.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import org.hibernate.tool.schema.*;
import java.util.*;
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
public class NewsManager
{
	public static void main(String[] args) throws Exception
	{
		// Hibernate 5.x����Hibernate�ı�׼��ʽ
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			// configure()����Ĭ�ϼ���hibernate.cfg.xml�ļ�
			.configure()
			.build();
		Metadata metadata = new MetadataSources(registry)
			.buildMetadata();
		// ʹ��Metadata����SessionFactory
		metadata.buildSessionFactory();
		// ����SchemaExport����
		SchemaExport se = new SchemaExport();
		// ���������ʽ���õ�SQL�ű�
		se.setFormat(true)
			// ���ñ���SQL�ű����ļ���
			.setOutputFile("new.sql")
			// ���SQL�ű�
			.create(EnumSet.of(TargetType.SCRIPT), metadata);
	}
}
