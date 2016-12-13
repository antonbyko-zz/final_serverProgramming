package Application;


	
	import static org.assertj.core.api.Assertions.assertThat;

	import java.util.List;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.test.context.junit4.SpringRunner;

	import Application.domain.Genre;
	import Application.domain.Film;
	import Application.domain.FilmRepository;

	@RunWith(SpringRunner.class)
	@DataJpaTest
	public class FilmRepositoryTest {

	    @Autowired
	    private FilmRepository repository;

	    @Test
	    public void findByMovieNameShouldReturnFilm() {
	        List<Film> films = repository.findByMovieName("Interstellar");
	        
	        assertThat(films).hasSize(1);
	        assertThat(films.get(0).getAuthor()).isEqualTo("Christopher Nolan");
	        assertThat(films.get(0).getRelease_date()).isEqualTo("2014");
	    }
	    
	    @Test
	    public void createNewStudent() {
	    	Film film = new Film("The Godfather", "Francis Ford Coppola", "1972" ,"USA", new Genre("Crime"));
	    	repository.save(film);
	    	assertThat(film.getId()).isNotNull();
	    }    

	}


