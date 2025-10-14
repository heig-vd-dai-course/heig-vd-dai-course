# SMTP and ncat

This directory contains a simple example of how to send an email using the SMTP
protocol with a mock server.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/05.03-smtp-and-ncat/01-course-material/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/05.03-smtp-and-ncat/01-course-material/05.03-smtp-and-ncat-presentation.pdf)
- Code examples: [Link to content](../02-code-examples/)

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

To stop the Mailpit server, run:

```sh
# Stop the Mailpit server
docker compose down
```
