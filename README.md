# Los Heroes API CRUD

![](
https://www.losheroes.cl/wps/wcm/connect/c1d8102a-dd6d-4b96-a3c8-3718be3f817a/Logo-LH-2020_4+-+copia.png?MOD=AJPERES&CACHEID=c1d8102a-dd6d-4b96-a3c8-3718be3f817a)

V1.0.0 c:


# Base de Datos

BD relacional con las siguientes tablas:

Customers:

```sh
customer_id
rut
names
surnames
email
birthday
```
Phones:

```sh
phone_id
phone_number
customer_id
```
Adresses:

```sh
adress_id
adress_customer
customer_id
```

El porque de tener un id como primary key y no ocupar el rut es por el simple hecho de escalabilidad. Si nos basamos en un contexto de una app local(Chile) utilizar el rut funcionaria. Si por el contrario a futuro existen planes de expansion a otros paises, un id seria optimo ya que recibiriamos otros formatos identificadores como dni.

Basado en lo anterior y en el contexto para esta solucion, 1 cliente puede tener 1 o mas numeros de telefono/celular y 1 o mas direcciones asociadas.
 
El deploy no contiene conexion a bd mysql externa por motivos de costos economicos. Esta con la bd h2 embebida.

El proyecto mantiene una estructura de organizacion con paquetes de entidades, servicios, repositorios y controladores. Lo hice de esa forma ya que es la mas comun y utilizada pero creo que seria mejor y mas mantenible agrupar por funcionalidades.

# Endpoints
 - Deploy en -> https://losheroesapi.herokuapp.com/api/v1


 - Swagger en -> https://losheroesapi.herokuapp.com/swagger-ui.html




| Metodo | Ruta | Response/Action |
| ------ | ------ | ------------------------|
| GET| /customers | Lista de clientes |
| GET| /customer/{id} | Cliente |
| POST| /customers | Agregar un cliente |
| PUT| /customers/{id} | Editar un cliente |
| DELETE| /customers/{id} | Eliminar un cliente |
| GET| /phones | Lista de telefonos |
| GET| /phones/{id} | Telefono |
| POST| /customers/{idCustomer}/phones | Agregar un telefono a un cliente |
| PUT| /phones/{id} | Editar un telefono |
| DELETE| /phones/{id} | Eliminar un telefono |
| GET| /adresses | Lista de direcciones |
| GET| /adresses/{id} | Direccion |
| POST| /customers/{idCustomer}/adresses | Agregar una Direccion a un cliente |
| PUT| /adresses/{id} | Editar una direccion |
| DELETE| /adresses/{id} | Eliminar una direccion |

*Al eliminar podria usarse borrado logico.

POST Customer Request Example
```sh
 {
        "rut": "17654875-2",
        "names": "Pedro Javier",
        "surnames": "Fernadez Inostroza",
        "email": "pjavievv@mail.com",
        "birthday": "1990-10-03"
 }
```
POST Customer Response Example
```sh
 {      "customerId": 100,
        "rut": "17654875-2",
        "names": "Pedro Javier",
        "surnames": "Fernadez Inostroza",
        "email": "pjavievv@mail.com",
        "birthday": "1990-10-03",
        "phones": null,
        "adresses": null
 }
```

# MySQL

**Para usar con bd mysql agregar al aplication.properties lo siguiente:
```sh
spring.datasource.url=jdbc:mysql://localhost:3306/nombredb
spring.datasource.username=usuariodb
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
```
# Exceptions

Las excepciones de la api son manejadas con la siguiente estructura:

ErrorSkeleton

```sh
{
    error = String / Error que puede traer atributos,
    message = String / Mensaje explicando el error,
    status = String / Estado HTTP, 
    code = int / Codigo del estado HTTP,
    detail = String / Detalles del error,
}
```