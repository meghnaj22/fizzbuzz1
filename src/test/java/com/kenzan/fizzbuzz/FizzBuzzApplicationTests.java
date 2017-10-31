package com.kenzan.fizzbuzz;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kenzan.fizzbuzz.controller.FizzBuzzController;
import com.kenzan.fizzbuzz.model.FizzBuzzResponse;
import com.kenzan.fizzbuzz.service.FizzBuzzService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzApplicationTests {

	@Mock
	private FizzBuzzService fizzBuzzServiceStreams;

	@Mock
	private FizzBuzzService fizzBuzzServiceLegacy;

	@InjectMocks
	private FizzBuzzController controller;

	@Autowired
	@Qualifier("streams-implementation")
	private FizzBuzzService fizzBuzzTest;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		if (fizzBuzzServiceStreams != null) {
			FizzBuzzResponse response = new FizzBuzzResponse();
			response.getFizz().add(new Long(3));
			when(fizzBuzzServiceStreams.getFizzBuzz(3)).thenReturn(response);

			this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		}
	}

	/**
	 * Controller test
	 * 
	 * @throws Exception
	 *//*

	@Test
	public void testFizzBuzzController() throws Exception {

		mockMvc.perform(get("/fizzbuzz/3")).andExpect(status().isOk()).andExpect(jsonPath("$.Fizz").value(3));

		verify(fizzBuzzServiceStreams, atLeastOnce()).getFizzBuzz(3);
	}

	*//**
	 * 
	 * Controller wrong data test
	 * 
	 * @throws Exception
	 *//*

	@Test
	public void testFizzBuzzControllerForWrongData() throws Exception {

		mockMvc.perform(get("/fizzbuzz/xxxxxx")).andExpect(status().isConflict())
				.andExpect(jsonPath("$.message").value(Constants.IMPROPER_DATA_MSG));
	}

	*//**
	 * 
	 * Testing Fizz Buzz Service with positive integer input
	 *//*

	@Test
	public void testFizzBuzzServiceWithPositiveNumbers() {

		FizzBuzzResponse response = fizzBuzzTest.getFizzBuzz(15);

		Assert.assertArrayEquals(new Long[] { new Long(3), new Long(6), new Long(9), new Long(12) },
				response.getFizz().toArray());
		Assert.assertArrayEquals(new Long[] { new Long(5), new Long(10) }, response.getBuzz().toArray());
		Assert.assertArrayEquals(new Long[] { new Long(15) }, response.getFizzBuzz().toArray());
	}

	*//**
	 * 
	 * Testing Fizz Buzz Service with negative integer input
	 */

	@Test
	public void testFizzBuzzServiceWithNegativeNumbers() {

		FizzBuzzResponse response = fizzBuzzTest.getFizzBuzz(-15);

		Assert.assertArrayEquals(new Long[] { new Long(-3), new Long(-6), new Long(-9), new Long(-12) },
				response.getFizz().toArray());
		Assert.assertArrayEquals(new Long[] { new Long(-5), new Long(-10) }, response.getBuzz().toArray());
		Assert.assertArrayEquals(new Long[] { new Long(-15) }, response.getFizzBuzz().toArray());
	}

}