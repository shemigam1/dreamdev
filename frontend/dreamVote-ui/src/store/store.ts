import { configureStore } from "@reduxjs/toolkit";
import { authApi } from "../api/auth";
import voterReducer from "../slice/voterSlice";

const store = configureStore({
  reducer: {
    [authApi.reducerPath]: authApi.reducer,
    voter: voterReducer,
  },
  middleware: (getDefaultMiddleware) => {
    return getDefaultMiddleware().concat(authApi.middleware);
  },
});

export default store;
