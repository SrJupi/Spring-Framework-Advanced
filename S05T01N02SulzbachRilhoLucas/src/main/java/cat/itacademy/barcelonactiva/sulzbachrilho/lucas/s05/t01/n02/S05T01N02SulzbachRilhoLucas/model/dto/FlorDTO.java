package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto;

public class FlorDTO {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor;

    public FlorDTO() {
    }

    public FlorDTO(Integer pk_FlorID, String nomFlor, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    public FlorDTO(Integer pk_FlorID, String nomFlor, String paisFlor, String tipusFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        this.tipusFlor = tipusFlor;
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