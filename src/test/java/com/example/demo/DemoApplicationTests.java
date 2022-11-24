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
		dsl.createTable("table")
      .column("col1", INTEGER)
      .execute();
	}

}
