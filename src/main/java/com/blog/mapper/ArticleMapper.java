package com.blog.mapper;

import com.blog.Pojo.Article;


public interface ArticleMapper {

    //根据id查询对应的文章
    public Article selectArticle(Integer id);

}
