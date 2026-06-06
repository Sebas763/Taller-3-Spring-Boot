import { useEffect, useState } from "react";
import type { Product } from "../types/responses/Product";
import { getProducts } from "../services/ProductServices";
import "../assets/Style.css";

export function ProductList() {
  // Estado para guardar la lista de productos
  const [products, setProducts] = useState<Product[]>([]);

  // Hook que se ejecuta al montar el componente para obtener productos
  useEffect(() => {
    getProducts()
      .then((data) => {
        setProducts(data); // Actualiza el estado con los productos obtenidos
      })
      .catch((error) => {
        console.error("Error al obtener productos:", error);
      });
  }, []);

  // Renderiza la lista de productos
  return (
  <div className="page">
    <h1>Lista de productos</h1>

    <div className="products">
      {products.map((product) => (
        <div className="card" key={product.productResourceId}>
          <div className="image">🛍️</div>

          <p className="name">{product.name}</p>

          <p className="price">
            <span>💰</span>
            {product.price}
          </p>
        </div>
      ))}
    </div>
  </div>
);
}
