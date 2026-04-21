import React from "react";

export default function LoginForm() {
  return (
    <>
      <div className="p-4 bg-[#0D2145] w-3/5">
        <form action="">
          <div className="flex flex-col gap-2 p-4">
            <label htmlFor="email">Email</label>
            <input type="email" id="email" name="email" />
          </div>

          <div className="flex flex-col gap-2 p-4">
            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password" />
          </div>

          <button
            type="submit"
            className="bg-[#0357EE] text-[#F4F5F7] px-4 py-2"
          >
            Login
          </button>
        </form>
      </div>
    </>
  );
}
