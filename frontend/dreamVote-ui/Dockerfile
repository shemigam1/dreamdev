# syntax=docker/dockerfile:1.7


FROM node:22-alpine AS build
WORKDIR /app


RUN corepack enable && corepack prepare pnpm@9 --activate


COPY package.json pnpm-lock.yaml ./
RUN pnpm install --frozen-lockfile

COPY . .

ENV VITE_APP_BASE_URL=__VITE_APP_BASE_URL__
RUN pnpm build


FROM nginxinc/nginx-unprivileged:1.27-alpine


COPY nginx.conf /etc/nginx/conf.d/default.conf


COPY --from=build --chown=nginx:nginx /app/dist /usr/share/nginx/html


COPY --chmod=0755 --chown=nginx:nginx docker-entrypoint.sh /docker-entrypoint.d/40-substitute-vite-env.sh

EXPOSE 8080


HEALTHCHECK --interval=10s --timeout=3s --start-period=5s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:8080/healthz || exit 1
