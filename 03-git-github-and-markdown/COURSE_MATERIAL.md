[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/03-git-github-and-markdown/COURSE_MATERIAL.md#practical-content
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/03-git-github-and-markdown/03-git-github-and-markdown-practical-content.pdf
[discussions]: https://github.com/orgs/heig-vd-dai-course/discussions/2
[illustration]:
  https://images.unsplash.com/photo-1618401471353-b98afee0b2eb?fit=crop&h=720

# Git, GitHub and Markdown - Course material

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] | [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot

Based on the original course by O. Liechti and J. Ehrensberger

![Main illustration][illustration]

## Table of contents

- [Table of contents](#table-of-contents)
- [Git](#git)
  - [Architecture](#architecture)
  - [Commits, hashes and tags](#commits-hashes-and-tags)
  - [Branches](#branches)
  - [Merging branches](#merging-branches)
  - [Conflicts](#conflicts)
  - [Ignore files](#ignore-files)
  - [Summary](#summary)
  - [Cheat sheet](#cheat-sheet)
- [GitHub](#github)
  - [Social platform](#social-platform)
  - [Free features and PRO features](#free-features-and-pro-features)
  - [Users and organizations](#users-and-organizations)
  - [Issues, pull requests and merge requests](#issues-pull-requests-and-merge-requests)
  - [Summary](#summary-1)
- [Markdown](#markdown)
  - [Markdown and output formats](#markdown-and-output-formats)
  - [Syntax](#syntax)
  - [Specifications](#specifications)
  - [Summary](#summary-2)
- [Practical content](#practical-content)
  - [Install Git](#install-git)
  - [Create and configure your GitHub account](#create-and-configure-your-github-account)
  - [Create your own profile README](#create-your-own-profile-readme)
  - [Add yourself to the list of students in the GitHub organization](#add-yourself-to-the-list-of-students-in-the-github-organization)
  - [Go further](#go-further)
- [Conclusion](#conclusion)
  - [What did you do and learn?](#what-did-you-do-and-learn)
  - [Test your knowledge](#test-your-knowledge)
- [Finished? Was it easy? Was it hard?](#finished-was-it-easy-was-it-hard)
- [What will you do next?](#what-will-you-do-next)
- [Sources](#sources)

## Git

> [Git](https://git-scm.com/) is a free and open source distributed version
> control system (VCS) designed to handle everything from small to very large
> projects with speed and efficiency.

Created by Linus Torvalds in 2005 to manage the Linux kernel source code, Git
allows to track changes in any set of files, usually used for coordinating work
among programmers collaboratively developing source code during software
development.

### Architecture

Git is a client-server system, where the server is called a **repository** and
the clients are called **clones**.

The repository is the single source of truth, and the clones are the local
copies of the repository.

Git is a **distributed** VCS, which means that each clone is a full copy of the
repository. This allows to work offline, and to have multiple backups of the
repository.

### Commits, hashes and tags

Git uses **commits** to track changes. A commit is a snapshot of the repository
at a given time. Each commit has a unique identifier, called a **hash**. The
hash is computed from the content of the commit, so it is impossible to modify a
commit without changing its hash.

Commits can be **tagged** to create a reference to a commit. This is often used
to mark a commit as a release.

Commits can be **signed** to prove that the commit was made by a specific
person. This is done for security reasons.

### Branches

Git uses **branches** to track different versions of the repository. The default
branch is often called `main` (the legacy name was `master`).

Each branch has a name and a pointer to a commit. The pointer is called a
**head**. The head of the main branch is called `HEAD`.

Often, when implementing a new feature, a new branch is created. This is done by
creating a new branch from the main branch. The new branch is called a **feature
branch**. The main branch is called the **target branch**.

Once you made all the changes, the modified files are **staged** and a new
commit is created. The commit is then **pushed** to the repository.

Commits can be compared to see the **differences** between the staged files and
the working directory. This is done by comparing the files with the last commit.

Commits can be **pulled** from the repository into the current branch.

### Merging branches

Collaborating on a project is done by creating branches, making and committing
changes, pushing and merging the branches back into the target branch.

There are three main ways to merge branches:

- **Merge**: merge the changes from the two branches into a new commit. This is
  the default behavior of Git.
- **Rebase**: append the source branch to the target branch so no new commits
  are created. This is a more advanced technique.
- **Squash**: Combine multiple commits into a single one to reduce the number of
  commits in a branch.

### Conflicts

Working collaboratively can lead to **conflicts**. Conflicts happen when two or
more people make changes to the same file at the same time. Git is able to
detect conflicts and will ask the user to resolve them.

### Ignore files

Files can be **ignored** by Git. This is done by creating a `.gitignore` file at
the root of the repository. This allows to avoid committing files that should
not be committed, such as IDE configuration files.

### Summary

- Git is a distributed VCS
- Git uses commits to track changes
- Git uses branches to track different versions of the repository
- Git can pull changes from a branch into another
- Git can merge, rebase or squash branches/commits
- Git can detect and resolve conflicts

We encourage you to learn how to use Git from the command line, so you can still
use it everywhere (even on a server).

### Cheat sheet

```sh
# Clone a Git repository
git clone <url>

# Create a branch and switch to it
git checkout -b <branch-name>

# Switch to a branch
git checkout <branch-name>

# Add changes to the staging area
git add <file>

# View differences between the working directory and the staging area
git diff <file>

# Check Git status
git status

# Commit changes
git commit -m "Commit message"

# Push changes to a branch
git push origin <branch-name>

# Pull changes from a branch
git pull origin <branch-name>

# Merge a branch into another
git merge <branch-name>
```

## GitHub

> [GitHub](https://github.com) is a platform and cloud-based service for
> software development and version control using Git, allowing developers to
> store and manage their code.

![bg right:40% w:75%](https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png)

GitHub is a web-based Git repository hosting service. It provides all the
features of Git, plus some additional features.

It is the most popular Git repository hosting service, with more than 65 million
repositories, a home for many open source projects and a place where many
companies host their private repositories.

### Social platform

GitHub is a **social** platform. It allows to **follow** other users and to
**star** repositories. It also allows to **fork** repositories, which means to
create a copy of a repository in your own account.

### Free features and PRO features

GitHub offers features on top of Git. Some features are only available for
public repositories. To enable them for private repositories, you need to
upgrade to a **PRO** account, which is not free.

As a HEIG-VD student, you can get a **PRO** account for free with the
[GitHub Student Developer Pack](https://education.github.com/pack).

### Users and organizations

Repositories can be owned by a **user** or by an **organization**.

An organization can have multiple members, and repositories can be shared
between members. It is a good practice to create an organization for a project
that will be worked on by multiple people.

### Issues, pull requests and merge requests

GitHub also provides a **wiki** for each repository, a **project board** to
manage tasks, an **issue tracker** to report bugs and a **pull request** system
to review and merge changes.

Contributing to a project hosted on GitHub is done by **forking** the
repository, making changes and opening a **pull request** to merge the changes
back into the original repository.

Forking is only needed if you are not a member of the repository or
organization.

Once a branch is ready to be merged into the target branch, it is good practice
to open a **pull request** (or a **merge request** on GitLab). A pull request is
a request to merge a branch into another. It is a way to discuss the changes
before merging them.

Reviewing a pull request is done by **commenting** on the changes. The reviewer
can ask for changes to be made before merging the branch or can approve the
changes.

Once the pull request is approved, the branch can be **merged** into the target
branch.

By default, GitHub does not delete the branch once it is merged. You might want
to enable this by default in your repository settings or delete it manually. It
avoids to cumulate out-dated branches in your repository.

### Summary

The whole process would be as follow:

1. Clone or fork the project
2. Checkout to a new branch
3. Make your changes, commit and push them as often as you want
4. Create the pull request
5. The maintainers review and merge if OK
6. You can delete the branch or the fork

## Markdown

> [Markdown](https://daringfireball.net/projects/markdown/) is a lightweight
> markup language for creating formatted text using a plain-text editor.

Markdown was created by John Gruber in 2004 with the help of Aaron Swartz
(co-founder of Reddit and an Internet hacktivist). It is a simple markup
language that allows to create formatted text using a plain-text editor.

It is widely used on the Internet, especially on GitHub, and GitLab. It is also
used in many static site generators, such as [Hugo](https://gohugo.io/) and
[MkDocs](https://www.mkdocs.org/).

### Markdown and output formats

The syntax of Markdown is very simple and easy to learn. It is a good
alternative to HTML for creating simple web pages, documentation, README files,
etc. The extension of a Markdown file is `.md`.

You can export Markdown files to HTML, PDF, DOCX, etc. making it a very
versatile format.

It is also possible to use HTML in Markdown files, so it is possible to create
more complex documents.

In fact, the exact current document you are reading right now is written in
Markdown.

### Syntax

Markdown is a markup language, which means that it uses special characters to
format the text. It is very similar to the syntax used in Discord, Telegram,
WhatsApp, etc.

#### Headings

To create headings, use the `#` character. The number of `#` characters
determines the level of the heading.

```markdown
# Heading 1

## Heading 2

### Heading 3

#### Heading 4

##### Heading 5
```

#### Text formatting

Text formatting can be done using `*`, `_`, `~`, `` ` `` or `>` characters.

```markdown
_This is italic_ and _this as well_.

**This is bold** and **this as well**.

This is ~~strikethrough~~.

This is `inline code`.

> This is a quote
```

#### Code blocks

Code blocks can highlight code syntax for many languages. Horizontal rules can
be used to separate sections with `---`.

````markdown
```java
System.out.println("Hello World!");
```

```javascript
console.log("Hello World!");
```

```python
print("Hello World!")
```
````

#### Unordered lists

Unordered lists can be created using `-` or `*` characters.

```markdown
List one

- Item 1
- Item 2
- Item 3

List two

- Item 1
- Item 2
- Item 3
```

#### Ordered lists

Ordered lists can be created using numbers followed by a `.` character. Only the
first number matters, the rest can be anything (but it is not recommended for
readability).

```markdown
1. Item 1
2. Item 2
3. Item 3
4. Still item 4
5. Still item 5
```

#### Links

Links can link to local files, headings, or references.

```markdown
[GitHub](https://github.com/)

<https://gitlab.com>

[`README.md`](./README.md)

[Jump to "Markdown"](#markdown)

[HEIG-VD][heig-vd]

[heig-vd]: https://heig-vd.ch
```

#### Images

Images can be added using the same syntax as links, but with a `!` character in
front of the link. The text field will be used as the alt text for accessibility
and SEO. An optional title can be set with `""` characters.

```markdown
![](https://my-website.com/assets/logo.png)

![A landscape of the Alps](./images/alps.jpeg)

![A schema describing the Git workflow](./images/schema.svg "Git workflow")
```

#### Tables

Tables can be created using the `|` character to separate columns and `-`
characters to separate the header from the content. The header is optional. The
text alignment can be specified using `:` characters.

```markdown
| Header 1 | Header 2 | Header 3 |
| -------- | :------: | -------: |
| Cell 1   |  Cell 2  |   Cell 3 |
| Cell 4   |  Cell 5  |   Cell 6 |
```

#### HTML

HTML can be used in Markdown files. This allows to create more complex
documents. It is also possible to use CSS to style the document. This is not
covered in this course and I would not recommend it as the goal of Markdown is
to be simple.

If you have a look at the source code of this document (the Markdown version on
GitHub), you will see that it is written in Markdown and that it uses HTML to
create the slides with the help of [Marp](https://marp.app/).

#### "Hacky" tips

You can use HTML comments to hide content from the Markdown parser. The same can
be achieved using a link-reference.

```markdown
<!-- This is a comment -->

[This is a comment]: #
```

New lines can be added between two lines with two spaces at the end of the line
or by using a backslash at the end of a line.

```markdown
<!-- You might want to highlight these lines to see the double spaces -->

A line  
Another line

A line\
Another line
```

### Specifications

Markdown is not a standard, but there are many implementations. The most popular
one is [CommonMark](https://commonmark.org/). GitHub uses a slightly different
version called [GitHub Flavored Markdown](https://github.github.com/gfm/).

Some projects use custom extensions to add more features to Markdown. For
example:

- [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) uses
  custom extensions to add more features to Markdown.
- [Marp](https://marp.app/) uses a custom syntax to manage background images in
  slides.

### Summary

- Markdown is easy to learn and use
- Markdown can be used to create documentation
- Markdown can be used to create slides
- Markdown can be exported to many formats
  - The presentations are exported to Web and PDF with the help of
    [Marp](https://marp.app/)
  - The course material is exported to PDF with the help of
    [Pandoc](https://pandoc.org/)

## Practical content

### Install Git

#### Install Git

Go to the official website and follow the instructions on how to install Git on
your system: <https://git-scm.com/downloads>

#### Check the installation

Open a terminal and type `git --version`

The output should be similar to this: `git version 2.41.0`

### Create and configure your GitHub account

#### Create a GitHub account

If you do not have a GitHub account yet, you will need to create one.

Follow the official documentation to create your account:
<https://docs.github.com/en/get-started/signing-up-for-github/signing-up-for-a-new-github-account>

> **Note** Do not forget to verify your email address!

#### Create a SSH key

In this section, you will create a SSH key to authenticate to GitHub. If you
already have one, you can skip this section. You must have `ssh-keygen`
installed on your system.

An SSH key is a pair of keys: a public key and a private key. The public key is
used to authenticate to a server, and the private key is used to sign the
authentication request.

It is required to use the SSH key authentication method to authenticate to
GitHub. It is more secure than using a password.

1. Open a terminal
2. Type `ssh-keygen -t ed25519 -C ""`
3. Press enter to use the default location
4. Enter a passphrase (optional)
5. Type `eval "$(ssh-agent -s)"`
6. Type `ssh-add ~/.ssh/id_ed25519`
7. Type `cat ~/.ssh/id_ed25519.pub`

> **Warning** Never share your private key with anyone! It must be kept secret
> and confidential, just like a password.

#### Add the public SSH key to your GitHub account

TODO

#### Enable two-factor authentication (optional, but highly recommended)

TODO

#### Enable your PRO account

TODO

### Create your own profile README

#### Create a new repository

In this section, you will create a new special repository to set your GitHub
profile. This repository is named `.github`. If you already have it, you can
skip this section.

#### Clone the repository locally

#### Fill your profile

Fill a new file named `profile/README.md` file. This file will be used by GitHub
to set your profile.

#### Commit your changes

Commit your changes and push them to the repository.

#### Push your changes

Push your changes to the repository.

#### Check the results

TODO

#### Share your profile in GitHub Discussions

This will notify us that you have completed the exercise.

GitHub Discussions - show and tell

#### Summary

### Add yourself to the list of students in the GitHub organization

TODO

#### Fork the repository

TODO

#### Clone the repository locally

TODO

#### Create a new branch

TODO

#### Add yourself to the list

TODO

#### Commit your changes

TODO

#### Intentionally create a conflict

TODO

#### Resolve the conflict

TODO

#### Push your changes

TODO

#### Create a pull request

TODO

#### Wait for review

TODO

#### Make changes if needed

TODO

#### Check the results

TODO

#### Summary

TODO

### Go further

This is an optional section. You can do it if you have time left. We encourage
you to do it nonetheless to learn more about Git and GitHub!

- Go in the GitHub Discussions, check the others profiles and give them a star!
- Follow your classmates!
- Follow other GitHub users! Can you think of an open source project you like?
  Follow these projects and/or maintainers!

## Conclusion

<!-- _class: lead -->

### What did you do and learn?

In this chapter, you have installed and configured Git properly. You have also
created your own GitHub account and profile README for your future social
profile as a computer scientist engineer.

Finally, you have added yourself to the list of students in the GitHub
organization using the issue, fork and pull request workflow, enabling you to
contribute to open source projects in the future.

Git is a valuable tool for collaborative work but we only scratched the surface.
Refer to the resources for more useful content!

### Test your knowledge

At this point, you should be able to answer the following questions:

- How does Git work?
- What is the difference between Git and GitHub?
- How is Markdown different from Word?
- What is a repository? What is a clone?
- What is a tag? What is the difference with a commit?
- Describe a typical Git workflow.

## Finished? Was it easy? Was it hard?

Can you let us know what was easy and what was difficult for you during this
chapter?

This will help us to improve the course and adapt the content to your needs. If
we notice some difficulties, we will come back to you to help you.

:arrow_right: [GitHub Discussions][discussions]

You can use reactions to express your opinion on a comment!

## What will you do next?

In the next chapter, you will learn the following topics:

- Java: why is Java a popular programming language?
- IntelliJ IDEA: tips and tricks for a better (collaborative) experience
- Maven: Java project structure, dependencies and build tool

## Sources

- Main illustration by [Roman Synkevych](https://unsplash.com/@synkevych) on
  [Unsplash](https://unsplash.com/photos/wX2L8L-fGeA)
