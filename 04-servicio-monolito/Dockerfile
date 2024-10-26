FROM openjdk:22
WORKDIR /usrapp/bin

ARG URL_EUREKA_SERVER
ARG URL_MONGO
ARG TAG_VERSION

# Usar los argumentos (por ejemplo, en variables de entorno o comandos)
ENV URL_EUREKA_SERVER=${URL_EUREKA_SERVER}
ENV URL_MONGO=${URL_MONGO}
ENV TAG_VERSION=${TAG_VERSION}

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
CMD ["java","-cp","./classes:./dependency/*","com.escuelaing.edu.co.distribuited_systems.user.UserApplication"]