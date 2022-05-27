package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n02.S05T01N02SulzbachRilhoLucas.model.dto;

public class FlorAddDTO {

    private String nomFlor;
    private String paisFlor;

    public FlorAddDTO() {
    }

    public FlorAddDTO(String nomFlor, String paisFlor) {
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
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
}