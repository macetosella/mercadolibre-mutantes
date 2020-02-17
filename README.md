
[![Build Status](https://travis-ci.com/macetosella/mercadolibre-mutantes.svg?branch=master)](https://travis-ci.com/macetosella/mercadolibre-mutantes)
[![codecov](https://codecov.io/gh/macetosella/mercadolibre-mutantes/branch/master/graph/badge.svg)](https://codecov.io/gh/macetosella/mercadolibre-mutantes)

# Examen Mercadolibre Mutantes
![Wolverfine_Image](https://i.pinimg.com/originals/80/23/d4/8023d4ffa90e5f4b5712921732878824.jpg) 

## Tabla de Contenidos

- [Ejercicio](#ejercicio)
  - [Tecnologias usadas](#tecnologias-usadas)
  - [Comentarios](#comentarios)
- [Setup](#setup)
  - [Instrucciones](#instrucciones)
  - [Uso](#uso)
  - [API Url](#api)
  - [Servicios](#servicios)
    - [Es mutante](#es-mutante)
    - [Estadisticas](#estadisticas)
- [Test](#test)
  - [Automaticos](#automaticos)
  - [Cobertura](#cobertura)

## Ejercicio

### Tecnologias usadas
- [JDK 1.8](https://www.oracle.com/index.html)
- [Spring Boot](https://projects.spring.io/spring-boot/)
- [Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [Docker](https://www.docker.com/)
- [MongoDB](https://www.mongodb.com)
- [Log4J2](http://www.slf4j.org/)
- [jUnit](http://junit.org/junit5/)
- [Mockito](http://site.mockito.org/)
- [Gradle](https://gradle.org/)
- [Jacoco](https://www.jacoco.org/jacoco/trunk/index.html)
- [Travis](https://travis-ci.com/)

### Comentarios
Cuando empece el challenge intente pensar el algoritmo de búsqueda de la matriz de forma dependiente. Cuando
lo tuve resuelto comencé a investigar sobre cual era la mejor forma de realizarlo y me encontré con varios estudios sobre resolución de problemas
muy similares, de hecho hay un algoritmo llamado 
_[Generalized suffix tree](https://en.wikipedia.org/wiki/Generalized_suffix_tree)_
el cual se usa para buscar ciertos patrones en cadenas reales de ADN. Pero decidí quedarme con el algoritmo que yo mismo desarrolle
por cuestión de tiempo a la hora de la implementación del ejercicio.

## Setup

### Instrucciones
Para compilar y ejecutar proyecto es necesario contar con la version 1.8 de la JDK y Gradle para la gestion de las dependencias.

Tambien es necesario contar con una instancia de MongoDB en caso de querer ejecutarlo localmente, se utilizan los datos de conexion por default de MongoDB, 
si la instancia se encuentra levantada en un host/port distinto se debe actualizar el archivo
_[application-dev.properties](src/main/resources/application-dev.properties)_

Para levantar la instancia local se uso un profile dev, el cual se configura en
_[application.properties](src/main/resources/application.properties)_

Tambien se anexa un Dockerfile con una imagen de mongoDB para ejecutar el código de forma local.


Los distintos logs de la aplicacion se generan en el directorio del proyecto.
En caso de querer loguear en otra ubicacion es necesario actualizar la propiedad _*dir*_ del archivo de configuracion _[log4j2](./src/main/resources/log4j2.properties)_.

Clonar este repositorio: https://github.com/macetosella/mercadolibre-mutantes

Una vez levantada la aplicacion se puede realizar invocaciones a la API.

El puerto por defecto de la API es 8080.

### Uso

Para iniciar la aplicación, asegúrese de cumplir con las instrucciones anteriores. 

Una vez listo, ejecutar la clase principal _MutantsApplication_ en su IDE preferido y espere hasta que se inicie la aplicación.

Tambien se puede iniciar la aplicacion con el siguiente comando en linea de comandos posicionandose en el directorio raiz
del proyecto:
```
./gradlew bootRun
```

### API Url

URL local: http://localhost:8080/

URL hosteada en Amazon: http://mutants.us-east-1.elasticbeanstalk.com/

### Servicios
#### Es mutante

Request: 
- POST http://mutants.us-east-1.elasticbeanstalk.com/V1/mutants/

Request body (caso ADN mutante):

```
  {"dna":["ATGCGA", "CAGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}
```

Response:

```
  200 OK
```
Request body (caso ADN humano):

```
  {"dna":["AATACT", "CCCAGA", "GGGATT", "AATTCC", "GGATCG", "TCACTG"]}
```

Response:

```
  403 Forbidden
```

#### Estadisticas

Request: 
- GET http://mutants.us-east-1.elasticbeanstalk.com/V1/stats

Response: 200 (application/json)

```
{
    "countMutantDna": 0,
    "countHumanDna": 0,
    "ratio": 0.0
}
```

### Test

#### Automaticos

Para la ejecucion de los test automaticos utilice jUnit.

Para poder probar los componentes de base de datos utilice una base de datos MongoDB embebida, esta se levanta durante 
el test y luego se destruye.
De esta forma no necesito tener una instancia de base de datos levantada, ni hosteada en algun servidor.

#### Cobertura

La cobertura de código en la herramienta Codecov muestra un 81%, lo cual cumple segun lo solicitado en el ejercicio.



