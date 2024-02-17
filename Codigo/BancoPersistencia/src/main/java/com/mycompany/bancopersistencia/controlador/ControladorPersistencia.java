/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.controlador;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.daos.ClienteDAO;
import com.mycompany.bancopersistencia.daos.IClienteDAO;
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
    
    public Cliente agregarCliente(ClienteNuevoDTO  client) throws PersistenciaException{
        Cliente clienteAgregado = this.clienteDAO.agregarCliente(client);
        return clienteAgregado;
    }
    
}
