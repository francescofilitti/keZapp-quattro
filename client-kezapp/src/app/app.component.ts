import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { Messaggio } from './messaggio';
import { RegistrazioneDto } from './registrazioneDto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  messaggio: Messaggio = new Messaggio();
  listaMessaggi: Messaggio[] = [];

  constructor(private http: HttpClient) {
  }
  ngOnInit() { }

  conferma() {

    let dto: InviaMessaggioDto = new InviaMessaggioDto();
    dto.messaggio = this.messaggio;

    let oss: Observable<RegistrazioneDto> = this.http.post<RegistrazioneDto>(
      "http://localhost:8080/conferma", dto);

    oss.subscribe(o => this.listaMessaggi = o.listaMessaggi);

  }

}
