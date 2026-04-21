import { createSlice, type PayloadAction } from "@reduxjs/toolkit";
import type { Voter } from "../components/utils/types";

type UserState = {
  voter: Voter | null;
};
const initialState: UserState = {
  voter: null,
};

const voterSlice = createSlice({
  name: "voter",
  initialState,
  reducers: {
    setVoter: (state, action) => {
      state.voter = action.payload;
    },
    clearVoter: (state) => {
      state.voter = null;
    },
    setLoggedIn: (state, action) => {
      if (state.voter) {
        state.voter.isLoggedIn = action.payload;
      }
    },
  },
});

export const { setVoter, clearVoter, setLoggedIn } = voterSlice.actions;
export default voterSlice.reducer;
