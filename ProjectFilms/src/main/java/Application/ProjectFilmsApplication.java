package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import Application.domain.Film;
import Application.domain.FilmRepository;
import Application.domain.GenreRepository;
import Application.domain.UserRepository;
import Application.domain.User;
import Application.domain.Genre;





@SpringBootApplication
public class ProjectFilmsApplication {
		private static final Logger log = LoggerFactory.getLogger(ProjectFilmsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjectFilmsApplication.class, args);
	}

	@Bean
	public CommandLineRunner FilmDemo(FilmRepository repository, GenreRepository grepository,UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of films");
			grepository.save(new Genre("Science fiction"));
			grepository.save(new Genre("Action"));
			grepository.save(new Genre("Comedy"));
			grepository.save(new Genre("Adventure"));
			grepository.save(new Genre("Drama"));
			grepository.save(new Genre("Horror"));
			grepository.save(new Genre("Westernce"));
		
			repository.save(new Film( "Interstellar", "Christopher Nolan", "2014","USA" , grepository.findByName("Drama").get(0)));
			
			
			// create users, admin and guest
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all students");
			for (Film film : repository.findAll()) {
				log.info(film.toString());
			}

		};
	}
}



