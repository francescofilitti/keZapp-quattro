/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.iad2.dto4;

/**
 *
 * @author utente
 */
public class RichiediRegistrazioneDto {
    private String nickname;

    @Override
    public String toString() {
        return "RichiediRegistrazioneDto{" + "nickname=" + nickname + '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public RichiediRegistrazioneDto(String nickname) {
        this.nickname = nickname;
    }

    public RichiediRegistrazioneDto() {
    }
    
}
