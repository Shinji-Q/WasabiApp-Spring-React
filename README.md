# WasabiApp-Spring-React
Projeto final dos cursos ministrados pelo professor Antônio Sampaio com apoio da Netbiis

## Build Application

### Requeriments Database

MariaDB

``` SQL
CREATE DATABASE wassabi;

GRANT all ON wassabi.* TO 'wassabi'@'localhost' identified BY 'wassabi' WITH GRANT OPTION; 
```

MySQL

``` SQL 
CREATE DATABASE wassabi;

CREATE USER 'wassabi'@'localhost' IDENTIFIED WITH mysql_native_password BY 'wassabi';

GRANT all ON wassabi.* TO 'wassabi'@'localhost';
```


RUN SCRIPTS IN src/main/java/com/wassabi/wassabiapp/model/sql


