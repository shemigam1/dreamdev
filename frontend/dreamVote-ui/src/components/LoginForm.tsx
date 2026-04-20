import React from "react";

export default function LoginForm() {
  return (
    <>
      <form action="">
        <div className="">
          <label htmlFor="email">Email</label>
          <input type="email" id="email" name="email" />
        </div>

        <div className="">
          <label htmlFor="password">Password</label>
          <input type="password" id="password" name="password" />
        </div>

        <button type="submit">Login</button>
      </form>
    </>
  );
}
