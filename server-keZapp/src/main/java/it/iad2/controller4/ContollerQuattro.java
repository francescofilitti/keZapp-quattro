package it.iad2.controller4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.dto4.RichiediMessaggiDto;
import it.iad2.service4.ServiceQuattro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContollerQuattro {

    @Autowired
    ServiceQuattro servizio;

    @ResponseBody
    @RequestMapping("/conferma")
    public RegistrazioneDto conferma(@RequestBody InviaMessaggioDto dto) {
        return servizio.conferma(dto.getMessaggio());
    }

    @ResponseBody
    @RequestMapping("/rimuovi")
    public RegistrazioneDto rimuovi(@RequestBody InviaMessaggioDto dto) {
        return servizio.rimuovi(dto.getMessaggio());
    }

    @ResponseBody
    @RequestMapping("/modifica")
    public InviaMessaggioDto modifica(@RequestBody InviaMessaggioDto dto) {
        return servizio.modifica(dto.getMessaggio());
    }

    @ResponseBody
    @RequestMapping("/cerca")
    public InviaMessaggioDto cerca(@RequestBody RichiediMessaggiDto dto) {
        return servizio.cerca(dto.getSessione());

    }

    @ResponseBody
    @RequestMapping("/aggiorna")
    public RegistrazioneDto aggiornaLista() {
        return servizio.aggiornaLista();
    }
}
