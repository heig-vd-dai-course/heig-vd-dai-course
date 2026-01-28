#!/usr/bin/env bash

## Variables
WORKDIR=$(pwd)
PLANTUML_DOCKER_IMAGE="plantuml/plantuml:1.2025"

## Script
# Check if PlantUML is available locally
if [ -f "/opt/plantuml.jar" ]; then
    echo "PlantUML installed locally, using it..."
    PLANTUML_CMD=(java -jar /opt/plantuml.jar)
else
    echo "PlantUML not installed, using its Docker image..."
    PLANTUML_CMD=(
        docker run --rm
        --volume="${WORKDIR}:/data"
        --user "$(id -u):$(id -g)"
        "$PLANTUML_DOCKER_IMAGE"
    )
fi

# Enable for recursive globbing
shopt -s globstar nullglob

# Convert diagrams (enable multipart output if applicable)
echo "Converting diagrams to SVG files..."
"${PLANTUML_CMD[@]}" -DMULTI_PART=1 -tsvg -nbthread auto --progress **/*.puml


echo "Renaming multipart SVG files..."
multipart_files=()
for multipart_svg_file in **/*_001.svg; do
    base_name="${multipart_svg_file%_001.svg}"
    source_name="${base_name}.puml"

    # Add to list of multipart files
    multipart_files+=("$source_name")

    # Rename base file to -01.svg
    mv "${base_name}.svg" "${base_name}-01.svg"

    # Rename all remaining multipart files
    counter=2
    for numbered_file in "${base_name}"_*.svg; do
        new_file_name="$(printf "${base_name}-%02d.svg" $counter)"
        
        mv "$numbered_file" "$new_file_name"
        
        counter=$((counter + 1))
    done
done

echo "Regenerating single-page SVG files for multipart diagrams..."
"${PLANTUML_CMD[@]}" -tsvg "${multipart_files[@]}"

echo "All diagrams processed successfully!"
