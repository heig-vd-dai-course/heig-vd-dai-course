#!/usr/bin/env sh

# Convert Markdown files to HTML
find . -type f ! -path "*practical-work*" -name "README.md" -mindepth 2 -maxdepth 2 -exec sh -c 'node /home/marp/.cli/marp-cli.js --config .github/marp.config.js --html --output "${1%.md}.html" "$1"' sh {} \;

# Convert Markdown files to PDF
find . -type f ! -path "*practical-work*" -name "README.md" -mindepth 2 -maxdepth 2 -exec sh -c 'node /home/marp/.cli/marp-cli.js --config .github/marp.config.js --html --allow-local-files --jpeg-quality 100 --pdf --output "${1%.md}.pdf" "$1"' sh {} \;

# Rename all HTML files to index.html
find . -type f -name "*.html" -exec sh -c 'mv "$1" "$(dirname "$1")/index.html"' sh {} \;

# Rename all PDF files to the name of their parent directory
find . -type f -name "*.pdf" -exec sh -c 'mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")").pdf"' sh {} \;
