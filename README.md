## Nisum API Reto Técnico

API REST que expone los endpoints:

```
POST   ->  http://localhost:8082/nisum-reto-tecnico/login
POST   ->  http://localhost:8082/nisum-reto-tecnico/api/v1/users
POST   ->  http://localhost:8082/nisum-reto-tecnico/api/v1/regexp
DELETE ->  http://localhost:8082/nisum-reto-tecnico/api/v1/regexp/{uuid}
```
RUTA DE SWAGGER: http://localhost:8082/nisum-reto-tecnico/swagger-ui/index.html

## Pasos a seguir para probar la API

Pasos a seguir para el funcionamiento de la solución de manera local.

### Pre-requisitos 

1) Ir a la consola h2 usando la siguiente ruta:

   
     http://localhost:8082/nisum-reto-tecnico/h2-console


2) Use la siguientes credenciales para acceder a la BD h2
   
     JDBC URL: jdbc:h2:mem:~/nisum-reto-tecnico

     USER: 'sa'

     PASSWORD: ''


3) Ejecutar el siguiente script para crear un usuario para el login inicial

```
INSERT INTO USERS
VALUES ('44db3-a397-e84de',
        CURRENT_TIMESTAMP(),
        'mcondorib@gmail.com',
        true,
        CURRENT_TIMESTAMP(),
       CURRENT_TIMESTAMP(),
       'marco condori',
        '$2a$12$mKN5ivlQ0nKNNoPwwy0OJ.2ZH29norAELfbYy4Zdu2mcLkjEwfIRi',
        'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtY29uZG9yaWJAZ21haWwuY29tIiwiZXhwIjoxNzIwNjAyMjczLCJub21icmUiOiJtYXJjbyBjb25kb3JpIn0.4Sw_iPY-xSeoCa4gTpexnM_Q5kOa633y1j0OnQVHwUc')
```

4) Ingresar a la siguiente ruta para obtener el Bearer Token en el header de Authorization

 http://localhost:8082/nisum-reto-tecnico/login


```
{
   "email": "mcondorib@gmail.com",
   "password": "123456"
}
```
5) Para registrar usuarios debemos ir a la siguiente ruta:

http://localhost:8082/nisum-reto-tecnico/api/v1/users

Luego agregaremos el Bearer Token en la pestaña de Authorization y en el BODy agregamos el siguiente JSON

```
{

    "name": "Juan Rodrigues",
    "email": "juanrodri@gmail.com",
    "password": "Dqq1a111",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}
```

obteniendo una respuesta como esta:

```
{
"id": "8f3a2c05-7182-47d5-a152-2dc81a864ee1",
"created": "2024-06-10 09:36:02",
"modified": "2024-06-10 09:36:02",
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtY29uZG9yaWJAZ21haWwuY29tIiwiZXhwIjoxNzIwNjE3NTQxLCJub21icmUiOiJtYXJjbyBjb25kb3JpIn0.Ij2QDGtpkNOdRG92KLYh5vv-YPY5nRW-7SoAImq7mPc",
"last_login": "2024-06-10T09:36:02.4508103",
"isactive": true
}
```