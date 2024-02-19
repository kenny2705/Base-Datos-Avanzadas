/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.controlador;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.conexion.dtos.CuentaNuevaDTO;
import com.mycompany.bancopersistencia.daos.ClienteDAO;
import com.mycompany.bancopersistencia.daos.CuentaDAO;
import com.mycompany.bancopersistencia.daos.IClienteDAO;
import com.mycompany.bancopersistencia.daos.ICuentaDAO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Arturo ITSON
 */
public class ControladorPersistencia {
    
    String cadenaConexion = "jdbc:mysql://localhost/Banco123";
    String usuario = "root";
    String contrasenia = "1234";
    IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contrasenia);
    IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    ICuentaDAO cuentaDAO = new CuentaDAO(conexionBD);
    
    public Cliente agregarCliente(ClienteNuevoDTO  client) throws PersistenciaException{
        Cliente clienteAgregado = this.clienteDAO.agregarCliente(client);
        return clienteAgregado;
    }
    
    public Cuenta agregarCuenta(CuentaNuevaDTO cuent) throws PersistenciaException{
        Cuenta cuentaAgregada = this.cuentaDAO.agregarCuenta(cuent);
        return cuentaAgregada;
    }
    
    
    public boolean existeCliente(String cuenta){
        
        
        
        return false;
    }
    
}
