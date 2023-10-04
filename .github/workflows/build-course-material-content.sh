#!/usr/bin/env sh

# Install required packages
apk add --no-cache \
    fontconfig \
    font-terminus \
    pandoc-cli \
    sed \
    weasyprint

# Convert Markdown files to HTML
find . -type f -name "COURSE_MATERIAL.md" -mindepth 2 -maxdepth 2 -exec sh -c ' \
    sed "/<details>/,/<\/details>/d" "$1" | pandoc --from=gfm --to=html --standalone --output "${1%.md}.html" \
' sh {} \;

# Convert HTML files to PDF
find . -type f -name "COURSE_MATERIAL.html" -mindepth 2 -maxdepth 2 -exec sh -c ' \
    weasyprint --stylesheet .github/workflows/course-material-template/style.css "$1" "${1%.html}.pdf" \
' sh {} \;

# Rename all PDF files to the name of their parent directory
find . -type f -name "COURSE_MATERIAL.pdf" -mindepth 2 -maxdepth 2 -exec sh -c ' \
    mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")")-course-material.pdf" \
' sh {} \;

# Delete all HTML files
find .  -type f -name "COURSE_MATERIAL.html" -mindepth 2 -maxdepth 2 -delete
