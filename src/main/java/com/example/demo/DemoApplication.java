package com.example.demo;

import java.util.Date;
import java.util.List;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

  @Autowired private DSLContext dsl;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @GetMapping("/authors")
  public @ResponseBody List<Author> authors() {
    var authorsResult = dsl.select().from("flyway_test.author").fetch();
    var authors = authorsResult.into(Author.class);
    return authors;
  }

  @GetMapping("/books")
  public @ResponseBody List<Book> books() {
    var booksResult = dsl.select().from("flyway_test.book").fetch();
    var books = booksResult.into(Book.class);
    return books;
  }

  public record Book(Integer id, Integer author_id, Integer title) {}
  ;

  public record Author(
      Integer id,
      String firstName,
      String lastName,
      Date dateOfBirth,
      Integer yearOfBirth,
      String address) {}
  ;
}
