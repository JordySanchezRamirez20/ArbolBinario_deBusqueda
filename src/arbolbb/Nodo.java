/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbb;

/**
 *
 * @author jordy
 */
public class Nodo {
    int dato;
    String nombre;
    Nodo NodoIzquierdo;
    Nodo NodoDerecho;
    
    //Constructor

    public Nodo(int dato, String nombre) {
        this.dato = dato;
        this.nombre = nombre;
        this.NodoIzquierdo = null;
        this.NodoDerecho = null;
        
        
    }

    @Override
    public String toString() {
        return  "Dato: " + dato + "\nNombre: " + nombre;
    }
    
}
