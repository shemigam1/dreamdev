import { configureStore } from "@reduxjs/toolkit";
import { fakeStoreApi } from "../apis/fakeStoreAppi";

const store = configureStore({
  reducer: {
    [fakeStoreApi.reducerPath]: fakeStoreApi.reducer,
  },
  middleware: (getDefaultMiddleware) => {
    return getDefaultMiddleware().concat(fakeStoreApi.middleware);
  },
});

export default store;
