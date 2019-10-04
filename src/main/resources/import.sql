/* Roles */
INSERT INTO permisos (descripcion, permiso) VALUES ('Acceso a todos los niveles', 'ROLE_ADMIN');
INSERT INTO permisos (descripcion, permiso) VALUES ('Acceso limitado', 'ROLE_USER');

/* Usuarios */
INSERT INTO usuarios (apellido, nombre, documento, email, usuario, clave, salt, fk_id_permiso,  activo) VALUES ('González', 'Mauri', '00000000', 'admin@gmail.com',  'admin', '1234', '1234', '1', 1);

INSERT INTO provincias (nombre) VALUES ('Chaco');
INSERT INTO provincias (nombre) VALUES ('Corrientes');
INSERT INTO provincias (nombre) VALUES ('Formosa');

INSERT INTO localidades (cpa, nombre, fk_id_prv) VALUES (3500, 'Resistencia', 1);
INSERT INTO localidades (cpa, nombre, fk_id_prv) VALUES (3503, 'Barranqueras', 1);
INSERT INTO localidades (cpa, nombre, fk_id_prv) VALUES (3509, 'Gral. José de San Martín', 1);




INSERT INTO preguntas (nro, pregunta, fk_id_enc) VALUES (1, 'Como considera el transito en nuestra ciudad', 1);
INSERT INTO preguntas (nro, pregunta, fk_id_enc) VALUES (2, 'Condicion actual en la ciudad', 1);

INSERT INTO respuestas (fk_id_pre) VALUES (3);
INSERT INTO respuestas (fk_id_pre) VALUES (4);

INSERT INTO opciones (nro, opcion, fk_id_res) VALUES (1, 'Visitante-Turista', 1);
INSERT INTO opciones (nro, opcion, fk_id_res) VALUES (1, 'Vivo aqui', 2);

INSERT INTO opciones (nro, opcion, fk_id_pre) VALUES (1, 'Muy Bueno', 2);
INSERT INTO opciones (nro, opcion, fk_id_pre) VALUES (1, 'Bueno', 2);
INSERT INTO opciones (nro, opcion, fk_id_pre) VALUES (1, 'No Conozco', 2);
INSERT INTO opciones (nro, opcion, fk_id_pre) VALUES (1, 'Malo', 2);
INSERT INTO opciones (nro, opcion, fk_id_pre) VALUES (1, 'Muy Malo', 2);


