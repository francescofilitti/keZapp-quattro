package it.iad2.repository4;

import it.iad2.model4.Messaggio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMessaggio extends JpaRepository<Messaggio, Long> {

    Messaggio findByTesto(String s);

    List<Messaggio> findByAliasDestinatarioIsNull();

    List<Messaggio> findByAliasDestinatario(String s);

}
