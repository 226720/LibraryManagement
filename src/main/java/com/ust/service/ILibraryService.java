package com.ust.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.request.BookRequest;
import com.ust.response.BookResponse;

@Service
public interface ILibraryService {

	BookResponse saveDetails(BookRequest bookRequest);

	List<BookResponse> getAllDetails();

	BookResponse getDetailsById(String id);

	BookResponse updateDetailsById(BookRequest bookRequest);

	BookResponse deleteDetailsById(String bookId);

}
