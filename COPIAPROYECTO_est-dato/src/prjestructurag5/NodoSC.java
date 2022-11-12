/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjestructurag5;

/**
 *
 * @author usuario
 */
public class NodoSC {
    //--atributos--
    private dEventosSC dato;
    private NodoSC siguiente;

    public NodoSC() {
        this.siguiente=null;
    }
    
    //---getters and setters---

    public dEventosSC getDato() {
        return dato;
    }

    public void setDato(dEventosSC dato) {
        this.dato = dato;
    }

    public NodoSC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSC siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}//--fin dondoSC
