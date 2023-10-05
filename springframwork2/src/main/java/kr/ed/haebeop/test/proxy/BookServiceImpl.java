package kr.ed.haebeop.test.proxy;

import org.springframework.stereotype.Service;
//구현체
@Service
public class BookServiceImpl implements BookService {
    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }
}
