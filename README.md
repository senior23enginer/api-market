api-market

#URL SWAGGER DOCUMENTATION
http://127.0.0.1:8080/swagger-ui/index.html

#Actuactor
http://127.0.0.1:8080/actuator/health/

#DockerFile
docker build -t api-market .
docker-compose up

instrucciones:
- se requiere crear la base de datos, para esto se puede utilizar el api_market.sql para crear la base de datos (Postgrel SQL)
  junto con el esquema.
- para la pruebas de los endpoints se puede utilizar una coleccion de postman donde esta definido cada endpoints .
- se adjunto la carpeta recursos donde esta contenido las evidencias de las pruebas de cada endpoint, esquema de la base
  de datos.
