# dreamVote UI

React SPA for the dreamVote voting application. Voters register, create
elections, nominate candidates, and cast votes.

**Live:** https://dreamvote.vercel.app
**Backend:** https://dreamvote-server.onrender.com

## Tech stack

- **React 19** + **TypeScript** + **Vite**
- **Redux Toolkit** (RTK Query for API calls, slices for app state)
- **React Router** for client-side routing
- **Tailwind CSS** for styling
- **nginx** (only inside the Docker image; Vercel serves the SPA from its
  CDN, no nginx in that path)

## Prerequisites

- **Node.js 22+**
- **pnpm** — install with `corepack enable && corepack prepare pnpm@9 --activate`
- A running backend (either local — see the
  [server repo](https://github.com/shemigam1/dreamVote) — or the deployed one)

## Local development

### 1. Install dependencies

```sh
pnpm install
```

### 2. Configure the API base URL

Create `.env` in the repo root (already there if you cloned a working copy):

```
VITE_APP_BASE_URL=http://localhost:8080
```

Point it wherever the backend is reachable. Common values:

| Backend running | `VITE_APP_BASE_URL` |
|---|---|
| Locally on `localhost:8080` | `http://localhost:8080` |
| Deployed | `https://dreamvote-server.onrender.com` |

### 3. Run the dev server

```sh
pnpm dev
```

Vite serves at `http://localhost:5173` with hot-reload.

## Docker

A `Dockerfile` is included for containerized deploys (Render, etc.). The
Vercel deploy does not use it.

```sh
# Build
docker build -t dreamvote-ui:dev .

# Run, pointing the SPA at any backend URL
docker run --rm -p 8080:8080 \
  -e VITE_APP_BASE_URL=https://dreamvote-server.onrender.com \
  dreamvote-ui:dev
```

The image uses a runtime-config-injection pattern: `VITE_APP_BASE_URL` is
substituted into the bundled JS at container startup, so the same image
works in any environment by passing a different env var.

Visit `http://localhost:8080`.

## Useful scripts

```sh
pnpm dev        # Vite dev server (HMR)
pnpm build      # tsc -b && vite build -> outputs to dist/
pnpm lint       # ESLint
pnpm preview    # Preview the production build locally
```

## Project structure

```
src/
├── api/          # RTK Query API slices (auth, election)
├── components/   # Reusable UI components
├── routes/       # Route definitions
├── slice/        # Redux slices (voter, election)
├── store/        # Redux store setup
├── views/        # Page-level components
└── App.tsx       # Router root
```

## Deployment

The app is deployed to **Vercel** (https://dreamvote.vercel.app). Vercel
auto-detects Vite, runs `pnpm install && pnpm build`, and serves `dist/`
from its CDN.

Required environment variable in Vercel:

```
VITE_APP_BASE_URL=https://dreamvote-server.onrender.com
```

The same repo's `Dockerfile` lets you also deploy to Render (or any
container host) if you prefer a Docker-based deployment.
