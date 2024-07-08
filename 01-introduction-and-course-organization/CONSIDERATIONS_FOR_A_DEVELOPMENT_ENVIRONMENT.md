# Considerations for a development environment

Here are some considerations to take into account when setting up your
development environment.

This list is not exhaustive and you may have other preferences. Feel free to
adapt it to your needs. However, these are some good practices that can help you
to be more productive and encouter less issues.

## Do not store your projets' sources on a cloud provider

We highly recommend to **never store your projects' sources your files on
OneDrive/Google Drive/Dropbox/etc.**. When you start to develop professionally,
your IDE and tools can generate a large amount of temporary files (cache files,
logs, compiled files, etc.). These files are often small but numerous and can be
generated every time you compile your project. As these cloud services will try
to keep up to synchronize these files, it can quickly use all your computer's
resources and can slow down your computer/develoment environment. As Git is
meant to store your sources (it is meant for this),
**[use Git to synchronize your sources between your computer and the cloud](#use-git-to-synchronize-your-sources-between-your-computer-and-the-cloud)**.

## Use Git to synchronize your sources between your computer and the cloud

As mentioned in the previous point, Git is meant to store your sources. It is a
version control system that will allow you to keep track of your changes,
collaborate with others, and synchronize your sources between your computer and
the cloud. You can use GitHub, GitLab, or Bitbucket to store your Git
repositories. We will cover Git and GitHub in the course.

## Take some time to organize your files on your computer

Managing files on your computer seems trivial but it is so simple to lose time
just because your files are not organized.

There is nothing more frustrating than not being able to find what you are
looking for just because your files does not have any structure.

Take some time to organize your files in a way that makes sense to you. Here is
one proposition:

```text
/home/USERNAME
├── heig-vd
│   └── dai
│       ├── course-material
│       │   ├── 01-introduction-and-course-organization
│       │   ├── 02-introduction-to-part-1
│       │   └── ...
│       └── practical-works
│           ├── practical-work-1
│           ├── practical-work-2
│           └── ...
└── ...
```

For a more advanced organization, you can check out the
[Johnny•Decimal](https://johnnydecimal.com/) method.

## Always open your project from your IDE

Do not open each file individually from the File Explorer.

Open your project from your IDE and navigate through your files from there. You
will have everything you need in one place and you will be able to use the full
potential of your IDE.

Modern IDEs are powerful tools that can help you to be more productive. Take
some time to learn how to use your IDE to its full potential to save time and be
more efficient.
