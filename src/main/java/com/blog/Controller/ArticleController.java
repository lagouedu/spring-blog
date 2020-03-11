package com.blog.Controller;

import com.blog.Pojo.Article;
import com.blog.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping("/")
    public String index(Model model, Integer pageNum) {

        if (pageNum == null) {
            pageNum = 1;
        }
        Pageable pageable = PageRequest.of(pageNum - 1, 4, Sort.by("id"));

        Page<Article> page = articleRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "client/index";
    }
}
