package api.Cinestar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.Cinestar.model.Cine;

@Repository

public interface ICine extends JpaRepository<Cine, Integer> {
	@Query (value = "{call sp_getCine(:id)}", nativeQuery = true)
	Cine getCine(int id);

}
