 package lee;

import org.springframework.expression.*;
import org.springframework.expression.spel.standard.*;
import org.springframework.expression.spel.support.*;
import org.springframework.expression.common.TemplateParserContext;

import java.util.*;

import org.crazyit.app.domain.*;
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
public class SpELTest
{
	public static void main(String[] args)
	{
		// ����һ��ExpressionParser�������ڽ������ʽ
		ExpressionParser parser = new SpelExpressionParser();

		// ʹ��ֱ�������ʽ
//		Expression exp = parser.parseExpression("'Hello World'");
//		System.out.println(exp.getValue(String.class));
//		exp = parser.parseExpression("0.23");
//		System.out.println(exp.getValue(Double.class));

		//------------ʹ��SpEL��������-----------
//		// ����һ������
//		Expression exp = parser.parseExpression(
//			"new String[]{'java' , 'Struts' , 'Spring'}");
//		System.out.println(exp.getValue());
//		// ������ά����
//		exp = parser.parseExpression(
//			"new int[2][4]");
//		System.out.println(exp.getValue());


		//------------ʹ��SpEL����List����-----------
//		Expression exp = parser.parseExpression(
//			"{'java' , 'Struts' , 'Spring'}");
//		System.out.println(exp.getValue());
//		// ��������ά��List����
//		exp = parser.parseExpression(
//			"{{'���Java����' , '���Android����'}, {'��' , 'ս����'}}");
//		System.out.println(exp.getValue());

		//------------ʹ��SpEL����List���ϡ�Map���ϵ�Ԫ��-----------
//		List<String> list = new ArrayList<String>();
//		list.add("Java");
//		list.add("Spring");
//		Map<String, Double> map =
//			new HashMap<String, Double>();
//		map.put("Java" , 80.0);
//		map.put("Spring" , 89.0);
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// ������������
//		ctx.setVariable("mylist" , list);
//		ctx.setVariable("mymap" , map);
//		// ����List���ϵĵڶ���Ԫ��
//		System.out.println(parser
//			.parseExpression("#mylist[1]").getValue(ctx));
//		// ����Map���ϵ�ָ��Ԫ��
//		System.out.println(parser
//			.parseExpression("#mymap['Java']").getValue(ctx));

		//------------ʹ��SpEL���÷���-----------
//		// ����String�����substring()����
//		System.out.println(parser
//			.parseExpression("'HelloWorld'.substring(2, 5)")
//			.getValue());
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("struts");
//		list.add("spring");
//		list.add("hibernate");
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// ����һ������
//		ctx.setVariable("mylist" , list);
//		// ����ָ������������Ķ����subList()����
//		System.out.println(parser
//			.parseExpression("#mylist.subList(1, 3)").getValue(ctx));

		//------------��SpEL��ʹ�������-----------
//		List<String> list = new ArrayList<String>();
//		list.add("java");
//		list.add("struts");
//		list.add("spring");
//		list.add("hibernate");
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		// ����һ������
//		ctx.setVariable("mylist" , list);
//		// �Լ��ϵĵ�һ��Ԫ�ؽ��и�ֵ
//		parser.parseExpression("#mylist[0]='���Java����'")
//			.getValue(ctx);
//		// ���潫��� ���Java����
//		System.out.println(list.get(0));
//		// ʹ����Ŀ�����
//		System.out.println(parser.parseExpression("#mylist.size()>3?"
//			+ "'myList���ȴ���3':'myList���Ȳ�����3'")
//			.getValue(ctx));

		//------------��SpEL��ʹ�����������-----------
//		//����Math�ľ�̬����
//		System.out.println(parser.parseExpression(
//			"T(java.lang.Math).random()").getValue());
//		//����Math�ľ�̬����
//		System.out.println(parser.parseExpression(
//			"T(System).getProperty('os.name')").getValue());

		//------------��SpEL�е��ù�����-----------
//		// ��������
//		System.out.println(parser.parseExpression(
//			"new String('HelloWorld').substring(2, 4)")
//			.getValue());
//		// ��������
//		System.out.println(parser.parseExpression(
//			"new javax.swing.JFrame('����')"
//			+ ".setVisible('true')").getValue());

		//------------��SpEL��ʹ�ð�ȫ��������-----------
//		// ʹ�ð�ȫ�����������null
//		System.out.println("----" + parser.parseExpression(
//			"#foo?.bar").getValue());
//		// ��ʹ�ð�ȫ������������NullPointerException
//		System.out.println(parser.parseExpression(
//			"#foo.bar").getValue());

//		//------------��SpEL�жԼ��Ͻ���ѡ��-----------
//		List<String> list = new ArrayList<String>();
//		list.add("���Java����");
//		list.add("���Ajax����");
//		list.add("���iOS����");
//		list.add("����Java EE��ҵӦ��ʵս");
//		// ����һ��EvaluationContext������ΪSpEL����������������
//		EvaluationContext ctx = new StandardEvaluationContext();
//		ctx.setVariable("mylist" , list);
//		// �жϼ���Ԫ��length()�����ĳ��ȴ���7�������iOS���塱���޳�
//		Expression expr = parser.parseExpression
//			("#mylist.?[length()>7]");
//		System.out.println(expr.getValue(ctx));
//		Map<String, Double> map = new HashMap<String ,Double>();
//		map.put("Java" , 89.0);
//		map.put("Spring" , 82.0);
//		map.put("Ӣ��" , 75.0);
//		ctx.setVariable("mymap" , map);
//		// �ж�Map���ϵ�valueֵ����80��ֻ����ǰ��2��Entry
//		expr = parser.parseExpression
//			("#mymap.?[value>80]");
//		System.out.println(expr.getValue(ctx));

		//------------��SpEL�жԼ��Ͻ���ͶӰ-----------
		List<String> list = new ArrayList<String>();
		list.add("���Java����");
		list.add("���Ajax����");
		list.add("���iOS����");
		list.add("����Java EE��ҵӦ��ʵս");
		// ����һ��EvaluationContext������ΪSpEL����������������
		EvaluationContext ctx = new StandardEvaluationContext();
		ctx.setVariable("mylist" , list);
		// �õ����¼��ϵ�Ԫ����ԭ���ϵ�ÿ��Ԫ��length()��������ֵ
		Expression expr = parser.parseExpression
			("#mylist.![length()]");
		System.out.println(expr.getValue(ctx));
		List<Person> list2 = new ArrayList<Person>();
		list2.add(new Person(1, "�����" , 162));
		list2.add(new Person(2, "��˽�" , 182));
		list2.add(new Person(3, "ţħ��" , 195));
		ctx.setVariable("mylist2" , list2);
		// �õ����¼��ϵ�Ԫ����ԭ���ϵ�ÿ��Ԫ��name����ֵ
		expr = parser.parseExpression
			("#mylist2.![name]");
		System.out.println(expr.getValue(ctx));

		//------------��SpEL��ʹ�ñ��ʽģ��-----------
//		Person p1 = new Person(1, "�����" , 162);
//		Person p2 = new Person(2, "��˽�" , 182);
//		Expression expr = parser.parseExpression(
//			"�ҵ�������#{name},�����#{height}"
//			, new TemplateParserContext());
//		// ��ʹ��p1����name��height���������ʽģ���е�#{}
//		System.out.println(expr.getValue(p1));
//		// ��ʹ��p2����name��height���������ʽģ���е�#{}
//		System.out.println(expr.getValue(p2));

	}
}