package jison.ApparelSpringApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(ApparelRepository apparelRepository) {
		return args -> {
			apparelRepository.save(new Apparel("Camo Head White/Black", "Bape", Size.L, Type.CLOTHING));
			apparelRepository.save(new Apparel("Air Force 1 White Low", "Nike", Size.SZ9, Type.FOOTWEAR));
			apparelRepository.findAll().forEach(apparel -> log.info("Loaded: " + apparel));
		};
	}

}
