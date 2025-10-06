# Docker and Docker Compose - Solution

L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).

This work is licensed under the [CC BY-SA 4.0][license] license.

## Resources

- Objectives, teaching and learning methods, and evaluation methods:
  [Link to content](..)
- Course material: [Link to content](../01-course-material/README.md) ·
  [Presentation (web)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/04.01-docker-and-docker-compose/01-course-material/index.html)
  ·
  [Presentation (PDF)](https://heig-vd-dai-course.github.io/heig-vd-dai-course/04.01-docker-and-docker-compose/01-course-material/04.01-docker-and-docker-compose-presentation.pdf)
- Code examples: [Link to content](../02-code-examples/)
- Solution: [Link to content](../03-solution/)

## Solution

This directory contains the solution to the practical content of the course.

Feel free to explore the code and use it as a reference for your own work.

If you have any questions or need further assistance, please don't hesitate to
ask for help in the [GitHub Discussions][discussions] or by opening an issue or
creating a pull request (PR) on the course repository.

### Run the _"Go further"_ solution

You can specify the Docker Compose file to use with the `-f` option. This is
useful when you have multiple Docker Compose files in the same directory:

```sh
# Run the writer with the "compose-with-environment-variables.yaml" file
docker compose -f compose-with-environment-variables.yaml up writer

# Run the reader with the "compose-with-environment-variables.yaml" file
docker compose -f compose-with-environment-variables.yaml up reader
```

[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/113
