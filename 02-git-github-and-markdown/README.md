---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine, J. Ehrensberger and H. Louis with the help of Copilot
title: HEIG-VD DAI Course - Git, GitHub and Markdown
description: Git, GitHub and Markdown for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-git-github-and-markdown/
footer: '**HEIG-VD** - DAI Course 2023-2024 - CC BY-SA 4.0'
style: |
    :root {
        --color-background: #fff;
        --color-foreground: #333;
        --color-highlight: #f96;
        --color-dimmed: #888;
        --color-headings: #7d8ca3;
    }
    blockquote {
        font-style: italic; 
    }
    table {
        width: 100%;
    }
    th:first-child {
        width: 15%;
    }
    h1, h2, h3, h4, h5, h6 {
        color: var(--color-headings);
    }
    h2, h3, h4, h5, h6 {
        font-size: 1.5rem;
    }
    h1 a:link, h2 a:link, h3 a:link, h4 a:link, h5 a:link, h6 a:link {
        text-decoration: none;
    }
    section:not([class=lead]) > p, blockquote {
        text-align: justify;
    }
headingDivider: 4
-->

[readme]: https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/02-git-github-and-markdown/README.md
[web]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-git-github-and-markdown/
[pdf]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-git-github-and-markdown/02-git-github-and-markdown.pdf
[video]: #

# Git, GitHub and Markdown

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[README][readme] | [Slides (web)][web] | [Slides (pdf)][pdf] | [Video (in French)][video]

<small>L. Delafontaine, J. Ehrensberger and H. Louis with the help of Copilot</small>

![bg opacity:0.1](https://images.unsplash.com/photo-1618401471353-b98afee0b2eb?fit=crop&w=720&q=80)

## Agenda

- **Theoretical content**
    - [Git](#git)
    - [GitHub](#github)
    - [Markdown](#markdown)
- **Practical content**
    - [Configure your GitHub account professionally](#configure-your-github-account-professionally)
    - [Create your own GitHub profile README](#create-your-own-github-profile-readme)
    - [Add yourself to the list of students in the GitHub organization](#add-yourself-to-the-list-of-students-in-the-github-organization)

## Theoretical content

<!-- _class: lead -->

### Git

> [Git](https://git-scm.com/) is a free and open source distributed version control system (VCS) designed to handle everything from small to very large projects with speed and efficiency.

Created by Linus Torvalds in 2005 to manage the Linux kernel source code, Git allows to track changes in any set of files, usually used for coordinating work among programmers collaboratively developing source code during software development.

---

Git is a client-server system, where the server is called a **repository** and the clients are called **clones**. The repository is the single source of truth, and the clones are the local copies of the repository.

Git is a **distributed** VCS, which means that each clone is a full copy of the repository. This allows to work offline, and to have multiple backups of the repository.

Git uses **commits** to track changes. A commit is a snapshot of the repository at a given time. Each commit has a unique identifier, called a **hash**. The hash is computed from the content of the commit, so it is impossible to modify a commit without changing its hash.

---

Git uses **branches** to track different versions of the repository. The default branch is often called `main` (the legacy name was `master`). Each branch has a name and a pointer to a commit. The pointer is called a **head**. The head of the main branch is called `HEAD`.

Commits can be **tagged** to create a reference to a commit. This is often used to mark a commit as a release.

Commits can be **signed** to prove that the commit was made by a specific person. This is done for security reasons.

---

Often, when implementing a new feature, a new branch is created. This is done by creating a new branch from the main branch. The new branch is called a **feature branch**. The main branch is called the **target branch**.

Once you made all the changes, the modified files are **staged** and a new commit is created. The commit is then **pushed** to the repository.

Changes can be compared to see the **differences** between the staged files and the working directory. This is done by comparing the files with the last commit.

Changes can be **pulled** from the repository into the current branch.

---

Collaborating on a project is done by creating branches, making and committing changes, pushing and merging the branches back into the target branch.

There are three main ways to merge branches:

- **Merge**: merge the changes from the two branches into a new commit. This is the default behavior of Git.
- **Rebase**: append the source branch to the target branch so no new commits are created. This is a more advanced technique.
- **Squash**: Combine multiple commits into a single one to reduce the number of commits in a branch.

---

Working collaboratively can lead to **conflicts**. Conflicts happen when two or more people make changes to the same file at the same time. Git is able to detect conflicts and will ask the user to resolve them.

When working on a project, it is important to keep the main branch up to date. This is done by **pulling** the changes from the main branch into the current branch. This is done by merging the main branch into the current branch.

Files can be **ignored** by Git. This is done by creating a `.gitignore` file at the root of the repository. This allows to avoid committing files that should not be committed, such as IDE configuration files.

#### Summary

- Git is a distributed VCS
- Git uses commits to track changes
- Git uses branches to track different versions of the repository
- Git can pull changes from a branch into another
- Git can merge, rebase or squash branches/commits
- Git can detect and resolve conflicts

I encourage you to learn how to use Git from the command line, so you can still use it everywhere (even on a server).

#### Common actions

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
```

---

```sh
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

#### Alternatives

- [Subversion](https://subversion.apache.org/)
- [Mercurial](https://www.mercurial-scm.org/)
- [Bazaar](https://bazaar.canonical.com/en/)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

#### Resources

- [Learn Git Branching](https://learngitbranching.js.org/)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

### GitHub

> [GitHub](https://github.com) is a platform and cloud-based service for software development and version control using Git, allowing developers to store and manage their code.

GitHub is a web-based Git repository hosting service. It provides all the features of Git, plus some additional features.

It is the most popular Git repository hosting service, with more than 65 million repositories, a home for many open source projects and a place where many companies host their private repositories.

---

GitHub is a **social** platform. It allows to **follow** other users and to **star** repositories. It also allows to **fork** repositories, which means to create a copy of a repository in your own account.

GitHub also provides a **wiki** for each repository, a **project board** to manage tasks, an **issue tracker** to report bugs and a **pull request** system to review and merge changes.

Not all these features are needed for all projects, but they are available if needed.

Repositories can be owned by a **user** or by an **organization**.

---

Contributing to a project hosted on GitHub is done by **forking** the repository, making changes and opening a **pull request** to merge the changes back into the original repository.

Forking is only needed if you are not a member of the repository or organization.

Once a branch is ready to be merged into the target branch, it is good practice to open a **pull request** (or a **merge request** on GitLab). A pull request is a request to merge a branch into another. It is a way to discuss the changes before merging them.

---

Reviewing a pull request is done by **commenting** on the changes. The reviewer can ask for changes to be made before merging the branch or can approve the changes.

Once the pull request is approved, the branch can be **merged** into the target branch.

By default, GitHub does not delete the branch once it is merged. You might want to enable this by default in your repository settings or delete it manually. It avoids to cumulate out-dated branches in your repository.

#### Summary

The whole process would be as follow:

1. Clone or fork the project
2. Checkout to a new branch
3. Make your changes
4. Commit and push your changes
5. Create the pull request
6. The maintainers review and merge if OK
7. You can delete the branch or the fork

#### Alternatives

- [GitLab](https://gitlab.com/) - My personal favorite
- [Bitbucket](https://bitbucket.org/) - My least favorite
- [Gitea](https://gitea.io/) - Very good self-hosted alternative
- [Gogs](https://gogs.io/)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

#### Resources

- [The Basics of GitHub](https://github.com/education/github-starter-course) - A great Git repository to learn the basics of GitHub!

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

### Markdown

> [Markdown](https://daringfireball.net/projects/markdown/) is a lightweight markup language for creating formatted text using a plain-text editor.

Markdown was created by John Gruber in 2004 with the help of Aaron Swartz (co-founder of Reddit and an Internet hacktivist). It is a simple markup language that allows to create formatted text using a plain-text editor.

It is widely used on the Internet, especially on GitHub, and GitLab. It is also used in many static site generators, such as [Hugo](https://gohugo.io/) and [MkDocs](https://www.mkdocs.org/).

---

The syntax of Markdown is very simple and easy to learn. It is a good alternative to HTML for creating simple web pages, documentation, README files, etc. The extension of a Markdown file is `.md`.

You can export Markdown files to HTML, PDF, DOCX, etc. making it a very versatile format.

It is also possible to use HTML in Markdown files, so it is possible to create more complex documents.

In fact, the exact current document you are reading right now is written in Markdown.

#### Headings

To create headings, use the `#` character. The number of `#` characters determines the level of the heading.

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
*This is italic* and _this as well_.

**This is bold** and __this as well__.

This is ~~strikethrough~~.

This is `inline code`.

> This is a quote
```

---

Code blocks can highlight code syntax for many languages. Horizontal rules can be used to separate sections with `---`.

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

* Item 1
* Item 2
* Item 3
```

#### Ordered lists

Ordered lists can be created using numbers followed by a `.` character. Only the first number matters, the rest can be anything (but it is not recommended for readability).

```markdown
1. Item 1
2. Item 2
3. Item 3
5. Still item 4
0. Still item 5
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

Images can be added using the same syntax as links, but with a `!` character in front of the link. The text field will be used as the alt text.

```markdown
![](https://picsum.photos/720?image=3)

![This is the alternate text](https://picsum.photos/720?image=3)
```

#### Tables

Tables can be created using the `|` character to separate columns and `-` characters to separate the header from the content. The header is optional. The text alignment can be specified using `:` characters.

```markdown
| Header 1 | Header 2 | Header 3 |
| -------- | :------: | -------: |
| Cell 1   | Cell 2   | Cell 3   |
| Cell 4   | Cell 5   | Cell 6   |
```

#### HTML

HTML can be used in Markdown files. This allows to create more complex documents. It is also possible to use CSS to style the document. This is not covered in this course and I would not recommend it as the goal of Markdown is to be simple.

If you have a look at the source code of this document (the Markdown version on GitHub), you will see that it is written in Markdown and that it uses HTML to create the slides with the help of [Marp](https://marp.app/).

#### Specifications

Markdown is not a standard, but there are many implementations. The most popular one is [CommonMark](https://commonmark.org/). GitHub uses a slightly different version called [GitHub Flavored Markdown](https://github.github.com/gfm/).

Some projects use custom extensions to add more features to Markdown. For example:

- [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) uses custom extensions to add more features to Markdown.
- [Marp](https://marp.app/) uses a custom syntax to manage background images in slides.

#### "Hacky" tips

You can use HTML comments to hide content from the Markdown parser. The same can be achieved using a link-reference.

```markdown
<!-- This is a comment -->

[This is a comment]: #
```

---

New lines can be added using a backspace between two lines or by using a backslash at the end of a line.

```markdown
A line\
Another line

A·line··
Another·line
```

#### Summary

- Markdown is easy to learn
- Markdown can be used to create README files
- Markdown can be used to create documentation
- Markdown can be used to create simple web pages
- Markdown can be used to create slides
- Markdown can be exported to many formats

#### Alternatives

- [reStructuredText](https://docutils.sourceforge.io/rst.html)
- [AsciiDoc](https://asciidoc.org/)
- [Textile](https://textile-lang.com/)
- [LaTeX](https://www.latex-project.org/)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

#### Resources

- [Markdown Guide](https://www.markdownguide.org/)
- [Complete list of GitHub Markdown emoji markup](https://gist.github.com/rxaviers/7360908)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

## Practical content

<!-- _class: lead -->

### What you will achieve

- [Configure your GitHub account professionally](#configure-your-github-account-professionally)
- [Create your own GitHub profile README](#create-your-own-github-profile-readme)
- [Add yourself to the list of students in the GitHub organization](#add-yourself-to-the-list-of-students-in-the-github-organization)

![bg right vertical](https://fakeimg.pl/800x600/0288d1/fff/?text=A)
![bg](https://fakeimg.pl/800x600/02669d/fff/?text=B)
![bg](https://fakeimg.pl/800x600/67b8e3/fff/?text=C)

### Configure your GitHub account professionally

<!-- _class: lead -->

#### Install Git

Check if your operating system package manager has Git available so you can install it from there (`apt` with Debian/Ubuntu, `brew` for [Brew](https://brew.sh/) or `choco` for [Chocolatey](https://chocolatey.org/) for example)! If not, you can download it and install it manually from the official website.

1. Go to <https://git-scm.com/downloads>
2. Download and install Git
3. Open a terminal and type `git --version`

The output should be similar to this: `git version 2.41.0`

#### Create a SSH key

In this section, you will create a SSH key to authenticate to GitHub. If you already have one, you can skip this section. You must have `ssh-keygen` installed on your system.

An SSH key is a pair of keys: a public key and a private key. The public key is used to authenticate to a server, and the private key is used to sign the authentication request.

It is required to use the SSH key authentication method to authenticate to GitHub. It is more secure than using a password.

---

1. Open a terminal
2. Type `ssh-keygen -t ed25519 -C ""`
3. Press enter to use the default location
4. Enter a passphrase (optional)
5. Type `eval "$(ssh-agent -s)"`
6. Type `ssh-add ~/.ssh/id_ed25519`
7. Type `cat ~/.ssh/id_ed25519.pub`

:warning: **Never share your private key with anyone!** It must be kept secret and confidential, just like a password.

#### Create your GitHub account

If you do not have a GitHub account yet, you will need to create one.

1. Go to <https://github.com>
2. Create your account
3. Verify your email address

#### Set up your GitHub account

In this section, you will set up your GitHub account.

1. Go to 
2. Add the public SSH key
3. Add a profile picture (optional)
4. Enable two-factor authentication (optional, but highly recommended)


### Create your own GitHub profile README

<!-- _class: lead -->

#### Create a new repository

In this section, you will create a new special repository to set your GitHub profile. This repository is named `.github`. If you already have it, you can skip this section.

#### Clone the repository locally


#### Fill your profile

Fill a new file named `profile/README.md` file. This file will be used by GitHub to set your profile.

#### Commit your changes

Commit your changes and push them to the repository.

#### Push your changes

Push your changes to the repository.

#### Check the results


#### Share your profile in GitHub Discussions

This will notify us that you have completed the exercise.

GitHub Discussions - show and tell

#### Summary


### Add yourself to the list of students in the GitHub organization

<!-- _class: lead -->

#### Fork the repository

#### Clone the repository locally

#### Create a new branch

#### Add yourself to the list

#### Commit your changes

#### Intentionally create a conflict

#### Resolve the conflict

#### Push your changes

#### Create a pull request

#### Wait for review

#### Make changes if needed

#### Check the results

#### Summary

### Go further

This is an optional section. You can do it if you have time left. I encourage you to do it nonetheless to learn more about Git and GitHub!

- Go in the GitHub Discussions, check the others profiles and give them a star!
- Follow your classmates!
- Follow other GitHub users! Can you think of an open source project you like? Follow these projects and/or maintainers!

## Conclusion

<!-- _class: lead -->

### What did you do?


### What did you learn? (questions)

At this point, you should be able to answer the following questions:

- What is Git?
- What is GitHub?
- What is Markdown?
- What is a repository?

### What did you learn? (answers)

> Q: What is Git?  
> A: Git is a distributed version control system.

> Q: What is GitHub?  
> A: GitHub is a Git repository hosting service.

## What will you do next?

In the next session, you will learn the following topics:

- TODO

## Feedback

Please take a few minutes to give us some feedback about this session. It will help us to improve it for the next one!

[GitHub Discussions - Git, GitHub and Markdown - Feedback](https://github.com/orgs/heig-vd-dai-course/discussions/1)

We are interested to see if the session was too theoretical / too practical, too slow / too fast, too easy / too difficult, not enough time / too much time, useful / not useful, etc.

You can use reactions to express your opinion on a comment.

## Sources

- Illustration by [Roman Synkevych](https://unsplash.com/@synkevych) on [Unsplash](https://unsplash.com/photos/wX2L8L-fGeA)
