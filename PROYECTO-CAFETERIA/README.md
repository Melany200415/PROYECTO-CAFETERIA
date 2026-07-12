# PROYECTO-CAFETERIA

Sistema de gestión para una cafetería desarrollado con JavaFX y MySQL.

## Integrantes
- Melany Perugachi
- Esteban Rodríguez
- Fernanda Rodríguez
- Alessandro Pillajo

## Descripción
Aplicación de escritorio para la gestión de ventas de una cafetería, con módulo de login, administración de clientes, productos y control de usuarios por roles.

## Tecnologías
- Java 21+
- JavaFX 21
- Maven
- MySQL

## Requisitos
- JDK 21 o superior
- MySQL 8.0+
- Maven 3.8+

## Instalación
1. Clonar el repositorio
2. Importar en IntelliJ IDEA
3. Ejecutar el script `baseDatos.sql` en MySQL
4. Configurar la conexión en el archivo de configuración
5. Ejecutar: `mvn clean javafx:run`

## Estructura del proyecto
```
PROYECTO-CAFETERIA/
├── Trabajo_Cafeteria/
│   └── src/main/java/org/example/trabajo_cafeteria/
│       ├── controlador/    # Controllers JavaFX
│       ├── dao/            # Acceso a datos
│       ├── modelo/         # Claves del dominio
│       ├── lib/            # Utilidades
│       └── resources/vista/ # Archivos FXML
└── baseDatos.sql           # Script de base de datos
```

## Funcionalidades
- **Login** con autenticación de usuarios
- **Gestión de Clientes** (CRUD)
- **Gestión de Productos** (CRUD)
- **Control de roles** (Administrador, Cajero, Vendedor, etc.)

