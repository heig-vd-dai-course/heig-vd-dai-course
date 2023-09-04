# Contributing to HEIG-VD DAI Course

- [Git](https://git-scm.com/) must be installed.
- [Node.js](https://nodejs.org/en/) must be installed in order to run
  [Prettier](https://prettier.io/).
- [Visual Studio Code](https://code.visualstudio.com/) must be installed with
  the following extensions:
  - [Marp for VS Code](https://marketplace.visualstudio.com/items?itemName=marp-team.marp-vscode)
  - [Markdown All in One](https://marketplace.visualstudio.com/items?itemName=yzhang.markdown-all-in-one)
  - [markdownlint](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint)

1. Clone or fork the GitHub repository and open it in Visual Studio Code.
2. Open the Markdown files in Visual Studio Code and press
   <kbd>Ctrl</kbd>+<kbd>Shift</kbd>+<kbd>V</kbd> to preview the files. If the
   Markdown file is a Marp presentation, it will display a preview of the
   slides. If the Markdown file is a README, it will display a preview of the
   README.
3. Edit the Markdown files and commit your changes.
   - Ensure to format the Markdown files with Prettier before committing your
     changes with the help of the
     `npx prettier **/*.md --write --print-width 80 --prose-wrap always`
     command.
4. Push and open a pull request.
5. Wait for the pull request to be reviewed and merged.
