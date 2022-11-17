package prjestructurag5;

import javax.swing.JOptionPane;

public class ListaES {

    //----ATRIBUTOS MODULO 1-------
    private Nodo inicio;
    //----ATRIBUTOS MODULO 2-------
    private NodoSC inicioSC;
    private NodoSC finSC;

    //------CONSTRUCTOR--------
    public ListaES() {
        this.inicio = null;//EnlazadaSimple
        this.inicioSC = null;//SimpleCircular
        this.finSC = null;//simpleCircular
    }

    //------METODOS GENERALES-----
    public boolean VaciasLista() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }//fin VaciaES()

    public boolean vaciaSC() {
        if (inicioSC == null) {
            return true;
        } else {
            return false;
        }
    }//fin vaciaSC

    //-----------------------------METODOS MODULO 1---------------------------------
    public void agregarUsuario() {
        //--instacia
        Dato d = new Dato();
        //--
        d.setNombre(JOptionPane.showInputDialog("DIGITE UN NOMBRE"));
        d.setUsuario(JOptionPane.showInputDialog("DIGITE UN NOMBRE DE USUARIO:"));

        d.setApellido(JOptionPane.showInputDialog("DIGITE UN APELLIDO:"));
        d.setContrasena(JOptionPane.showInputDialog("DIGITE UNA CONTRASEÑA:"));
        d.setEstado(true);

        Nodo nuevo = new Nodo();
        nuevo.setElemento(d);

        if (VaciasLista()) {//se pone al inicio
            inicio = nuevo;
        } else if (d.getNombre().compareTo(inicio.getElemento().getNombre()) < 0) { // se pone a la derecha
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else if (inicio.getSiguiente() == null) {//se pone a la izquierda 
            inicio.setSiguiente(nuevo);
        } else {//se pone en medio
            Nodo aux = inicio;
            while ((aux.getSiguiente() != null) && (aux.getSiguiente().getElemento().getUsuario().
                    compareTo(d.getUsuario()) < 0)) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }//fin agregarUsuario

    public void eliminarUsuario() {

        String usuario = JOptionPane.showInputDialog("DIGITE EL USUARIO A ELIMINAR");
        if (!VaciasLista()) {
            if (inicio.getElemento().getUsuario().equals(usuario)) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null,
                        "¡Se elimino el cliente con exito!");
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
    }//fin eliminar

    //inicio desactivar usuario
    public void desactivarUsuario() {
        Dato d = new Dato();
        String usuario = JOptionPane.showInputDialog("DIGITE EL USUARIO A DESACTIVAR");
        if (!VaciasLista()) {
            if (inicio.getElemento().getUsuario().equals(usuario) == true) {
                //inicio = inicio.getSiguiente();
                d.setEstado(false);
                inicio.getElemento().setEstado(false);
                //JOptionPane.showMessageDialog(null,
                //"¡Se desactivo el cliente con exito!");
                JOptionPane.showMessageDialog(null,
                        "Usuario: " + usuario + " descativado con exito");
            } else {

                JOptionPane.showMessageDialog(null, "Usuario no encontrado");

            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "La lista esta vacia");
        }
    }//fin desactivar usario

    public void mostrarUsuarios() {
        if (!VaciasLista()) {
            String s = "";
            String a = "";
            Nodo aux = inicio;
            while (aux != null) {
                if (aux.getElemento().isEstado() == true) {
                    a = "Usuario Activo";
                } else {
                    a = "Usuario Inactivo";
                }
                s = s + "Usuario: " + aux.getElemento().getUsuario() + "--" + aux.getElemento().getNombre() + " " + aux.getElemento().getApellido()
                        + "--" + aux.getElemento().getContrasena() + "--" + a + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, s);
        } else {
            JOptionPane.showMessageDialog(null, "No hay usuarios registrados, no se puede mostrar");
        }
    }

    //-----------------------------METODOS MODULO 2---------------------------------
    public void agregarEvento() {
        try {
            dEventosSC DE = new dEventosSC();
            DE.setNombre(JOptionPane.showInputDialog("Digite el nombre del evento:"));
            DE.setCiudad(JOptionPane.showInputDialog("Digite el nombre de la Ciudad"));
            char op = ' ';
            String lugar = "";
            while (op != 'A' && op != 'B' && op != 'C') {

                op = JOptionPane.showInputDialog("Seleccione un lugar"
                        + "\nA. ESTADIO"
                        + "\nB. ANFITEATRO"
                        + "\nC. TEATRO").toUpperCase().charAt(0);
            }
            switch (op) {
                case 'A':
                    lugar = "ESTADIO";
                    break;
                case 'B':
                    lugar = "ANFITEATRO";
                    break;
                case 'C':
                    lugar = "TEATRO";
                    break;
            }
            DE.setLugar(lugar);
            DE.setDireccion("Digite una direccion");
            DE.setFecha(JOptionPane.showInputDialog("Digite la fecha del evento con el siguiente formato dd/mm/yyyy"));
            DE.setStatus(true);

            //se crea nodo
            NodoSC nuevo = new NodoSC();
            //se almacena 
            nuevo.setDato(DE);
            //INICIO DE LOGICA DE AGREGAR
            if (vaciaSC()) {
                inicioSC = nuevo;
                finSC = nuevo;
                finSC.setSiguiente(inicioSC);
            } else if (DE.getNombre().compareTo(inicioSC.getDato().getNombre()) < 0) {
                nuevo.setSiguiente(inicioSC);
                inicioSC = nuevo;
                finSC.setSiguiente(inicioSC);
            } else if (DE.getNombre().compareTo(finSC.getDato().getNombre()) >= 0) {
                finSC.setSiguiente(nuevo);
                finSC = nuevo;
                finSC.setSiguiente(inicioSC);
            } else {
                NodoSC aux = inicioSC;
                while (aux.getSiguiente().getDato().
                        getNombre().compareTo(DE.getNombre()) <= 0) {
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }//FIN DE LOGICA DE AGREGAR

            //------RECURSIVIDAD--------
            char r = JOptionPane.showInputDialog("Desea ingresar otro evento?"
                    + "\nSI || NO").toUpperCase().charAt(0);
            if (r == 'S') {
                agregarEvento();
            } else {
                JOptionPane.showMessageDialog(null, "Evento agregado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar evento"
                    + "\n" + e.getMessage());
            char r = JOptionPane.showInputDialog("Desea intentar de nuevo?"
                    + "\nSI || NO").toUpperCase().charAt(0);
            if (r == 'S') {
                agregarEvento();
            }
        }

    }//fin agregarEvento

    public void mostrarEvento() {
        if (!vaciaSC()) {
            String s = "";
            NodoSC aux = inicioSC;
            s = s + aux.getDato().getNombre() + "--" + aux.getDato().getFecha()
                    + "--" + aux.getDato().getCiudad() + aux.getDato().getLugar() + "--" + aux.getDato().getDireccion() + "--" + aux.getDato().isStatus() + "-->";
            aux = aux.getSiguiente();
            while (aux != inicioSC) {
                s = s + aux.getDato().getNombre() + "--" + aux.getDato().getFecha()
                        + "--" + aux.getDato().getCiudad() + aux.getDato().getLugar() + "--" + aux.getDato().isStatus() + "-->";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, s);
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS");
        }
    }//fin mostrarEvento

    public void editarEvento() {

        if (!vaciaSC()) {
            boolean encontrado = false;
            try {
                String nombre = "";
                while (nombre.equals("")) {
                    nombre = JOptionPane.showInputDialog("Digite el nombre del evento a editar");
                }

                //buscado el evento
                NodoSC aux = inicioSC;
                char op = ' ';
                if (aux.getDato().getNombre().equals(nombre)) {
                    encontrado = true;
                    while (op != 'A' && op != 'B' && op != 'C' && op != 'D' && op != 'E' && op != 'S') {
                        op = JOptionPane.showInputDialog("Que Desea editar?"
                                + "\nA. Nombre (" + aux.getDato().getNombre() + ")"
                                + "\nB. Ciudad (" + aux.getDato().getCiudad() + ")"
                                + "\nC. Lugar (" + aux.getDato().getLugar() + ")"
                                + "\nD. Direccion (" + aux.getDato().getDireccion() + ")"
                                + "\nE. Fecha (" + aux.getDato().getFecha() + ")").toUpperCase().charAt(0);

                        switch (op) {
                            case 'A':
                                aux.getDato().setNombre(JOptionPane.showInputDialog("Digite el nuevo nombre: \n Actual: " + aux.getDato().getNombre()));
                                break;
                            case 'B':
                                aux.getDato().setCiudad(JOptionPane.showInputDialog("Digite la nueva ciudad: \n Actual: " + aux.getDato().getCiudad()));
                                break;//fin set ciudad
                            case 'C':
                                char op2 = JOptionPane.showInputDialog("Seleccione un lugar"
                                        + "\nA. ESTADIO"
                                        + "\nB. ANFITEATRO"
                                        + "\nC. TEATRO").toUpperCase().charAt(0);

                                switch (op2) {
                                    case 'A':
                                        aux.getDato().setLugar("ESTADIO");
                                        break;
                                    case 'B':
                                        aux.getDato().setLugar("ANFITEATRO");
                                        break;
                                    case 'C':
                                        aux.getDato().setLugar("TEATRO");
                                        break;

                                }
                                break;//fin set lugar
                            case 'D':
                                aux.getDato().setDireccion(JOptionPane.showInputDialog("Digite la nueva direccion:\nActual: " + aux.getDato().getDireccion()));
                                break;
                            case 'E':
                                aux.getDato().setFecha(JOptionPane.showInputDialog("Digite la nueva fecha 'dd/mm/aaaa' \nActual: " + aux.getDato().getFecha()));
                                break;

                            case 'S':
                                break;

                        }
                    }

                }//fin if
                aux = aux.getSiguiente();
                while (aux != inicioSC) {
                    if (aux.getDato().getNombre().equals(nombre)) {
                        encontrado = true;
                        while (op != 'A' && op != 'B' && op != 'C' && op != 'D' && op != 'E' && op != 'S') {
                            op = JOptionPane.showInputDialog("Que Desea editar?"
                                    + "\nA. Nombre (" + aux.getDato().getNombre() + ")"
                                    + "\nB. Ciudad (" + aux.getDato().getCiudad() + ")"
                                    + "\nC. Lugar (" + aux.getDato().getLugar() + ")"
                                    + "\nD. Direccion (" + aux.getDato().getDireccion() + ")"
                                    + "\nE. Fecha (" + aux.getDato().getFecha() + ")").toUpperCase().charAt(0);

                            switch (op) {
                                case 'A':
                                    aux.getDato().setNombre(JOptionPane.showInputDialog("Digite el nuevo nombre: \n Actual: " + aux.getDato().getNombre()));
                                    break;
                                case 'B':
                                    aux.getDato().setCiudad(JOptionPane.showInputDialog("Digite la nueva ciudad: \n Actual: " + aux.getDato().getCiudad()));
                                    break;//fin set ciudad
                                case 'C':
                                    op = JOptionPane.showInputDialog("Seleccione un lugar"
                                            + "\nA. ESTADIO"
                                            + "\nB. ANFITEATRO"
                                            + "\nC. TEATRO").toUpperCase().charAt(0);

                                    switch (op) {
                                        case 'A':
                                            aux.getDato().setLugar("ESTADIO");
                                            break;
                                        case 'B':
                                            aux.getDato().setLugar("ANFITEATRO");
                                            break;
                                        case 'C':
                                            aux.getDato().setLugar("TEATRO");
                                            break;

                                    }
                                    break;//fin set lugar
                                case 'D':
                                    aux.getDato().setDireccion(JOptionPane.showInputDialog("Digite la nueva direccion:\nActual: " + aux.getDato().getDireccion()));
                                    break;
                                case 'E':
                                    aux.getDato().setFecha(JOptionPane.showInputDialog("Digite la nueva fecha 'dd/mm/aaaa' \nActual: " + aux.getDato().getFecha()));
                                    break;

                                case 'S':
                                    break;

                            }
                        }

                    }
                    aux = aux.getSiguiente();
                }

                //------RECURSIVIDAD--------
                if (encontrado == true) {
                    char r = JOptionPane.showInputDialog("Desea editar otro evento?"
                            + "\nSI || NO").toUpperCase().charAt(0);
                    if (r == 'S') {
                        editarEvento();
                    }
                } else {
                    char r = JOptionPane.showInputDialog("No fue posible encontrar el evento \nDesea editar otro evento?"
                            + "\nSI || NO").toUpperCase().charAt(0);
                    if (r == 'S') {
                        editarEvento();
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al editar evento"
                        + "\n" + e.getMessage());
                char r = JOptionPane.showInputDialog("Desea intentar de nuevo?"
                        + "\nSI || NO").toUpperCase().charAt(0);
                if (r == 'S') {
                    editarEvento();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "LISTA VACIA");
        }

    }//fin editarEvento(){}

    public void inactivarEvento() {
        if (!vaciaSC()) {
            boolean encontrado = false;
            try {
                String nombre = "";
                while (nombre.equals("")) {
                    nombre = JOptionPane.showInputDialog("Digite el nombre del evento a desactivar");

                }

                //buscado el evento
                NodoSC aux = inicioSC;
                char op = ' ';
                if (aux.getDato().getNombre().equals(nombre)) {
                    encontrado = true;
                    if (aux.getDato().isStatus() == true) {
                        aux.getDato().setStatus(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "El evento se encuectra inactivo actualmente");
                    }
                }
                aux = aux.getSiguiente();
                while (aux != inicioSC) {
                    if (aux.getDato().getNombre().equals(nombre)) {
                        encontrado = true;
                        if (aux.getDato().isStatus() == true) {
                            aux.getDato().setStatus(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "El evento se encuectra inactivo actualmente");
                        }
                    }
                    aux = aux.getSiguiente();
                }

                //------RECURSIVIDAD--------
                if (encontrado == true) {
                    char r = JOptionPane.showInputDialog("Desea desactivar otro evento?"
                            + "\nSI || NO").toUpperCase().charAt(0);
                    if (r == 'S') {
                        editarEvento();
                    }
                } else {
                    char r = JOptionPane.showInputDialog("No fue posible encontrar el evento \nDesea desactivar  otro evento?"
                            + "\nSI || NO").toUpperCase().charAt(0);
                    if (r == 'S') {
                        editarEvento();
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al desactivar  evento"
                        + "\n" + e.getMessage());
                char r = JOptionPane.showInputDialog("Desea intentar de nuevo?"
                        + "\nSI || NO").toUpperCase().charAt(0);
                if (r == 'S') {
                    editarEvento();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS");
        }

    }//fin inactivarEvvento(){}
    
    //-----------------------------METODOS MODULO 3---------------------------------
    
    public void agregarAsiento(){}
}//fin clase LISTAES(){}
