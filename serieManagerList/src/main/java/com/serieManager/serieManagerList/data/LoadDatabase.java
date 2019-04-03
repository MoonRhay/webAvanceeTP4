package com.serieManager.serieManagerList.data;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.serieManager.serieManagerList.app.Serie;
import com.serieManager.serieManagerList.app.SerieRepository;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(SerieRepository repository) {
		return args -> {
			System.out.println("Preloading " + repository.save(new Serie("Breaking Bad","4", "Walter White","VO")));
			//System.out.println("Preloading " + repository.save(new Serie("Arrow","10", "Mickey Mouse","VO")));
		};
	}
}
