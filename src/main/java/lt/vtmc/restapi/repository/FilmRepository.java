package lt.vtmc.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.restapi.models.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
