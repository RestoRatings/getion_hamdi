/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hamdi
 */
public class MYdb {
    
    //
    String url = "jdbc:mysql://localhost:3306/pidev4se1";
    String user = "root";
    String pwd = "";
    
    
    Connection con;
    
    //3 
    static MYdb instance;
     //1 rendre le constructeur prive
    private MYdb() {
        
        try {
            con = DriverManager.getConnection(url, user, pwd);
            
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Probeleme de connexion");
        }
    }
    
    // 2 etape: de creer une methode static pour utiliser le const 
    public static MYdb getinstance(){
        if(instance == null){
            instance =  new MYdb();
        }
        return instance;
        
    }

    public Connection getCon() {
        return con;
    }
    
    
    
}

    

