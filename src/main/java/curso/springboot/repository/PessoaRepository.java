package curso.springboot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.PessoaModel;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<PessoaModel, Long>{

	@Query("select p from PessoaModel p where p.nome like %?1%")
	List<PessoaModel> findByName(String nome);
}
