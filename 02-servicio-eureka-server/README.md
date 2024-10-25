# Manual para Compilar y Ejecutar un Servicio de Discovery con Spring Eureka

Este manual te guiará para compilar y ejecutar un **servicio de Discovery** basado en **Spring Eureka** utilizando Maven.


## Paso 1: Clonar o Acceder al Proyecto

Si aún no tienes el proyecto en tu máquina, clónalo o navega al directorio del proyecto. Usa el siguiente comando para clonar desde un repositorio (reemplaza `<repository-url>` con la URL de tu repositorio):

```bash
git clone https://github.com/Rincon10/AYGO-LAB01.git
cd 02-servicio-eureka-server
```

## Paso 2: Compilar el Proyecto con Maven

n el directorio raíz del proyecto, ejecuta el siguiente comando 

```bash
mvn clean install
```

### Paso 3: Comandos para ejecutar la aplicacion 

Para ejecutar el proyecto usa el siguiente comando:

### Windows


```bash
java -cp "target/classes;target/dependency/*" com.escuelaing.edu.co.distribuited_systems.eureka.servicio_eureka_server.ServicioEurekaServerApplication
```

### Linux

```bash
java -cp "target/classes:target/dependency/*" com.escuelaing.edu.co.distribuited_systems.eureka.servicio_eureka_server.ServicioEurekaServerApplication
```

si, todo ejecuta de manera correcta deberia ver el siguiente log

![alt text](../docs/img/04-cmd-eureka.png)

y si accedemos a el puerto 8761, veremos todos los servicios suscritos

![!\[alt text\](../docs/img/03-front.png)](../docs/img/05-eureka.png)

## Manual de creacion de imagen docker

vamos a crear la imagen docker:
### Comandos Docker

```bash 
docker build --tag miusuario/servicio-eureka:1.0 .
```

iniciando contenedor
```bash
docker run -d -p <puerto_host>:<puerto_contenedor> --name nombre_instancia <tu_usuario_docker>/<nombre_imagen>:<versión>
```

entonces ejecutamos 

```bash
docker run -d -p 8761:8761 --name instancia1-eureka rincon10/servicio-eureka:1.0 
```


si todo sale bien veriamos que el contenedor se esta ejecutando de manera correcta con 

```bash
docker ps -a
```

![alt text](../docs/img/06-eureka-docker.png)


### publicando la imagen

Para publicar la imagen en Docker Hub, sigue estos pasos:

```bash
docker login
```