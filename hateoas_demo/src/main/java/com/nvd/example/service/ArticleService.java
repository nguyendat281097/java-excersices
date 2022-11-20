package com.nvd.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nvd.example.model.Article;

@Service
public class ArticleService {
	public static List<Article> articles = new ArrayList<>();
	static {
		for (int i = 0; i < 10; i++) {
			articles.add(createDefaultData(i));
		}
	}

	private static Article createDefaultData(Integer id) {
		Article article = new Article();
		article.setId(id);
		article.setContent("HATEOAS example by Dat Nguyen");
		article.setPublishedDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		article.setAuthorId(1);
		return article;

	}

	public List<Article> getArticles() {
		return articles;
	}
	
	public Article getArticle(int id) {
		return articles.get(id);
	}
	
}
