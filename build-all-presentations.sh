#!/usr/bin/env sh

## Variables
WORKDIR=$(pwd)
MARP_DOCKER_IMAGE="marpteam/marp-cli:v4.1.1"

## Script
echo "Removing all previous generated presentations..."
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
eval "$MARP_CMD --config-file .marp/config.yaml --parallel $(nproc) **/*/PRESENTATION.md"

echo "Converting presentations to PDF..."
eval "$MARP_CMD --config-file .marp/config.yaml --parallel $(nproc) --pdf **/*/PRESENTATION.md"

# Rename files
echo "Renaming HTML files to 'index.html'..."
find . -mindepth 3 -maxdepth 3 -type f -name "PRESENTATION.html" -exec sh -c '
    mv -f "$1" "$(dirname "$1")/index.html"
' sh {} \;

echo "Renaming presentation files to match parent directory..."
find . -mindepth 3 -maxdepth 3 -type f -name "PRESENTATION.pdf" -exec sh -c '
    for file; do
        chapter_name=$(basename "$(dirname "$(dirname "$file")")")
        mv -f "$file" "$(dirname "$file")/$chapter_name-presentation.pdf"
    done
' sh {} +

echo "All presentations processed successfully!"
