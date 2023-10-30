package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book")
    public List<Book> bookList();

    @Select("SELECT * FROM book WHERE bookNo=#{bookNo}")
    public Book bookGet(int bookNo);

    @Select("SELECT COUNT(*) FROM book")
    public int bookCount();

    @Insert("INSERT INTO book(courseNo, title, content, publish, publishDate, author, imageFile, price) VALUES(#{courseNo}, #{title}, #{content}, #{publish}, #{publishDate}, #{author}, #{imageFile}, #{price})")
    public void bookInsert(Book book);

    @Update("UPDATE book SET courseNo=#{courseNo}, title=#{title}, content=#{content}, publish=#{publish}, publishDate=#{publishDate}, author=#{author}, imageFile=#{imageFile}, price=#{price} WHERE bookNo=#{bookNo}")
    public void bookUpdate(Book book);

    @Delete("DELETE FROM book WHERE bookNo=#{bookNo}")
    public void bookDelete(int bookNo);


    @Select("SELECT * FROM book WHERE courseNo=#{courseNo}")
    public List<Book> bookCourseList(int courseNo);
}
