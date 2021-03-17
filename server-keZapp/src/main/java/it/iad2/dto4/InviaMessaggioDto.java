package it.iad2.dto4;

import it.iad2.model4.Messaggio;

public class InviaMessaggioDto {
    public Messaggio messaggio;

    public InviaMessaggioDto() {
    }

    public InviaMessaggioDto(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    public Messaggio getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String toString() {
        return "InviaMessaggioDto{" + "messaggio=" + messaggio + '}';
    }

    
     
    
}
