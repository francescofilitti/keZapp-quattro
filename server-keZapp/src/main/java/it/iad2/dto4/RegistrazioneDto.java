package it.iad2.dto4;

import it.iad2.model4.Messaggio;
import java.util.List;

public class RegistrazioneDto {

    public List<Messaggio> listaMessaggi;

    public RegistrazioneDto() {
    }

    public RegistrazioneDto(List<Messaggio> listaMessaggi) {
        this.listaMessaggi = listaMessaggi;
    }

    public List<Messaggio> getListaMessaggi() {
        return listaMessaggi;
    }

    public void setListaMessaggi(List<Messaggio> listaMessaggi) {
        this.listaMessaggi = listaMessaggi;
    }

    @Override
    public String toString() {
        return "RegistrazioneDto{" + "listaMessaggi=" + listaMessaggi + '}';
    }


}
