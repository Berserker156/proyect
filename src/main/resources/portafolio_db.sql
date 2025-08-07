-- Crea la base de datos
CREATE DATABASE portafolio_db;
GO

USE portafolio_db;
GO

-- Tabla de usuarios
CREATE TABLE usuarios (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(100) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL
);

-- Tabla de proyectos
CREATE TABLE proyectos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    nombre NVARCHAR(255) NOT NULL,
    descripcion NVARCHAR(1000),
    fecha_creacion DATETIME NOT NULL DEFAULT GETDATE(),
    url NVARCHAR(255)
);