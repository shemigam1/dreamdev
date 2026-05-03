#!/bin/sh


set -eu


VITE_APP_BASE_URL="${VITE_APP_BASE_URL:-/api}"

echo "[vite-env] substituting __VITE_APP_BASE_URL__ -> ${VITE_APP_BASE_URL}"

find /usr/share/nginx/html -type f -name "*.js" -exec \
    sed -i "s|__VITE_APP_BASE_URL__|${VITE_APP_BASE_URL}|g" {} +

echo "[vite-env] done"
