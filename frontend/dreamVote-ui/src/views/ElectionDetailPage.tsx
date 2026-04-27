import { useState, useEffect } from "react";
import { useParams, useNavigate, Link } from "react-router";
import { useSelector } from "react-redux";
import type { RootState } from "../store/store";
import PhaseBadge, { getPhase } from "../components/PhaseBadge";
import {
  useGetElectionByIdQuery,
  useActivateElectionMutation,
  useDeactivateElectionMutation,
  useVoteMutation,
} from "../api/election";

type Candidate = { firstName: string; lastName: string };

type Election = {
  id: string;
  title: string | null;
  description: string | null;
  createdBy: string;
  candidates: Candidate[];
  poll: Record<string, number>;
  createdAt: string;
  active: boolean;
  voteCount: number;
};

export default function ElectionDetailPage() {
  const { electionId } = useParams<{ electionId: string }>();
  const navigate = useNavigate();
  const voter = useSelector((state: RootState) => state.voter.voter);

  const { data: response, isLoading, refetch } = useGetElectionByIdQuery(electionId!);
  const [activate] = useActivateElectionMutation();
  const [deactivate] = useDeactivateElectionMutation();
  const [vote] = useVoteMutation();

  const [selected, setSelected] = useState<string | null>(null);
  const [confirmOpen, setConfirmOpen] = useState(false);
  const [endNomConfirm, setEndNomConfirm] = useState(false);
  const [votedFor, setVotedFor] = useState<string | null>(null);

  useEffect(() => {
    if (!voter || !voter.isLoggedIn) navigate("/auth");
  }, [voter, navigate]);

  useEffect(() => {
    if (electionId) {
      const stored = localStorage.getItem(`vote_${electionId}`);
      if (stored) setVotedFor(stored);
    }
  }, [electionId]);

  if (!voter || !voter.isLoggedIn) return null;
  if (isLoading) {
    return (
      <PageShell>
        <p className="text-center text-[#6B7A9E] py-16 font-mono text-sm">
          loading election...
        </p>
      </PageShell>
    );
  }

  const election: Election | undefined = response?.data;
  if (!election) {
    return (
      <PageShell>
        <p className="text-center text-[#9BA9C7] py-16">Election not found.</p>
      </PageShell>
    );
  }

  const voteCount = election.voteCount ?? 0;
  const phase = getPhase(election.active, voteCount);
  const isCreator = election.createdBy === voter.voterId;
  const slug = `election-${new Date(election.createdAt).toLocaleDateString("en-GB", { day: "2-digit", month: "short" }).toLowerCase().replace(" ", "-")}-${election.id.slice(-4)}`;
  const total = Object.values(election.poll).reduce((a, b) => a + b, 0);

  async function handleActivate() {
    await activate({ electionId: election!.id, voterId: voter!.voterId });
    setEndNomConfirm(false);
    refetch();
  }

  async function handleDeactivate() {
    await deactivate({ electionId: election!.id, voterId: voter!.voterId });
    refetch();
  }

  async function handleVote() {
    if (!selected) return;
    try {
      await vote({
        electionId: election!.id,
        voterId: voter!.voterId,
        candidateLastName: selected,
      }).unwrap();
      localStorage.setItem(`vote_${electionId}`, selected);
      setVotedFor(selected);
      setConfirmOpen(false);
      refetch();
    } catch {}
  }

  return (
    <PageShell back={{ label: "Elections", to: "/" }}>
      <div className="max-w-[680px] mx-auto px-5 py-10">
        <div className="mb-7">
          <PhaseBadge phase={phase} />
          {election.title ? (
            <>
              <h2 className="mt-4 mb-1.5 text-[26px] font-bold tracking-tight text-[#F4F5F7]">
                {election.title}
              </h2>
              <p className="font-mono text-[11px] text-[#6B7A9E] mb-2 break-all">
                {slug}
              </p>
            </>
          ) : (
            <h2 className="mt-4 mb-1.5 font-mono text-[22px] font-bold tracking-tight break-all text-[#F4F5F7]">
              {slug}
            </h2>
          )}
          {election.description && (
            <p className="text-sm text-[#9BA9C7] mb-2 whitespace-pre-wrap">
              {election.description}
            </p>
          )}
          <p className="text-sm text-[#9BA9C7]">
            Created{" "}
            {new Date(election.createdAt).toLocaleDateString("en-US", {
              month: "long",
              day: "numeric",
              year: "numeric",
            })}
          </p>
        </div>

        {phase === "nomination" && (
          <NominationView
            election={election}
            isCreator={isCreator}
            endNomConfirm={endNomConfirm}
            onEndNomClick={() => setEndNomConfirm(true)}
            onCancelEndNom={() => setEndNomConfirm(false)}
            onConfirmEndNom={handleActivate}
          />
        )}

        {phase === "voting" && !votedFor && (
          <VotingView
            election={election}
            selected={selected}
            confirmOpen={confirmOpen}
            onSelect={setSelected}
            onVoteClick={() => setConfirmOpen(true)}
            onCancelVote={() => setConfirmOpen(false)}
            onConfirmVote={handleVote}
            isCreator={isCreator}
            onDeactivate={handleDeactivate}
          />
        )}

        {phase === "voting" && votedFor && (
          <VotedView
            poll={election.poll}
            votedFor={votedFor}
            total={total}
            onRefresh={refetch}
          />
        )}

        {phase === "closed" && (
          <ClosedView poll={election.poll} total={total} />
        )}
      </div>
    </PageShell>
  );
}

function NominationView({
  election,
  isCreator,
  endNomConfirm,
  onEndNomClick,
  onCancelEndNom,
  onConfirmEndNom,
}: {
  election: Election;
  isCreator: boolean;
  endNomConfirm: boolean;
  onEndNomClick: () => void;
  onCancelEndNom: () => void;
  onConfirmEndNom: () => void;
}) {
  const navigate = useNavigate();
  return (
    <>
      <div className="bg-[#081A3A] border border-[#1A2D5A] rounded-xl overflow-hidden mb-6">
        <div className="px-4 py-3.5 border-b border-[#1A2D5A] flex justify-between items-center">
          <span className="text-[11px] text-[#6B7A9E] uppercase tracking-[0.08em] font-medium">
            Candidates
          </span>
          <span className="font-mono text-sm font-semibold tabular-nums">
            {election.candidates.length}
          </span>
        </div>
        {election.candidates.length === 0 ? (
          <p className="px-4 py-7 text-sm text-[#6B7A9E] text-center">
            No candidates yet. Nominate one to start.
          </p>
        ) : (
          election.candidates.map((c, i) => {
            const initials = `${c.firstName[0]}${c.lastName[0]}`.toUpperCase();
            return (
              <div
                key={i}
                className={`flex items-center gap-3 px-4 py-3.5 text-sm ${i < election.candidates.length - 1 ? "border-b border-[#1A2D5A]" : ""}`}
              >
                <span className="w-7 h-7 rounded-full bg-[rgba(3,87,238,0.14)] border border-[rgba(3,87,238,0.45)] text-[#7FA8FF] flex items-center justify-center text-[11px] font-semibold flex-shrink-0">
                  {initials}
                </span>
                <span>
                  {c.firstName} {c.lastName}
                </span>
              </div>
            );
          })
        )}
      </div>

      <div className="flex flex-wrap gap-2.5 items-center">
        <button
          onClick={() => navigate(`/elections/${election.id}/nominate`)}
          className="bg-[#0357EE] hover:bg-[#0048D1] text-white font-semibold px-5 py-3 rounded-[10px] text-sm transition"
        >
          + Nominate candidate
        </button>

        {isCreator && !endNomConfirm && (
          <>
            <button
              onClick={onEndNomClick}
              className="text-[#F4F5F7] border border-[#1A2D5A] hover:border-[#2A4480] hover:bg-[#081A3A] px-4 py-3 rounded-[10px] text-sm font-medium transition"
            >
              End nominations
            </button>
            <span className="font-mono text-[11px] text-[#6B7A9E]">
              admin · starts voting
            </span>
          </>
        )}
      </div>

      {isCreator && endNomConfirm && (
        <div className="mt-3 bg-[rgba(245,166,35,0.14)] border border-[rgba(245,166,35,0.3)] rounded-[10px] px-4 py-3.5 flex items-center justify-between gap-3 flex-wrap">
          <span className="text-sm">
            <strong className="text-[#F5C16C]">Start voting?</strong>{" "}
            <span className="text-[#9BA9C7]">Nominations will close.</span>
          </span>
          <div className="flex gap-2">
            <button
              onClick={onCancelEndNom}
              className="text-sm border border-[#1A2D5A] hover:border-[#2A4480] hover:bg-[#081A3A] px-3 py-2 rounded-[10px] font-medium transition"
            >
              Cancel
            </button>
            <button
              onClick={onConfirmEndNom}
              className="text-sm bg-[#0357EE] hover:bg-[#0048D1] text-white px-3 py-2 rounded-[10px] font-medium transition"
            >
              Start voting
            </button>
          </div>
        </div>
      )}
    </>
  );
}

function VotingView({
  election,
  selected,
  confirmOpen,
  onSelect,
  onVoteClick,
  onCancelVote,
  onConfirmVote,
  isCreator,
  onDeactivate,
}: {
  election: Election;
  selected: string | null;
  confirmOpen: boolean;
  onSelect: (name: string) => void;
  onVoteClick: () => void;
  onCancelVote: () => void;
  onConfirmVote: () => void;
  isCreator: boolean;
  onDeactivate: () => void;
}) {
  return (
    <>
      <div className="bg-[rgba(3,87,238,0.14)] border border-[rgba(3,87,238,0.45)] rounded-[10px] px-3.5 py-3 mb-5 text-sm text-[#9FBDFF]">
        <strong className="text-[#BFD4FF]">Choose one candidate.</strong> Your
        vote cannot be changed after confirmation.
      </div>

      <div className="bg-[#081A3A] border border-[#1A2D5A] rounded-xl overflow-hidden mb-5">
        {election.candidates.map((c, i) => {
          const lastName = c.lastName;
          const isSelected = selected === lastName;
          const initials = `${c.firstName[0]}${c.lastName[0]}`.toUpperCase();
          return (
            <button
              key={i}
              onClick={() => !confirmOpen && onSelect(lastName)}
              className={`flex items-center gap-3.5 w-full px-4 py-4 text-left transition font-medium text-sm ${i < election.candidates.length - 1 ? "border-b border-[#1A2D5A]" : ""} ${isSelected ? "bg-[rgba(3,87,238,0.14)]" : "hover:bg-[#0D2145]"}`}
            >
              <span
                className="w-[18px] h-[18px] rounded-full border-2 flex items-center justify-center flex-shrink-0"
                style={{
                  borderColor: isSelected ? "#0357EE" : "#2A4480",
                }}
              >
                {isSelected && (
                  <span className="w-2 h-2 rounded-full bg-[#0357EE] block" />
                )}
              </span>
              <span
                className="w-8 h-8 rounded-full flex items-center justify-center text-xs font-semibold flex-shrink-0"
                style={{
                  background: isSelected ? "#0357EE" : "#0D2145",
                  color: isSelected ? "#fff" : "#9BA9C7",
                }}
              >
                {initials}
              </span>
              <span className="flex-1">
                {c.firstName} {c.lastName}
              </span>
            </button>
          );
        })}
      </div>

      {confirmOpen ? (
        <div className="bg-[#081A3A] border-2 border-[#0357EE] rounded-xl px-5 py-4">
          <p className="text-[15px] mb-3.5">
            Confirm vote for{" "}
            <strong>
              {election.candidates.find((c) => c.lastName === selected)
                ? `${election.candidates.find((c) => c.lastName === selected)!.firstName} ${selected}`
                : selected}
            </strong>{" "}
            — <span className="text-[#F5C16C]">this is final</span>.
          </p>
          <div className="flex gap-2.5 justify-end">
            <button
              onClick={onCancelVote}
              className="text-sm border border-[#1A2D5A] hover:border-[#2A4480] hover:bg-[#0D2145] px-4 py-2.5 rounded-[10px] font-medium transition"
            >
              Cancel
            </button>
            <button
              onClick={onConfirmVote}
              className="text-sm bg-[#0357EE] hover:bg-[#0048D1] text-white px-4 py-2.5 rounded-[10px] font-semibold transition"
            >
              Confirm vote
            </button>
          </div>
        </div>
      ) : (
        <button
          onClick={onVoteClick}
          disabled={!selected}
          className="w-full py-3.5 rounded-[10px] font-semibold text-[15px] transition"
          style={{
            background: selected ? "#0357EE" : "#0D2145",
            color: selected ? "#fff" : "#9BA9C7",
            cursor: selected ? "pointer" : "not-allowed",
            opacity: selected ? 1 : 0.5,
          }}
        >
          {selected
            ? `Cast vote for ${election.candidates.find((c) => c.lastName === selected)?.firstName} ${selected}`
            : "Select a candidate to vote"}
        </button>
      )}

      {isCreator && (
        <button
          onClick={onDeactivate}
          className="mt-4 w-full text-center text-sm text-[#6B7A9E] hover:text-[#9BA9C7] font-mono transition"
        >
          Close election · admin
        </button>
      )}
    </>
  );
}

function VotedView({
  poll,
  votedFor,
  total,
  onRefresh,
}: {
  poll: Record<string, number>;
  votedFor: string;
  total: number;
  onRefresh: () => void;
}) {
  return (
    <>
      <div className="bg-[rgba(0,128,96,0.16)] border border-[rgba(0,128,96,0.4)] rounded-xl px-4 py-4 mb-7 flex items-center gap-3.5">
        <span className="w-9 h-9 rounded-full bg-[#008060] text-white flex items-center justify-center text-base font-bold flex-shrink-0">
          ✓
        </span>
        <div>
          <p className="text-[15px] font-semibold text-[#4FD1A8] mb-0.5">
            You voted for {votedFor}
          </p>
          <p className="text-sm text-[#9BA9C7]">
            Your vote is recorded and cannot be changed.
          </p>
        </div>
      </div>

      <div className="flex items-baseline justify-between mb-3.5 gap-3 flex-wrap">
        <div>
          <div className="text-[11px] text-[#6B7A9E] uppercase tracking-[0.08em] mb-1">
            Current results
          </div>
          <div className="text-2xl font-bold tabular-nums">
            {total}{" "}
            <span className="text-sm font-normal text-[#9BA9C7]">votes</span>
          </div>
        </div>
        <button
          onClick={onRefresh}
          className="text-[#9BA9C7] hover:text-[#F4F5F7] border border-[#1A2D5A] hover:border-[#2A4480] text-xs px-3 py-1.5 rounded-lg transition"
        >
          ↻ Refresh
        </button>
      </div>
      <ResultsChart poll={poll} votedFor={votedFor} showWinner={false} />
    </>
  );
}

function ClosedView({
  poll,
  total,
}: {
  poll: Record<string, number>;
  total: number;
}) {
  return (
    <>
      <div className="flex items-baseline justify-between mb-3.5 gap-3 flex-wrap">
        <div>
          <div className="text-[11px] text-[#6B7A9E] uppercase tracking-[0.08em] mb-1">
            Final results
          </div>
          <div className="text-[32px] font-bold tabular-nums">
            {total}{" "}
            <span className="text-sm font-normal text-[#9BA9C7]">
              total votes
            </span>
          </div>
        </div>
      </div>
      <ResultsChart poll={poll} showWinner />
    </>
  );
}

function ResultsChart({
  poll,
  showWinner,
  votedFor,
}: {
  poll: Record<string, number>;
  showWinner: boolean;
  votedFor?: string;
}) {
  const entries = Object.entries(poll).sort(([, a], [, b]) => b - a);
  const max = Math.max(...entries.map(([, v]) => v), 1);
  const total = entries.reduce((sum, [, v]) => sum + v, 0) || 1;

  if (entries.length === 0) {
    return (
      <div className="bg-[#081A3A] border border-[#1A2D5A] rounded-xl px-4 py-7 text-center text-sm text-[#6B7A9E]">
        No votes yet.
      </div>
    );
  }

  return (
    <div className="bg-[#081A3A] border border-[#1A2D5A] rounded-xl p-4">
      {entries.map(([name, count], i) => {
        const pct = Math.round((count / total) * 100);
        const barPct = Math.round((count / max) * 100);
        const isWinner = showWinner && i === 0;
        const isYours = votedFor === name;
        return (
          <div
            key={name}
            className={`py-3 ${i < entries.length - 1 ? "border-b border-[#1A2D5A]" : ""}`}
          >
            <div className="flex items-center justify-between mb-2 gap-3">
              <div className="flex items-center gap-2 flex-wrap min-w-0 flex-1">
                <span
                  className={`text-[15px] ${isWinner ? "font-semibold" : "font-medium"}`}
                >
                  {name}
                </span>
                {isWinner && (
                  <span className="text-[10px] font-semibold bg-[rgba(0,128,96,0.16)] text-[#4FD1A8] px-2 py-0.5 rounded-full border border-[rgba(0,128,96,0.3)] uppercase tracking-[0.06em]">
                    Winner
                  </span>
                )}
                {isYours && (
                  <span className="text-[10px] font-medium bg-[rgba(3,87,238,0.14)] text-[#7FA8FF] px-2 py-0.5 rounded-full border border-[rgba(3,87,238,0.45)]">
                    Your vote
                  </span>
                )}
              </div>
              <div className="flex items-baseline gap-2 tabular-nums flex-shrink-0">
                <span className="text-lg font-bold">{count}</span>
                <span className="text-xs text-[#6B7A9E]">{pct}%</span>
              </div>
            </div>
            <div className="h-1.5 bg-[#02102D] rounded-full overflow-hidden">
              <div
                className="h-full rounded-full transition-all duration-300"
                style={{
                  width: `${barPct}%`,
                  background: isWinner ? "#008060" : "#0357EE",
                }}
              />
            </div>
          </div>
        );
      })}
    </div>
  );
}

function PageShell({
  children,
  back,
}: {
  children: React.ReactNode;
  back?: { label: string; to: string };
}) {
  return (
    <div className="min-h-screen bg-[#02102D] text-[#F4F5F7]">
      <header className="sticky top-0 z-10 bg-[#02102D] border-b border-[#1A2D5A]">
        <div className="max-w-[680px] mx-auto px-5 h-14 flex items-center gap-4">
          <Link
            to="/"
            className="font-mono text-[11px] text-[#7FA8FF] bg-[rgba(3,87,238,0.14)] border border-[rgba(3,87,238,0.45)] px-2.5 py-1 rounded-md tracking-[0.08em]"
          >
            DREAM VOTE
          </Link>
          {back && (
            <>
              <span className="text-[#6B7A9E] text-sm">/</span>
              <Link
                to={back.to}
                className="text-sm text-[#9BA9C7] hover:text-[#F4F5F7] transition"
              >
                ‹ {back.label}
              </Link>
            </>
          )}
        </div>
      </header>
      {children}
    </div>
  );
}
