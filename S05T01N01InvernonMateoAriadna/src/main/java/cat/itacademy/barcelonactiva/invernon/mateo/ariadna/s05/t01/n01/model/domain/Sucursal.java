package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s05.t01.n01.model.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "pk_SucursalID")
    private Integer pk_SucursalID;
    
    @Column(name = "nombreSucursal")
    private String nombreSucursal;
    
    @Column(name = "paisSucursal")
    private String paisSucursal;

    public Sucursal() {
    }

    public Sucursal(String nomSucursal, String paisSucursal) {
        this.nombreSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nombreSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nombreSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}