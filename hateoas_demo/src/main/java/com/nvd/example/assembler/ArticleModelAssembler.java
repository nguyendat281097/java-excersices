package com.nvd.example.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.nvd.example.controller.ArticleController;
import com.nvd.example.model.Article;

@Component
public class ArticleModelAssembler implements RepresentationModelAssembler<Article, EntityModel<Article>> {

	@Override
	public EntityModel<Article> toModel(Article entity) {
		EntityModel<Article> articleModel = EntityModel.of(entity);
		 
		articleModel.add(linkTo(methodOn(ArticleController.class).getArticle(entity.getId())).withSelfRel());
		articleModel.add(linkTo(methodOn(ArticleController.class).getArticles()).withRel(IanaLinkRelations.COLLECTION));
	     
		articleModel.add(linkTo(methodOn(ArticleController.class).getComments(entity.getId())).withRel("comments"));
	     
		articleModel.add(linkTo(methodOn(ArticleController.class).getTags(entity.getId())).withRel("tags"));
		return articleModel;
	}
}