
CREATE TABLE public.usuario (
                cod_usuario VARCHAR NOT NULL,
                nombre_usuario VARCHAR NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (cod_usuario)
);


CREATE TABLE public.repuestos (
                cod_repuesto INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                precio INTEGER NOT NULL,
                CONSTRAINT repuestos_pk PRIMARY KEY (cod_repuesto)
);


CREATE TABLE public.Mecanico (
                codigo_mecanico INTEGER NOT NULL,
                cedula INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                apellido VARCHAR NOT NULL,
                direccion VARCHAR NOT NULL,
                CONSTRAINT mecanico_pk PRIMARY KEY (codigo_mecanico)
);


CREATE TABLE public.cliente (
                cedula INTEGER NOT NULL,
                nombre VARCHAR NOT NULL,
                apellido VARCHAR NOT NULL,
                direccion VARCHAR NOT NULL,
                telefono VARCHAR NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (cedula)
);


CREATE TABLE public.vehiculo (
                matricula VARCHAR NOT NULL,
                cedula INTEGER NOT NULL,
                modelo VARCHAR NOT NULL,
                color VARCHAR NOT NULL,
                fecha_entrada DATE NOT NULL,
                CONSTRAINT vehiculo_pk PRIMARY KEY (matricula)
);


CREATE TABLE public.reparacion (
                cod_repuesto INTEGER NOT NULL,
                matricula VARCHAR NOT NULL,
                descripcion VARCHAR NOT NULL,
                CONSTRAINT reparacion_pk PRIMARY KEY (cod_repuesto, matricula)
);


CREATE TABLE public.factura (
                cod_factura VARCHAR NOT NULL,
                cod_repuesto INTEGER NOT NULL,
                matricula VARCHAR NOT NULL,
                cod_usuario VARCHAR NOT NULL,
                documento_cliente VARCHAR NOT NULL,
                total REAL NOT NULL,
                CONSTRAINT factura_pk PRIMARY KEY (cod_factura, cod_repuesto, matricula, cod_usuario)
);


CREATE TABLE public.mecanico_vehiculo (
                matricula VARCHAR NOT NULL,
                codigo_mecanico INTEGER NOT NULL,
                CONSTRAINT mecanico_vehiculo_pk PRIMARY KEY (matricula, codigo_mecanico)
);


ALTER TABLE public.factura ADD CONSTRAINT usuario_factura_fk
FOREIGN KEY (cod_usuario)
REFERENCES public.usuario (cod_usuario)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reparacion ADD CONSTRAINT repuestos_reparacion_fk
FOREIGN KEY (cod_repuesto)
REFERENCES public.repuestos (cod_repuesto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.mecanico_vehiculo ADD CONSTRAINT mecanico_mecanicovehiculo_fk
FOREIGN KEY (codigo_mecanico)
REFERENCES public.Mecanico (codigo_mecanico)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.vehiculo ADD CONSTRAINT cliente_telefono_fk
FOREIGN KEY (cedula)
REFERENCES public.cliente (cedula)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.mecanico_vehiculo ADD CONSTRAINT telefono_mecanicovehiculo_fk
FOREIGN KEY (matricula)
REFERENCES public.vehiculo (matricula)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reparacion ADD CONSTRAINT telefono_reparacion_fk
FOREIGN KEY (matricula)
REFERENCES public.vehiculo (matricula)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.factura ADD CONSTRAINT reparacion_factura_fk
FOREIGN KEY (cod_repuesto, matricula)
REFERENCES public.reparacion (cod_repuesto, matricula)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
