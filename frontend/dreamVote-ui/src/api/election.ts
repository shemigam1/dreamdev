import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const baseUrl = import.meta.env.VITE_APP_BASE_URL;

export const electionApi = createApi({
  reducerPath: "electionApi",
  baseQuery: fetchBaseQuery({ baseUrl }),
  tagTypes: ["Elections"],
  endpoints: (builder) => ({
    getAllElections: builder.query({
      query: () => "/elections",
      providesTags: ["Elections"],
    }),
    getElectionById: builder.query({
      query: (electionId: string) => `/elections/${electionId}`,
    }),
    getElectionsByCreator: builder.query({
      query: (voterId: string) => `/elections/creator/${voterId}`,
    }),
    createElection: builder.mutation({
      query: (body) => ({ url: "/elections/", method: "POST", body }),
      invalidatesTags: ["Elections"],
    }),
    activateElection: builder.mutation({
      query: ({ electionId, ...body }) => ({
        url: `/elections/${electionId}/activate`,
        method: "PATCH",
        body,
      }),
      invalidatesTags: ["Elections"],
    }),
    deactivateElection: builder.mutation({
      query: ({ electionId, ...body }) => ({
        url: `/elections/${electionId}/deactivate`,
        method: "PATCH",
        body,
      }),
      invalidatesTags: ["Elections"],
    }),
    nominateCandidate: builder.mutation({
      query: (body) => ({ url: "/elections/nominate", method: "POST", body }),
      invalidatesTags: ["Elections"],
    }),
    vote: builder.mutation({
      query: (body) => ({ url: "/elections/vote", method: "POST", body }),
      invalidatesTags: ["Elections"],
    }),
    getPolls: builder.query({
      query: (electionId: string) => `/elections/${electionId}/polls`,
    }),
    getAllCandidates: builder.query({
      query: (electionId: string) => ({
        url: "/elections/candidates",
        method: "GET",
        body: { electionId },
      }),
    }),
  }),
});

export const {
  useGetAllElectionsQuery,
  useGetElectionByIdQuery,
  useGetElectionsByCreatorQuery,
  useCreateElectionMutation,
  useActivateElectionMutation,
  useDeactivateElectionMutation,
  useNominateCandidateMutation,
  useVoteMutation,
  useGetPollsQuery,
  useGetAllCandidatesQuery,
} = electionApi;
