import { createBrowserRouter } from "react-router";
import AuthPage from "../views/AuthPage";
import HomePage from "../views/HomePAge";

export const router = createBrowserRouter([
  { path: "/", element: <HomePage /> },
  { path: "/auth", element: <AuthPage /> },
]);
