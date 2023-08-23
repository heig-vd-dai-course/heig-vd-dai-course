---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of Copilot
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
        hyphens: auto;
    }
headingDivider: 4
-->

[markdown]: https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/02-git-github-and-markdown/README.md
[web]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-git-github-and-markdown/
[pdf]: https://heig-vd-dai-course.github.io/heig-vd-dai-course/02-git-github-and-markdown/02-git-github-and-markdown.pdf
[video]: #
[feedback]: https://github.com/orgs/heig-vd-dai-course/discussions/1

# Git, GitHub and Markdown

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] | [Web][web] | [PDF][pdf]<!-- | [Video (in French)][video]--> | [Feedback][feedback]

<small>L. Delafontaine and H. Louis, with the help of Copilot</small>

<small>Based on the original course by O. Liechti and J. Ehrensberger</small>

![bg opacity:0.1](https://images.unsplash.com/photo-1618401471353-b98afee0b2eb?fit=crop&h=720&q=80)

## Table of contents

- **[Theoretical content](#theoretical-content)**
    - [Git](#git)
    - [GitHub](#github)
    - [Markdown](#markdown)
- **[Practical content](#practical-content)**
    - [What will you do?](#what-will-you-do)
    - [Find the practical content](#find-the-practical-content)

## Theoretical content

<!-- _class: lead -->

### Git

> [Git](https://git-scm.com/) is a free and open source distributed version control system (VCS) designed to handle everything from small to very large projects with speed and efficiency.

![bg right:40% w:75%](https://git-scm.com/images/logos/logomark-orange@2x.png)

---

Created by Linus Torvalds in 2005 to manage the Linux kernel source code, Git allows to track changes in any set of files, usually used for coordinating work among programmers collaboratively developing source code during software development.

Git is a client-server system, where the server is called a **repository** and the clients are called **clones**.

![bg right:40% w:75%](https://imgs.xkcd.com/comics/git.png)

---

 The repository is the single source of truth, and the clones are the local copies of the repository.

Git is a **distributed** VCS, which means that each clone is a full copy of the repository. This allows to work offline, and to have multiple backups of the repository.

Git uses **commits** to track changes. A commit is a snapshot of the repository at a given time. Each commit has a unique identifier, called a **hash**. The hash is computed from the content of the commit, so it is impossible to modify a commit without changing its hash.

---

Git uses **branches** to track different versions of the repository. The default branch is often called `main` (the legacy name was `master`).

Each branch has a name and a pointer to a commit. The pointer is called a **head**. The head of the main branch is called `HEAD`.

![bg right:40% contain](https://wac-cdn.atlassian.com/dam/jcr:bb02240a-7d85-4f5a-ae7f-c2727b37fc79/01%20Many%20ways%20of%20referring%20to%20a%20commit.svg?cdnVersion=1162)

---

Commits can be **tagged** to create a reference to a commit. This is often used to mark a commit as a release.

Commits can be **signed** to prove that the commit was made by a specific person. This is done for security reasons.

Often, when implementing a new feature, a new branch is created. This is done by creating a new branch from the main branch. The new branch is called a **feature branch**. The main branch is called the **target branch**.

---

Once you made all the changes, the modified files are **staged** and a new commit is created. The commit is then **pushed** to the repository.

Changes can be compared to see the **differences** between the staged files and the working directory. This is done by comparing the files with the last commit.

Changes can be **pulled** from the repository into the current branch.

TODO

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

---

**Hooks** can be used to run scripts before or after certain actions. For example, a pre-commit hook can be used to run tests before committing changes.

The most important Git Hooks are the following:

- `pre-commit`: run before committing changes
- `post-commit`: run after committing changes
- `pre-push`: run before pushing changes
- `post-push`: run after pushing changes
- `post-merge`: run after merging changes

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

- [Atlassian Git tutorials - Beginner](https://www.atlassian.com/git/tutorials/what-is-version-control) - Atlassian tutorials are really good!
- [Atlassian Git tutorials - Getting started](https://www.atlassian.com/git/tutorials/setting-up-a-repository)
- [Atlassian Git tutorials - Collaborating](https://www.atlassian.com/git/tutorials/syncing)
- [Atlassian Git tutorials - Advanced Tips](https://www.atlassian.com/git/tutorials/advanced-overview)
- [Learn Git Branching](https://learngitbranching.js.org/)
- [Git Hooks](https://git-scm.com/book/en/v2/Customizing-Git-Git-Hooks)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

### GitHub

> [GitHub](https://github.com) is a platform and cloud-based service for software development and version control using Git, allowing developers to store and manage their code.

![bg right:40% w:75%](https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png)

---

GitHub is a web-based Git repository hosting service. It provides all the features of Git, plus some additional features.

It is the most popular Git repository hosting service, with more than 65 million repositories, a home for many open source projects and a place where many companies host their private repositories.

GitHub is a **social** platform. It allows to **follow** other users and to **star** repositories. It also allows to **fork** repositories, which means to create a copy of a repository in your own account.

---

GitHub also provides a **wiki** for each repository, a **project board** to manage tasks, an **issue tracker** to report bugs and a **pull request** system to review and merge changes.

Not all these features are needed for all projects, but they are available if needed.

Repositories can be owned by a **user** or by an **organization**.

Contributing to a project hosted on GitHub is done by **forking** the repository, making changes and opening a **pull request** to merge the changes back into the original repository.

---

Forking is only needed if you are not a member of the repository or organization.

Once a branch is ready to be merged into the target branch, it is good practice to open a **pull request** (or a **merge request** on GitLab). A pull request is a request to merge a branch into another. It is a way to discuss the changes before merging them.

Reviewing a pull request is done by **commenting** on the changes. The reviewer can ask for changes to be made before merging the branch or can approve the changes.

---

Once the pull request is approved, the branch can be **merged** into the target branch.

By default, GitHub does not delete the branch once it is merged. You might want to enable this by default in your repository settings or delete it manually. It avoids to cumulate out-dated branches in your repository.

#### Summary

The whole process would be as follow:

1. Clone or fork the project
2. Checkout to a new branch
3. Make your changes, commit and push them as often as you want
4. Create the pull request
5. The maintainers review and merge if OK
6. You can delete the branch or the fork

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

Images can be added using the same syntax as links, but with a `!` character in front of the link. The text field will be used as the alt text for accessibility and SEO. An optional title can be set with `""` characters.

```markdown
![](https://my-website.com/assets/logo.png)

![A landscape of the Alps](./images/alps.jpeg)

![A schema describing the Git workflow](./images/schema.svg "Git workflow")
```

#### Tables

Tables can be created using the `|` character to separate columns and `-` characters to separate the header from the content. The header is optional. The text alignment can be specified using `:` characters.

```markdown
| Header 1 | Header 2 | Header 3 |
| -------- | :------: | -------: |
| Cell 1   |  Cell 2  |   Cell 3 |
| Cell 4   |  Cell 5  |   Cell 6 |
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

- Markdown is easy to learn and use
- Markdown can be used to create documentation
- Markdown can be used to create slides
- Markdown can be exported to many formats
    - The theoretical content of this course is exported to Web and PDF with the help of [Marp](https://marp.app/)
    - The practical content of this course is exported to PDF with the help of [Pandoc](https://pandoc.org/)

#### Alternatives

- [reStructuredText](https://docutils.sourceforge.io/rst.html)
- [AsciiDoc](https://asciidoc.org/)
- [Textile](https://textile-lang.com/)
- [LaTeX](https://www.latex-project.org/) - You might want to consider this if you need to write a scientific paper and/or your bachelor/master thesis as it is the standard in the scientific community and much more powerful than Markdown.

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

#### Resources

- [Markdown Guide](https://www.markdownguide.org/)

_Missing item in the list? Feel free to open a pull request to add it! :sparkles:_

## Practical content

<!-- _class: lead -->

### What will you do?

- Install Git
- Create and configure your GitHub account
- Create your own GitHub profile README
- Add yourself to the list of students in the GitHub organization

![bg vertical right](https://fakeimg.pl/800x600/0288d1/fff/?text=A)
![bg](https://fakeimg.pl/800x600/02669d/fff/?text=B)
![bg](https://fakeimg.pl/800x600/67b8e3/fff/?text=C)

### Find the practical content

<!-- _class: lead -->

You can find the practical content for this session on [GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/02-git-github-and-markdown/PRACTICAL_CONTENT.md).

## Conclusion

<!-- _class: lead -->

### What did you do and learn?

In this session, you installed and configured Git properly. You also created your own GitHub account and profile README for your future social profile as a computer scientist engineer.

Finally, you added yourself to the list of students in the GitHub organization using the issue, fork and pull request workflow, enabling you to contribute to open source projects in the future.

Git is a valuable tool for collaborative work but we only scratched the surface. Refer to the resources for more useful content.

### Test your knowledge

At this point, you should be able to answer the following questions:

- How does Git work?
- What is the difference between Git and GitHub?
- How is Markdown different from Word?
- What is a repository? What is a clone?
- What is a tag? What is the difference with a commit?
- Describe a typical Git workflow.

## What will you do next?

In the next session, you will learn the following topics:

- Java
- IntelliJ IDEA
- Maven

## Feedback

Please take a few minutes to give us some feedback about this session. It will help us to improve it for the next one!

[GitHub Discussions - Feedback][feedback]

We are interested to see if the session was too theoretical / too practical, too slow / too fast, too easy / too difficult, not enough time / too much time, useful / not useful, etc.

You can use reactions to express your opinion on a comment.

## Sources

- Main illustration by [Roman Synkevych](https://unsplash.com/@synkevych) on [Unsplash](https://unsplash.com/photos/wX2L8L-fGeA)
