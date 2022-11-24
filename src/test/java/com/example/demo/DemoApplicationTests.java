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
		System.out.println(">>> test 1");
	}

	@Test
	void doSomethingWithTheDatatabaseWithJooq() {
		System.out.println(">>> test 2");

		dsl.dropTableIfExists("users").execute();
		var x = dsl.createTable("users")
				.column("id", INTEGER)
				.column("name", VARCHAR)
				// .primaryKey("id")
				.execute();

		System.out.println(">>> createTable: " + x);

	}

}
