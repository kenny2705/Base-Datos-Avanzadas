/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco.control;

import com.mycompany.bancoGUI.DlgInicio;
import com.mycompany.bancoGUI.formCuenta;
import com.mycompany.bancoGUI.formIniciarSesion;
import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.daos.ClienteDAO;
import com.mycompany.bancopersistencia.daos.IClienteDAO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import javax.swing.JOptionPane;

/**
 *
 * @author Arturo ITSON
 */
public class control {
    
        //creamos los datos de acceso a la base de datos
        String cadenaConexion = "jdbc:mysql://localhost/Banco123";
        String usuario = "root";
        String contra = "1234";
        //creamos la conexion o el elemento para establecer la conexion
        IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
        //creamos el dao para manipular (en este caso enviar) los activistas
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    
 
    IClienteDAO cli = new ClienteDAO(conexionBD);
    
    public boolean iniciarSesion(int cuenta, String contra) throws PersistenciaException{

       if( cli.consultarClienteporNC(cuenta) != null){
           return true;
       }
       else{
           return false;
       }
    } 
    
    
    public void mostrarInicioSesion(){
        formIniciarSesion is = new formIniciarSesion();
        is.setVisible(true);
    }
    
    public void mostrarInicio(){
        formCuenta fc = new formCuenta();
        fc.setVisible(true);
        
    } 
    
//    public String regresarID(int id) throws PersistenciaException{
//        
//        int numero = id;
//        String valorr = String.valueOf(id);
//        
//        return valorr;
//       
//    }
    
    public void guardarID(int id) throws PersistenciaException{
         int valor = id;    
         formCuenta cue = new formCuenta();
         cue.setValor(String.valueOf(id));
    }
}
