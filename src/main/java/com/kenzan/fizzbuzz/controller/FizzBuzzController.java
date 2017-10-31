
package com.kenzan.fizzbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kenzan.fizzbuzz.Constants;
import com.kenzan.fizzbuzz.model.ErrorResponse;
import com.kenzan.fizzbuzz.model.FizzBuzzResponse;
import com.kenzan.fizzbuzz.service.FizzBuzzService;

/**
 * 
 * @author meghnaj
 *
 *         REST Controller defining the api endpoint for fizzbuzz service. You
 *         can access it URL /fizzbuzz/{your value} For Ex: /fizzbuzz/50
 *
 */
@RestController
public class FizzBuzzController {

	@Autowired
	@Qualifier("legacy-implementation")
	FizzBuzzService fizzBuzzServiceLegacy;

	/*@Autowired
	@Qualifier("streams-implementation")
	FizzBuzzService fizzBuzzServiceStreams;
*/
	/**
	 * Controller method for fizzbuzz application
	 * 
	 * @param intValue
	 * @return
	 */
	@RequestMapping(value = "/fizzbuzz/{value}")
	public FizzBuzzResponse getFizzBuzz(@PathVariable long value) {

		/**
		 * Calling the fizzbuzz service and returning the result
		 */
		return fizzBuzzServiceLegacy.getFizzBuzz(value);

	}

	/**
	 * handling Exception
	 * 
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(NumberFormatException.class)
	public ErrorResponse conflict() {

		return new ErrorResponse(Constants.INCORRECT_DATA_MESSAGE);
	}

}