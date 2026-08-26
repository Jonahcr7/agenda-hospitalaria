CREATE TABLE medico(
    id BIGSERIAL NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    cedula VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100),
    telefono VARCHAR(20),
    especialidad VARCHAR(50) NOT NULL,
    PRIMARY KEY (id));