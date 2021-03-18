package it.iad2.dto4;

import it.iad2.model4.Chat;
import it.iad2.model4.Messaggio;
import java.util.List;

public class RegistrazioneDto {

    private List<Chat> contatti;
    private List<Messaggio> messaggi;
    private String sessione;

    public RegistrazioneDto() {
    }

    public RegistrazioneDto(List<Chat> contatti, List<Messaggio> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    @Override
    public String toString() {
        return "RegistrazioneDto{" + "contatti=" + contatti + ", messaggi=" + messaggi + ", sessione=" + sessione + '}';
    }

    public List<Chat> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

}
