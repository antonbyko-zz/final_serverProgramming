package Application.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Genre {
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long genreid;
		private String name;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
		private List<Film> films;
		
		public Genre(){}
		
		public Genre(String name){
			this.name = name;
		}

		public Long getGenreid() {
			return genreid;
		}

		public void setGenreid(Long genreid) {
			this.genreid = genreid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Film> getFilms() {
			return films;
		}

		public void setFilms(List<Film> films) {
			this.films = films;
		}

		/*@Override
		public String toString() {
			return "Genre [genreid=" + genreid + ", name=" + name + "]";
		}
		*/

		@Override
		public String toString() {
			return name ;
		}
		
		

		
		
		
}
