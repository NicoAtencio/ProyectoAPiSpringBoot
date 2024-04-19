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

Se recomienda para observar el correcto funcionamiento del proyecto realizar las siguientes peticiones HTTP en el siguiente orden, en este caso se usa el puerto local 8080 pero en caso de usar otro puerto se debe modificar el puerto en la url:

- Creacion de un cliente en el edpoint correspondiente POST http://localhost:8080/cliente/crear pasar por body
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

- Creacion de un producto POST http://localhost:8080/productos/crear  pasar por body
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

- Creacion de una venta POST http://localhost:8080/ventas/crear pasar por body
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

- Mostrar los productos que tengan la misma o menor cantidad con respecto al parametro que le pasemos con endpoint GET http://localhost:8080/productos/cantidadmaxima/10 En este caso mostrará todos los productos que tienen 10 o menos cantidad de stock. Se puede pasar el numero que se desee.

- Mostrar los productos con detalles de una venta GET http://localhost:8080/ventas/productos/{id_venta} Devolverá un arreglo de los productos de una venta especifica.


