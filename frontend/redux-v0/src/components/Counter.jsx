import React, { use } from "react";
import { useDispatch, useSelector } from "react-redux";
import { decrement, increment } from "../slice/counterSlice";

function Counter() {
  const value = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();
  return (
    <div>
      <p>Counter: {value}</p>
      <button
        onClick={() => {
          dispatch(increment());
        }}
      >
        +
      </button>
      <button
        onClick={() => {
          dispatch(decrement());
        }}
      >
        -
      </button>
    </div>
  );
}

export default Counter;
