package com.ldx.springboot_data;

import com.ldx.springboot_data.mapper.ArticleMapper;
import com.ldx.springboot_data.mapper.CommentMapper;
import com.ldx.springboot_data.pojo.Address;
import com.ldx.springboot_data.pojo.Article;
import com.ldx.springboot_data.pojo.Comment;
import com.ldx.springboot_data.pojo.Person;
import com.ldx.springboot_data.repository.CommentRepository;
import com.ldx.springboot_data.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

//@RunWith(SpringRunner.class) //这是JUnit4里的配置，可以把依赖去掉不使用它
@SpringBootTest
class SpringbootDataApplicationTests {

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
	public void testSelectArticle() {
		Article article = articleMapper.selectArticle(1);
		System.out.println(article);
	}

	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void jpa() {
		Optional<Comment> byId = commentRepository.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void redis() {
		Person person = new Person();
		person.setFirstname("涨");
		person.setLastname("三");

		Address address = new Address();
		address.setCity("北京");
		address.setCountry("中国");
		person.setAddress(address);

		personRepository.save(person);
	}

	@Test
	public void redis2() {
		List<Person> list = personRepository.findByAddress_City("北京");
		for (Person person : list) {
			System.out.println(person);
		}
	}

}
