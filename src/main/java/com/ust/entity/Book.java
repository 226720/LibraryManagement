package com.ust.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book")
public class Book {
	@Id
	private String bookId;
	private String bookName;
	private String student;
	private LocalDate issuedDate;
	private LocalDate expiredDate;
	
	

}
