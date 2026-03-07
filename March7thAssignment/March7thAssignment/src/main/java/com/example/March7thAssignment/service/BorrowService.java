package com.example.March7thAssignment.service;

import com.example.March7thAssignment.entity.Book;
import com.example.March7thAssignment.entity.BorrowRecord;
import com.example.March7thAssignment.entity.User;
import com.example.March7thAssignment.repo.BookRepository;
import com.example.March7thAssignment.repo.BorrowRecordRepository;
import com.example.March7thAssignment.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowRecord borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available");
        }

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturnDate(null); // not returned yet
        record.setReturned(false);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRecordRepository.save(record);
    }

    public List<BorrowRecord> findAll() {
        return borrowRecordRepository.findAll();
    }
}
