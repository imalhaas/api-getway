package br.com.erudio.apigetway.Repository;

import br.com.erudio.apigetway.Model.PersonVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonVO, Long> {
}
