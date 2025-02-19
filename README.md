# PROYECTO DE LIBRERIA CON SQL UTILIZANDO JPA


✏️  Actividad Sistema de Guardado de una Librería
El objetivo de este ejercicio es el desarrollo de un sistema de guardado de libros en JAVA utilizando una base de datos MySQL y JPA como framework de persistencia.  

Creación de la Base de Datos MySQL : Lo primero que se debe hacer es crear la base de datos sobre la que operará el sistema de reservas de libros. Para ello, se debe abrir el IDE de base de datos que se está utilizando y ejecutar la siguiente sentencia:  

CREATE DATABASE libreria; 
De esta manera se habrá creado una base de datos vacía llamada librería. 

Paquetes del Proyecto Java: Los paquetes que se utilizarán para este proyecto son los siguientes: 

entidades: En este paquete se almacenarán aquellas clases que se quiere persistir en la base de datos. 

servicios: En este paquete se alojarán las clases encargadas de gestionar la lógica del negocio. Por lo general, se crea un servicio para manejar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de cada entidad, así como también las consultas relacionadas con cada una de ellas.

persistencia: Aquí se alojarán todas las clases DAO de cada una de tus entidades.

. 

En este proyecto, trabajarás con la eliminación de entidades, aunque es importante destacar que eliminar registros directamente no siempre es una buena práctica. Para evitar la eliminación definitiva, implementarás un borrado lógico, permitiendo que las entidades puedan ser activadas o desactivadas en lugar de ser eliminadas de la base de datos.

🔹 ¿Cómo lo harás? Cada entidad incluirá un atributo booleano llamado "activo", que estará configurado en true al momento de su creación. Cuando necesites "eliminar" una entidad, simplemente cambiarás su estado a false, evitando la pérdida definitiva de los datos y facilitando su posible reactivación en el futuro.

Este enfoque mejora la integridad de la información y te permitirá tener un mejor control sobre los datos almacenados. 🚀

Entidades: Crearás el siguiente modelo de entidades: 

IMG
Entidad Libro: La entidad libro modela los libros que están disponibles en la biblioteca. En esta entidad, el atributo “ejemplares” contiene la cantidad total de ejemplares de ese libro, En esta versión BETA no gestionamos transacciones de préstamo. El isbn, será la llave primaria de esa entidad.

Entidad Autor: La entidad autor modela los autores de libros. El id, será la llave primaria de esa entidad, debe ser autogenerado.

Entidad Editorial: La entidad editorial modela las editoriales que publican libros.  El id, será la llave primaria de esa entidad, debe ser autogenerado.

Unidad de Persistencia : Configurar tu archivo persistence.xml para indicar lo necesario para crear la unidad de persistencia y la conexión con la base de datos correspondiente.

Servicios: Deberás contemplar los siguientes puntos:

AutorServicio : Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para administrar autores (consulta, creación, modificación y eliminación). Recomendamos gestionar un método para eliminar, y comprender su lógica de aplicación, y un método darBaja, para setear el atributo booleano. (qué es cómo se gestiona en el ámbito de desarrollo). 

EditorialServicio : Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para administrar editoriales (consulta, creación, modificación y baja)

LibroServicio :Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para administrar libros (consulta, creación, modificación y baja).

Main : Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para interactuar con el usuario. En esta clase se muestra el menú de opciones con las operaciones disponibles que podrá realizar el usuario. Si lo deseas puedes crear una clase independiente llamada Menu y desde el Main solamente invocar a la misma. 

Tareas a realizar

Crear base de datos Librería

Crear archivo de configuración correspondiente para declarar la unidad de persistencia y establecer la conexión con la base de datos. 

Crear entidades previamente mencionadas. (libro, autor, editorial)

Generar las tablas con JPA

Crear los servicios correspondientes para manipular la lógica de cada entidad. 

Crear los métodos para persistir entidades en la base de datos librería

Crear los métodos para dar de alta/bajo o editar dichas entidades.

Búsqueda de un autor por nombre.

Búsqueda de un libro por ISBN.

Búsqueda de un libro por Título. 

Búsqueda de un libro/s por nombre de autor.

Búsqueda de un libro/s por nombre de Editorial.

Agregar las siguientes validaciones a todas las funcionalidades de la aplicación: 

Validar campos obligatorios.

No ingresar datos duplicados. 


## Al dia
#### Creadas:
    ☻ Entidades
    ☻ Persistencias
    ☻ Servicios

### Falta
    ♣ Validaciones
    ♣ Control de bugs y exepciones

    

