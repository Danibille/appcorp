package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>, JpaSpecificationExecutor<Genero>{

}
