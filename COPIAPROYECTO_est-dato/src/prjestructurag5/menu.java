/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prjestructurag5;

import javax.swing.JOptionPane;

/**
 *
 * @author Derek
 */
public class menu {

        public void inicioSesion() {
                char ini = ' ';
                while (ini != 'S') {
                        String user = JOptionPane.showInputDialog("Digite un usuario: (admin)");
                        String pass = JOptionPane.showInputDialog("Digite un contraseña: (admin)");

                        if (user.equals("admin") && pass.equals("admin")) {
                                JOptionPane.showMessageDialog(null, "BIENVENIDO USUARIO ADMINISTRADOR");
                                menuP();
                        } else {
                                ini = JOptionPane.showInputDialog("Desea salir:"
                                        + "SI || NO").toUpperCase().charAt(0);
                                if (ini == 'S') {
                                        JOptionPane.showMessageDialog(null, "HASTA LUEGO");
                                }
                        }
                }

        }//fin inicioSesion(){}

        public void menuP() {
                //---INSTACIAS--

                //----VARIABLES---
                char op1 = ' ';
                while (op1 != 'S') {
                        ListaES LES = new ListaES();
                        char op2 = ' ';
                        op1 = JOptionPane.showInputDialog("A. MODULO 1 (USUARIOS)"
                                + "\nB. MODULO 2 (EVENTOS)"
                                + "\nC. MODULO 3 (VENTAS)"
                                + "\nD. MODULO 4 (CAJAS)"
                                + "\nS. SALIR").toUpperCase().charAt(0);
                        switch (op1) {
                                case 'A': //MODULO USUARIOS

                                        while (op2 != 'S') {
                                                op2 = JOptionPane.showInputDialog("SELECCION LA OPCION:"
                                                        + "\nA. REGISTRO USUARIOS"
                                                        + "\nB. DESACTIVAR USUARIOS"
                                                        + "\nC. MOSTRAR USUARIOS"
                                                        + "\nS. SALIR").toUpperCase().charAt(0);
                                                switch (op2) {
                                                        case 'A':
                                                                LES.agregarUsuario();
                                                                break;
                                                        case 'B':
                                                                LES.desactivarUsuario();
                                                                break;
                                                        case 'C':
                                                                LES.mostrarUsuarios();
                                                                break;
                                                        case 'S':
                                                                break;
                                                        default:
                                                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                                }
                                        }
                                        break;//-----------------------
                                case 'B'://MODULO EVENTOS
                                        while (op2 != 'S') {
                                                op2 = JOptionPane.showInputDialog("SELECCIONE LA OPCION:"
                                                        + "\nA. AGREGAR EVENTO"
                                                        + "\nB. MOSTRAR EVENTOS"
                                                        + "\nC. EDITAR EVENTO"
                                                        + "\nD. INACTIVAR EVENTO"
                                                        + "\nS. SALIR").toUpperCase().charAt(0);
                                                switch (op2) {
                                                        case 'A':
                                                                LES.agregarEvento();
                                                                break;
                                                        case 'B':
                                                                LES.mostrarEvento();
                                                                break;
                                                        case 'C':
                                                                LES.editarEvento();
                                                                break;
                                                        case 'D':
                                                                LES.inactivarEvento();
                                                                break;
                                                        case 'S':
                                                                break;
                                                        default:
                                                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                                }
                                        }
                                        break;//-----------------------
                                case 'C'://MODULO VENTAS
                                        break;//-----------------------
                                case 'D'://MODULO CAJAS
                                        break;//-----------------------
                                case 'S'://SALIR
                                        inicioSesion();
                                        break;//-----------------------
                                default:
                                        JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                        }
                }
        }

}//fin menu class{}
