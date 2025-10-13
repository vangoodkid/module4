package com.example.aop.service;

import com.example.aop.entity.Book;
import com.example.aop.entity.BorrowTicket;
import com.example.aop.repository.BookRepository;
import com.example.aop.repository.BorrowTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;

import static com.example.aop.service.LibraryException.InvalidTicketException;
import static com.example.aop.service.LibraryException.OutOfStockException;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowTicketRepository ticketRepository;

    private  SecureRandom random = new SecureRandom();


    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }

    @Transactional
    public String borrowBook(Long bookId) {
        Book book = getBook(bookId);
        if (book.getQuantity() <= 0) {
            throw new LibraryException.OutOfStockException("Sách đã hết, không thể mượn");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String code = generateCode();
        BorrowTicket ticket = new BorrowTicket();
        ticket.setBook(book);
        ticket.setCode(code);
        ticketRepository.save(ticket);
        return code;
    }

    @Transactional
    public void returnBook(String code) {
        List<BorrowTicket> tickets = ticketRepository.findByCode(code);
        if (tickets.isEmpty()) {
            throw new LibraryException.InvalidTicketException("Mã mượn sách không hợp lệ");
        }
        BorrowTicket ticket = tickets.get(0);
        Book book = ticket.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        ticketRepository.delete(ticket);
    }

    private String generateCode() {
        int num = random.nextInt(100000); // 0..99999
        return String.format("%05d", num);
    }
}
