package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class FlorResponseDTO {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    public FlorResponseDTO() {
    }

    public FlorResponseDTO(String nomFlor, String paisFlor) {
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    public FlorResponseDTO(Integer pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        ArrayList<String> paisos = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria",
                "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece",
                "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands",
                "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));
        if (paisos.contains(paisFlor)){
            this.tipusFlor = "UE";
        }else{
            this.tipusFlor = "Fora UE";
        }
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNomFlor() {
        return nomFlor;
    }

    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getTipusFlor() {
        return tipusFlor;
    }

    public void setTipusFlor(String tipusFlor) {
        this.tipusFlor = tipusFlor;
    }
}