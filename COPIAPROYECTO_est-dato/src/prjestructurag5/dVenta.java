/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjestructurag5;

/**
 *
 * @author Derek
 */
public class dVenta {
    
    //-----Atributos
    private String nombreComprador;
    private String codAsiento;
    private String fechaCompra;
    private String horaCompra;

    public dVenta() {
        this.nombreComprador="";
        this.codAsiento="";
        this.fechaCompra="";
        this.horaCompra="";
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getCodAsiento() {
        return codAsiento;
    }

    public void setCodAsiento(String codAsiento) {
        this.codAsiento = codAsiento;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
    }
    
    
    
    
     
}
