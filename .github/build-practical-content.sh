#!/usr/bin/env sh

# Install DejaVu Sans font
apk add --no-cache ttf-dejavu

# Convert practical content Markdown files to PDF
find . -type f -name "PRACTICAL_CONTENT.md" -mindepth 2 -maxdepth 2 -exec sh -c 'pandoc --variable papersize:a4 --variable geometry:margin=2cm --variable fontsize:12pt --variable linestretch:1.5 --variable mainfont:"DejaVu Sans" --variable lang:en --variable colorlinks:true --from=gfm --to=pdf --pdf-engine=xelatex --include-in-header=.github/pandoc-header.tex --output "${1%.md}.pdf" "$1"' sh {} \;

# Convert practical work Markdown files to PDF
find . -type f -name "README.md" -path "*practical-work*" -mindepth 2 -maxdepth 2 -exec sh -c 'pandoc --variable papersize:a4 --variable geometry:margin=2cm --variable fontsize:12pt --variable linestretch:1.5 --variable mainfont:"DejaVu Sans" --variable lang:en --variable colorlinks:true --from=gfm --to=pdf --pdf-engine=xelatex --include-in-header=.github/pandoc-header.tex --output "${1%.md}.pdf" "$1"' sh {} \;

# Rename all practical content PDF files to the name of their parent directory with a '-practical-content' suffix
find . -type f -name "PRACTICAL_CONTENT.pdf" -exec sh -c 'mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")")-practical-content.pdf"' sh {} \;

# Rename all practical work PDF files to the name of their parent directory
find . -type f -name "README.pdf" -exec sh -c 'mv "$1" "$(dirname "$1")/$(basename "$(dirname "$1")").pdf"' sh {} \;
