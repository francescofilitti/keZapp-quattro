import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Chat } from './chat';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazioneDto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  messaggio: string = ""
  nickname: string = "";
  listaMessaggi: Messaggio[] = [];
  contatti: Chat[] = [];
  chat: Chat;
  sessione: string = "";
  destinatario: string = "";

  constructor(private http: HttpClient) {
  }
  ngOnInit() { }



  registrazione() {

    let dto: RichiediRegistrazioneDto = new RichiediRegistrazioneDto();
    dto.nickname = this.nickname;

    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>(
      "http://localhost:8080//registrazione", dto);

    oss.subscribe
      (c => {
        this.contatti = c.contatti;
        this.listaMessaggi = c.listaMessaggi;
        this.chat.sessione = c.sessione
      });

  }
  inviaTutti() {
    let dto: InviaMessaggioDto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;
    dto.sessione = this.sessione;
    dto.destinatario = this.destinatario;
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/invia-tutti', dto);
    oss.subscribe(a => {
      this.listaMessaggi = a.listaMessaggi;
      this.sessione = a.sessione;
      this.contatti = a.contatti;
    });

  }

  inviaUno(c: Chat) {
    let dto: InviaMessaggioDto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;
    dto.sessione = this.sessione;
    dto.destinatario = this.destinatario;
    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>('http://localhost:8080/invia-tutti', dto);
    oss.subscribe(a => {
      this.listaMessaggi = a.listaMessaggi;
      this.sessione = a.sessione;
      this.contatti = a.contatti;

    });

    /*aggiorna(){
      -- da implementare --
    }*/

  }
  }