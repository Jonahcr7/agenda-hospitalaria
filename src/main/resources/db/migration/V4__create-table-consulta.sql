CREATE TABLE consulta(
    id BIGSERIAL NOT NULL,
    fecha_hora_de_atencion TIMESTAMP NOT NULL,
    sintomas TEXT NOT NULL,
    diagnostico TEXT NOT NULL,
    tratamiento TEXT,
    observaciones TEXT,
    id_cita BIGINT NOT NULL UNIQUE,
    CONSTRAINT pk_consulta PRIMARY KEY(id),
    CONSTRAINT fk_consulta_cita FOREIGN KEY(id_cita) REFERENCES cita(id)
);