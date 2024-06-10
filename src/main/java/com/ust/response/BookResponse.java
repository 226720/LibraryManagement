package com.ust.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
	private String bookId;
	private String bookName;
	private LocalDate issuedDate;

}
