import { useEffect } from "react";
import { RouterProvider } from "react-router";
import { useDispatch } from "react-redux";
import { router } from "./routes/router";
import { setVoter } from "./slice/voterSlice";

function App() {
  const dispatch = useDispatch();

  useEffect(() => {
    const stored = localStorage.getItem("voter");
    if (stored) {
      try {
        dispatch(setVoter(JSON.parse(stored)));
      } catch {
        localStorage.removeItem("voter");
      }
    }
  }, [dispatch]);

  return <RouterProvider router={router} />;
}

export default App;
