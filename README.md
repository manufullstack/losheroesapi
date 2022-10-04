# Los Heroes API CRUD


[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

BD relacional con las siguientes tablas:
- Customers
- Phones
- Adresses

Basado en lo anterior 1 cliente puede tener 1 o mas numeros de telefono/celular y 1 o mas direcciones asociadas.

El proyecto mantiene uan estructura de organizacion con paquetes de entidades, servicios, repositorios y controladores. Lo hice de esa forma ya que es la mas comun utilizada pero creo que seria mejor y mas mantenible agrupar por funcionalidades.

# Endpoints
 - Deploy en -> https://losheroesapi.herokuapp.com/api/v1/
 - Swagger en -> https://losheroesapi.herokuapp.com/swagger-ui.html
 El deploy no contiene conexion a bd mysql externa por motivos de costos. Esta con la h2 embebida.

| Metodo | Ruta | Response |
| ------ | ------ | ------------------------|
| GET| /customers || Lista de clientes |
| GET| /customer/id || Cliente |
| POST| /customers || Agregar un cliente |
| PUT| /customers/id || Editar un cliente |
| DELETE| /customers/id || Eliminar un cliente |
| GET| /phones || Lista de telefonos |
| GET| /phones/id || Telefono |
| POST| /customers/id/phones || Agregar un telefono a un cliente |
| PUT| /phones/id || Editar un telefono |
| DELETE| /phones/id || Eliminar un telefono |
| GET| /adresses || Lista de direcciones |
| GET| /adresses/id || Direccion |
| POST| /customers/id/adresses || Agregar una Direccion a un cliente |
| PUT| /adresses/id || Editar una direccion |
| DELETE| /adresses/id || Eliminar una direccion |

*Al eliminar podria usarse borrado logico.

***Falta validar excepciones con RuntimeException. Las reglas de negocio de rut y email no repetidos estan validadas.


**Para usaar con bd mysql agregar al aplication.properties lo siguiente:

spring.datasource.url=jdbc:mysql://localhost:3306/nombredb
spring.datasource.username=usuariodb
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect