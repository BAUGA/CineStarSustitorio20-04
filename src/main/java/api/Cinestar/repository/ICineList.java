package api.Cinestar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import api.Cinestar.model.CineList;

@Repository


public interface ICineList   extends JpaRepository<CineList, Integer> {
	@Query(value ="{call sp_getCines()}", nativeQuery= true)
	List<CineList> getCines();
	

}
