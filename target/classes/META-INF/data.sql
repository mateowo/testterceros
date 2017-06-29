insert into STUDENT(ID, FIRSTNAME, LASTNAME) VALUES (1, 'first1', 'last1')
insert into STUDENT(ID, FIRSTNAME, LASTNAME) VALUES (2, 'first2', 'last2')
insert into STUDENT(ID, FIRSTNAME, LASTNAME) VALUES (3, 'first3', 'last3')
insert into STUDENT(ID, FIRSTNAME, LASTNAME) VALUES (4, 'first4', 'last4')

insert into COURSE(ID, NAME, CREDITS) VALUES (1, 'c1', 4)
insert into COURSE(ID, NAME, CREDITS) VALUES (2, 'c2', 3)
insert into COURSE(ID, NAME, CREDITS) VALUES (3, 'c3', 4)

insert into SECTION(ID, SEMESTER, COURSE_ID) VALUES (1, '20171', 1)
insert into SECTION(ID, SEMESTER, COURSE_ID) VALUES (2, '20171', 1)
insert into SECTION(ID, SEMESTER, COURSE_ID) VALUES (3, '20171', 2)

insert into SECTION_STUDENT(STUDENTS_ID, SECTION_ID) VALUES (1,1)

insert into SECTION_STUDENT(STUDENTS_ID, SECTION_ID) VALUES (2,1)
insert into SECTION_STUDENT(STUDENTS_ID, SECTION_ID) VALUES (3,1)
insert into SECTION_STUDENT(STUDENTS_ID, SECTION_ID) VALUES (4,2)
insert into SECTION_STUDENT(STUDENTS_ID, SECTION_ID) VALUES (2,3)
insert into SECTION_STUDENT(STUDENTS_ID, SECTION_ID) VALUES (3,3)

update SEQUENCE set SEQ_COUNT=1000



insert into ciudad(idCiudad, ciudad) VALUES (1, 'Bogota')
insert into ciudad(idCiudad, ciudad) VALUES (2, 'Medellin')
insert into ciudad(idCiudad, ciudad) VALUES (3, 'Pereira')

insert into tipoIdentificacion(idTipo, tipo) VALUES (1, 'CC')
insert into tipoIdentificacion(idTipo, tipo) VALUES (2, 'TI')
insert into tipoIdentificacion(idTipo, tipo) VALUES (3, 'NIT')

INSERT INTO CLASIFICACION (IDCLASIFICACION, CLASIFICACION, NUMEROCLASIFICACION)	VALUES (1, 'Nacionals', 1)
INSERT INTO CLASIFICACION (IDCLASIFICACION, CLASIFICACION, NUMEROCLASIFICACION) VALUES (2, 'Extranjeros', 1)
INSERT INTO CLASIFICACION (IDCLASIFICACION, CLASIFICACION, NUMEROCLASIFICACION) VALUES (3, 'Por Mayor', 2)
INSERT INTO CLASIFICACION (IDCLASIFICACION, CLASIFICACION, NUMEROCLASIFICACION) VALUES (4, 'Por Menorcito', 3)

INSERT INTO TIPOTERCERO (IDTIPOTERCERO, TIPOTERCERO) VALUES (1, 'Cliente')
INSERT INTO TIPOTERCERO (IDTIPOTERCERO, TIPOTERCERO) VALUES (2, 'Banco')
INSERT INTO TIPOTERCERO (IDTIPOTERCERO, TIPOTERCERO)VALUES (3, 'Vendedor')


INSERT INTO TIPOCONTRIBUYENTE (IDTIPOCONTRIBUYENTE, TIPOCONTRIBUYENTE) VALUES (1, 'Persona Fiscal')
 INSERT INTO TERCERO (IDTERCERO, ACTIVO, CODIGO, DESCUENTO, FECHA_CREACION, IDENTIFICACION, IMAGEN, OBSERVACION, PLAZO, PRIMERAPRELLIDO, PRIMERNOMBRE, SEGUNDOAPELLIDO, SEGUNDONOMBRE, IDCIUDAD, IDTIPO, IDTIPOCONTRIBUYENTE) 
	VALUES (5, 1, '12345', 0.0, '2017-06-27', '12054', NULL, 'Buenempleado', 1, 'Perez', 'Pepo', 'Gomez', 'Juan', 1, 1, 1)


INSERT INTO TERCEROXTIPOTERCERO (IDTIPOTERCERO, IDTERCERO) VALUES (3, 5)


ALTER TABLE contacto MODIFY COLUMN idContacto int AUTO_INCREMENT


ALTER TABLE
TERCERO
ADD CONSTRAINT "UNICA"
UNIQUE ( IDENTIFICACION, IDTIPO )



