package com.rnd.backendspring;

import com.rnd.backendspring.dao.CategoryDao;
import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackendSpringApplicationTests {

//	@Autowired
//	private CategoryService categoryService;
//
	@Test
	public void contextLoads() {
//		String categoryName = "algoritma";
//		List<CategoryBook> cb = categoryService.findCategoryByName(categoryName);
//		assert cb.isEmpty();
	}

}
