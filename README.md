# Sistema de Gestión de Biblioteca – Capa Lógica

Este proyecto contiene la **lógica del sistema**, incluyendo entidades, reglas de negocio y gestión de datos.  
Aquí se implementan todos los conceptos de Programación Orientada a Objetos solicitados en la entrega.

---

## 📌 Estructura del Proyecto

Biblioteca/
├── bl/
│ ├── entities/
│ │ ├── Autor.java
│ │ ├── Biblioteca.java
│ │ ├── Bibliotecario.java
│ │ ├── Libro.java
│ │ ├── Prestamo.java
│ │ └── Usuario.java
│ └── logic/
│ └── DatosBiblioteca.java
└── dl/
└── GestorBiblioteca.java

---

## 📘 Descripción por Carpeta

### 📂 **bl/entities**  
Contiene todas las entidades principales del sistema:

- **Autor.java** – Información del autor de un libro (nombre, nacionalidad).  
- **Libro.java** – Guarda título, género, código y autor (composición).  
- **Usuario.java** – Representa un usuario de la biblioteca.  
- **Bibliotecario.java** – Hereda de Usuario (ejemplo de herencia).  
- **Prestamo.java** – Une usuario y libro; incluye fechas, código y toda la info en el toString.  
- **Biblioteca.java** – Administra listas de libros, usuarios y préstamos (agregación).

### 📂 **bl/logic**

- **DatosBiblioteca.java**  
  Contiene la lógica del sistema:
  - Valida datos ingresados.
  - Administra operaciones.
  - Se comunica con la capa de datos.

### 📂 **dl**

- **GestorBiblioteca.java**  
  Administra la persistencia de la información (simulada o real).

---



