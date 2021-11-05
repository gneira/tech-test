# Ejercicio pre proceso
 Este es un ejercicio para validar conocimientos en una pre prueba de selección
 
# Instalación
 Ir a la carpeta executable y descomprimir el archivo technical-test-0.0.1-SNAPSHOT.jar.zip, 
 luego dar permisos de ejecución a los archivos start.sh y stop.sh luego ejecutar el comando ./start.sh para levantar el servicio
 
# Datos de pruebas
 Ejecutar prueba a través del siguiente curl:
 ```json
 curl --location --request POST 'http://localhost:8080/user/v1' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name": "Juan Rodriguez",
	"email": "juan@rodriguez.org",
	"password": "Ahunter22",
	"phones": [
		{
			"number": "1234567",
			"citycode": "1",
			"contrycode": "57"
		}
	]
}'
```

# Swagger
Tambien se puede testear abriendo la url de swagger http://localhost:8080/swagger-ui/# luego seleccionar el post /user/v1, 
luego el boton try out y agregar la data json y presionar el boton execute.
```json
{
	"name": "Juan Rodriguez",
	"email": "juan@rodriguez.org",
	"password": "Ahunter22",
	"phones": [
		{
			"number": "1234567",
			"citycode": "1",
			"contrycode": "57"
		}
	]
}
```
