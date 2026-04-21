import Polls from "../components/assets/Polls";
import LoginForm from "../components/LoginForm";
import RegisterForm from "../components/RegisterForm";
import { useState } from "react";

function AuthPage() {
  const [tab, setTab] = useState("login");
  return (
    <div className="bg-[#02102D] text-[#F4F5F7] min-h-screen flex flex-col">
      <div className="relative overflow-hidden border-b border-[#1A2D5A] py-14 px-5 text-center">
        <div
          className="absolute top-[-40px] left-1/2 -translate-x-1/2 w-[420px] h-[420px] pointer-events-none"
          style={{
            background:
              "radial-gradient(circle, rgba(3,87,238,0.14) 0%, transparent 60%)",
          }}
        />
        <div className="relative">
          <h3 className="inline-block font-mono text-[#7FA8FF] bg-[#0357EE]/15 border border-[#0357EE]/45 px-2.5 py-1 rounded-md tracking-[0.08em] mb-4">
            DREAM VOTE
          </h3>
          <h1 className="text-4xl font-bold tracking-tight mb-2">
            Let your voice be heard.
          </h1>
          <p className="text-[#9BA9C7]">Nominate. Vote. See results.</p>
        </div>
      </div>

      <div className="flex-1 flex items-start justify-center px-5 py-10">
        <div className="w-full max-w-[400px] bg-[#081A3A] border border-[#1A2D5A] rounded-2xl overflow-hidden">
          <div className="flex gap-1 p-1.5 bg-[#02102D] border-b border-[#1A2D5A]">
            <button
              onClick={() => setTab("login")}
              className={`flex-1 py-2.5 text-sm font-medium rounded-lg transition ${
                tab === "login"
                  ? "bg-[#0D2145] border border-[#1A2D5A] text-[#F4F5F7]"
                  : "border border-transparent text-[#9BA9C7] hover:text-[#F4F5F7]"
              }`}
            >
              Log in
            </button>
            <button
              onClick={() => setTab("signup")}
              className={`flex-1 py-2.5 text-sm font-medium rounded-lg transition ${
                tab === "signup"
                  ? "bg-[#0D2145] border border-[#1A2D5A] text-[#F4F5F7]"
                  : "border border-transparent text-[#9BA9C7] hover:text-[#F4F5F7]"
              }`}
            >
              Register
            </button>
          </div>

          {tab === "login" ? <LoginForm /> : <RegisterForm />}
        </div>

        <div className="w-1/2 flex items-center justify-center lg:block hidden">
          <Polls />
        </div>
      </div>
    </div>
  );
}

export default AuthPage;
