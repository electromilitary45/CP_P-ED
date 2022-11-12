/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjestructurag5;

/**
 *
 * @author usuario
 */
public class dEventosSC {
    //--atributos---
    private String nombre;
    private String fecha;
    private String lugar; //Estadio,Anfiteatro, Teatro
    private String ciudad;
    private String direccion;
    private boolean status;

    public dEventosSC() {
        this.nombre="";
        this.fecha="";
        this.lugar="";
        this.nombre="";
        this.direccion="";
        this.status=true;
    }
    
    //---------getters and setters--------

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public boolean isStatus() {
        return status;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}//fin class dEvevntosLDC{}
