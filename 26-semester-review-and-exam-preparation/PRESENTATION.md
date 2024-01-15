---
marp: true
---

<!--
theme: gaia
size: 16:9
paginate: true
author: L. Delafontaine and H. Louis, with the help of ChatGPT
title: HEIG-VD DAI Course - Semester review and exam preparation
description: Semester review and exam preparation for the DAI course at HEIG-VD, Switzerland
url: https://heig-vd-dai-course.github.io/heig-vd-dai-course/26-semester-review-and-exam-preparation/
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

[web]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/26-semester-review-and-exam-preparation/
[pdf]:
  https://heig-vd-dai-course.github.io/heig-vd-dai-course/26-semester-review-and-exam-preparation/26-semester-review-and-exam-preparation-presentation.pdf
[license]:
  https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/LICENSE.md
[illustration]:
  https://images.unsplash.com/photo-1604134967494-8a9ed3adea0d?fit=crop&h=720

# Semester review and exam preparation

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-dai-course>

[Web][web] · [PDF][pdf]

<small>L. Delafontaine and H. Louis, with the help of ChatGPT.</small>

<small>This work is licensed under the [CC BY-SA 4.0][license] license.</small>

![bg opacity:0.1][illustration]

## Semester review

<!-- _class: lead -->

You made it! Congratulations! 🎉

### Retrospective

<!-- _class: lead -->

Let's have a look back on what **you** did during this semester.

---

> You will learn the following topics during this course:
>
> - Network programming (inputs/outputs, encodings, TCP and UDP)
> - Application-level protocols (SMTP, SSH, HTTP and your own)
> - Web infrastructures (reverse proxy, load balancer, sticky sessions)
> - How to read and write technical documentation
>
> At the end of the course, you will be able to create applications that can
> communicate over the network!

---

> You will learn the following technologies during this course:
>
> - Git and GitHub
> - Markdown
> - Java for network programming
> - Docker & Docker Compose
> - Network utilities
> - The terminal :heart:

![bg right:40%](https://images.unsplash.com/photo-1530124566582-a618bc2615dc?fit=crop&h=720)

### Git, GitHub and Markdown

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/03-git-github-and-markdown/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1618401471353-b98afee0b2eb?fit=crop&h=720)

#### Key points to remember for this chapter

0. Set up your Git environment with SSH and signed commits
1. Open an issue (written with Markdown) to discuss the feature
2. Clone or fork the project with SSH and checkout to a new branch
3. Make your changes, commit and push them as often as you want
4. Resolve conflicts if any
5. Create or update the pull request and add details if needed
6. Other members review and approve if everything is OK
7. The work is merged and you can delete the branch or the fork

#### Elements to improve for next year

- For people on Windows, create a document to help set up a proper and working
  environment (WSL2, Git, Java, Maven, SDKMAN!, etc.)
- Add more information about SSH and signed commits maybe?

### Java, IntelliJ IDEA and Maven

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/04-java-intellij-idea-and-maven/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1497935586351-b67a49e012bf?fit=crop&h=720)

#### Key points to remember for this chapter

- Java and the JVM
- Maven as a build tool
  - `pom.xml` file
  - Plugins vs. dependencies
- Sharing code with Git and GitHub
  - `.gitignore` files
  - IntelliJ IDEA (and IDEs in general) configuration files
- Managing multiple versions of Java/dependencies with SDKMAN!

#### Elements to improve for next year

- Make usage of picocli with a concret example (introduction to picocli and its
  documentation) instead of Logback
- Make usage of
  [Spotless](https://github.com/diffplug/spotless/tree/main/plugin-maven) to
  format the code for uniformity
- For people on Windows, create a document to help set up a proper and working
  environment (WSL2, Git, Java, Maven, SDKMAN!, etc.)
- Introduction to unit testing with JUnit5 maybe?

### Java IOs

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/05-java-ios/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1549319114-d67887c51aed?fit=crop&h=720)

#### Key points to remember for this chapter

- Java IOs classes and use cases (text files vs. binary files)
- Those 🤬 charset encodings (Unicode vs. UTF-8, other charsets)
- Buffering and flushing
- End of line characters (`\n`, `\r`, `\r\n`, etc.)
- Dealing with exceptions (try-with-resources, etc.)

You **should always specify encodings and end of line characters explicitly** as
the defaults are dependent on the platform your code is running on. Marking them
explicitly will make your code **portable**.

#### Elements to improve for next year

- Add disclaimer about the `PrintWriter` class - it is not recommended to use it
  as it swallows exceptions and does not throw them

### Practical work 1

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/06-practical-work-1/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1583736902935-6b52b2b2359e?fit=crop&h=720)

#### What you were ask to do

- A CLI to process files
- Use Java, Maven and [picocli](https://picocli.info/)
- You can choose what the CLI will do
- Publish your CLI on GitHub

We have seen some very interesting projects! All of you were very creative!
Caesar cipher, image processing, JSON-XML convertor, etc.

#### Elements to improve for next year

- Nothing much to improve in my opinion. Do you agree?

### Define an application protocol

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/09-define-an-application-protocol/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1521587760476-6c12a4b040da?fit=crop&h=720)

#### Key points to remember for this chapter

Defining an application protocol is **not an easy task**. There are many ways to
do it, and there is no "one size fits all" solution. You should always keep in
mind the following points:

1. Context - What the application protocol is used for?
2. Transport - What protocol(s) is/are involved? On which port(s)? How are
   messages/actions encoded? How are messages/actions delimited? How are
   messages/actions treated? Who initiates/closes the communication? What
   happens on an unknown message/action/exception?

---

3. Messages/actions - What are the messages/actions? What are the parameters?
   What are the return values? What are the exceptions? - Always try to describe
   these **for a given context**, not from each point of view (e.g. "_making an
   order_" with the input/outputs from the client to the server and the
   responses instead of "_the client sends these messages and the server replies
   these messages with these outputs_"). It makes it _way_ easier to understand
   and to implement.
4. Example diagrams - What are the examples of messages/actions? What are the
   examples of exceptions? Illustrate your application protocol with diagrams
   (UML, sequence, etc.) to make it easier to understand.

#### Elements to improve for next year

- Remove the exploration in details of known protocols (SMTP, POP3, IMAP, SSH,
  etc.) and focus on the definition of an application protocol
- Add more examples of application protocols (e.g. a protocol to order a pizza,
  a protocol to play a game, etc.)
- Add more examples of diagrams

This was a **very** difficult chapter to teach. I hope you understood the
importance of defining an application protocol and how to do it. If you can, use
an existing protocol instead of defining your own.

### Docker and Docker Compose

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/10-docker-and-docker-compose/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1511578194003-00c80e42dc9b?fit=crop&h=720)

#### Key points to remember for this chapter

- Bare-metal vs. virtualization vs. containerization
- Docker as a containerization tool
  - Images
  - Containers
  - Registries
  - Dockerfile files
- Docker Compose as a tool to manage multiple containers
  - Docker Compose files

#### Elements to improve for next year

- Move this chapter after the Java TCP programming chapter
- More details on each line of the Dockerfile and Docker Compose file maybe?
- Use more concrete examples instead of a generic Alpine image with greetings,
  `tree` command with volumes and File Browser as a web application with ports
  maybe? It is hard to think of a good example that is not too complex to
  understand and not too simple to be useless.

### SMTP and Telnet

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/11-smtp-and-telnet/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1526554850534-7c78330d5f90?fit=crop&h=720)

#### Key points to remember for this chapter

- Differences between SMTP, POP3 and IMAP
- SMTP security concerns
- How is an email sent and received from one client to another through multiple
  SMTP servers
- Using a SMTP mock server to test your application

#### Elements to improve for next year

- Move this chapter after the Java TCP programming chapter
- Make usage of [ncat](https://nmap.org/ncat/) (part of
  [nmap](https://nmap.org/)) instead of Telnet - Rename the chapter to "SMTP and
  ncat"

### SSH and SCP

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/12-ssh-and-scp/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1506818144585-74b29c980d4b?fit=crop&h=720)

#### Key points to remember for this chapter

This chapter will **not** be in the exam! The other classes did not study this
topic.

- SSH keys and how to connect to a remote server
- SCP and how to copy files to a remote server

#### Elements to improve for next year

- Maybe this chapter is too abstract at the time of the semester? Maybe it
  should be moved to the end of the semester? With the web infrastructures
  chapter?

### Java TCP programming

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/13-java-tcp-programming/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1554960750-9468c5d9e239?fit=crop&h=720)

#### Key points to remember for this chapter

- TCP as a reliable protocol
- `Socket` and `ServerSocket` classes
- Get streams from sockets (deal as with files - buffering, flushing, charsets,
  end of line characters, exceptions handling, etc.)

#### Elements to improve for next year

- Move this chapter right after the Define an application protocol chapter so
  that the practical work can be done in parallel with the next chapters
- Add details/examples on variable-length messages/actions (e.g. `readLine()`
  vs. `read()` with a fixed buffer size)
- Add a proper introduction to concurrency and its issues
- Make an example built from scratch to show how to use the `Socket` and
  `ServerSocket` classes with multiple clients (with `ThreadPool` executor) and
  then show the examples for other implementations

### Practical work 2

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/14-practical-work-2/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1610633389918-7d5b62977dc3?fit=crop&h=720)

#### What you were ask to do

- A TCP network application with its own application protocol
- You can choose what the network application will do
- Groups of two students

We have seen some very interesting projects! All of you were very creative! Chat
applications, hanging man (poor boy...) games, naval battle games, etc.

#### Elements to improve for next year

- Nothing much to improve in my opinion. Do you agree?

### Java UDP programming

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/17-java-udp-programming/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1578054041218-5ee0003926dd?fit=crop&h=720)

#### Key points to remember for this chapter

- Differences between TCP and UDP
- `DatagramSocket`, `DatagramPacket` and `MulticastSocket` classes
- Reliability of UDP
- Unicast, broadcast and multicast
- Messaging patterns
- Service discovery protocols

#### Elements to improve for next year

- Make an example built from scratch to show how to use the `DatagramSocket`,
  `DatagramPacket` and `MulticastSocket` classes with multiple clients (with
  `ThreadPool` executor) and then show the examples for other implementations
- Add example for the request/response pattern with unicast for the practical
  work

This was a **very** difficult chapter to teach. I hope you understood the main
differences between TCP and UDP and how to use UDP.

### Practical work 3

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/18-practical-work-3/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1636357582639-27620e21d7c5?fit=crop&h=720)

#### What you were ask to do

- An UDP network application
- You can choose what the network application will do
- Share your application on GitHub with Docker and Docker Compose
- Groups between 2 and 3 students

We have seen some very interesting projects! All of you were very creative!
Teletext application, multiplayer Pong game, Tower defense game, IoT logging
system, etc.

#### Elements to improve for next year

- Improve the criteria for the evaluation of the practical work (some are too
  vague)

### HTTP and curl

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/21-http-and-curl/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1446770145316-10a05382c470?fit=crop&h=720)

#### Key points to remember for this chapter

- HTTP request methods
- HTTP response status codes
- HTTP path parameters, query parameters and body
- HTTP headers
- HTTP content negotiation
- HTTP sessions (stateless vs. stateful)
  - Using a query parameter or a cookie
- API design

#### Elements to improve for next year

- Nothing much to improve in my opinion. I tried to improve the balance between
  the theoretical/practical content and I think it is quite good now. Do you
  agree?

### Web infrastructures

<!--
_class: lead
_paginate: false
-->

[Find this chapter on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/22-web-infrastructures/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1492515114975-b062d1a270ae?fit=crop&h=720)

#### Key points to remember for this chapter

- Functional and non-functional requirements
- How HTTP features can be used to build web infrastructures:
  - The `Host` header
  - Reverse proxy
  - System scaling
  - Load balancing
  - Caching

#### Elements to improve for next year

- Nothing much to improve in my opinion. I tried to improve the balance between
  the theoretical/practical content and I think it is quite good now. Do you
  agree?

### Practical work 4

<!--
_class: lead
_paginate: false
-->

[Find this practical work on GitHub](https://github.com/heig-vd-dai-course/heig-vd-dai-course/blob/main/23-practical-work-4/README.md)

![bg opacity:0.1](https://images.unsplash.com/photo-1572901334602-f40b66a0c71c?fit=crop&h=720)

#### What you were ask to do

- Get and access a virtual machine on our cloud with SSH
- Install Docker and Docker Compose on the virtual machine
- Develop a simple CRUD API to manage resources
- Deploy the applications (reverse proxy + CRUD API)
- Access the applications from a (free) domain name
- Groups of 4 students

#### Elements to improve for next year

- Nothing much to improve in my opinion. I think it is the perfect practical
  work to close the loop of the course. Do you agree?

### Evaluations

<!--
_class: lead
_paginate: false
-->

![bg opacity:0.1][illustration]

#### Elements to improve for next year

- Most of them were too long (especially the first two)
- Some questions were too specific
- Some questions were not understood by the students, missing the point of the
  question
  - "_Reading/writing an application protocol is boring_"  
    Reading/writing an application protocol is not an easy task but it an
    essential skill to know how to document something that someone else will use
- It was the most painful point, we will try to improve this!

### GAPS evaluation

<!-- _class: lead -->

Let's check these _beautiful_ charts!

<small>You can find all GAPS evaluations
[on the repository](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/26-semester-review-and-exam-preparation).</small>

#### _"J'ai moins apprécié et je propose..."_

> RAS

> Il y a beaucoup trop de rendus/travaux écrits pourquoi ne pas faire des petits
> tests (15-20 minutes) sur ce que l'on appris. par exemple question que l'on
> peut nous poser lors d'un entretien d'embauche sans feuille, un test
> intermédiaire (mini-examen) avec tout et l'examen final.

---

> Les premiers tests ont, à mon goût, était un peu trop short au niveau timing.
> Néanmoins cela s'est déjà amélioré suite à nos retours, merci.

> C'est difficile de savoir quoi réviser pour les tests, ils sont un peu
> difficile et avec peu de temps. (Le test 3 était plus adapté déjà).

> J'ai trouvé les tests théorique trop spécifique, cela ne m'aurait pas dérangé
> si j'avais accès à mes notes mais par exemple de demander un protocole entier
> je ne trouve pas très intéressant, surtout que j'ai passé plusieurs heures sur
> un exercices pour en faire un propre que je ne peux même pas utiliser aux
> tests.

---

> Les examens semblent parfois plus dur et malheureusement, on a du mal à
> s'imaginer de la difficulté en se basant uniquement sur la théorie. Il y a
> tout de même une certain manque de pratique quand il s'agit d'exercices de
> programmation (pas tout le temps, mais occasionnellement). Le nombre d'examens
> est un poil trop grand en plus des nombreux laboratoires. peut-être le baisser
> un tout petit peu soit l'un, soit l'autre.

> Enfin, les évaluations sont longues, et il est parfois difficile de comprendre
> ce qu'il est attendu.

---

> J'ai moins apprécié le nombre de test, 4 c'est trop. 3 aurait été plus
> judicieux. De plus que vous étiez particulièrement strict sur la correction.

> Il est difficiles de savoir sur quoi on va être évalué exactement.

---

> J'aime bien la liberté que vous nous donnez pour le choix des TP mais pour
> certains ça devient un désavantage si l'on voit trop gros. Je pense que c'est
> mieux de donner une consigne de base pour tout le monde et que si l'on désire
> partir dans un autre sujet de venir en discuter avec vous.

> je ne comprends pas trop l'intérêt de la partie orale qui suit un labo, les
> présentations c'est stressant.

> J'ai moins apprécié le rythme du cours, je ne pense pas avoir de difficulté à
> comprendre la matière, mais la quantité de travail à fournir dans les labos
> est trop importante.

---

> J'ai utilisé `ein tool estimate-hours` et `git-hours` pour sortir une
> estimation du temps de travail sur les labos:
>
> - 30h pour le labo1
> - 50h pour le labo2
> - 45h pour le labo3
>
> Ce qui fait déjà 60h/pers. pour les 3 premiers labos. Il reste donc 30h pour
> les 4 tests, le dernier labo et les practial work pour ne pas dépasser les 90h
> de la fiche d'unité.

> Peut être trop de pratique (les labos sont gros)

---

> Les consignes de laboratoires sont ouvertes, et donc les choix de ce qui peut
> être implémenté sont libres. Bien que cela puisse développer notre créativité,
> l'évaluation est établie sur des critères qui correspondent à l'implémentation
> présentée en cours. Cela m'a particulièrement démotivé, car toute possibilité
> de créativité était vraisemblablement mal vue parce que soit trop complexe,
> soit elle ne correspondait pas aux critères.

> La taille des labos, nécessitant beaucoup de temps.

---

> Un gros manque d'accompagnement pour la pratique. Quand vous donnez des codes
> (UDP, Server-client) ce serait intéressant de parcourir ensemble le code et de
> l'expliquer en détail sans y passer des heures.

> Je pense que j'ai besoin pour assimiler la matière de moins de texte, et
> d'avoir peut-être des fois des cours un peu plus guidé. J'ai l'impression
> d'avoir perdu beaucoup de temps à chercher des infos. Néanmoins le cours est
> très intéressant et mérite sa place dans ce cursus.

---

> Aussi, trop peu de temps alloué à chacun des outils. Il serait préférable de
> réduire la quantité d'information à apprendre, afin de comprendre le
> fonctionnement interne de chacun des outils (docker mériterait plus de temps
> pour expliquer son fonctionnement plutot que les détails syntaxiques par
> exemple). Sachant que certains éléments vont être vu en WEB, il serait
> possible d'enlever le dernier chapitre sans perdre en qualité.

> Le temps de travail: c'est trop pour ce que vaut ce cours. C'est intéressant,
> utile, mais il faudrait que ce cours justifie ce temps scolairement, qu'on ait
> les périodes, etc.

---

> Le vide de vraie théorie: on nous présente les concepts, mais on ne nous
> prépare que peu à vraiment coder les principes qu'on nous apprend. J'ai passé
> longtemps à tenter de comprendre UDP et les interfaces durant le labo, quand
> j'aurais dû déjà le savoir du cours.

> Les codes d'exemples sont difficiles à lire. Même dans les versions mieux
> amenées (HTTP), on ne nous explique jamais le contenu du code, seulement le
> but

> Le support de cours sur Git j'ai du mal personnellement, et les PDF sont moyen
> vu que généré automatiquement.

#### _"J'ai particulièrement apprécié..."_

> Les tests sur des plus petites parties de la matière rendent la préparation de
> ceux-ci plus faciles, mais alors la longueur devrait aussi être adaptée pour
> mieux équilibrer le travail imputé entre les classes parallèles. Si les tests
> contiennent moins de matière, ils devraient aussi être plus courts, car
> évaluer 4 thématiques en 4 fois 1h30 dépasse largement le temps d'évaluation
> utilisé par les classes parallèles, sans compter que les moyenne de classe
> diffèrent largement.

---

> J'ai bien aimer la plateforme d’évaluation en ligne en tout cas faire un TE
> comme dans un cas réel.

> avoir plus de tests mais sur moins de sujet est une bonne chose. Avoir peu ou
> moyennement de théorie avec de la pratique qui suit juste derrière est
> vraiment top. Les tests sur l'ordi bien également

> Pouvoir faire des projets au choix c'est motivant.

> La présentation des labos qui mettent en valeur le travail effectué et nous
> entraîne à présenter notre travail.

---

> Les labos sont vraiment sympa.

> Les évaluations (et présentation) de la pratique sont bien réalisés.

> La présence des enseignants et de l'assistant même en cas de souci autre.
> L'explication est claire et précise. Une liberté à choisir notre laboratoire
> nous permettant d'être créatif. Cours donné sur une plateforme professionnel

> Les supports de cours sont excellent et mis à jour régulièrement est c'est
> fort apprécié.

---

> La structure du cours / des documents du cours (Merci d'utiliser git et du
> markdown, si seulement tous les cours étaient comme ça...).

> La liberté qu'offre le cours et l'entrain du professeur à améliorer le cours
> et l'école en passant. J'apprécie aussi qu'on tente des nouvelles approches,
> avec du matériel de cours neuf, même si cela implique qu'il n'est pas encore
> complétement formé (encore des fautes, incohérences, erreurs de langage, etc.)

> Le façon de donner le cours est très agréable et très dynamique.

---

> Les enseignants nous laissent avancer à notre rythme et nous laisse explorer
> les sujets que l'on veut dans un cadre définis pour les travaux pratiques et
> pour les exercices.

> Les explications que vous donnés lors des questions sont excellentes.

> Le fait d'avoir moins de théorie et plus de pratique est une bonne idée.

> La théorie qui n'est pas inutilement longue, pratiquer nous permet de faire le
> lien entre la théorie et la pratique de manière beaucoup plus efficace que
> dans les autres modules.

---

> L'approche orientée pratique du cours.

> J'ai aimé la pratique de ce cours, la façon d'apprendre.

> J'ai appris beaucoup d'outils intéressant durant ce cours.

> J'aime bien comment le cours est organisé ainsi que la méthode d'enseignement
> que les enseignants on choisi (notamment quand je compare avec les autres
> classes ).

> La structure du cours est intéressante, surtout pour ceux qui apprennent bien
> avec la pratique.

---

> L'approche pratique de l'éducation, en nous laissant expérimenter par nous
> même le fonctionnement de différents outils.

> L'ajout de quiz est vraiment très utile, il faudrait juste qu'il soit beaucoup
> plus fourni.

> Avoir la structure / planification du cours dès le début.

> La présence n'est pas obligatoire et malgré que la classe peu être vide les
> enseignants sont toujours disponible par mail.

---

> On se sent bien dans votre classe. Vous savez mettre à l'aise et c'est
> agréable. Vous faites attention à ce qu'aucun élève ne soit oublié et prenne
> du retard c'est vraiment bien.

> En général : 7,5/10

> L'investissement du prof et de l'assistant dans le cours.

> Le prof et l'assistant sont vraiment bien :)

---

> Prof et assistant sont très sympas, aimables et sont très investis dans le
> cours. On voit qu'ils écoutent les remarques que les étudiants leur font et
> les prennent en compte presque immédiatement. (Si seulement on pouvait avoir
> plus de profs comme eux)

> J'ai particulièrement apprécié le cours dans sa globalité, mais surtout
> l'engagement de Ludovic et Hadrien est top! Il y a encore des points à
> améliorer mais c'est déjà un grand pas!

---

> Aussi, c'est très ouvert aux modifications des élèves, mais ça ne devrait pas
> être notre devoir, on passe déjà assez de temps sur ces labos. Mais au moins
> si on a quelque chose qui nous dérange, on peut le corriger, c'est pas un
> cours immuable, ni un prof inaccessible, inabordable.

## Taboo questions

Here are some taboo questions we never take the time to discuss and I would like
your opinion on them. There will be no judgement and no consequences. I just
want to understand your point of view.

- Did you find the course too difficult?
- Did you feel the need to cheat during the semester?
- Is there anything that you feel was not fair during the semester?
- Do you have a taboo question you would like to ask?

## Exam preparation

<!-- _class: lead -->

What you need to know for the exam

### Exam preparation

**Where and when?**

- **Date**: 07.02.2024 (Wednesday)
- **Time**: 08:00
- **Duration**: 1 hour
- **Place(s)**: G01, J01 and H01

Find all examens on [SACHEM](https://sachem.heig-vd.ch/examens/actuel/).

![bg right:40%][illustration]

---

**What to expect?**

A paper exam that will test your knowledge on everything we have seen during the
semester (theoretical content, practical content and practical works).

**Allowed resources?**

Two double-sided sheets (so four single-sided sheets) of personal notes.

![bg right:40%][illustration]

---

**How to revise?**

All typical questions are at the end of each chapter you studied.

All previous evaluations are available in the course repository:

- [Evaluation 1](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/00-evaluation-and-exam-archives)
- [Evaluation 2](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/00-evaluation-and-exam-archives)
- [Evaluation 3](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/00-evaluation-and-exam-archives)
- [Evaluation 4](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/24-evaluation-4)

![bg right:40%][illustration]

## Questions

<!-- _class: lead -->

Do you have any questions?

## Conclusion

<!-- _class: lead -->

### Conclusion

You can be proud of yourself! You all did a great job! We had a blast following
your progress during this semester.

This course is now over, but we hope you enjoyed it and learned a lot.

This course is part of a larger curriculum, and we hope you will be able to
apply what you learned in the next courses.

This course is only the start of what you can learn about. We hope you will
continue to learn about these topics in the future.

### How to stay up to date?

Staying up to date is a challenge in the IT world. Here are some resources to
help you with content related to this course:

- <https://news.ycombinator.com/>
- <https://www.reddit.com/r/homelab/>
- <https://www.reddit.com/r/programming/>
- <https://www.reddit.com/r/selfhosted/>
- <https://github.com/awesome-selfhosted/awesome-selfhosted>

### Well, what now?

You have gained significant knowledge during this course. Use this knowledge
wisely. With great power comes great responsibility. You can now:

- Go deeper in the web development world
- Enter the game of self-hosting
- Interact with the open-source community

Thrive to learn more, and do not hesitate to share your knowledge with others.

### Closing remarks

My personal closing remarks are the following:

- **Always stay critical**! Don't believe everything you read or hear!
- **Always ask yourself questions**! _Why?_ _How?_ _What?_ _Am I doing the right
  thing for the right cause?_ _Do I listen to myself?_
- **Always do what is good for you**! Health, relationships, friends are more
  important than work! You are more important than work!
- **Always trust yourself and your guts**! Do what you think is right!
- **Help others, be kind**: cooperation is better than competition!

### Thank you, good luck, and farewell!

<!-- _class: lead -->

Apéro time! 🎉

## Sources

- Main illustration by [MChe Lee](https://unsplash.com/@mclee) on
  [Unsplash](https://unsplash.com/photos/PC91Jm1DlWA)
- Illustration by [Kenny Eliason](https://unsplash.com/@neonbrand) on
  [Unsplash](https://unsplash.com/photos/60krlMMeWxU)
- Illustration by [Roman Synkevych](https://unsplash.com/@synkevych) on
  [Unsplash](https://unsplash.com/photos/wX2L8L-fGeA)
- Illustration by [Nathan Dumlao](https://unsplash.com/@nate_dumlao) on
  [Unsplash](https://unsplash.com/photos/KixfBEdyp64)
- Illustration by [Martijn Baudoin](https://unsplash.com/@martijnbaudoin) on
  [Unsplash](https://unsplash.com/photos/audio-mixer-set-4h0HqC3K4-c)
- Illustration by
  [Birmingham Museums Trust](https://unsplash.com/@birminghammuseumstrust) on
  [Unsplash](https://unsplash.com/photos/ScZwMqoxcls)
- Illustration by [Iñaki del Olmo](https://unsplash.com/@inakihxz) on
  [Unsplash](https://unsplash.com/photos/NIJuEQw0RKg)
- Illustration by [CHUTTERSNAP](https://unsplash.com/@chuttersnap) on
  [Unsplash](https://unsplash.com/photos/xewrfLD8emE)

---

- Illustration by [Joanna Kosinska](https://unsplash.com/@joannakosinska) on
  [Unsplash](https://unsplash.com/photos/uGcDWKN91Fs)
- Illustration by [Mathew Schwartz](https://unsplash.com/@cadop) on
  [Unsplash](https://unsplash.com/photos/sb7RUrRMaC4)
- Illustration by [Carl Nenzen Loven](https://unsplash.com/@archduk3) on
  [Unsplash](https://unsplash.com/photos/N8GdKC4Rcvs)
- Illustration by [Rafael Rex Felisilda](https://unsplash.com/@rafaelrex) on
  [Unsplash](https://unsplash.com/photos/chess-pieces-on-chess-board-rCxTJlaU5Yc)
- Illustration by
  [Possessed Photography](https://unsplash.com/@possessedphotography) on
  [Unsplash](https://unsplash.com/photos/tiNCpHudGrw)
- Illustration by [Jorge Ramirez](https://unsplash.com/@jorgedevs) on
  [Unsplash](https://unsplash.com/photos/a-cell-phone-tower-in-a-park-with-a-lake-in-the-background-0vmMg1r7FRU)
- Illustration by [Ashley Knedler](https://unsplash.com/@ashkned) on
  [Unsplash](https://unsplash.com/photos/KvD36NRFjl4)
- Illustration by [Nicolas Picard](https://unsplash.com/@artnok) on
  [Unsplash](https://unsplash.com/photos/-lp8sTmF9HA)
- Illustration by [Lāsma Artmane](https://unsplash.com/@lasmaa) on
  [Unsplash](https://unsplash.com/photos/lighted-christmas-tree-surrounded-by-houses-5X8N9A2ruHM)
