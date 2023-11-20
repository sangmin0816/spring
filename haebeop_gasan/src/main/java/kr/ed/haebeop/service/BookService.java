package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Book;
import java.util.List;
public interface BookService {
    public List<Book> bookList();
    public Book bookGet(int bookNo);
    public int bookCount();
    public void bookInsert(Book book);
    public void bookUpdate(Book book);
    public void bookDelete(int bookNo);

    public List<Book> bookCourseList(int courseNo);
}
