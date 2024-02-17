CREATE DATABASE Banco123;

use Banco123;


-- Creacion de la tabla Cliente
create table Cliente(
	idCliente int primary key not null auto_increment,
    nombre varchar(50),
    apellidoPaterno varchar(50),
	apellidoMaterno varchar(50),
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

-- Creacion de la tabla Transferencia
create table Transferencia(
	idOperacion int not null primary key,
    monto float,
    tipo varchar(15),
    fecha varchar(15),
    idCuentaEmisora int,
    idCuentaReceptora int,
    foreign key (idCuentaEmisora) references Cliente(idCliente),
	foreign key (idCuentaReceptora) references Cliente(idCliente)
);

-- Creacion de la tabla Retiro sin cuenta
create table retiroSC(
	idRetiroSC int not null primary key,
    fecha varchar(15),
    montoRetiro float,
    idCliente int,
    foreign key (IdCliente) references Cliente(idCliente)
    );
