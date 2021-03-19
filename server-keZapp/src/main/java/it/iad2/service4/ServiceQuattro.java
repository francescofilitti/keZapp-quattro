package it.iad2.service4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.dto4.RichiediMessaggiDto;
import it.iad2.dto4.RichiediRegistrazioneDto;

public interface ServiceQuattro {

    RegistrazioneDto registrazione(RichiediRegistrazioneDto dto);

    RegistrazioneDto inviaTutti(InviaMessaggioDto dto);

    RegistrazioneDto inviaUno(InviaMessaggioDto dto);

    RegistrazioneDto aggiornaLista(String ss);
    
    
}
