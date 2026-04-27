import { configureStore } from "@reduxjs/toolkit";
import { authApi } from "../api/auth";
import { electionApi } from "../api/election";
import voterReducer from "../slice/voterSlice";
import electionReducer from "../slice/electionSlice";

const store = configureStore({
  reducer: {
    [authApi.reducerPath]: authApi.reducer,
    [electionApi.reducerPath]: electionApi.reducer,
    voter: voterReducer,
    election: electionReducer,
  },
  middleware: (getDefaultMiddleware) => {
    return getDefaultMiddleware()
      .concat(authApi.middleware)
      .concat(electionApi.middleware);
  },
});

export type RootState = ReturnType<typeof store.getState>;

export default store;
