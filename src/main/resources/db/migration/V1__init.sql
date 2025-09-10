-- Script inicial de la base de datos para el Sistema de Gestión de Mantenimiento

-- Tabla de equipos
CREATE TABLE equipment (
                           id BIGSERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           description TEXT,
                           status VARCHAR(50)
);

-- Tabla de mantenimientos
CREATE TABLE maintenance (
                             id BIGSERIAL PRIMARY KEY,
                             equipment_id BIGINT NOT NULL,
                             type VARCHAR(50) NOT NULL, -- preventivo o correctivo
                             scheduled_date DATE NOT NULL,
                             performed_date DATE,
                             description TEXT,
                             status VARCHAR(50),
                             CONSTRAINT fk_equipment FOREIGN KEY (equipment_id) REFERENCES equipment(id)
);

-- Tabla de tareas de mantenimiento
CREATE TABLE maintenance_task (
                                  id BIGSERIAL PRIMARY KEY,
                                  maintenance_id BIGINT NOT NULL,
                                  task_description TEXT NOT NULL,
                                  responsible VARCHAR(255),
                                  completed BOOLEAN DEFAULT FALSE,
                                  CONSTRAINT fk_maintenance FOREIGN KEY (maintenance_id) REFERENCES maintenance(id)
);
