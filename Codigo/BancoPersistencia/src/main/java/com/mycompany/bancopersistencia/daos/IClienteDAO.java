/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Arturo ITSON
 */
public interface IClienteDAO {
    
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException;
   // public Cliente obtenerID() throws PersistenciaException;
    public Cliente consultarClienteporNC(int id) throws PersistenciaException;
    public List<Cliente> consultarTodosClientes() throws PersistenciaException;
    
}
