package it.iad2.serviceImpl4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.model4.Messaggio;
import it.iad2.repository4.RepositoryQuattro;
import it.iad2.service4.ServiceQuattro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplQuattro implements ServiceQuattro {

    @Autowired
    RepositoryQuattro repositoryQ;

    @Override
    public RegistrazioneDto conferma(Messaggio p) {
        repositoryQ.save(p);
        RegistrazioneDto dto = new RegistrazioneDto();
        List<Messaggio> listaMessaggi = repositoryQ.findAll();
        if (listaMessaggi == null) {
            dto.setListaMessaggi(new ArrayList<>());
        } else {
            dto.setListaMessaggi(listaMessaggi);
        }
        return dto;
    }

    @Override
    public RegistrazioneDto rimuovi(Messaggio p) {
        repositoryQ.delete(p);
        RegistrazioneDto dto = new RegistrazioneDto();
        List<Messaggio> listaMessaggi = repositoryQ.findAll();

        if (listaMessaggi == null) {
            dto.setListaMessaggi(new ArrayList<>());
        } else {
            dto.setListaMessaggi(listaMessaggi);
        }
        return dto;
    }

    @Override
    public InviaMessaggioDto modifica(Messaggio p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InviaMessaggioDto cerca(String s) {
        InviaMessaggioDto dto = new InviaMessaggioDto();
        dto.setMessaggio(repositoryQ.findByTesto(s));
        return dto;
    }

    @Override
    public RegistrazioneDto aggiornaLista() {
        RegistrazioneDto listaMessaggiDto = new RegistrazioneDto();
        List<Messaggio> listaMessaggi = repositoryQ.findAll();
        if (listaMessaggi == null) {
            listaMessaggiDto.setListaMessaggi(new ArrayList<>());
        } else {
            listaMessaggiDto.setListaMessaggi(listaMessaggi);
        }
        return listaMessaggiDto;
    }

    @Override
    public InviaMessaggioDto seleziona(Messaggio p) {
        InviaMessaggioDto dto = new InviaMessaggioDto();
        repositoryQ.findById(p.getId());
        dto.setMessaggio(p);
        return dto;
    }

}
