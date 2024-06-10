package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.entity.Book;
import com.ust.request.BookRequest;
import com.ust.response.BookResponse;
import com.ust.service.ILibraryService;

@RestController
@RequestMapping("library")
public class LibraryController {
	
	@Autowired
	ILibraryService libraryService;
	
	@PostMapping
	public ResponseEntity<BookResponse> saveDetails(@RequestBody BookRequest bookRequest){		
		BookResponse bookResponse = libraryService.saveDetails(bookRequest);
		return new ResponseEntity<>(bookResponse,HttpStatus.OK);	
	}
	@GetMapping
	public ResponseEntity<List<BookResponse>> getDetails(){		
		List<BookResponse> bookResponseList = libraryService.getAllDetails();
		return new ResponseEntity<>(bookResponseList,HttpStatus.OK);	
	}
	@GetMapping("/id")
	public ResponseEntity<BookResponse> getDetailsById(@RequestParam String id){		
		BookResponse bookResponse = libraryService.getDetailsById(id);
		return new ResponseEntity<>(bookResponse,HttpStatus.OK);	
	}
	@PutMapping("/book")
	public ResponseEntity<BookResponse> updateDetailsById(@RequestBody BookRequest bookRequest){		
		BookResponse bookResponse = libraryService.updateDetailsById(bookRequest);
		return new ResponseEntity<>(bookResponse,HttpStatus.OK);	
	}
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<BookResponse> deleteDetailsById(@PathVariable String bookId){		
		BookResponse bookResponse = libraryService.deleteDetailsById(bookId);
		return new ResponseEntity<>(bookResponse,HttpStatus.OK);	
	}

}
