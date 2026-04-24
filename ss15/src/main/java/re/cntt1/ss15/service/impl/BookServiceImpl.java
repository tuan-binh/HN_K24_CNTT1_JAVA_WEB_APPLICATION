package re.cntt1.ss15.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.cntt1.ss15.model.Book;
import re.cntt1.ss15.repository.IBookRepository;
import re.cntt1.ss15.service.IBookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {
    private final IBookRepository bookRepository;

    @Override
    public Page<Book> getAllManga(String search, Pageable pageable) {
//        if (search.isEmpty()) {
        return bookRepository.findAll(pageable);
//        } else {
//            return bookRepository.searchBook(search);
//        }
    }

}
