package com.example.demo;

import static org.jooq.impl.SQLDataType.*;
import org.jooq.*;
import org.jooq.impl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DSLContext dsl;

	@Test
	void contextLoads() {

	}

	@Test
	void doSomethingWithTheDatatabaseWithJooq() {
		dsl.dropTableIfExists("users").execute();
		var x = dsl.createTable("users")
				.column("id", INTEGER)
				.column("name", VARCHAR)
				// .primaryKey("id")
				.execute();

		System.out.println(x);

	}

}
