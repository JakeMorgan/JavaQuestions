package com.accenture.JavaQuestions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageQuestionDTO {
    private List<QuestionDTO> questionDTOList;
    private Pageable pageable;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pageable{
        private Integer totalPages;
        private Long totalElements;
        private Integer number;
    }
}
