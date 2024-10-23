
CREATE DATABASE api_market;

-- DROP SCHEMA zemsania;

CREATE SCHEMA zemsania AUTHORIZATION postgres;

-- zemsania.franquicia definition

-- Drop table

-- DROP TABLE zemsania.franquicia;

CREATE TABLE zemsania.franquicia (
	franquicia_id bigserial NOT NULL,
	franquiciado varchar(255) NULL,
	franquiciante varchar(255) NULL,
	modelo_negocio varchar(255) NULL,
	nombre varchar(255) NULL,
	status varchar(255) NULL,
	create_at timestamp(6) NULL,
	CONSTRAINT franquicia_pkey PRIMARY KEY (franquicia_id)
);

-- zemsania.producto definition

-- Drop table

-- DROP TABLE zemsania.producto;

CREATE TABLE zemsania.producto (
	producto_id bigserial NOT NULL,
	categoria varchar(255) NULL,
	create_at timestamp(6) NULL,
	nombre varchar(255) NULL,
	status varchar(255) NULL,
	stock int4 NULL,
	sucursal_id varchar(255) NULL,
	CONSTRAINT producto_pkey PRIMARY KEY (producto_id)
);

-- zemsania.sucursal definition

-- Drop table

-- DROP TABLE zemsania.sucursal;

CREATE TABLE zemsania.sucursal (
	sucursal_id bigserial NOT NULL,
	direccion varchar(255) NULL,
	franquicia_id varchar(255) NULL,
	status varchar(255) NULL,
	create_at timestamp(6) NULL,
	CONSTRAINT sucursal_pkey PRIMARY KEY (sucursal_id)
);

