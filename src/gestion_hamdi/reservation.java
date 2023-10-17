/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Hamdi
 */
public class reservation {
    private int id_res; 
    private LocalDate datereser ;
    private LocalTime timereser;
    restaurant restau;

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }
    
    

    public restaurant getRestau() {
        return restau;
    }

    public void setRestau(restaurant restau) {
        this.restau = restau;
    }
    
    
    

    public LocalTime getTimereser() {
        return timereser;
    }

    public void setTimereser(LocalTime timereser) {
        this.timereser = timereser;
    }
    

    public LocalDate getDatereser() {
        return datereser;
    }

    public void setDatereser(LocalDate datereser) {
        this.datereser = datereser;
    }

  





    

 


    

    public int getId() {
        return id_res;
    }

    public void setId(int id) {
        this.id_res = id;
    }

 


    public reservation() {
    }



    public reservation(int id_res,LocalDate datereser, LocalTime timereser, restaurant restau) {
        this.id_res = id_res;
        
        this.datereser = datereser;
        this.timereser = timereser;
        this.restau = restau;
    }

    public reservation(int id_res, LocalDate datereser, LocalTime timereser) {
        this.id_res = id_res;
        this.datereser = datereser;
        this.timereser = timereser;
    }

 


    @Override
    public String toString() {
        return "reservation id:"+this.id_res+"  "+this.datereser + " " +this.timereser;
    }
    
    
}