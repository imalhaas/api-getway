package br.com.erudio.apigetway.Repository;

import br.com.erudio.apigetway.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
