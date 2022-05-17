package lt.vtmc.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.restapi.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
