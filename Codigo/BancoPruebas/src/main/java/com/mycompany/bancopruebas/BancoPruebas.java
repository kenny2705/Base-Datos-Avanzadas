/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bancopruebas;

import com.mycompany.bancodominio.Cliente;

import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.daos.ClienteDAO;
import com.mycompany.bancopersistencia.daos.IClienteDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo ITSON
 */
public class BancoPruebas {

    private static final Logger LOG = Logger.getLogger(BancoPruebas.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creamos los datos de acceso a la base de datos
        String cadenaConexion = "jdbc:mysql://localhost/Banco123";
        String usuario = "root";
        String contra = "1234";
        //creamos la conexion o el elemento para establecer la conexion
        IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
        //creamos el dao para manipular (en este caso enviar) los activistas
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        
       
        
///////////////////////////////////////////////////////////////////////////////////////        
// aqui codigo de prueba para agregar un cliente
        ClienteNuevoDTO prueba = new ClienteNuevoDTO("Arturo", "Garcia", "Ramirez", "Obregon", "16/02/2024");
        
        
        try {
            //creamos un cliente para guardar el activista que nos regresa el metodo
            Cliente activistaAgregado = clienteDAO.agregarCliente(prueba);
            LOG.log(Level.INFO, activistaAgregado.toString());
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudo agregar", e);
        }
        
        

////////////////////////////////////////////////////////////////////////////////////////////
// Aqui codigo de prueba para consultar los clientes

        try {
            List<Cliente> listaClientes = clienteDAO.consultarTodosClientes();
            listaClientes.forEach(activista -> System.out.println(activista.toString()));

        } catch (Exception e) {
            LOG.log(Level.SEVERE, null, e);

        }

        // TODO code application logic here
    }
}
