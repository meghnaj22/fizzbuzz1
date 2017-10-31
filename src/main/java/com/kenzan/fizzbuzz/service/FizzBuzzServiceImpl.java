package com.kenzan.fizzbuzz.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kenzan.fizzbuzz.model.FizzBuzzResponse;

/**
 * Service class handling logic for fizzbuzz application.
 * 
 * 
 * @author meghna
 *
 */

@Service("legacy-implementation")
public class FizzBuzzServiceImpl implements FizzBuzzService {

	/**
	 * 
	 * Method for evaluating fizzbuzz result.
	 * 
	 */
	
	public FizzBuzzResponse getFizzBuzz(long value) {

		/**
		 * Null check for the incorrect/null values entered, update to 0
		 */
		long valueInput = Optional.ofNullable(value).orElse(new Long(0));

		FizzBuzzResponse response = new FizzBuzzResponse();

		/**
		 *  To evaluate fizzbuzz iterating over the integer value. Input integer value negative or
		 * positive handled
		 */
		for (long i = valueInput >= 0 ? 1 : -1; valueInput >= 0 ? i <= valueInput
				: i >= valueInput; i = valueInput >= 0 ? i + 1 : i - 1) {

			boolean isDivisibleBy3 = i % 3 == 0;
			boolean isDivisibleBy5 = i % 5 == 0;

			if (isDivisibleBy3 && isDivisibleBy5) {
				response.getFizzBuzz().add(i);
			} else if (isDivisibleBy3) {
				response.getFizz().add(i);
			} else if (isDivisibleBy5) {
				response.getBuzz().add(i);
			}
		}

		return response;
	}

}