package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private QuoteRepository quoteRepository;

	@Test
	@DisplayName("Database has 5 quotes")
	void databaseHas5Quotes() {
		Assertions.assertThat(this.quoteRepository.findAll()).hasSize(5);
	}
}
