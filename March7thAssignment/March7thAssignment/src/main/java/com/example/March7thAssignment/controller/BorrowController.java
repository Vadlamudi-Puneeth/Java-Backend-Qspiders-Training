package com.example.March7thAssignment.controller;

import com.example.March7thAssignment.dto.BorrowRequest;
import com.example.March7thAssignment.entity.BorrowRecord;
import com.example.March7thAssignment.service.BorrowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@RequiredArgsConstructor
@Tag(name = "Borrowing", description = "Book borrowing and tracking APIs")
@SecurityRequirement(name = "basicAuth")
public class BorrowController {

    private final BorrowService borrowService;

    @Operation(summary = "Borrow a book", description = "Record that a user has borrowed a specific book")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book borrowed successfully"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @PostMapping
    public BorrowRecord borrowBook(@RequestBody BorrowRequest request) {
        return borrowService.borrowBook(request.getUserId(), request.getBookId());
    }

    @Operation(summary = "Get all borrow records", description = "Fetch all the books that have been borrowed")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden")
    })
    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowService.findAll();
    }
}
