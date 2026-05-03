import { createBrowserRouter } from "react-router";
import Login from "../views/Login";
import Products from "../components/Products";
import GetProduct from "../components/GetProduct";

export const router = createBrowserRouter([
  { path: "/login", element: <Login /> },
  { path: "/", element: <Products /> },
  { path: "/product/:id", element: <GetProduct /> },
]);
