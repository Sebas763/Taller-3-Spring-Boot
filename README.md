# Taller #3 — Full Stack App

Aplicación full stack que conecta una base de datos MySQL con un backend en Spring Boot y un frontend en React, mostrando usuarios y productos almacenados en la base de datos.

---

## 🛠️ Tecnologías

| Capa | Tecnología |
|------|-----------|
| Frontend | React + Vite + TypeScript |
| Backend | Java + Spring Boot |
| Base de Datos | MySQL |
| Gestor de paquetes | npm |

---

## 📁 Estructura del proyecto

```
Taller#3 Completo/
├── Backend/
│   └── demo/          # Proyecto Spring Boot
├── Frontend/
│   └── mi-app/        # Proyecto React + Vite
└── Base de Datos/
    ├── DatabaseUser.sql
    └── DatabaseProduct.sql
```

---

## ⚙️ Requisitos previos

- [Node.js](https://nodejs.org) v18+
- [Java JDK](https://www.oracle.com/java/technologies/downloads/) 17+
- [Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/) 8.0+

---

## 🚀 Cómo correr el proyecto

### 1. Base de Datos

1. Abre DBeaver o cualquier cliente MySQL
2. Ejecuta los archivos en orden:
   ```
   Base de Datos/DatabaseUser.sql
   Base de Datos/DatabaseProduct.sql
   ```

### 2. Backend

Abre la carpeta `Backend/demo` en IntelliJ IDEA y corre la aplicación, o desde la terminal:

```bash
cd Backend/demo
mvn spring-boot:run
```

El backend corre en `http://localhost:8080`

### 3. Frontend

```bash
cd Frontend/mi-app
npm install
npm run dev
```

El frontend corre en `http://localhost:5173`

---

## 📌 Endpoints principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/users` | Obtener todos los usuarios |
| GET | `/api/products` | Obtener todos los productos |

---

## 👤 Autor

**Sebas763** — [GitHub](https://github.com/Sebas763)
