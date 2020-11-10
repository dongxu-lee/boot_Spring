package com.ldx.springboot_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // 开启基于注解的缓存管理支持
@SpringBootApplication
public class SpringbootCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCacheApplication.class, args);
	}

}
