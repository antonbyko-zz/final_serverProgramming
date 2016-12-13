package Application.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Application.domain.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {
	List<Film> findByMovieName(String movieName);
}


