package it.iad2.repository4;

import it.iad2.model4.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryQuattro extends JpaRepository<Messaggio, Long> {

    public Messaggio findByTesto(String s);

}
