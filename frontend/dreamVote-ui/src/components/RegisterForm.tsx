import { useState } from "react";
import { useNavigate } from "react-router";
import { useRegisterMutation } from "../api/auth";

export default function RegisterForm() {
  const voterRegisteration = {
    firstname: "",
    lastname: "",
    email: "",
    password: "",
  };

  const navigate = useNavigate();

  const [voterProfile, setvoterProfile] = useState(voterRegisteration);
  const [register, { isLoading, isError }] = useRegisterMutation();
  const [errorMsg, setErrorMsg] = useState("");

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setvoterProfile((prev) => {
      return {
        ...prev,
        [name]: value,
      };
    });

    // console.log(voterProfile);
  };

  const handleSubmit = async (e: React.SubmitEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const { success } = await register(voterProfile).unwrap();
      if (!success) {
        setErrorMsg("Registration failed. Please try again.");
        console.log(errorMsg);

        return;
      }
      // localStorage.setItem("token", token);
      // console.log(token);
      navigate("/");
    } catch (error) {}
  };

  return (
    <>
      <form onSubmit={handleSubmit} className="p-6">
        <div className="flex flex-col gap-2 mb-4">
          <label
            htmlFor="firstname"
            className="text-sm font-medium text-[#9BA9C7]"
          >
            Firstname
          </label>
          <input
            onChange={handleChange}
            type="text"
            id="firstname"
            name="firstname"
            placeholder="Luffy"
            className="w-full px-3.5 py-3 bg-[#081A3A] border border-[#1A2D5A] rounded-[10px] text-[#F4F5F7] text-sm placeholder:text-[#6B7A9E] outline-none transition focus:border-[#0357EE] focus:ring-2 focus:ring-[#0357EE]/20"
          />
        </div>
        <div className="flex flex-col gap-2 mb-4">
          <label
            htmlFor="lastname"
            className="text-sm font-medium text-[#9BA9C7]"
          >
            Lastname
          </label>
          <input
            onChange={handleChange}
            type="text"
            id="lastname"
            name="lastname"
            placeholder="Monkey D."
            className="w-full px-3.5 py-3 bg-[#081A3A] border border-[#1A2D5A] rounded-[10px] text-[#F4F5F7] text-sm placeholder:text-[#6B7A9E] outline-none transition focus:border-[#0357EE] focus:ring-2 focus:ring-[#0357EE]/20"
          />
        </div>
        <div className="flex flex-col gap-2 mb-4">
          <label htmlFor="email" className="text-sm font-medium text-[#9BA9C7]">
            Email
          </label>
          <input
            onChange={handleChange}
            type="email"
            id="email"
            name="email"
            placeholder="luffy@strawhats.com"
            className="w-full px-3.5 py-3 bg-[#081A3A] border border-[#1A2D5A] rounded-[10px] text-[#F4F5F7] text-sm placeholder:text-[#6B7A9E] outline-none transition focus:border-[#0357EE] focus:ring-2 focus:ring-[#0357EE]/20"
          />
        </div>

        <div className="flex flex-col gap-2 mb-5">
          <label
            htmlFor="password"
            className="text-sm font-medium text-[#9BA9C7]"
          >
            Password
          </label>
          <input
            onChange={handleChange}
            type="password"
            id="password"
            name="password"
            className="w-full px-3.5 py-3 bg-[#081A3A] border border-[#1A2D5A] rounded-[10px] text-[#F4F5F7] text-sm outline-none transition focus:border-[#0357EE] focus:ring-2 focus:ring-[#0357EE]/20"
          />
        </div>

        <button
          type="submit"
          disabled={isLoading}
          className="w-full bg-[#0357EE] hover:bg-[#0048D1] text-white font-semibold py-3.5 rounded-[10px] transition"
        >
          {isLoading ? "Registering..." : "Register"}
        </button>
      </form>
    </>
  );
}
