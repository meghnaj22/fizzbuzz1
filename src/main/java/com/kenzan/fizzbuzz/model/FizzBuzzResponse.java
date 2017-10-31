package com.kenzan.fizzbuzz.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FizzBuzzResponse {

	@JsonProperty("Fizz")
	private List<Long> fizz;

	@JsonProperty("Buzz")
	private List<Long> buzz;

	@JsonProperty("FizzBuzz")
	private List<Long> fizzBuzz;

	public FizzBuzzResponse() {
		super();
		this.fizz = new ArrayList<Long>();
		this.buzz = new ArrayList<Long>();
		this.fizzBuzz = new ArrayList<Long>();
	}

	public List<Long> getFizz() {
		return fizz;
	}

	public void setFizz(List<Long> fizz) {
		this.fizz = fizz;
	}

	public List<Long> getBuzz() {
		return buzz;
	}

	public void setBuzz(List<Long> buzz) {
		this.buzz = buzz;
	}

	public List<Long> getFizzBuzz() {
		return fizzBuzz;
	}

	public void setFizzBuzz(List<Long> fizzBuzz) {
		this.fizzBuzz = fizzBuzz;
	}

}