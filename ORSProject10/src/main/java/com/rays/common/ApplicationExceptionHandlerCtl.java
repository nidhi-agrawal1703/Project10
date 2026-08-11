package com.rays.common;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 
 * @author Nidhi
 *
 */

@RestControllerAdvice
public class ApplicationExceptionHandlerCtl {
		
		//All Database Related Problems
		@ExceptionHandler({
			CannotCreateTransactionException.class,
			DataAccessException.class,
			JDBCConnectionException.class
		})
		public ResponseEntity<ORSResponse> handleDatabaseException(Exception e){
			
			ORSResponse res=new ORSResponse(false);
			res.addMessage("Database Server Down.Please Try Again");
			return ResponseEntity
	                .status(HttpStatus.SERVICE_UNAVAILABLE)   // 503
	                .body(res);
		}
		
		//All Other Runtime Exception
		@ExceptionHandler(RuntimeException.class)
		public ResponseEntity<ORSResponse> handleRuntimeException(Exception e){
			e.printStackTrace(); // Print the actual exception

			
			ORSResponse res=new ORSResponse(false);
		res.addMessage(e.getMessage());
			return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	               .body(res);
		}
}
