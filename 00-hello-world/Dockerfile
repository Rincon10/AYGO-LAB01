FROM openjdk:22
WORKDIR /usrapp/bin
ENV PORT=33025
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
CMD ["java","-cp","./classes:./dependency/*","com.escuelaing.edu.co.distribuited_systems.DistribuitedSystemsApplication"]