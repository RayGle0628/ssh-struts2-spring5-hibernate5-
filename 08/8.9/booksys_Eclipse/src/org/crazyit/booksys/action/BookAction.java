package org.crazyit.booksys.action;

import java.util.List;

import org.crazyit.booksys.domain.Book;
import org.crazyit.booksys.service.BookService;

import com.opensymphony.xwork2.ActionSupport;
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
public class BookAction extends ActionSupport
{
	private BookService bookService;
	// ����ע��BookService��������setter������
	// �÷����ķ�����Ҫ��BookService������id��Ӧ
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	private Book book;
	private List<Book> books;
	private int id;
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}

	public List<Book> getBooks()
	{
		return books;
	}
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	// �������ͼ���add()����
	public String add()
	{
		// ����ҵ���߼������addBook()�����������û�����
		bookService.addBook(book);
		int result = book.getId();
		if(result > 0)
		{
			addActionMessage("��ϲ����ͼ����ӳɹ���");
			return SUCCESS;
		}
		addActionError("ͼ�����ʧ�ܣ����������룡");
		return ERROR;
	}
	public String list()
	{
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}
	public String delete()
	{
		bookService.deleteBook(id);
		return SUCCESS;
	}
}
