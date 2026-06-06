import { useEffect, useState } from "react";
import type { User } from "../types/responses/User";
import { getUsers } from "../services/UserServices";
import "../assets/Style.css";

export function UserList() {
  // Estado para guardar la lista de usuarios
  const [users, setUsers] = useState<User[]>([]);

  // Hook que se ejecuta al montar el componente para obtener usuarios
  useEffect(() => {
    getUsers()
      .then((data) => {
        setUsers(data); // Actualiza el estado con los usuarios obtenidos
      })
      .catch((error) => {
        console.error("Error al obtener usuarios:", error);
      });
  }, []);

  // Renderiza la lista de usuarios
  return (
    <div className="page">
      <h1>Lista de usuarios</h1>

      <div className="products">
        {users.map((user) => (
          <div className="card" key={user.id || user.userResourceId}>
            <div className="image">👤</div>

            <p className="name">{user.name}</p>

            <p className="age">
              <span>Edad: </span>
              {user.age}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}