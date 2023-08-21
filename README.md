# Galería de fotos

Galería de fotos es una API básica para mostrar todos los álbumes de fotos
alojados en JSON Placeholder, así como un detalle de las fotos de cada uno
de los álbumes.

Este proyecto es sólo una prueba y no está en desarrollo.

### Índice
- [Tecnologías utilizadas](#tecnologias)
- [Instalación y uso](#instalacion)
- [Detalles](#detalles)
- [Contacto](#contacto)
- [Licencia](#licencia)

<a id="tecnologias"></a>
## Tecnologías utilizadas
***
* [Spring Boot](https://spring.io/projects/spring-boot): Versión 3.1.2
* [Kotlin](https://kotlinlang.org/docs/releases.html#release-details): Versión 1.8.22
* [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html): Versión 17
* [Maven](https://maven.apache.org/docs/3.9.2/release-notes.html): Versión 3.9.2
* [JUnit 5 (Jupiter)](https://junit.org/junit5/docs/5.10.0/release-notes/): Versión 5.10.0
* [Mockito](https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter): Versión 5.4.0
* [H2](https://www.h2database.com/html/main.html): Versión 2.2.220
* [SpringDoc OpenAPI Starter WebMVC UI (para Swagger)](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui): Versión 2.1.0
* [FreeMarker](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-freemarker): Versión 3.1.2

<a id="instalacion"></a>
## Instalación y uso
***
Para compilar y ejecutar esta aplicación de manera local necesitarás 
JDK 1.8 y Maven 3.

Clona o descarga este proyecto.

Usando Maven, carga todas las dependencias y ejecuta la aplicación 
principal (PhotoGalleryApplication) o usa el comando 
```"mvn spring-boot:run"```.

Hecho esto, podrás ver la aplicación en http://localhost:8080/

Y la documentación realizada con Swagger en http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

Para comprobar que todo funciona correctamente, usa los tests unitarios y de
integración proporcionados en src/test/juanaljaro.photogallery/, usando JUnit.

En la aplicación, podrás navegar de manera interactiva entre las 3 vistas
diseñadas ("/", "/albums" y "/photos/$id" siendo $id el "id" de un álbum,
es decir, un número del 1 al 100).

También se gestionan las excepciones posibles con una vista extra de error ("/error").

## Detalles
***

### Capas
El código se ha estructurado en capas para respetar el modelo MVC, aunque en
una versión muy simplificada al no tener una base de datos propia y sólo
realizar consultas externas a JSON Placeholder.

Por lo tanto, se han creado las capas de controladores, servicios (con sus
interfaces para respetar el modelo de factoría en caso de que se quisiera
seguir desarrollando el proyecto) y dominio.

### Código
Todo el código ha sido escrito en inglés por coherencia, ya que se suele usar nomenclatura
en inglés y lo único en español es este documento y las vistas.

En cualquier caso, se han uso nombres intuitivos y simples de manera que sea sencillo de
entender. De hecho, es tan simple que no he visto necesario usar comentarios.

### FreeMarker

He decidido utilizar FreeMarker para generar de manera rápida una plantilla HTML con
la que poder visuazizar la aplicación.


### H2

Por otro lado, H2 o Hibernate no son necesarios en realidad en el estado actual de este
proyecto, ya que no se almacena nada en base de datos, sólo se hacen
consultas a JSON Placeholder.

Aún así, he decidido incluirlo porque me ha parecido lo más
coherente en un proyecto de Spring Boot, donde es habitual realizar todas
las acciones CRUD y sería probablemente el siguiente paso lógico en el
desarrollo de este proyecto.

### Subida a GitHub
Sólo al realizar este documento (al finalizar el código) me he dado cuenta de que no he
ido subiendo los cambios a GitHub según iba realizando la aplicación, por lo que no
se podrá apreciar el desarrollo del proyecto.

En cualquier caso, el proceso ha sido bastante simple teniendo en cuenta la
funcionalidad de esta API tan simple.

## Contacto
***
Escríbeme a mi email personal si lo tienes o en [LinkedIn](https://www.linkedin.com/in/juanaljaro/).

## Licencia
***
Sin licencia.
