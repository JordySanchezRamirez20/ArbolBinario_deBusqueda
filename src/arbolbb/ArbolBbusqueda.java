/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbb;

import javax.swing.JOptionPane;

/**
 *
 * @author jordy
 */
public class ArbolBbusqueda {

    Nodo Raiz;

    public ArbolBbusqueda() {
        Raiz = null;
    }

    public static String Salida;
    public static int Sa = 0;

    public void InsertarNodo() {
        int dato;
        String nombre;
        boolean b;
        dato = Integer.parseInt(JOptionPane.showInputDialog(null, "\n\tDato:", "Insertar Nodo", 3));
        if (Raiz == null) {
            nombre = JOptionPane.showInputDialog(null, "\n\tNombre: ", "Insertar Nodo", 3);
            Nodo nuevo = new Nodo(dato, nombre);
            Raiz = nuevo;
        } else {
            Nodo Aux = Raiz;
            Nodo Padre;
            while (true) {
                Padre = Aux;
                if (dato == Aux.dato) {
                    JOptionPane.showMessageDialog(null, "\n\tEl dato ya existe", "Error", 0);
                    break;
                }
                if (dato < Aux.dato) {
                    Aux = Aux.NodoIzquierdo;
                    if (Aux == null) {
                        nombre = JOptionPane.showInputDialog(null, "\n\tNombre: ", "Insertar Nodo", 3);
                        Nodo nuevo = new Nodo(dato, nombre);
                        Padre.NodoIzquierdo = nuevo;
                        break;
                    } else {
                        if (dato == Aux.dato) {
                            JOptionPane.showMessageDialog(null, "\n\tEl dato ya existe", "Error", 0);
                            break;

                        }
                    }
                } else {
                    Aux = Aux.NodoDerecho;
                    if (Aux == null) {
                        nombre = JOptionPane.showInputDialog(null, "\n\tNombre: ", "Insertar Nodo", 3);
                        Nodo nuevo = new Nodo(dato, nombre);
                        Padre.NodoDerecho = nuevo;
                        break;
                    } else {
                        if (dato == Aux.dato) {
                            JOptionPane.showMessageDialog(null, "\n\tEl dato ya existe", "Error", 0);
                            break;
                        }

                    }
                }

            }
        }

    }

    boolean Vacio() {
        if (Raiz == null) {
            JOptionPane.showMessageDialog(null, "\n\tEl árbol de busqueda esta vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public void PreOrden(Nodo Raiz) {
        if (Raiz != null) {
            Salida += " -" + Raiz.dato;
            PreOrden(Raiz.NodoIzquierdo);
            PreOrden(Raiz.NodoDerecho);

        }
    }

    public void InOrden(Nodo Raiz) {
        if (Raiz != null) {
            InOrden(Raiz.NodoIzquierdo);
            Salida += " -" + Raiz.dato;
            InOrden(Raiz.NodoDerecho);
        }
    }

    public void PostOrden(Nodo Raiz) {
        if (Raiz != null) {
            PostOrden(Raiz.NodoIzquierdo);
            PostOrden(Raiz.NodoDerecho);
            Salida += " -" + Raiz.dato;
        }
    }

    void IRaiz() {
        Nodo Aux = Raiz;
        JOptionPane.showMessageDialog(null, "\n\tLa Raíz es : \n" + Aux, "Valor de la Raíz", 1);
    }

    void Buscar() {
        Nodo Aux = Raiz;
        int Dato;
        int b;
        b = 0;
        Dato = Integer.parseInt(JOptionPane.showInputDialog(null, "\n\tDato: ", "Buscar Dato", 3));
        while(Aux != null) {
            if (Dato == Aux.dato) {
                JOptionPane.showMessageDialog(null,"\n\t" + Aux,"Buscar Dato",1);
                b = 1;
                break;
            }
            else{
            if (Dato < Aux.dato) {
                if (Dato == Aux.dato) {
                    JOptionPane.showMessageDialog(null,"\n\t" + Aux,"Buscar Dato",1);
                    b = 1;
                    break;
                }
                Aux = Aux.NodoIzquierdo;
            } else {
                if(Dato > Aux.dato){
                    if (Dato == Aux.dato) {
                    JOptionPane.showMessageDialog(null,"\n\t" + Aux,"Buscar Dato",1);
                    b = 1;
                    break;
                  }
                }
                Aux = Aux.NodoDerecho;
            }
        }
         }
        if(b == 0){
                JOptionPane.showMessageDialog(null,"\n\tNo existe el dato en el árbol","Buscar Dato",0);
        }
    }
    
    void Modificar(){
        Nodo Aux = Raiz;
        int Dato;
        int b;
        b = 0;
        Dato = Integer.parseInt(JOptionPane.showInputDialog(null, "\n\tDato: ", "Modificarr Dato", 3));
        while(Aux != null) {
            if (Dato == Aux.dato) {
                Aux.nombre = JOptionPane.showInputDialog(null,"\n\tNombre: ","Modificar Dato",3);
                JOptionPane.showMessageDialog(null,"\n\tSe modificó con éxito: \n" + Aux,"Modificar Dato",1);
                b = 1;
                break;
            }
            else{
            if (Dato < Aux.dato) {
                if (Dato == Aux.dato) {
                    Aux.nombre = JOptionPane.showInputDialog(null,"\n\tNombre: ","Modificar Dato",3);
                    JOptionPane.showMessageDialog(null,"\n\tSe modificó con éxito: \n" + Aux,"Buscar Dato",1);
                    b = 1;
                    break;
                }
                Aux = Aux.NodoIzquierdo;
            } else {
                if(Dato > Aux.dato){
                    if (Dato == Aux.dato) {
                    Aux.nombre = JOptionPane.showInputDialog(null,"\n\tNombre: ","Modificar Dato",3);    
                    JOptionPane.showMessageDialog(null,"\n\tSe modificó con éxito: \n" + Aux,"Buscar Dato",1);
                    b = 1;
                    break;
                  }
                }
                Aux = Aux.NodoDerecho;
            }
        }
         }
        if(b == 0){
                JOptionPane.showMessageDialog(null,"\n\tNo existe el dato en el árbol","Buscar Dato",0);
        }
    }
    
    void MayorValor(){
        Nodo Aux = Raiz;
        int daton = 0;
        while(Aux != null){
            if(Aux.dato > daton){
                daton = Aux.dato;
            }
            Aux = Aux.NodoDerecho;
        }
        JOptionPane.showMessageDialog(null,"\n\tEl Dato de mayor valor es :" + daton,"Buscar el Mayor Valor en los Nodos del Árbol",1);
    }
    
    void MenorValor(){
        int dato = 0;
        Nodo Aux = Raiz.NodoDerecho;
        Nodo Padre = Raiz;
        while(Padre != null){
            if(Padre.dato < Aux.dato){
                dato = Padre.dato;
            }
            Padre = Padre.NodoIzquierdo;
        }
        JOptionPane.showMessageDialog(null,"\n\tEl Dato de menor valor es :" + dato,"Buscar el Mayor Valor en los Nodos del Árbol",1);
    }
    
    void SumaNodos(Nodo Raiz){
        if(Raiz != null){
            Sa += Raiz.dato;
            SumaNodos(Raiz.NodoDerecho);
            SumaNodos(Raiz.NodoIzquierdo); 
        }
    }
    
    void ContarN(Nodo Raiz){
        int n = 0;
        if(Raiz != null){
             n = Raiz.dato;
             ContarN(Raiz.NodoDerecho);
             ContarN(Raiz.NodoIzquierdo);
             Sa += 1;
            
        }
        
    }
    
    void Niveles(Nodo Raiz, int n){
        if(Raiz != null){
            Niveles(Raiz.NodoIzquierdo, n+1);
            Niveles(Raiz.NodoDerecho, n + 1);
            if(n > Sa){
                Sa = n;
            }
        }
    }
    
    public boolean EliminarNodo(int dato){
        Nodo Aux = Raiz;
        Nodo Padre = Raiz;
        boolean esNodoIzquierdo = true;
        while(Aux.dato != dato){
            Padre = Aux;
            if(dato < Aux.dato){
                esNodoIzquierdo = true;
                Aux = Aux.NodoIzquierdo;
            }
            else{
                esNodoIzquierdo = false;
                Aux = Aux.NodoDerecho;
            }
            if(Aux == null){
                return false;
            }
        } //while
        if(Aux.NodoIzquierdo == null && Aux.NodoDerecho == null){
            if(Aux == Raiz){
                Raiz = null;
            }
            else if(esNodoIzquierdo){
                Padre.NodoIzquierdo = null;
                
            }
            else{
                Padre.NodoDerecho = null;
            }
        }
        else if(Aux.NodoDerecho == null){
            if(Aux == Raiz){
                Raiz = Aux.NodoIzquierdo;
                    
            }
            else if(esNodoIzquierdo){
                Padre.NodoIzquierdo = Aux.NodoIzquierdo;
            }
            else
                Padre.NodoDerecho = Aux.NodoIzquierdo;
        }
        else if(Aux.NodoIzquierdo == null){
            if(Aux == Raiz){
                Raiz = Aux.NodoDerecho;
            }
            else if(esNodoIzquierdo){
                Padre.NodoIzquierdo = Aux.NodoDerecho;
            }
            else{
                Padre.NodoDerecho = Aux.NodoDerecho;
            }
        }
        else{
            Nodo Reemplazo = obtenerNodoReemplazo(Aux);
            if(Aux == Raiz){
                Raiz = Reemplazo;
            }
            else if(esNodoIzquierdo){
                Padre.NodoIzquierdo = Reemplazo;
            }
            else{
                Padre.NodoDerecho = Reemplazo;
            }
            Reemplazo.NodoIzquierdo = Aux.NodoIzquierdo;
        }
        return true;
    }
    
    public Nodo obtenerNodoReemplazo(Nodo nodoReemplazo){
        Nodo reemplazoPadre = nodoReemplazo;
        Nodo reemplazo = nodoReemplazo;
        Nodo Aux = nodoReemplazo.NodoDerecho;
        while(Aux != null){
            reemplazoPadre = reemplazo;
            reemplazo = Aux;
            Aux = Aux.NodoIzquierdo;
        }
        if(reemplazo != nodoReemplazo.NodoDerecho){
            reemplazoPadre.NodoIzquierdo = reemplazo.NodoDerecho;
            reemplazo.NodoDerecho = nodoReemplazo.NodoDerecho;
        }
        
        JOptionPane.showMessageDialog(null,"\n\tEl Nodo reemplazo es:  \n" + reemplazo, "Eliminar dato en el arbol binario",1);
        return reemplazo;
    }
}
