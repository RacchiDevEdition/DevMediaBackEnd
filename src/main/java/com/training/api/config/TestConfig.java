package com.training.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.api.models.Category;
import com.training.api.models.News;
import com.training.api.repositories.CategoryRepository;
import com.training.api.repositories.NewsRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		News n1 = new News(null, "Super notícia", "Realmente, é uma super notícia");
		News n2 = new News(null, "Titulo", "Realmente, é um título épico");
		News n3 = new News(null, "Incrível!!! Veja hoje", "Realmente, verei hoje");
		News n4 = new News(null, "Massa demais, vejam isso", "Realmente, macarrão é uma massa");
		News n5 = new News(null, "Cansei de exemplos", "Realmente, cansei de exemplos");


		Category c1 = new Category(null, "Notícias Interessantes");
		Category c2 = new Category(null, "ClickBait");

		n1.getCategory().add(c2);
		n2.getCategory().add(c2);
		n3.getCategory().add(c2);
		n4.getCategory().add(c1);
		n5.getCategory().add(c1);
		c1.getNews().add(n1);
	
		categoryRepository.saveAll(Arrays.asList(c1, c2));
		newsRepository.saveAll(Arrays.asList(n1, n2, n3, n4, n5));


	}
}
