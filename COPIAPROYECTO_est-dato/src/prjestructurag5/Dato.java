package prjestructurag5;

public class Dato {

    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena; //Mi teclado fisico esta en ingles
    private boolean estado;

    public Dato() {
        this.nombre = "";
        this.apellido = "";
        this.usuario = "";
        this.contrasena = "";
        this.estado = true; //false o true 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
