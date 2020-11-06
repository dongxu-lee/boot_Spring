package com.ldx.springboot_data.repository;

import com.ldx.springboot_data.pojo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {

    // 根据城市查人
    List<Person> findByAddress_City(String name);

}
