package com.belong.ms.customer.details.api;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApiError {
	private String errorId;
	private String message;
	private String details;
	
	public ApiError(HttpStatus status) { this.errorId = String.valueOf(status.value()); }
	
	public ApiError(HttpStatus status, Throwable ex) {
		this(status);
		this.message = ex.getMessage();
	}
	
	public ApiError(HttpStatus status, Throwable ex, String details) {
		this(status, ex);
		this.details = details;
	}

}
