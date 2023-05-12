package com.example.hw1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class scoreDto {
    private String subject;
    private int score;
}
