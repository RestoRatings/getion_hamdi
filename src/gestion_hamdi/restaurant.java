/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

import java.sql.Date;

/**
 *
 * @author Hamdi
 */
public class restaurant {
    private int id_restau; 
    private String nom , location;
    

    public int getId() {
        return id_restau;
    }

    public void setId(int id) {
        this.id_restau = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String prenom) {
        this.location = prenom;
    }

        public restaurant(int id_restau, String nom, String location) {
            this.id_restau = id_restau;
            this.nom = nom;
            this.location = location;
        }

  

    public restaurant(String nom, String prenom) {
        this.nom = nom;
        this.location = prenom;
    }

    public restaurant() {
    }
         public String toStringForDisplay() {
        return this.nom + " - " + this.location;
    }
    @Override
    public String toString() {
        return "personne id:"+this.id_restau+"  "+this.nom+ " "+ this.location  ;
    }
 
      
}
