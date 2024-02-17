/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

/**
 *
 * @author Arturo ITSON
 */
public class Cliente {
   
        
    //Clase POJO
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String fechaNacimiento; // "2023-3-2"
    
    
    public Cliente(){
    
    }

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String fechaNacimiento) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", domicilio=" + domicilio + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

    
    
}
