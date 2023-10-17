/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_hamdi;

import java.util.List;

/**
 *
 * @author Hamdi
 * @param <T>
 */

    public interface Iservice<T> {
    
    void ajouter(T t);
    void supprimer(T t);
    void modifier(T t);
    List<T> affihcer();
    
}
    

