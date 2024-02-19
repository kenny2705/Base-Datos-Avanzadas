/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

/**
 *
 * @author Arturo ITSON
 */
public class Cuenta {
    
    //Clase POJO
    private int numeroCuenta;
    private String contra;
    private String fechaApertura;
    private float saldo;
    private int idCliente;
    
    
    public Cuenta(){
    
    }

    public Cuenta(String contra, String fechaApertura, float saldo, int idCliente) {
        this.contra = contra;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Cuenta(int numeroCuenta, String contra, String fechaApertura, float saldo, int idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.contra = contra;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", contra=" + contra + ", fechaApertura=" + fechaApertura + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }
    
    
    
    
}
