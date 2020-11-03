package com.accenture.JavaQuestions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageableDTO {
    private Integer totalPages;
    private Long totalElements;
    private Integer number;
}