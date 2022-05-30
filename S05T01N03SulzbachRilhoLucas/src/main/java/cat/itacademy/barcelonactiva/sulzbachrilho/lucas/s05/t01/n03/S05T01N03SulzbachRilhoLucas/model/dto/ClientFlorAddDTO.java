package cat.itacademy.barcelonactiva.sulzbachrilho.lucas.s05.t01.n03.S05T01N03SulzbachRilhoLucas.model.dto;

public class ClientFlorAddDTO {

    private String nomFlor;
    private String paisFlor;

    public ClientFlorAddDTO() {
    }

    public ClientFlorAddDTO(String nomFlor, String paisFlor) {
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