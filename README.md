# Spring-boot-validations
Como implementar validaciones spring boot + thymeleaf

Para la implementación de validaciones con spring boot y thymeleaf es necesario tener la dependencia de javax.validation en el POM.XML (en versiones
anteriores de spring boot ya estaba incluída) y
añadir las anotaciones pertientes en la clase de la entidad. Además, es necesario incluir en el controlador una objeto de tipo BindingResult.

Para los mensajes que sean lanzados en las vistas con thymeleaf es necesario incluir en alguna etiqueta html el código necesario
para que se muestre el mensaje de los errores ( para ello con el parámetro message s contunuación de cada una de las anotaciones en los campos de la entidad
es suficiente). Para validar una unique constraint lo hacemos de una menera un poco diferente ( lanzamos una excepción "DataAccessException") desde
el controlador y pasamos el mensaje a la vista a través del Model.
