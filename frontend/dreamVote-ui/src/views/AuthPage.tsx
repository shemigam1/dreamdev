import Polls from "../components/assets/Polls";
import LoginForm from "../components/LoginForm";
import RegisterForm from "../components/RegisterForm";
import { useState } from "react";

function AuthPage() {
  const [tab, setTab] = useState("login");
  return (
    <div className="bg-[#02102D] text-[#F4F5F7] flex h-screen w-screen items-center justify-center">
      <div className="lg:w-1/2 w-full flex flex-col items-center justify-center border border-[#1A2D5A]">
        <div className="tabs ">
          <button
            onClick={() => setTab("login")}
            className={tab === "login" ? "tab tab--active" : "tab"}
          >
            Log in
          </button>
          <button
            onClick={() => setTab("signup")}
            className={tab === "signup" ? "tab tab--active" : "tab"}
          >
            Sign up
          </button>
        </div>

        {tab === "login" ? <LoginForm /> : <RegisterForm />}
      </div>

      <div className="w-1/2 flex items-center justify-center lg:block hidden">
        <Polls />
      </div>
    </div>
  );
}

export default AuthPage;
