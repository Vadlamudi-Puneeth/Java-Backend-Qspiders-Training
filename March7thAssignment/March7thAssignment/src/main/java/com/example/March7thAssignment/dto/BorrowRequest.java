package com.example.March7thAssignment.dto;

import lombok.Data;

@Data
public class BorrowRequest {
    private Long userId;
    private Long bookId;
}
