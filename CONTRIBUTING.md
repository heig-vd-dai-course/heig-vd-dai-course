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
2. Open the Markdown files in Visual Studio Code and press `Ctrl`+`Shift`+`V` to
   preview the files. If the Markdown file is a Marp presentation, it will
   display a preview of the slides. If the Markdown file is a README, it will
   display a preview of the README.
3. Edit the Markdown files and commit your changes.
   - Ensure to format the Markdown files with Prettier before committing your
     changes with the help of the
     `npx prettier **/*.md --write --print-width 80 --prose-wrap always`
     command.
   - Ensure all local images are optimized with the help of the `optipng *.png`
     command.
4. Push and open a pull request.
5. Wait for the pull request to be reviewed and merged.

## Taking screenshots

All window screenshots are taken with the `Screenshop.app` tool from Apple. You
can open it with the `Command + Shift + 5` shortcut. **Show floating thumbnail**
is enabled in the options.

All application windows are of the same size (888x888) and are placed on the
screen of the Mac Book Pro.

### Safari

To set Safari to a specific size and position, you can use the following
AppleScript:

```applescript
set theApp to "Safari"
set appPosition to {-1445, 98}
set appSize to {888, 888}

tell application "System Events" to tell application process theApp
	tell window 1
		set position to appPosition
		set size to appSize
	end tell
end tell

```

As I (Ludovic) do not use Safari as my main browser, it is perfect for
screenshots as it does not contain any personal information and/or bookmarks and
extensions.

### Terminal

To set Terminal to a specific size and position, you can use the following
AppleScript:

```applescript
set theApp to "Terminal"
set appPosition to {-1445, 98}
set appSize to {888, 888}

tell application "System Events" to tell application process theApp
	tell window 1
		set position to appPosition
		set size to appSize
	end tell
end tell
```
