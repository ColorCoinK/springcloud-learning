package com.learning.repository;

import com.learning.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Title null.java$
 * @ClassName BookRepository
 * @Description TODO
 * @Author sanss
 * @Date 2019/2/14 14:44
 * @Version 1.0
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}