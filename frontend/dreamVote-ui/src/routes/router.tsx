import { createBrowserRouter } from "react-router";
import AuthPage from "../views/AuthPage";

export const router = createBrowserRouter([
    { path: "/auth", element: <AuthPage />},
]);