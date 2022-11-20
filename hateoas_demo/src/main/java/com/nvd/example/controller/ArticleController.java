package com.nvd.example.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nvd.example.assembler.ArticleModelAssembler;
import com.nvd.example.model.Article;
import com.nvd.example.service.ArticleService;

@RestController
@RequestMapping("/articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleModelAssembler modelAssembler;

	@GetMapping("/")
	public CollectionModel<EntityModel<Article>> getArticles() {
		List<EntityModel<Article>> listEntityModel = articleService.getArticles().stream().map(modelAssembler::toModel)
				.collect(Collectors.toList());

		CollectionModel<EntityModel<Article>> collectionModel = CollectionModel.of(listEntityModel);

		collectionModel.add(linkTo(methodOn(ArticleController.class).getArticles()).withSelfRel());
		return collectionModel;
	}

	@GetMapping("/{id}/comments")
	public HttpEntity<EntityModel<String>> getComments(@PathParam("id") Integer id) {
		return null;
	}

	@GetMapping("/{id}/tags")
	public HttpEntity<EntityModel<String>> getTags(@PathParam("id") Integer id) {
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Article>> getArticle(@PathParam("id") Integer id) {
		Article article = articleService.getArticle(id);
		EntityModel<Article> model = modelAssembler.toModel(article);
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
}
