package re.cntt1.ss15.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import re.cntt1.ss15.model.Book;

import java.util.List;

public interface IBookService {

    Page<Book> getAllManga(String search, Pageable pageable);

}
