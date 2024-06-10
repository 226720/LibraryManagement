package com.ust.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ust.constants.BookConstants;
import com.ust.entity.Book;
import com.ust.exception.BookAPIException;
import com.ust.repository.IBookRepository;
import com.ust.request.BookRequest;
import com.ust.response.BookResponse;
@Service
public class LibraryServiceImpl implements ILibraryService {
	
	@Autowired
	IBookRepository bookRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public BookResponse saveDetails(BookRequest bookRequest) {	
		
		Book book = new Book();
		book.setBookId(bookRequest.getBookId());
		book.setBookName(bookRequest.getBookName());
		book.setIssuedDate(LocalDate.now());
		book.setExpiredDate(LocalDate.now().plusDays(14));
		bookRepository.save(book);
		BookResponse bookResponse = new BookResponse();
		bookResponse= modelMapper.map(book, BookResponse.class);
		return bookResponse;
	}

	@Override
	public List<BookResponse> getAllDetails() {
		List<Book> bookList = bookRepository.findAll();		
		List<BookResponse> response = bookList.stream().map(x -> {
			BookResponse bookResponse = new BookResponse();
            modelMapper.map(x, bookResponse);
            return bookResponse;
        }).collect(Collectors.toList());		
		return response;
	}

	@Override
	public BookResponse getDetailsById(String id) {
		Optional<Book> bookCheck = bookRepository.findById(id);
		Book bookExists = null;
		if(bookCheck.isPresent()) {
			bookExists = bookCheck.get();
		}
		BookResponse bookResponse = new BookResponse();
		bookResponse = modelMapper.map(bookExists, BookResponse.class);
		return bookResponse;
	}

	@Override
	public BookResponse updateDetailsById(BookRequest bookRequest) {
		Optional<Book> bookCheck = bookRepository.findById(bookRequest.getBookId());
		Book bookExists = null;
		if(bookCheck.isPresent()) {
			bookExists = bookCheck.get();
			bookExists.setBookName(bookRequest.getBookName());
			bookExists.setStudent(bookRequest.getBookName());
		}
		BookResponse bookResponse = new BookResponse();
		bookResponse = modelMapper.map(bookExists, BookResponse.class);
		return bookResponse;
	}

	@Override
	public BookResponse deleteDetailsById(String bookId) {
		Optional<Book> bookCheck = bookRepository.findById(bookId);
		if(bookCheck.isPresent()) {
			bookRepository.deleteById(bookId);
		}
		else
			throw new BookAPIException(BookConstants.DELETED,HttpStatus.CONFLICT);
		BookResponse bookResponse = new BookResponse();
		bookResponse = modelMapper.map(bookCheck, BookResponse.class);
		return bookResponse;
	}

}
