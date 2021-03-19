import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Chat } from './chat';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazioneDto';
import { RichiediMessaggioDto } from './richiedi-messaggio-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  messaggio: string;
  nickname: string;
  listaMessaggi: Messaggio[] = [];
  contatti: Chat[] = [];
  chat: Chat;
  sessione: string;
  destinatario: string;


  constructor(private http: HttpClient) {
  }
  ngOnInit() { }



  registrazione() {

    let dto: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dto.nickname = this.nickname;

    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>(
      "http://localhost:8080/registrazione", dto);

    oss.subscribe
      ((c) => {
        this.contatti = c.contatti;
        this.listaMessaggi = c.listaMessaggi;
        this.sessione = c.sessione
      });


    this.sessione = this.chat.sessione;
    this.nickname = "";
  }
  inviaTutti() {
    let dto: InviaMessaggioDto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;
    dto.sessione = this.sessione;
    dto.destinatario = null;
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/invia-tutti', dto);
    oss.subscribe
      ((c) => {
        this.contatti = c.contatti;
        this.listaMessaggi = c.listaMessaggi;

      });

    this.messaggio = "";
  }

  inviaUno(c: Chat) {
    let dto: InviaMessaggioDto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;
    dto.sessione = c.sessione;
    dto.destinatario = c.nickname;
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/invia-uno', dto);
    oss.subscribe((a) => {
      this.listaMessaggi = a.listaMessaggi;
      this.contatti = a.contatti;

    });

    this.messaggio = "";
  }

  aggiornaLista() {
    let dto: RichiediMessaggioDto = new RichiediMessaggioDto();
    dto.sessione = this.sessione;
    let ox: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/aggiorna', dto);
    ox.subscribe((a) => {
      this.listaMessaggi = a.listaMessaggi;
      this.contatti = a.contatti;

    });


  }
}
