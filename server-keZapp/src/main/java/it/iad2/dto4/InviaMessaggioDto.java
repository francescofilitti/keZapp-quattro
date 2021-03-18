package it.iad2.dto4;

import it.iad2.model4.Messaggio;

public class InviaMessaggioDto {
    private String sessione;
    private String messaggio;
    private String destinatario;

    public InviaMessaggioDto() {
    }

    public InviaMessaggioDto(String sessione, String messaggio, String destinatario) {
        this.sessione = sessione;
        this.messaggio = messaggio;
        this.destinatario = destinatario;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "InviaMessaggioDto{" + "sessione=" + sessione + ", messaggio=" + messaggio + ", destinatario=" + destinatario + '}';
    }

    
}
