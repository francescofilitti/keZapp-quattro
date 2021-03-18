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
  inviaTutti(){

  }

}