package re.cntt1.ss15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import re.cntt1.ss15.model.Book;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,String> {

    // Method Query
    // Hành động + By + Thuộc tính + Điều kiện

    List<Book> findAllByTitleContainsOrAuthorContains(String title,String author);

    // Custom Query (JPQL)
    @Query("""
        SELECT b FROM Book b WHERE
            b.title LIKE concat('%',:search,'%') OR
            b.author LIKE concat('%',:search,'%')
    """)
    List<Book> searchBook(@Param("search") String search);

}
