#!/bin/env bash

## This script runs benchmarks for different file sizes and implementations
## Made with the help of ChatGPT

# Define the file sizes and implementations
sizes=(1 1024 1048576 5242880)
implementations=("BINARY" "BUFFERED_BINARY" "TEXT" "BUFFERED_TEXT")
runs=10

# Function to calculate average time
calculate_average() {
  local times=("$@")
  local sum=0

  for time in "${times[@]}"; do
    sum=$(echo "$sum + $time" | bc)
  done

  local average=$(echo "scale=1; $sum / ${#times[@]}" | bc)

  echo $average
}

# Function to extract time from command output using awk
extract_time() {
  local output="$1"

  local time=$(echo "$output" | grep -oP 'Execution time in ms: \K[0-9]+')

  echo $time
}

# Loop over each file size
for size in "${sizes[@]}"; do
  # Generate the file name based on the size and the extension
  if [ "$implementation" = "BINARY" ] || [ "$implementation" = "BUFFERED_BINARY" ]; then
    file_name="${size}-bytes.bin"
  else
    file_name="${size}-chars.txt"
  fi

  # Loop over each implementation
  for implementation in "${implementations[@]}"; do
    # Initialize arrays to store times
    write_times=()
    read_times=()

    # Run the tests N times
    for ((i=0; i<runs; i++)); do
      # Capture write command output and extract time
      write_output=$(java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation $implementation $file_name write --size $size)
      write_time=$(extract_time "$write_output")
      write_times+=($write_time)

      # Capture read command output and extract time
      read_output=$(java -jar target/java-ios-1.0-SNAPSHOT.jar --implementation $implementation $file_name read)
      read_time=$(extract_time "$read_output")
      read_times+=($read_time)
    done

    # Calculate average times
    avg_write_time=$(calculate_average "${write_times[@]}")
    avg_read_time=$(calculate_average "${read_times[@]}")

    # Display the results
    echo "Size: $size bytes"
    echo "Implementation: $implementation"
    echo "Average write time: $avg_write_time ms"
    echo "Average read time: $avg_read_time ms"
    echo "-----------------------------------------"
  done
done

