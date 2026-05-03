import { use, useState } from "react";
import { useLoginMutation } from "../apis/fakeStoreAppi";
import { useNavigate } from "react-router";

function LoginForm() {
  const user = {
    username: "",
    password: "",
  };

  const navigate = useNavigate();

  const [userProfile, setUserProfile] = useState(user);
  const [login, { isLoading, isError }] = useLoginMutation();
  const [errorMsg, setErrorMsg] = useState("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setUserProfile((prev) => {
      return {
        ...prev,
        [name]: value,
      };
    });
    // setUserProfile((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleSubmit = async (e: React.SubmitEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const { token } = await login(userProfile).unwrap();
      if (!token) {
        setErrorMsg("check your network connection or credentials");
        return;
      }
      localStorage.setItem("token", token);
      console.log(token);
      navigate("/");
    } catch (error) {}
  };
  return (
    <>
      <form action="" onSubmit={handleSubmit}>
        <div className="">
          <label htmlFor="username">username</label>
          <input
            name="username"
            type="text"
            placeholder="enter your username..."
            onChange={handleChange}
          />
        </div>

        <div className="">
          <label htmlFor="password">password</label>
          <input
            name="password"
            type="password"
            placeholder="enter your password..."
            onChange={handleChange}
          />
        </div>

        <div className="">
          <button type="submit" disabled={isLoading}>
            {isLoading ? "Logging in..." : "Login"}
          </button>
        </div>
      </form>
    </>
  );
}

export default LoginForm;
