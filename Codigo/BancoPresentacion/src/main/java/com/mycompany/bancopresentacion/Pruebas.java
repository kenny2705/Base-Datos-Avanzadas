/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopresentacion;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.controlador.ControladorDominio;
import com.mycompany.bancodominio.controlador.DominioException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo ITSON
 */
public class Pruebas {
    
    private static final Logger LOG = Logger.getLogger(Pruebas.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorDominio controlD = new ControladorDominio();
        
        Cliente clientAgregado;
        try {
            clientAgregado = controlD.agregarCliente("abc", "gv", "hola", "6666", "2025-1-1");
            LOG.log(Level.INFO, clientAgregado.toString());
        } catch (DominioException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO code application logic here
    }
}
