package com.kenzan.fizzbuzz.service;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.springframework.stereotype.Service;

import com.kenzan.fizzbuzz.model.FizzBuzzResponse;

@Service("streams-implementation")
public class FizzBuzzServiceImplWithStreams implements FizzBuzzService {

	private static final String BUZZ = "Buzz";
	private static final String FIZZ = "Fizz";
	private static final String FIZZ_BUZZ = "FizzBuzz";

	/**
	 * 
	 * Another implementation with java streams api
	 * 
	 */
	
	public FizzBuzzResponse getFizzBuzz(long value) {

		/**
		 * Null check and assigning it 0 in case this value comes as null
		 */

		Long valueInput = Math.abs(Optional.ofNullable(value).orElse(new Long(0)));
		Long number = ;
		boolean negativeFlag = value < 0 ? true : false;

		/**
		 * Initailizing a LongStream then mapping to stream of entries(key,
		 * value) then collecting it by grouping it
		 */
		Map<String, List<Long>> result = LongStream.rangeClosed(1, valueInput).mapToObj(number -> {

			number = negativeFlag ? number * -1 : number;
			boolean isDivisibleBy3 = number % 3 == 0;
			boolean isDivisibleBy5 = number % 5 == 0;

			if (isDivisibleBy3 && isDivisibleBy5) {
				return new AbstractMap.SimpleEntry<String, Long>(FIZZ_BUZZ, number);
			} else if (isDivisibleBy3) {
				return new AbstractMap.SimpleEntry<String, Long>(FIZZ, number);
			} else if (isDivisibleBy5) {
				return new AbstractMap.SimpleEntry<String, Long>(BUZZ, number);
			} else {
				return null;
			}

		}).filter(entry -> entry != null).collect(Collectors.groupingBy(AbstractMap.SimpleEntry<String, Long>::getKey,
				Collectors.mapping(AbstractMap.SimpleEntry<String, Long>::getValue, Collectors.toList())));

		Map<String, List<Long>> result = LongStream.rangeClosed(1, valueInput).mapToObj(myMethod(number, negativeFlag)).filter(entry -> entry != null).collect(Collectors.groupingBy(AbstractMap.SimpleEntry<String, Long>::getKey,
				Collectors.mapping(AbstractMap.SimpleEntry<String, Long>::getValue, Collectors.toList())));

		/**
		 * Creating an elegant response
		 */
		
		FizzBuzzResponse response = new FizzBuzzResponse();

		response.getFizz().addAll(Optional.ofNullable(result.get(FIZZ)).orElse(Arrays.asList()));
		response.getBuzz().addAll(Optional.ofNullable(result.get(BUZZ)).orElse(Arrays.asList()));
		response.getFizzBuzz().addAll(Optional.ofNullable(result.get(FIZZ_BUZZ)).orElse(Arrays.asList()));

		return response;
	}

	public SimpleEntry<String, Long> myMethod(long number, boolean negativeFlag)
	{
		number = negativeFlag ? number * -1 : number;
		boolean isDivisibleBy3 = number % 3 == 0;
		boolean isDivisibleBy5 = number % 5 == 0;

		if (isDivisibleBy3 && isDivisibleBy5) {
			return new AbstractMap.SimpleEntry<String, Long>(FIZZ_BUZZ, number);
		} else if (isDivisibleBy3) {
			return new AbstractMap.SimpleEntry<String, Long>(FIZZ, number);
		} else if (isDivisibleBy5) {
			return new AbstractMap.SimpleEntry<String, Long>(BUZZ, number);
		} else {
			return null;
		}
		
	}
	
}