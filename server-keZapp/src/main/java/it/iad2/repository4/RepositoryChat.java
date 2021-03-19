package it.iad2.repository4;

import it.iad2.model4.Chat;
import it.iad2.model4.Messaggio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryChat extends JpaRepository<Chat, Long> {

    List<Chat> findByNicknameEquals(String s);

    Chat findByNickname(String s);

    Chat findBySessione(String s);
}
