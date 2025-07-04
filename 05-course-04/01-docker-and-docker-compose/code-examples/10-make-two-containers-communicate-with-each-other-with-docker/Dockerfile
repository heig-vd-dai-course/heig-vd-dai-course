# Base image
FROM ubuntu:24.04

# Working directory
WORKDIR /app

# Update and install packages
RUN apt update && apt install --yes ncat

# Copy the entrypoint script
COPY docker-entrypoint.sh docker-entrypoint.sh

# Entrypoint
ENTRYPOINT ["/app/docker-entrypoint.sh"]

# Command to run
CMD ["--help"]
