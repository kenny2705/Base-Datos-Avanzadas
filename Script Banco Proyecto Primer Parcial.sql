CREATE DATABASE Banco123;

use Banco123;


-- Creacion de la tabla Cliente
create table Cliente(
	idCliente int primary key not null auto_increment,
    nombre varchar(50),
    apellidoPaterno varchar(50),
	apelldoMaterno varchar(50),
	domicilio varchar (100),
    fechaNacimiento varchar(15)
);

-- Creacion de la tabla Cuenta
create table Cuenta(
	numeroCuenta int not null primary key auto_increment,
    fechaApertura varchar(15),
	saldo float,
    idCliente int,
    foreign key (idCliente) references Cliente(idCliente)
);