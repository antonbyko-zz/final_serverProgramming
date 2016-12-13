package Application.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    public String movieName;
    private String author;
    private String release_date;
    private String country;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "genreid")
    private Genre genre;
    
    
	public Film(String movieName, String author, String release_date,String country,Genre genre) {
		super();
		
		this.movieName = movieName;
		this.author = author;
		this.release_date = release_date;
		this.country = country;
		this.genre = genre;
	}
	
	public Film(){}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getmovieName() {
		return movieName;
	}

	public void setmovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    @Override
    public String toString() {
    if (this.genre != null)
       return "Film [id=" + id + ", movieName=" + movieName + ", author=" + author + ", release_date=" + release_date
       + ", country=" + country + ", genre=" + this.genre+ "]";
    else
       return "Film [id=" + id + ", movieName=" + movieName + ", author=" + author + ", release_date=" + release_date
       + ", country=" + country + "]";                          
    }
    
    


}
