# Base image
FROM alpine:3.22

# Working directory
WORKDIR /app

# Update and install packages
RUN apk update && apk add --no-cache tree

# Copy files into the container
COPY demo demo

# Entrypoint
ENTRYPOINT ["tree"]

# Command to run
CMD ["--help"]
