package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class SucursalAddDTO {
    private String nomSucursal;
    private String paisSucursal;


    public SucursalAddDTO() {
    }

    public SucursalAddDTO(String nomSucursal, String paisSucursal) {

        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    @Override
    public String toString() {
        return "SucursalAddDTO{" +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                '}';
    }
}
