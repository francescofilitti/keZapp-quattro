package it.iad2.controller4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.dto4.RichiediMessaggiDto;
import it.iad2.dto4.RichiediRegistrazioneDto;
import it.iad2.service4.ServiceQuattro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ControllerQuattro {

    @Autowired
    ServiceQuattro servizio;

    @ResponseBody
    @RequestMapping("/registrazione")
    public RegistrazioneDto registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        return servizio.registrazione(dto);
    }

    @ResponseBody
    @RequestMapping("/invia-tutti")
    public RegistrazioneDto inviaTutti(@RequestBody InviaMessaggioDto dto) {
        return servizio.inviaTutti(dto);
    }

    @ResponseBody
    @RequestMapping("/invia-uno")
    public RegistrazioneDto inviaUno(@RequestBody InviaMessaggioDto dto) {
        return servizio.inviaUno(dto);
    }

    @ResponseBody
    @RequestMapping("/aggiorna")
    public RegistrazioneDto aggiornaLista(@RequestBody RichiediMessaggiDto dto) {
        return servizio.aggiornaLista(dto.getSessione());
    }
}
