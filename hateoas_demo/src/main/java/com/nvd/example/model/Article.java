package com.nvd.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private Integer id;
    private String content;
    private String publishedDate;
    private Integer authorId;
}
