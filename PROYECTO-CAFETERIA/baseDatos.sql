-- Crear la base de datos
CREATE DATABASE sistema_ventas;
USE sistema_ventas;

-- ==========================
-- TABLA CLIENTE
-- ==========================
CREATE TABLE cliente(
    cedula VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    correo VARCHAR(100) NOT NULL
);

INSERT INTO cliente VALUES
('1712345678','María López','0987654321','maria@gmail.com'),
('1723456789','Carlos Pérez','0998765432','carlos@gmail.com'),
('1734567890','Ana Torres','0976543210','ana@gmail.com'),
('1745678901','Luis Mendoza','0965432109','luis@gmail.com'),
('1756789012','Gabriela Castro','0954321098','gabriela@gmail.com'),
('1767890123','Miguel Herrera','0943210987','miguel@gmail.com'),
('1778901234','Fernanda Rodríguez','0932109876','fernanda@gmail.com'),
('1789012345','Ricardo Gómez','0921098765','ricardo@gmail.com'),
('1790123456','Valentina Ruiz','0910987654','valentina@gmail.com'),
('1701234567','Jorge Salazar','0909876543','jorge@gmail.com');

-- ==========================
-- TABLA PRODUCTOS
-- ==========================
CREATE TABLE productos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

INSERT INTO productos(nombre,precio,stock) VALUES
('Laptop Lenovo',850.00,15),
('Mouse Logitech',18.50,50),
('Teclado Mecánico',45.90,30),
('Monitor Samsung 24"',220.00,18),
('Impresora Epson',175.50,12),
('Disco SSD 1TB',98.99,25),
('Memoria USB 64GB',12.75,80),
('Audífonos Bluetooth',39.99,40),
('Webcam HD',55.00,22),
('Router WiFi',65.80,16);

-- ==========================
-- TABLA USUARIO
-- ==========================
CREATE TABLE usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(30) NOT NULL UNIQUE,
    clave VARCHAR(30) NOT NULL,
    rol VARCHAR(20) NOT NULL
);

INSERT INTO usuario(usuario,clave,rol) VALUES
('admin','Admin123','Administrador'),
('cajero1','Caja123','Cajero'),
('cajero2','Caja456','Cajero'),
('vendedor1','Venta123','Vendedor'),
('vendedor2','Venta456','Vendedor'),
('bodega1','Bodega123','Bodega'),
('supervisor','Super123','Supervisor'),
('gerente','Gerente123','Gerente'),
('recepcion','Recep123','Recepcionista'),
('invitado','Invitado123','Invitado');