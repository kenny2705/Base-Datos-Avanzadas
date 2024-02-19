/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bancopersistencia.daos;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancopersistencia.conexion.dtos.CuentaNuevaDTO;
import com.mycompany.bancopersistencia.excepciones.PersistenciaException;

/**
 *
 * @author Arturo ITSON
 */
public interface ICuentaDAO {
    
    
        public Cuenta agregarCuenta(CuentaNuevaDTO cuenta) throws PersistenciaException;
        public Cuenta consultarCuentaPorContra(String contra) throws PersistenciaException;
        public float consultarSaldo(String contra) throws PersistenciaException;
}
