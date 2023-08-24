[markdown]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/03-git-github-and-markdown/PRACTICAL_CONTENT.md
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/03-git-github-and-markdown/03-git-github-and-markdown-practical-content.pdf

# Git, GitHub and Markdown - Practical content

<https://github.com/heig-vd-dai-course>

[Markdown][markdown] | [PDF][pdf]

L. Delafontaine and H. Louis, with the help of Copilot

## Table of contents

- [Install Git](#install-git)
- [Create and your GitHub account](#create-and-configure-your-github-account)
- [Create your own GitHub profile README](#create-your-own-github-profile-readme)
- [Add yourself to the list of students in the GitHub organization](#add-yourself-to-the-list-of-students-in-the-github-organization)

## Install Git

Check if your operating system package manager has Git available so you can
install it from there (`apt` with Debian/Ubuntu, `brew` for
[Brew](https://brew.sh/) or `choco` for [Chocolatey](https://chocolatey.org/)
for example)! If not, you can download it and install it manually from the
official website.

1. Go to <https://git-scm.com/downloads>
2. Download and install Git
3. Open a terminal and type `git --version`

The output should be similar to this: `git version 2.41.0`

## Create and configure your GitHub account

### Create your GitHub account

If you do not have a GitHub account yet, you will need to create one.

1. Go to <https://github.com>
2. Create your account
3. Verify your email address

### Create a SSH key

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

:warning: **Never share your private key with anyone!** It must be kept secret
and confidential, just like a password.

### Set up your GitHub account

In this section, you will set up your GitHub account.

1. Go to
2. Add the public SSH key
3. Add a profile picture (optional)
4. Enable two-factor authentication (optional, but highly recommended)

## Create your own GitHub profile README

### Create a new repository

In this section, you will create a new special repository to set your GitHub
profile. This repository is named `.github`. If you already have it, you can
skip this section.

### Clone the repository locally

### Fill your profile

Fill a new file named `profile/README.md` file. This file will be used by GitHub
to set your profile.

### Commit your changes

Commit your changes and push them to the repository.

### Push your changes

Push your changes to the repository.

### Check the results

### Share your profile in GitHub Discussions

This will notify us that you have completed the exercise.

GitHub Discussions - show and tell

### Summary

## Add yourself to the list of students in the GitHub organization

### Fork the repository

### Clone the repository locally

### Create a new branch

### Add yourself to the list

### Commit your changes

### Intentionally create a conflict

### Resolve the conflict

### Push your changes

### Create a pull request

### Wait for review

### Make changes if needed

### Check the results

### Summary

## Go further

This is an optional section. You can do it if you have time left. We encourage
you to do it nonetheless to learn more about Git and GitHub!

- Go in the GitHub Discussions, check the others profiles and give them a star!
- Follow your classmates!
- Follow other GitHub users! Can you think of an open source project you like?
  Follow these projects and/or maintainers!
