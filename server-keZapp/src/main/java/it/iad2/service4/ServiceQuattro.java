package it.iad2.service4;

import it.iad2.dto4.RegistrazioneDto;
import it.iad2.dto4.InviaMessaggioDto;
import it.iad2.model4.Messaggio;

public interface ServiceQuattro {

    RegistrazioneDto conferma(Messaggio p);

    InviaMessaggioDto modifica(Messaggio p);
    // InviaMessaggioDto annulla (Messaggio p); Da gestire lato client?

    RegistrazioneDto rimuovi(Messaggio p);

    InviaMessaggioDto cerca(String s);
    
    InviaMessaggioDto seleziona(Messaggio p);
    
    RegistrazioneDto aggiornaLista();
    

}
