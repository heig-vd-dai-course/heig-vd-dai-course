#!/usr/bin/env sh

## Error handling
set -o errexit
set -o pipefail
set -o noclobber
set -o nounset
set -o functrace

## Variables
WORKDIR=$(pwd)
MARP_DOCKER_IMAGE="marpteam/marp-cli:v4.1.1"

## Script
# Remove all previously generated presentations
rm -f **/*-presentation.pdf || true
rm -f **/index.html || true

# Check if Marp is installed locally
if command -v "marp-cli.js" > /dev/null 2>&1; then
    echo "Marp installed locally, using it..."
    MARP_CMD="marp-cli.js"
else
    echo "Marp not installed, using its Docker image..."
    MARP_CMD="docker run --rm --entrypoint=\"marp-cli.js\" --volume=\"$WORKDIR\":/home/marp/app $MARP_DOCKER_IMAGE"
fi

# Convert presentations
echo "Converting presentations to HTML..."
eval "$MARP_CMD --parallel $(nproc) **/*/PRESENTATION.md"

echo "Converting presentations to PDF..."
eval "$MARP_CMD --parallel $(nproc) --pdf **/*/PRESENTATION.md"

# Rename files
echo "Renaming HTML files to 'index.html'..."
find . -mindepth 2 -maxdepth 2 -type f -name "PRESENTATION.html" -exec sh -c '
    mv "$1" "$(dirname "$1")/index.html"
' sh {} \;

echo "Renaming PDF files to match parent directory..."
find . -mindepth 2 -maxdepth 2 -type f -name "PRESENTATION.pdf" -exec sh -c '
    mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")")-presentation.pdf"
' sh {} \;

echo "All presentations processed successfully!"
