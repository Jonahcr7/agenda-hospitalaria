CREATE TABLE cita(
    id BIGSERIAL NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
    estado VARCHAR(20) NOT NULL,
    motivo_consulta VARCHAR(255) NOT NULL,
    id_medico BIGINT NOT NULL,
    id_paciente BIGINT NOT NULL,
    CONSTRAINT pk_cita PRIMARY KEY(id),
    CONSTRAINT fk_cita_medico FOREIGN KEY(id_medico) REFERENCES medico(id),
    CONSTRAINT fk_cita_paciente FOREIGN KEY(id_paciente) REFERENCES paciente(id)
);