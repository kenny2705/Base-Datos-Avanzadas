/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio.controlador;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.controlador.ControladorPersistencia;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo ITSON
 */
public class ControladorDominio {
    
    
    ControladorPersistencia controlPersistencia = new ControladorPersistencia();

    public Cliente agregarCliente(String nombre, String apellidoPatero, String apellidoMaterno, String domicilio, String fechaNacimiento) throws DominioException {
        ClienteNuevoDTO clienteDTO = new ClienteNuevoDTO(nombre, apellidoPatero, apellidoMaterno, domicilio, fechaNacimiento);
        Cliente clienteAgregado;
        
        try {
            clienteAgregado = this.controlPersistencia.agregarCliente(clienteDTO);
            return clienteAgregado;

        }

        catch (PersistenciaException ex) {
            Logger.getLogger(ControladorDominio.class.getName()).log(Level.SEVERE, null, ex);
            throw  new DominioException("No se agrego", ex);
        }
    }

    // pendiente
}
