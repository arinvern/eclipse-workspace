package cat.itacademy.barcelonactiva.invernon.mateo.ariadna.s04.model.domain;

import jakarta.persistence.Column;

//import javax.persistence.*; error

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruites")
public class Fruita {
    
    @Id
    private int id;
    @Column (name="nom")
    private String nom;
    @Column (name="quantitatQuilos")
    private int quantitatQuilos;
    

    public Fruita() {}
    

    public Fruita(int id, String nom, Integer quantitatQuilos) {
        this.id = id;
    	this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
        
    }
    
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }
    
    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
	}
}