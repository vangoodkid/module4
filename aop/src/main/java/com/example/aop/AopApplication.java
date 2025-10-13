package com.example.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.example.aop.entity.Book;
import com.example.aop.repository.BookRepository;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(BookRepository books) {
		return args -> {
			if (books.count() == 0) {
				Book b1 = new Book();
				b1.setTitle("Clean Code");
				b1.setAuthor("Robert C. Martin");
				b1.setQuantity(2);
				books.save(b1);

				Book b2 = new Book();
				b2.setTitle("Spring in Action");
				b2.setAuthor("Craig Walls");
				b2.setQuantity(1);
				books.save(b2);
			}
		};
	}

}