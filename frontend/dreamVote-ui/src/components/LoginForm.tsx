import React from "react";

export default function LoginForm() {
  return (
    <>
      <form action="" className="p-6">
        <div className="flex flex-col gap-2 mb-4">
          <label htmlFor="email" className="text-sm font-medium text-[#9BA9C7]">
            Email
          </label>
          <input
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
            type="password"
            id="password"
            name="password"
            className="w-full px-3.5 py-3 bg-[#081A3A] border border-[#1A2D5A] rounded-[10px] text-[#F4F5F7] text-sm outline-none transition focus:border-[#0357EE] focus:ring-2 focus:ring-[#0357EE]/20"
          />
        </div>

        <button
          type="submit"
          className="w-full bg-[#0357EE] hover:bg-[#0048D1] text-white font-semibold py-3.5 rounded-[10px] transition"
        >
          Log in
        </button>
      </form>
    </>
  );
}
