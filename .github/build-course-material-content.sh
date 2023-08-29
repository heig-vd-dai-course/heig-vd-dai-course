#!/usr/bin/env sh

# Install DejaVu Sans font
apk add --no-cache ttf-dejavu

# Convert Markdown files to PDF
find . -type f -name "README.md" -mindepth 2 -maxdepth 2 -exec sh -c 'pandoc --variable papersize:a4 --variable geometry:margin=2cm --variable fontsize:12pt --variable linestretch:1.5 --variable mainfont:"DejaVu Sans" --variable lang:en --variable colorlinks:true --from=gfm --to=pdf --pdf-engine=xelatex --include-in-header=.github/pandoc-header.tex --output "${1%.md}.pdf" "$1"' sh {} \;

# Rename all PDF files to the name of their parent directory
find . -type f -name "README.pdf" -exec sh -c 'mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")")-course-material.pdf"' sh {} \;
