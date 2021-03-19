import { Chat } from "./chat";
import { Messaggio } from "./messaggio";

export class RegistrazioneDto {
  contatti: Chat[];
  listaMessaggi: Messaggio[];
  sessione: string;
}
