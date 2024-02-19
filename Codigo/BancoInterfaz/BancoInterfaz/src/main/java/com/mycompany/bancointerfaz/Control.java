/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancointerfaz;

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
public class Control {
 
        //creamos los datos de acceso a la base de datos
        String cadenaConexion = "jdbc:mysql://localhost/Banco123";
        String usuario = "root";
        String contra = "1234";
        //creamos la conexion o el elemento para establecer la conexion
        IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
        //creamos el dao para manipular (en este caso enviar) los activistas
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    
    IClienteDAO ic = new ClienteDAO(conexionBD);
    
    
    public void consultarID(int id) throws PersistenciaException{
        
        
        ic.consultarClienteporNC(id);
            

        
    }
    
    
}
