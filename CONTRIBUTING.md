# Contributing to the HEIG-VD DAI Course repository

- [Docker](https://www.docker.com/) with its
  [Docker Compose](https://docs.docker.com/compose/) plugin must be installed.
- [Git](https://git-scm.com/) must be installed.
- [Visual Studio Code](https://code.visualstudio.com/)

1. Clone or fork the GitHub repository.
2. Open the project in Visual Studio Code.
3. Visual Studio Code should prompt you to install the recommended extension
   ([Visual Studio Code Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)).
   Install it. Other extensions will be installed automatically when you open
   the project in a Development Container.
4. Press `Ctrl`+`Shift`+`P` to open the command palette and run the
   `Dev Containers: Reopen in Container` command.
5. Visual Studio Code will build the Docker image and open the project in a
   container with all the required tools installed (extensions and packages).
6. Open the Markdown files in Visual Studio Code and press `Ctrl`+`Shift`+`V` to
   preview the files.
7. You are now ready to edit the Markdown files and commit your changes.

## Making changes to the Git repository

1. Open an issue describing the changes you want to make.
2. Clone/fork the GitHub repository.
3. Create a new branch with the name of the issue you want to fix.
4. Open the project in a container with the help of Visual Studio Code as
   described above.
5. Edit the files and commit your changes.
   - Ensure to format the Markdown files with Prettier before committing your
     changes with the help of the
     `npx prettier **/*.md --write --print-width 80 --prose-wrap always`
     command.
   - Ensure all local images are optimized:
     - PNGs with the help of the `optipng **/**/*.png` command.
     - JPGs with the help of the `jpegoptim -s --all-progressive **/**/*.jpg`
       command.
     - PDFs with the help of the `ps2pdf <input>.pdf <output>.pdf` command.
6. Push and open a pull request.
7. Wait for the pull request to be reviewed and merged.

## PlantUML local server

To generate diagrams, you can use the [PlantUML](https://plantuml.com/) local
server.

A local server is automatically available when using the Development Container
at the following address: <http://localhost:9090/>.

## Taking screenshots

All window screenshots are taken with the `Screenshot.app` tool from Apple. You
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
