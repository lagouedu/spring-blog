package com.blog.springblog;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.CommentMapper;
import com.blog.Pojo.Address;
import com.blog.Pojo.Article;
import com.blog.Pojo.Comment;
import com.blog.Pojo.Person;
import com.blog.Repository.CommentRepository;
import com.blog.Repository.PersonRepository;
import com.blog.Repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringblogApplicationTests {


    @Autowired
    private CommentMapper commentMapper;

    @Test
    void contextLoads() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }


    @Autowired
    private ArticleMapper articleMapper;


    @Test
    public void selectArticle(){
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }


    //测试整合JPA
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void selectComment(){
        Optional<Comment> byId = commentRepository.findById(1);
        if(byId.isPresent()){}
        System.out.println(byId.get());
    }


    //测试整合redis
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void savePerson(){
        Person person = new Person();
        person.setFirstname("张");
        person.setLastname("三");

        Address address = new Address();
        address.setCity("北京");
        address.setCountry("中国");
        person.setAddress(address);

        // 向redis数据库中添加了数据
        personRepository.save(person);

    }

    @Test
    public void selectPerson(){
        List<Person> list = personRepository.findByAddress_City("北京");
        for (Person person : list) {
            System.out.println(person);
        }


    }


    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void articleRepository() {
        Optional<Article> article = articleRepository.findById(1);
        if (article.isPresent()) {
            System.out.println(article);
        } else {
            System.out.println("No article with id 1!");
        }
    }

    @Test
    void articleRepositoryFindAll() {
        List<Article> articles = articleRepository.findAll();
        for (Article article : articles) {
            System.out.println(article);
        }
    }
}
