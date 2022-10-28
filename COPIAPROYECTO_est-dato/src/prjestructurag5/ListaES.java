package prjestructurag5;

import javax.swing.JOptionPane;

public class ListaES {

    private Nodo inicio;

    public ListaES() {
        this.inicio = null;
    }

    public boolean VaciasLista() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }//fin Vacia()

    //-----------------------------METODOS---------------------------------
    public void agregarUsuario(String nombre, String apellido, String usuario, String contrasena){
        Dato d = new Dato();
        d.setUsuario(usuario);
        d.setNombre(nombre);  
        d.setApellido(apellido);
        d.setContrasena(contrasena);

        Nodo nuevo = new Nodo();
        nuevo.setElemento(d);
        if (VaciasLista()) {
            inicio = nuevo;
        } else if (d.getUsuario().compareTo(inicio.getElemento().getUsuario()) < 0) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nuevo);
        } else {
            Nodo aux = inicio;
            while ((aux.getSiguiente() != null) && (aux.getSiguiente().getElemento().getUsuario().
                    compareTo(d.getUsuario()) < 0)) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }//fin agregarUsuario

    public void desactivarUsuario(String usuario) {
        //JOptionPane.showMessageDialog(null, usuario);
        if (!VaciasLista()) {
            if (inicio.getElemento().getUsuario().equals(usuario)) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null,
                        "¡Se desactivo el cliente con exito!");
            } else {
                Nodo anterior;
                Nodo auxiliar;
                anterior = inicio;
                auxiliar = inicio.getSiguiente();
                while ((auxiliar != null) && (!auxiliar.getElemento()
                        .getUsuario().equals(usuario))) {
                    anterior = anterior.getSiguiente();
                    auxiliar = auxiliar.getSiguiente();
                }
                if (auxiliar != null) {
                    anterior.setSiguiente(auxiliar.getSiguiente());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacia");
        }
    }//fin desactivar

    public void mostrarUsuarios() {
        JOptionPane.showMessageDialog(null, "AQUI SE MOSTRARAN LOS USUARIOS");
    }

}//fin clase LISTAES(){}
