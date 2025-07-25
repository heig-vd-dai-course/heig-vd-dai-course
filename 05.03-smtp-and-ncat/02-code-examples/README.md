# SMTP and ncat

This repository contains a simple example of how to send an email using the SMTP
protocol with a mock server.

## Usage

Start the Mailpit server with Docker Compose:

```sh
# Start the Mailpit server in the background
docker compose up -d
```

Then, you can run the Java client:

```sh
# Compile the Java client
javac SmtpClientExample.java

# Run the Java client
java SmtpClientExample
```

Access the Mailpit web interface at <http://localhost:8025>. You should see the
email sent by the Java client.
