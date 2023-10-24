/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;

/**
 *
 * @author Hamdi
 */
public class Gestion_hamdi {

    /**
     * @param args the command line arguments
     */

        // TODO code application logic here
          public static void main(String[] args) {
               
           
        // TODO code application logic here
          
          
        LocalTime time = LocalTime.of(20, 00);
        Restaurant p5 = new Restaurant(1,"gabes","fuck");
        Restaurant p2 = new Restaurant(1,"yummy","gabes");
        Restaurant p3 = new Restaurant(21, "hamdi", "salah");
        
            
       
    
        
        
   
       servicesrestaurant sp = new servicesrestaurant();

      //restaurantAmodifier.setNom("del");
        
        
      sp.modifier(p3);
       sp.affihcer();
       
    
      
       
       servicesreservation res=new servicesreservation();
       LocalDate madates = LocalDate.of(2010, 8, 1);
        //reservation resAsupprimer = res.getReservationParId(9);
        //res.ajouter(r2);
        
        //reservation resAmodifier = res.getReservationParId(13);
        //reservation resAsupprimer = res.getReservationParId(12);
        reservation r2 = new reservation(15, madates, time, p3);
         reservation r3 = new reservation(15, madates, time, p3);
       res.modifier(r2);
        res.ajouter(r3);
        res.supprimer(r3);
       //res.ajouter(r2);
      // res.supprimer(resAsupprimer);
        
        //resAmodifier.setDatereser(madates);
        //res.supprimer(resAsupprimer);
        //System.out.println(resAmodifier);
       ///res.ajouter(r1);
     res.affihcer();
    }


    
}
