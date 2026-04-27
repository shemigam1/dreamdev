export type Voter = {
  firstName?: string;
  lastName?: string;
  voterId: string;
  email: string;
  isLoggedIn: boolean;
};

export type Candidate = {
  firstName: string;
  lastName: string;
};

export type ElectionSummary = {
  id: string;
  createdAt: string;
  active: boolean;
  candidateCount: number;
  voteCount: number;
};

export type Election = {
  id: string;
  createdBy: string;
  candidates: Candidate[];
  poll: Record<string, number>;
  createdAt: string;
  active: boolean;
  voteCount: number;
};
