package it.iad2.serviceImpl4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.dto4.RichiediMessaggiDto;
import it.iad2.dto4.RichiediRegistrazioneDto;
import it.iad2.model4.Chat;
import it.iad2.model4.Messaggio;
import it.iad2.service4.ServiceQuattro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.iad2.repository4.RepositoryMessaggio;
import it.iad2.repository4.RepositoryChat;

@Service
public class ServiceImplQuattro implements ServiceQuattro {

    @Autowired
    RepositoryMessaggio repositoryMessaggio;

    @Autowired
    RepositoryChat repositoryChat;

    @Override
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto dto) {
        List<Chat> listaBlogger = repositoryChat.findByNicknameEquals(dto.getNickname());

        if (listaBlogger.isEmpty()) {
            //istanziamo una nuova chat
            Chat blogger = new Chat();
            //assegnamo nickname alla chat con il nickname che arriva dal dto del client
            blogger.setNickname(dto.getNickname());
            //salviamo il blogger nella db x valorizzare l'id
            blogger = repositoryChat.save(blogger);
            //valorizziamo parametro sessione passando a string l'id
            blogger.setSessione(Long.toString(blogger.getId()));
            //carichiamo il record completo
            repositoryChat.save(blogger);
            List<Chat> listaUtenti = repositoryChat.findAll();
            List<Messaggio> listaMessaggi = repositoryMessaggio.findAll();

            return new RegistrazioneDto(listaUtenti, listaMessaggi, blogger.getSessione());
        } else {
            return new RegistrazioneDto();
        }

    }

    @Override
    public RegistrazioneDto inviaTutti(InviaMessaggioDto dto) {
        dto.setDestinatario(null);
        return inviaUno(dto);
//        Messaggio m = new Messaggio();
//        m.setTesto(dto.getMessaggio());
//        Chat dest = rb.findByNickname(dto.getSessione());
//        m.setAliasDestinatario(dest.getNickname());
//        List<Chat> listaDest = new ArrayList<>();
//        listaDest = rb.findAll();
//        List<Messaggio> listaMessaggi = new ArrayList<>();
//        listaMessaggi.add(m);
//
//        return new RegistrazioneDto(listaDest, listaMessaggi, dto.getSessione());
//
    }

    @Override
    public RegistrazioneDto inviaUno(InviaMessaggioDto dto) {
        RegistrazioneDto dtoReturn = new RegistrazioneDto();
        Chat utente = repositoryChat.findBySessione(dto.getSessione());

        if (utente == null) {
            return dtoReturn;
        } else if (dto.getDestinatario() != null) {
            Chat dest = repositoryChat.findByNickname(dto.getDestinatario());

            if (dest == null) {
                return dtoReturn;
            }
        }
        Messaggio m = new Messaggio();
        m.setTesto(dto.getMessaggio());
        Chat dest = repositoryChat.findBySessione(dto.getSessione());
        m.setAliasDestinatario(dto.getDestinatario());
        m.setAliasMittente(dest.getNickname());
        m = repositoryMessaggio.save(m);
        return aggiornaLista(dto.getSessione());
    }

    @Override
    public RegistrazioneDto aggiornaLista(String ss) {
        Chat c = repositoryChat.findBySessione(ss);
        if (c == null) {
            RegistrazioneDto rec = new RegistrazioneDto();
            return rec;
        }

        List<Chat> listaChat = repositoryChat.findAll();
        return new RegistrazioneDto(listaChat, recuperaMessaggi(c), null);

    }

    private List<Messaggio> recuperaMessaggi(Chat c) {

        //Recupero tutti i messaggi pubblici
        List<Messaggio> pubblici = repositoryMessaggio.findByAliasDestinatarioIsNull();
        //Recupero tutti i messaggi privati
        List<Messaggio> privati = repositoryMessaggio.findByAliasDestinatario(c.getNickname());
        //Unisco le due lista
        pubblici.addAll(privati);
        return pubblici;
    }
}
