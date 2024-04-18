# API CON SPRING BOOT

Este proyecto es una Api utlizando Spring boot donde su funcionalidad es para un bazar donde se puede crear, modificar, eliminar y editar clientes, productos y ventas.

### Autor 

Hector Nicolas Atencio

### Instalacion

- Clonar el repositorio

### A tener en cuenta

- El proyecto esta configurado para que la administracion de la base de datos MySQL sea a travez de phpMyAdmin
- JDK 21

### Desplegar proyecto

Para el correcto despliegue del proyecto debe crear una base de datos en phpMyAdmin llamada base_proyecto_todocode

### Peticiones

Se recomienda para observar el correcto funcionamiento del proyecto realizar las siguientes peticiones HTTP en el siguiente orden:

- Creacion de un cliente en el edpoint correspondiente pasar por body
{
    "nombre": "Alguien",
    "apellido": "Primero",
    "dni": "111"
}

- Creacion de otro cliente pasar por body
{
    "nombre": "Otro",
    "apellido": "Segundo",
    "dni": "222"
}

- Creacion de un producto pasar por body 
{
    "nombre": "Producto 1",
    "marca": "Buena",
    "costo": 200,
    "cantidad_disponible": 10
}

- Creacion de otro producto pasar por body 
{
    "nombre": "Producto 2",
    "marca": "Mejor",
    "costo": 500,
    "cantidad_disponible": 20
}

- Creacion de una venta pasar por body 
{
    "fecha_venta": "2024-04-16",
    "detalleVentas": [
        {
            "producto":{
                "codigo_producto": 1
            },
            "cantidad": 1
        },
        {
            "producto": {
                "codigo_producto": 2
            },
            "cantidad": 1
        }
    ],
    "unCliente":{
        "id_cliente": 1
    }
}
