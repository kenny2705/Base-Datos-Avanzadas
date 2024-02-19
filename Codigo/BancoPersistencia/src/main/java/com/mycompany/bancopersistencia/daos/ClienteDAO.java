/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo ITSON
 */
public class ClienteDAO implements IClienteDAO{
    
    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws PersistenciaException {
        //1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO Cliente (nombre, apellidoPaterno, apellidoMaterno, domicilio, fechaNacimiento) VALUES (?,?,?,?,?)";

        //2. Vamos a insertar o intentar hacer la inserción en la tabla
        // Try With Resources
        try (//recursos
                Connection conexion = this.conexionBD.crearConexion(); //  establecemos la conexion con la bd
                //Crear el statement o el comando donde ejecutamos la sentencia
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            //3. mandar los valores del activista al comandoSQL
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getDomicilio());
            comandoSQL.setString(5, cliente.getFechaNacimiento());

            //4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            //nos posicionamos en el primer registro o en el siguiente disponible. 
            registroGenerado.next();

            Cliente clienteNuevo = new Cliente(
                    registroGenerado.getInt(1),
                    cliente.getNombre(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getDomicilio(),
                    cliente.getFechaNacimiento()
            );
            // regresamos el cliente
            return clienteNuevo;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);

        }

    }

    @Override
    public Cliente consultarClienteporNC(int id) throws PersistenciaException {
        //1. realizar la consulta
        String consulta = "SELECT * FROM Cliente WHERE idCliente = (?)";

        // INICIAMOS la ejecucion
        try (Connection conexion = this.conexionBD.crearConexion();
                PreparedStatement comandoSQL = conexion.prepareStatement(consulta);) {
            
            comandoSQL.setInt(1, id);
            ResultSet resultado = comandoSQL.executeQuery();

            resultado.next();

            Cliente clienteConsultado = new Cliente(
                    resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5),
                    resultado.getString(6));

            //regresamos el activista consultado
            return clienteConsultado;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Cliente no encontrado", e);
            throw new PersistenciaException("No se ha encontrado ningún activista", e);
            
        }

    }

    @Override
    public List<Cliente> consultarTodosClientes() throws PersistenciaException {
        String sentenciaSQL = "SELECT * FROM Cliente";
        List<Cliente> listaClientes = new ArrayList<>();

        try (Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL);) {
            ResultSet resultado = comandoSQL.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("idCliente");
                String nombre = resultado.getString("nombre");
                String apellidoP = resultado.getString("apellidoPaterno");
                String apellidoM = resultado.getString("apellidoMaterno");
                String telefono = resultado.getString("domicilio");
                String fechaI = resultado.getString("fechaNacimiento");
                Cliente client = new Cliente(id, nombre, apellidoP, apellidoM, telefono, fechaI);
                listaClientes.add(client);

            }
            LOG.log(Level.INFO, "Se consultaron {0} clientes", listaClientes.size());
            return listaClientes;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
            throw new PersistenciaException("No se pudieron consultar los clientes", e);

        }

    }

}
