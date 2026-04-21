import { useSelector } from "react-redux";
import { useNavigate } from "react-router";

function HomePage() {
  const navigate = useNavigate();
  const isLoggedIn = localStorage.getItem("isLoggedIn") === "true";
  if (!isLoggedIn) {
    navigate("/auth");
  }

  const voter = useSelector((state: any) => state.voter);
  console.log(voter);
  return (
    <div>
      <p>Welcome, {voter.email}!</p>
      <p>ID: {voter.id}</p>
      <p>Status: {voter.isLoggedIn ? "Logged In" : "Not Logged In"}</p>
    </div>
  );
}

export default HomePage;
