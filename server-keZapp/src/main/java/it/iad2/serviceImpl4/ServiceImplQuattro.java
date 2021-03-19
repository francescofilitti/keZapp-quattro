package it.iad2.serviceImpl4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.dto4.RichiediMessaggiDto;
import it.iad2.dto4.RichiediRegistrazioneDto;
import it.iad2.model4.Chat;
import it.iad2.model4.Messaggio;
import it.iad2.repository4.RepositoryQuattro;
import it.iad2.repository4.RepositoryBlogger;
import it.iad2.service4.ServiceQuattro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplQuattro implements ServiceQuattro {

    @Autowired
    RepositoryQuattro repositoryQ;

    @Autowired
    RepositoryBlogger rb;

    @Override
    public RegistrazioneDto registrazione(RichiediRegistrazioneDto dto) {
        List<Chat> listaBlogger = rb.findByNicknameEquals(dto.getNickname());

        if (listaBlogger.isEmpty()) {
            //istanziamo una nuova chat
            Chat blogger = new Chat();
            //assegnamo nickname alla chat con il nickname che arriva dal dto del client
            blogger.setNickname(dto.getNickname());
            //salviamo il blogger nella db x valorizzare l'id
            blogger = rb.save(blogger);
            //valorizziamo parametro sessione passando a string l'id
            blogger.setSessione(Long.toString(blogger.getId()));
            //carichiamo il record completo
            rb.save(blogger);
            List<Chat> listaUtenti = rb.findAll();
            List<Messaggio> listaMessaggi = repositoryQ.findAll();

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
        Chat utente = rb.findBySessione(dto.getSessione());

        if (utente == null) {
            return dtoReturn;
        } else if (dto.getDestinatario() != null) {
            Chat dest = rb.findByNickname(dto.getDestinatario());

            if (dest == null) {
                return dtoReturn;
            }
        }
        Messaggio m = new Messaggio();
        m.setTesto(dto.getMessaggio());
        Chat dest = rb.findByNickname(dto.getDestinatario());
        m.setAliasDestinatario(dto.getDestinatario());
        m.setAliasMittente(dest.getNickname());
        m = repositoryQ.save(m);

        List<Chat> listaDest = new ArrayList<>();
        listaDest.add(rb.findByNickname(dto.getDestinatario()));
        List<Messaggio> listaMessaggi = new ArrayList<>();
        listaMessaggi.add(m);

        return new RegistrazioneDto(listaDest, listaMessaggi, dto.getSessione());

    }

    @Override
    public RegistrazioneDto aggiornaLista(RichiediMessaggiDto dto) {
        RegistrazioneDto rec = new RegistrazioneDto();
        Chat c = rb.findBySessione(dto.getSessione());
        if (c == null) {
            return rec;
        }
        return new RegistrazioneDto();
    }

}
