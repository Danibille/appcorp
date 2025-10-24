package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer>, JpaSpecificationExecutor<Editora> {

}