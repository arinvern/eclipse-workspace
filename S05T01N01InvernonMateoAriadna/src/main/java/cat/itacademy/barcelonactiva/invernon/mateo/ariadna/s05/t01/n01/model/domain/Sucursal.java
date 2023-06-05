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
    
    @Column(name = "pk_SucursalID", columnDefinition = "VARCHAR(20) DEFAULT 'ValorPredeterminado'")
    private Integer pk_SucursalID;
    
    @Column(name = "nombreSucursal", columnDefinition = "VARCHAR(45) DEFAULT 'ValorPredeterminado'")
    private String nombreSucursal;
    
    @Column(name = "paisSucursal", columnDefinition = "VARCHAR(20) DEFAULT 'ValorPredeterminado'")
    private String paisSucursal;

    public Sucursal() {
    }

    public Sucursal(String nombreSucursal, String paisSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}