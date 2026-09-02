CREATE TABLE paciente(
    id BIGSERIAL NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    email VARCHAR(100),
    telefono VARCHAR(20) NOT NULL,
    fecha_nacimiento DATE,
    documento_identidad VARCHAR(50) NOT NULL UNIQUE,
    CONSTRAINT pk_paciente PRIMARY KEY(id)
);