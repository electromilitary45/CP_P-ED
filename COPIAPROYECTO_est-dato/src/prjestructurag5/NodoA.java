/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjestructurag5;

/**
 *
 * @author Derek
 */
public class NodoA {

    private dVenta elemento;

    private NodoA enlaIzq;
    private NodoA enlaceDer;

    public NodoA() {
        this.enlaIzq = null;
        this.enlaceDer = null;
    }

    public dVenta getElemento() {
        return elemento;
    }

    public void setElemento(dVenta elemento) {
        this.elemento = elemento;
    }

    public NodoA getEnlaIzq() {
        return enlaIzq;
    }

    public void setEnlaIzq(NodoA enlaIzq) {
        this.enlaIzq = enlaIzq;
    }

    public NodoA getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoA enlaceDer) {
        this.enlaceDer = enlaceDer;
    }
}
