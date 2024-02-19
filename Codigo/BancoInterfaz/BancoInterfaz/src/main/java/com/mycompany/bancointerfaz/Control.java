/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancointerfaz;

import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancopersistencia.conexion.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.conexion.dtos.CuentaNuevaDTO;
import com.mycompany.bancopersistencia.conexion.ConexionBD;
import com.mycompany.bancopersistencia.conexion.IConexionBD;
import com.mycompany.bancopersistencia.daos.ClienteDAO;
import com.mycompany.bancopersistencia.daos.CuentaDAO;
import com.mycompany.bancopersistencia.daos.IClienteDAO;
import com.mycompany.bancopersistencia.daos.ICuentaDAO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Arturo ITSON
 */
public class Control {
    
    
        private static final Logger LOG = Logger.getLogger(Control.class.getName());

 
        //creamos los datos de acceso a la base de datos
        String cadenaConexion = "jdbc:mysql://localhost/Banco123";
        String usuario = "root";
        String contra = "1234";
        //creamos la conexion o el elemento para establecer la conexion
        IConexionBD conexionBD = new ConexionBD(cadenaConexion, usuario, contra);
        //creamos el dao para manipular (en este caso enviar) los activistas
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
    
        IClienteDAO ic = new ClienteDAO(conexionBD);
        ICuentaDAO icu = new CuentaDAO(conexionBD);

        
    
    public void consultarID(int id) throws PersistenciaException{    
        
        ic.consultarClienteporNC(id);
        
    }
    
    
    
    public void registrarse(String nombre, String apellidoP, String apellidoM, String domicilio, String nacimiento, String contra) throws PersistenciaException{
        
        
        Calendar calendario = Calendar.getInstance();
        String anio = String.valueOf(calendario.get(Calendar.YEAR));
        String mes = String.valueOf(calendario.get(Calendar.MONTH) + 1);
        String dia = String.valueOf(calendario.get(Calendar.DATE));
        String fechaHoy = dia + "/" + mes + "/" + anio ;
        
        
        ClienteNuevoDTO cn = new ClienteNuevoDTO(nombre, apellidoP, apellidoM, domicilio, nacimiento);
        
        
        try{
           Cliente generado = ic.agregarCliente(cn);           
            
                    try{
                        
                        CuentaNuevaDTO cu = new CuentaNuevaDTO(contra, fechaHoy, 0, generado.getIdCliente());
        
                        icu.agregarCuenta(cu);
                        
                        JOptionPane.showConfirmDialog(null, "hh");
                        JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente " , "OK Mensaje", JOptionPane.YES_OPTION);
                        JOptionPane.showMessageDialog(null, "Su Numero de cuenta es: " + generado.getIdCliente());
                        }
        
                    catch (Exception e){
                        
                          LOG.log(Level.SEVERE, "No se pudo agregar", e);
                          //JOptionPane.showMessageDialog(null, "Error, no se pudo crear la cuenta", "ERROR_MESSAGE", JOptionPane.WARNING_MESSAGE);

                        }
            
            }
        
        
        
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo agregar el cliente", "ERROR_MESSAGE", JOptionPane.WARNING_MESSAGE);

        }
        
        
        
    }
    

    
    
}
