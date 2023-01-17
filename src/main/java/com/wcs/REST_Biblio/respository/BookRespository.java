package com.wcs.REST_Biblio.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.REST_Biblio.entity.Book;

import java.util.List;

@Repository
public interface BookRespository extends JpaRepository<Book, Integer> {

    // custom query to search to blog post by title or content
    List<Book> findByTitleContainingOrAuthorContaining(String text, String textAgain);
    
}
