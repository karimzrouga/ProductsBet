package com.products_bet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products_bet.MODEL.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
