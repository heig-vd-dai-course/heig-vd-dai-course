# Material for the teaching staff

## Before the course

- Review the slides and the course sequence
- Create a new planning in the course project
- Send an email to all students to remind them of the course with:
  - A link to this GitHub organization
  - When and where the course will take place

### Email sent for the 2023-2024 academic year

```text
[DAI] Informations générales sur le cours

Bonjour tout le monde,

J'espère que vous avez passé un bel été et que vous vous sentez prêt-e-s pour cette nouvelle année qui va commencer.

Je serai votre professeur pour le cours Développement d'applications internet (DAI) et Hadrien Louis (en copie) sera l'assistant de ce cours. Nous nous réjouissons de vous retrouver mardi pour la première leçon.

Le cours aura lieu les mardis de 13:15 à 14:45 en salle B01a et de 16:35 à 18:05 en salle A05a.

Vous trouverez toutes les informations sur le cours dans cette organisation GitHub : https://github.com/heig-vd-dai-course.

Pour les personnes curieuses qui souhaiteraient déjà explorer le contenu du cours, ne soyez pas surprises si certaines parties ne sont pas complètes ; nous sommes en train de finaliser le cours avec sa nouvelle structure.

Pour les personnes sous Windows, je vous recommande vivement d'installer et configurer Windows Subsystem for Linux (WSL 2) ou GitBash pour suivre ce cours. L'un ou l'autre de ces outils sera utile pour certaines parties du cours et vous rencontrerez moins de soucis. Vous pouvez suivre le tutoriel suivant pour installer et configurer WSL 2 : https://learn.microsoft.com/en-us/windows/wsl/install ou GitBash: https://gitforwindows.org/.

Je vous souhaite une bonne fin d'après-midi et à bientôt,
Ludovic Delafontaine
```

## During the course

- Give the course
- Actively participate in the course
- Identify the students that are struggling
- Help the students
- Take notes of the questions asked by the students
- Review feedbacks from the students
- Improve the course material from the questions and feedbacks

## After the course

- Create Git tags to archive the course material for the given year
  - For the `heig-vd-dai-course` repository - this will create a release with
    the PDFs of the slides
  - For the `.github` repository
- Lock and archive all GitHub Discussions for the given year
- Lock and archive the planning in the course project for the given year
- Remove the students from `.github` repository for a clean start next year
- Move all members of the organization to the `@old-members` team
- Send an email to all students to thank them for their participation with:
  - A link to both Git tags for a future reference

## Tips

### Taking screenshots

All window screenshots are taken with the `Screenshop.app` tool from Apple. You
can open it with the `Command + Shift + 5` shortcut. **Show floating thumbnail**
is enabled in the options.

All application windows are of the same size (888x888) and are placed at the
same position on the screen of the Mac Book Pro.

To set a specific application to a specific size and position, you can use the
following AppleScript:

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

Screenshots made within the browser are made with Safari. As I (Ludovic) do not
use Safari as my main browser, it is perfect for screenshots as it does not
contain any personal information and/or bookmarks and extensions.
