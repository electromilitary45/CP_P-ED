/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjestructurag5;

/**
 *
 * @author Derek
 */
public class dAsientos {
    
    //---atributos
    private String codArea;
    private int cantAsientos;
    private double costoVenta;
    private boolean status;
    
     //--constructor
    public dAsientos() {
        this.cantAsientos=0;
        this.codArea="";
        this.costoVenta=0;
        this.status=true;
    }

    //----getters and setters
    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    public double getCostoVenta() {
        return costoVenta;
    }

    public void setCostoVenta(double costoVenta) {
        this.costoVenta = costoVenta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
