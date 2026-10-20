Requisitos
############
Java 21 con Spring Boot
Docker Desktop -  Contenedor MySQL

API para gestionar las recetas grastronomicas organizadas por categorias
Endpoints:
    http://localhost:8090/api/recetas/5
    http://localhost:8090/api/recetas/search/rroz
    
    http://localhost:8090/api/categorias/5
    http://localhost:8090/api/categorias/search/lian
GET http://localhost:8090/api/categorias/page?pageNumber=0&pageSize=5&sortField=nombre&sortDir=desc
    http://localhost:8090/api/categorias/page
    http://localhost:8090/api/recetas/page
    http://localhost:8090/api/recetas/page?pageNumber=0&pageSize=5&sortField=titulo&sortDir=desc

26.- JPA: Añadir ordenamiento a nuestra consultas - CategoriaRepository - CategoriaServiceImpl
Sin usar ORDER BY c.nombre ASC en el HQL y sí pasando desde el serviceImpl el parametro Sort
27.- JPA: Optimizar nuestros endpoint con Paginación: crear un nuevo metodo en el repository que encapsula en un Page el listado de recetas, 
implementamos el método, creamos un dtoRecetaPage y en el controller creamos un endpoint que llama a este servicio
28.- JPA: Tansaccionalidad. Creamos un entidad usuarios y navegacion. Creamos sus dtos, repository, service , serviceImpl y el controllador de usuarios. 
Probamos la transaccionalidad de usuarios que a parte se conecta al servicio de navegación.
Endpoints:
    POST http://localhost:8090/api/usuarios