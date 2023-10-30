package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Book;
import kr.ed.haebeop.persistence.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> bookList() {
        return bookMapper.bookList();
    }

    @Override
    public Book bookGet(int bookNo) {
        return bookMapper.bookGet(bookNo);
    }

    @Override
    public int bookCount() {
        return bookMapper.bookCount();
    }

    @Override
    public void bookInsert(Book book) {
        bookMapper.bookInsert(book);
    }

    @Override
    public void bookUpdate(Book book) {
        bookMapper.bookUpdate(book);
    }

    @Override
    public void bookDelete(int bookNo) {
        bookMapper.bookDelete(bookNo);
    }

    @Override
    public List<Book> bookCourseList(int courseNo) {
        return bookMapper.bookCourseList(courseNo);
    }
}
