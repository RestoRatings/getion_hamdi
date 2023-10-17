/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hamdi
 */
public class servicesrestaurant implements  Iservice <restaurant>{
    Connection con; 
    Statement ste;

    public servicesrestaurant() {
        con = MYdb.getinstance().getCon();    }
    
    

    @Override
    public void ajouter(restaurant t) {
        try {
            String req = "INSERT INTO restaurant(nom,location)values(?,?)";
            PreparedStatement pre = con.prepareStatement(req);
            pre.setString(1,t.getNom());
            pre.setString(2,t.getlocation());
            pre.executeUpdate();
            
           
            
            
            } catch (SQLException ex) {
                System.out.println(ex);
            
        }
       
    }

    @Override
    public void supprimer(restaurant t) {
  
        try{
        
         String req = "DELETE FROM restaurant WHERE id_restau = ?";
          PreparedStatement pre = con.prepareStatement(req);
         pre.setInt(1, t.getId()); 
             pre.executeUpdate();}
         catch (SQLException ex) {
                System.out.println(ex);
            
        }}
     @Override
    public void modifier(restaurant t) {
        
              try {
            String req = "UPDATE restaurant SET nom = ?, location = ? WHERE id_restau = ?";

            PreparedStatement pre = con.prepareStatement(req);
           
            pre.setString(1,t.getNom());
            pre.setString(2,t.getlocation());
             pre.setInt(3, t.getId());
          
            pre.executeUpdate();
            
            
            
            } catch (SQLException ex) {
                System.out.println(ex);
            
        }
       
    }
    

    @Override
    public List<restaurant> affihcer() {
        List<restaurant> restaurantss = new ArrayList<>();
        String sql ="select * from restaurant";
        try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                restaurant r= new restaurant(rs.getInt("id_restau"),
                        rs.getString("nom"), rs.getString("location"));
                restaurantss.add(r);
                        for (restaurant element : restaurantss) {
            System.out.println(element);
        }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return restaurantss;
    }
    
    ////
    public restaurant getRestaurantParId(int id) {
    String sql = "SELECT * FROM restaurant WHERE id_restau = ?";
    try {
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1, id);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            int restaurantId = rs.getInt("id_restau");
            String nom = rs.getString("nom");
            String location = rs.getString("location");
            
            // Create and return a restaurant object with retrieved data
            return new restaurant(restaurantId, nom, location);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return null;
}

    
}


  




