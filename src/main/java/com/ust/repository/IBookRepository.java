package com.ust.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.entity.Book;
@Repository
public interface IBookRepository extends MongoRepository<Book, String>{

}
