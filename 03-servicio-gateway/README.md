# Manual para Compilar y Ejecutar un Servicio Gateway con Spring Netflix Gateway

Este manual te guiará para compilar y ejecutar un **servicio Gateway** basado en **Spring Netflix Gateway** utilizando Maven.


## Paso 1: Clonar o Acceder al Proyecto

Si aún no tienes el proyecto en tu máquina, clónalo o navega al directorio del proyecto. Usa el siguiente comando para clonar desde un repositorio (reemplaza `<repository-url>` con la URL de tu repositorio):

```bash
git clone https://github.com/Rincon10/AYGO-LAB01.git
cd 03-servicio-gateway
```

## Paso 2: Compilar el Proyecto con Maven

n el directorio raíz del proyecto, ejecuta el siguiente comando

```bash
mvn clean install
```

### Paso 3: Comandos para ejecutar la aplicacion

>[!IMPORTANT]
Para que el proyecto se inicie correctamente sin ninguna excepción, es necesario iniciar primero el servicio de discovery. Esto permite que los diferentes servicios sepan a qué URL hacer las solicitudes. En caso de que no esté en ejecución, consulta el siguiente [README](../02-servicio-eureka-server/README.md).

Para ejecutar el proyecto usa el siguiente comando:

### Windows


```bash
URL_EUREKA_SERVER=http://localhost:8761/eureka java -cp "target/classes;target/dependency/*" com.escuelaing.edu.co.distribuited_systems.servicio_gateway.ServicioGatewayApplication
```

### Linux

```bash
URL_EUREKA_SERVER=http://localhost:8761/eureka java -cp "target/classes:target/dependency/*" com.escuelaing.edu.co.distribuited_systems.servicio_gateway.ServicioGatewayApplication
```

si, todo ejecuta de manera correcta deberia ver el siguiente log

![alt text](../docs/img/08-cmd-gateway.png)

y si accedemos a el puerto 8090 /actuator/health, veremos todos la salud del servicio
![alt text](../docs/img/09-api_gateway.png)

## Manual de creacion de imagen docker

vamos a crear la imagen docker:
### Comandos Docker

```bash 
docker build --tag miusuario/servicio-gateway:1.0 .
docker build --tag rincon10/servicio-gateway:1.0 .
```

iniciando contenedor
```bash
docker run -d -p <puerto_host>:<puerto_contenedor> --name nombre_instancia <tu_usuario_docker>/<nombre_imagen>:<versión>
```

entonces ejecutamos

```bash
docker run -d -p 8090:8090 --name instancia1-gateway -e URL_EUREKA_SERVER=http://host.docker.internal:8761/eureka rincon10/servicio-gateway:1.0
```


si todo sale bien veriamos que el contenedor se esta ejecutando de manera correcta

```bash
docker ps -a
```

![alt text](../docs/img/10-gateway-docker.png)


### publicando la imagen

Para publicar la imagen en Docker Hub, sigue estos pasos:

```bash
docker login
```

y luego

```bash
docker push rincon10/servicio-gateway:1.0
```

### Configuracion en AWS

1. Acceda a la máquina virtual
2. Instale Docker

```bash
sudo yum update -y
sudo yum install docker
```
3. Inicie el servicio de docker

```bash
sudo service docker start
```
4. Configure su usuario en el grupo de docker para no tener que ingresar “sudo” cada vez que invoca un comando

```bash
sudo usermod -a -G docker ec2-user
```

5. Desconectese de la máquina virtual e ingrese nuevamente para que la configuración de grupos de usuarios tenga efecto.
6. A partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p):



```bash
sudo docker run -d -p 8090:8090 --network="host" --name instancia-1-gateway -e URL_EUREKA_SERVER=http://localhost:8761/eureka rincon10/servicio-gateway:1.0
```

7. Abra los puertos de entrada del security group de la máxima virtual para acceder al servicio

en nuestro caso la url que se expone es el siguiente http://ec2-3-80-71-218.compute-1.amazonaws.com, si todo sale bien podra acceder a la instancia de aws, como se deberia ver como en la siguiente imagen


![alt text](../docs/img/11-gateway-aws.png)