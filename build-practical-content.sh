#!/usr/bin/env sh

# Convert Markdown files to PDF
find . -type f -name "PRACTICAL_CONTENT.md" -mindepth 2 -maxdepth 2 -exec sh -c 'pandoc pandoc.yaml --variable geometry:margin=2cm --variable fontsize:12pt --variable papersize:a4 --variable lang:en --output "${1%.md}.pdf" "$1"' sh {} \;

# Rename all PDF files to the name of their parent directory with a '-practical-content' suffix
find . -type f -name "PRACTICAL_CONTENT.pdf" -exec sh -c 'mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")")-practical-content.pdf"' sh {} \;
