package com.blog.Repository;

import com.blog.Pojo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,String> {

    // 根据城市信息查询对应的人
    List<Person> findByAddress_City(String name);
}
