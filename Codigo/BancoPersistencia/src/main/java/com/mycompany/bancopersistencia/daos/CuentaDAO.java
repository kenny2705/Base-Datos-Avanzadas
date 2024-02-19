/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.conexion.dtos.CuentaNuevaDTO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arturo ITSON
 */
public class CuentaDAO implements ICuentaDAO {
    
    IConexionBD conexionBD;
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public CuentaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public Cuenta agregarCuenta(CuentaNuevaDTO cuenta) throws PersistenciaException {
        //1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO Cuenta (contra, fechaApertura,saldo, idCliente) VALUES (?,?,?,?)";

        //2. Vamos a insertar o intentar hacer la inserción en la tabla
        // Try With Resources
        try (//recursos
                Connection conexion = this.conexionBD.crearConexion(); //  establecemos la conexion con la bd
                //Crear el statement o el comando donde ejecutamos la sentencia
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            //3. mandar los valores del activista al comandoSQL
            comandoSQL.setString(1, cuenta.getContra());
            comandoSQL.setString(2, cuenta.getFechaApertura());
            comandoSQL.setFloat(3, cuenta.getSaldo());
            comandoSQL.setInt(4, cuenta.getIdCliente());

            //4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            //nos posicionamos en el primer registro o en el siguiente disponible. 
            registroGenerado.next();

            Cuenta cuentaNueva = new Cuenta(
                    registroGenerado.getInt(1),
                    cuenta.getContra(),
                    cuenta.getFechaApertura(),
                    cuenta.getSaldo(),
                    cuenta.getIdCliente()
            );
            // regresamos la cuenta
            return cuentaNueva;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito la cuenta", e);
            throw new PersistenciaException("No se pudo guardar la cuenta ", e);

        }

    }    
    
    
}
