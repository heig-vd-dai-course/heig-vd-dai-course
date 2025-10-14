---
marp: true
---

<!--
theme: custom-marp-theme
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of GitHub Copilot
title: HEIG-VD DAI - Git, GitHub and Markdown
description: Git, GitHub and Markdown for the DAI course at HEIG-VD, Switzerland
header: '[**Git, GitHub and Markdown**](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/01.03-git-github-and-markdown)'
footer: '[**HEIG-VD**](https://heig-vd.ch) - [DAI 2025-2026](https://github.com/heig-vd-dai-course/heig-vd-dai-course) - [CC BY-SA 4.0](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md)'
headingDivider: 6
-->

# Git, GitHub and Markdown

<!--
_class: lead
_paginate: false
-->

[Link to the course][course]

<small>L. Delafontaine and H. Louis, with the help of
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Objectives

- Understand how to use Git, GitHub and Markdown.
- Create and manage repositories on GitHub.
- Write and format documentation using Markdown.
- Share and collaborate effectively using Git and GitHub and their features.

![bg right:40%](https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720)

## Git

<!-- _class: lead -->

More details for this section in the [course][course]. You can find other
resources and alternatives as well.

### Git

- A version control system (VCS).
- Created in 2005 by Linus Torvalds.
- Efficiently tracks changes in files.
- Used to manage source code and documentation within a project.

![bg right w:60%](https://git-scm.com/images/logos/downloads/Git-Logo-2Color.svg)

### Architecture

- Git operates with a client-server structure:
  - Remote repositories (server).
  - Local repositories (local copies known as _clones_).
- Fully distributed VCS for offline work: each clone contains the full history.

![bg right contain](https://wac-cdn.atlassian.com/dam/jcr:9d51f0ee-5946-4be2-886c-ff040ef8c1a1/03.svg?cdnVersion=1210)

### Commits, hashes and tags

- Commits represent snapshots of the repository.
- Each commit has a unique, unalterable hash.
- Tags serve as references, often for releases.
- Commit signing enhances security.

![bg right w:90%](https://wac-cdn.atlassian.com/dam/jcr:bb02240a-7d85-4f5a-ae7f-c2727b37fc79/01%20Many%20ways%20of%20referring%20to%20a%20commit.svg?cdnVersion=1210)

### Branches

- Tracks distinct repository versions.
- Default branch is typically named `main`.
- Branches have names and commit pointers (heads).
- Allow to work on features or bug fixes without affecting the main branch.

![bg right w:90%](https://wac-cdn.atlassian.com/dam/jcr:34c86360-8dea-4be4-92f7-6597d4d5bfae/02%20Feature%20branches.svg?cdnVersion=1210)

### Merging branches

- Collaborative project workflow.
- Three primary merging methods:
  - Merge.
  - Rebase.
  - Squash.
- In this course, you will focus on the merge method.

![bg vertical right w:75%](https://wac-cdn.atlassian.com/dam/jcr:4639eeb8-e417-434a-a3f8-a972277fc66a/02%20Merging%20main%20into%20the%20feature%20branh.svg?cdnVersion=1210)
![bg vertical right w:75%](https://wac-cdn.atlassian.com/dam/jcr:a712e238-6cb9-4c8c-8ef7-1975dca49be3/04%20Squashing%20a%20commit%20with%20an%20interactive%20rebase.svg?cdnVersion=1210)

### Conflicts

- Arise from simultaneous file edits.
- Git detects and requires resolution.
- Conflicts must be resolved to decide which changes to keep.
- It can be tricky but is a crucial skill.

![bg right h:80%](https://imgs.xkcd.com/comics/git.png)

### Ignore files

- gitignore files omit specific files that should not be on the repository.
- Improves repository cleanliness and security (avoid sensitive data leaks).
- Tip: avoid online gitignore generators, they generate a lot of unnecessary
  rules.

![bg right w:85%](./images/git-ignore-files.png)

### Summary

- Git is a distributed VCS.
- Git uses commits to track changes.
- Git uses branches to track different versions of the repository.
- Git can pull changes from a remote repository.
- Git can merge, rebase or squash branches/commits.
- Git can detect and resolve conflicts.

**We encourage you to learn how to use Git from the command line, so you can
still use it everywhere (even on a server).**

## GitHub

<!-- _class: lead -->

More details for this section in the [course material][course]. You can find
other resources and alternatives as well.

### GitHub

- Git hosting platform.
- Created in 2008.
- Web-based Git hosting.
- Popular for open source projets.

![bg right w:60%](https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg)

### Social platform

- Social interactions:
  - Follow users.
  - Star projects.
  - Discover new projects.
- Forking repositories.
  - Create a copy of a repository.
  - Make changes and contribute back.

![bg right w:85%](./images/github-social-platform.png)

### Free features and PRO features

- Enhanced features with PRO (access to premium features and software).
- Free for students - you can apply!

![bg right w:85%](./images/github-free-features-and-pro-features.png)

### Users and organizations

- Users or organizations ownership.
- Users can be part of multiple organizations.

![bg right w:85%](./images/github-users-and-organizations.png)

### Issues, pull requests and forks

- Contribution workflow.
  - Issues.
  - Forks.
  - Pull requests.
- Approval process.
- Project management tools (wiki, planning, etc.).

![bg right w:85%](./images/github-issues-pull-requests-merge-requests.png)

### Summary

The whole process would be as follows:

1. Open an issue to discuss the feature (optional, but recommended).
2. Clone or fork the project and checkout to a new branch.
3. Make your changes, commit and push them as often as you want.
4. Create the pull request.
5. The maintainers review and merge if OK.
6. You can delete the branch or the fork.

## Markdown

<!-- _class: lead -->

More details for this section in the [course material][course]. You can find
other resources and alternatives as well.

### Markdown

- Lightweight markup language.
- Created by John Gruber and Aaron Swartz in 2004.
- Simple and versatile.
- Used by many platforms and tools.

![bg right w:60%](https://upload.wikimedia.org/wikipedia/commons/4/48/Markdown-mark.svg)

### Markdown and output formats

- Multiple output formats.
- Supports HTML integration.
- Used in web pages, presentations, documentation.

![bg right w:85%](./images/markdown-markdown-and-output-formats.png)

### Syntax

- Markup language with special characters (`#`, `*`, `-`, `[]`, `!` `_`, etc.).
- Discord and Telegram uses Markdown for formatting.
- Supports headings, text formatting, code blocks, lists, links, images, and
  tables.

![bg right w:85%](./images/markdown-syntax.png)

### Specifications

- No single standard.
- CommonMark and GitHub Flavored Markdown are the most popular.
- Custom extensions for additional features on some platforms.

![bg right w:85%](./images/markdown-specifications.png)

### Summary

- Markdown is easy to learn and use.
- Markdown can be used to create documentation.
- Markdown can be used to create slides.
- Markdown can be exported to many formats.

## Questions

<!-- _class: lead -->

Do you have any questions?

## Practical content

<!-- _class: lead -->

### What will you do?

- Install and configure Git.
- Create and configure your GitHub account.
- Create your own GitHub profile README.
- Add yourself to the GitHub repository README.

![bg right 85%](./images/what-will-you-do.png)

### Now it's your turn!

- Read the course material.
- Do the practical content.
- Ask questions if you have any.

➡️ [Find the course on GitHub][course].

**Do not hesitate to help each other! There's no need to rush!**

![bg right w:75%][course-qr-code]

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

➡️ [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## Sources

- Main illustration by [Roman Synkevych](https://unsplash.com/@synkevych) on
  [Unsplash](https://unsplash.com/photos/wX2L8L-fGeA)
- Illustration by [Aline de Nadai](https://unsplash.com/@alinedenadai) on
  [Unsplash](https://unsplash.com/photos/j6brni7fpvs)
- Git logo by [Git](https://git-scm.com/)
- Git illustrations by [Atlassian](https://www.atlassian.com/) -
  [1](https://www.atlassian.com/git/tutorials/what-is-git),
  [2](https://www.atlassian.com/git/tutorials/refs-and-the-reflog),
  [3](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow),
  [4](https://www.atlassian.com/git/tutorials/merging-vs-rebasing)
- Git strip by [xkcd](https://xkcd.com/1597/)

[course]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/01.03-git-github-and-markdown
[license]:
	https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/2
[illustration]: ./images/main-illustration.jpg
[course-qr-code]:
	https://quickchart.io/qr?format=png&ecLevel=Q&size=400&margin=1&text=https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/01.03-git-github-and-markdown
