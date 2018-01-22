package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@RestController //相当于同时添加@Controller和@ResponseBody注解。
//@EnableAutoConfiguration

@SpringBootApplication
@EnableJpaAuditing
public class ShopApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		
	}


}
