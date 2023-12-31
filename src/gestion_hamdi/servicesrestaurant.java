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
public class servicesrestaurant implements  Iservice <Restaurant>{
    Connection con; 
    Statement ste;

    public servicesrestaurant() {
        con = MYdb.getinstance().getCon();    }
    
    

    @Override
    public void ajouter(Restaurant t) {
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
    public void supprimer(Restaurant t) {
  
        try{
        
         String req = "DELETE FROM restaurant WHERE id_restau = ?";
          PreparedStatement pre = con.prepareStatement(req);
         pre.setInt(1, t.getId()); 
             pre.executeUpdate();}
         catch (SQLException ex) {
                System.out.println(ex);
            
        }}
     @Override
    public void modifier(Restaurant t) {
        
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
    public List<Restaurant> affihcer() {
        List<Restaurant> restaurantss = new ArrayList<>();
        String sql ="select * from restaurant";
        try {
            ste= con.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                Restaurant r= new Restaurant(rs.getInt("id_restau"),
                        rs.getString("nom"), rs.getString("location"));
                restaurantss.add(r);
                for (Restaurant element : restaurantss) {
                String  hell=element.toStringForDisplay();
                System.out.println(  hell);
            
        }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return restaurantss;
    }
    
    ////
    public Restaurant getRestaurantParId(int id) {
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
            return new Restaurant(restaurantId, nom, location);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return null;
}

    
}


  




