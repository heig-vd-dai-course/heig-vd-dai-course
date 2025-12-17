# DAI-TIC-C - Evaluation 1

Cette évaluation porte sur les notions suivantes :

- Git, GitHub and Markdown
- Java, IntelliJ IDEA and Maven
- Java IOs
- Docker and Docker Compose
- Practical work 1
- SMTP and ncat
- Define an application protocol
- Java TCP and UDP programming
- Java network concurrency

Vous pouvez répondre aux questions en français ou en anglais.

L'évaluation dure 1h30 (90 minutes). Une fois que vous avez terminé, veuillez
marquer votre évaluation comme terminée.

Validez avec le corps enseignant que le système a bien enregistré votre
évaluation. Vous pourrez ensuite quitter la salle de façon silencieuse.

Ressources autorisées :

- Deux (2) feuilles recto-verso (soit quatre (4) pages recto) papier avec vos
  propres notes.

Toute tentative de tricherie sera sanctionnée avec la note 1.

---

## Question 1 (2 points)

Expliquez ce qu'est une branche avec Git et comment c'est utilisé.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Une branche avec Git est une version parallèle du code source. Elle permet de
travailler sur des fonctionnalités, des corrections de bugs ou des
expérimentations de manière isolée sans affecter la branche principale (souvent
appelée "main" ou "master").

Les branches sont utilisées pour faciliter le développement collaboratif,
permettre des tests indépendants et organiser le flux de travail. Une fois les
modifications terminées et validées, une branche peut être fusionnée (merge)
dans la branche principale.

</details>

## Question 2 (2 points)

Décrivez le cycle de vie d'une nouvelle contribution sur GitHub en réordonnant
les étapes suivantes :

- Création de la PR
- Suppression de la branche
- Création de la branche
- Développement
- Fermeture de la PR et de l'issue
- Création de l'issue
- Approbation
- Fusion
- Revue de code
- Modifications

_L'ordre correct des étapes doit être respecté pour obtenir les points._

<details>
<summary>Afficher la réponse</summary>

1. Création de l'issue (optionnel)
2. Création de la branche
3. Développement
4. Création de la PR
5. Revue de code
6. Modifications
7. Approbation
8. Fusion
9. Fermeture de la PR et de l'issue
10. Suppression de la branche (optionnel)

</details>

## Question 3 (2 points)

Rédigez un document Markdown avec les éléments suivants :

- Un titre de niveau 1
- Un titre de niveau 2
- Un paragraphe de texte
- Un lien vers le site <https://www.example.com>
- Une liste à puces ordonnée avec 3 éléments
- Une image dont la source est `https://www.example.com/image.png`

<details>
<summary>Afficher la réponse</summary>

```markdown
# Titre de niveau 1

## Titre de niveau 2

Ceci est un paragraphe de texte.

[Ceci est un lien vers example.com](https://www.example.com)

- Élément 1
- Élément 2
- Élément 3

![Image](https://www.example.com/image.png)
```

</details>

## Question 4 (2 points)

Dans un environnement Java, quel est le but du JDK ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Utilisé pour développer des applications Java, comprend le compilateur et
      les outils de développement.
- [ ] Utilisé pour exécuter des applications Java, comprend uniquement
      l'environnement d'exécution.

<details>
<summary>Afficher la réponse</summary>

- [x] Utilisé pour développer des applications Java, comprend le compilateur et
      les outils de développement.
- [ ] Utilisé pour exécuter des applications Java, comprend uniquement
      l'environnement d'exécution.

</details>

## Question 5 (2 points)

Dans un environnement Java, quel est le but de Maven ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Fournir une machine virtuelle pour exécuter des applications Java.
- [ ] Compiler le code source Java en bytecode.
- [ ] Gérer les dépendances et les bibliothèques externes.

<details>
<summary>Afficher la réponse</summary>

- [ ] Fournir une machine virtuelle pour exécuter des applications Java.
- [ ] Compiler le code source Java en bytecode.
- [x] Gérer les dépendances et les bibliothèques externes.

</details>

## Question 6 (2 points)

En quoi un utilitaire comme SDKMAN! est-il utile pour développer en Java ?

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

SDKMAN! est un gestionnaire de versions pour les kits de développement logiciel
(SDK) dans l'écosystème Java. Il permet aux développeurs de facilement
installer, gérer et basculer entre différentes versions de Java Development Kits
(JDK) et d'autres outils liés à Java. Cela est particulièrement utile pour
tester des applications avec différentes versions de Java ou pour travailler sur
plusieurs projets nécessitant des versions spécifiques.

</details>

## Question 7 (2 points)

Pourquoi dit-on que Java est un langage "WORA" (Write Once, Run Anywhere) ?

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Java est considéré comme un langage "WORA" (Write Once, Run Anywhere) car le
code Java compilé en bytecode peut être exécuté sur n'importe quelle plateforme
disposant d'une Java Virtual Machine (JVM). Cela signifie qu'un programme Java
écrit une fois peut fonctionner sur différentes architectures matérielles et
systèmes d'exploitation sans nécessiter de recompilation, offrant ainsi une
grande portabilité.

</details>

## Question 8 (2 points)

Quel est le but d'un fichier `compose.yaml` ou `docker-compose.yaml` dans le
contexte de Docker ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Décrire la configuration réseau d'un conteneur Docker.
- [ ] Définir les étapes pour construire une image Docker.
- [ ] Gérer les volumes de données pour les conteneurs Docker.
- [ ] Démarrer plusieurs conteneurs Docker simultanément.

<details>
<summary>Afficher la réponse</summary>

- [x] Décrire la configuration réseau d'un conteneur Docker.
- [ ] Définir les étapes pour construire une image Docker.
- [x] Gérer les volumes de données pour les conteneurs Docker.
- [x] Démarrer plusieurs conteneurs Docker simultanément.

</details>

## Question 9 (2 points)

Soit le fichier `Dockerfile` suivant :

```Dockerfile
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/my-app-1.0-SNAPSHOT.jar /app/my-app-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "my-app-1.0-SNAPSHOT.jar"]

CMD ["--help"]
```

Expliquez le rôle de chaque instruction dans ce fichier `Dockerfile`.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

- `FROM eclipse-temurin:21-jre` : Cette instruction spécifie l'image de base à
  utiliser pour construire l'image Docker. Ici, elle utilise l'image Eclipse
  Temurin avec Java Runtime Environment (JRE) version 21.
- `WORKDIR /app` : Cette instruction définit le répertoire de travail à
  l'intérieur du conteneur Docker. Toutes les commandes suivantes seront
  exécutées dans ce répertoire.
- `COPY target/my-app-1.0-SNAPSHOT.jar /app/my-app-1.0-SNAPSHOT.jar` : Cette
  instruction copie le fichier JAR de l'application depuis le répertoire
  `target` de l'hôte vers le répertoire `/app` du conteneur.
- `ENTRYPOINT ["java", "-jar", "my-app-1.0-SNAPSHOT.jar"]` : Cette instruction
  définit la commande par défaut qui sera exécutée lorsque le conteneur démarre.
  Ici, elle exécute l'application Java en utilisant le fichier JAR.
- `CMD ["--help"]` : Cette instruction fournit des arguments par défaut à
  l'ENTRYPOINT. Si aucun argument n'est fourni lors de l'exécution du conteneur,
  l'argument `--help` sera utilisé.

</details>

## Question 10 (2 points)

Quel est le but du protocole IMAP dans le contexte des communications réseau ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Envoyer des e-mails entre un client de messagerie et un serveur de
      messagerie.
- [ ] Recevoir des e-mails depuis un serveur de messagerie vers un client de
      messagerie.
- [ ] Envoyer des e-mails entre serveurs de messagerie.
- [ ] Synchroniser les e-mails entre plusieurs appareils.

<details>
<summary>Afficher la réponse</summary>

- [ ] Envoyer des e-mails entre un client de messagerie et un serveur de
      messagerie.
- [x] Recevoir des e-mails depuis un serveur de messagerie vers un client de
      messagerie.
- [ ] Envoyer des e-mails entre serveurs de messagerie.
- [x] Synchroniser le statut des e-mails entre plusieurs appareils.

</details>

## Question 11 (4 points)

Une équipe de développement vous a fourni le document de protocole applicatif
suivant pour une application de messagerie instantanée :

```text
= Protocole de messagerie instantanée

Ceci est un protocole applicatif.

== Commandes serveurs

LOGIN <username> <password>
SEND <sender> <message>

== Commandes clients

MESSAGE <recipient> <message>
ERROR <error_code> <error_message>
```

Quelle structure pourriez-vous proposer pour améliorer ce document dans le but
de le rendre plus complet et précis ? Pour chacun de vos points, expliquez
brièvement pourquoi c'est important.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Un protocole applicatif est constitué de plusieurs éléments clés :

- Section 1 - Vue d'ensemble (Overview) - Fournit une introduction au protocole,
  son but et son contexte d'utilisation. - Important pour comprendre l'objectif
  du protocole.
- Section 2 - Protocole de transport (Transport protocol) - Spécifie le
  protocole de transport sous-jacent utilisé (par exemple, TCP, UDP) et les
  ports associés, ainsi que les mécanismes de connexion. - Important pour
  garantir une communication fiable et efficace.
- Section 3 - Messages - Définit les types de messages échangés, leur format,
  les champs obligatoires et optionnels, ainsi que les messages retournés dans
  un contexte donné. - Important pour assurer une compréhension claire des
  échanges entre le client et le serveur.
- Section 4 - Exemples (Examples) - Fournit des exemples concrets d'échanges de
  messages pour illustrer le fonctionnement du protocole. - Important pour
  faciliter la compréhension et l'implémentation du protocole et l'illustrer.

</details>

## Question 12 (8 points)

Soit le code Java suivant :

---

```java
// Client.java
import java.io.*;
import java.net.*;

class Client {
  public static void main(String[] args) {
    try (InputStream fis = new FileInputStream("file.png", StandardCharsets.UTF_8);
        Socket socket = new Socket("localhost", 1234);
        OutputStream out = socket.getOutputStream(); ) {
      int b;
      while ((b = bis.read()) != 0) {
        out.write(b);
      }

      out.flush();
      out.close();
      bis.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
```

```java
// Server.java
import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(); ) {
      while (!serverSocket.isClosed()) {
        try {
          BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
          OutputStream fos = new FileOutputStream("file.bak.png");
          BufferedOutputStream bos = new BufferedOutputStream(fos);

          int b;
          while ((b = in.readLine()) != -1) {
            bos.write(b);
          }

          in.close();
          bos.flush();
          bos.close();
        } catch (IOException e) {
          System.err.println("[Server] IO exception: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("[Server] IO exception: " + e);
    }
  }
}
```

---

Le but (initial) de ce code était le suivant :

> Créer un client et un serveur TCP en Java qui communiquent en s'envoyer des
> fichiers binaires. Le client se connecte à l'hôte `localhost` et envoie un
> fichier (`file.png`) au serveur (qui tourne également sur `localhost`), qui le
> reçoit et le sauve localement sous le nom `file.bak.png`. Toutes les bonnes
> pratiques doivent être utilisées. Il n'est pas demander de gérer la
> concurrence côté serveur.

Mais celui-ci ne marche pas comme prévu.

Pour chacune des 8 fautes identifiées dans les deux bouts de code, faites les
actions suivantes :

1. Indiquez le fichier et la ligne où se trouve la faute et décrivez pourquoi
   c'en est une.
2. Proposez une correction Java pour chaque faute.

> **Note**
>
> L'affichage des erreurs à l'aide d'un `System.out.println` ou
> `System.err.println` est acceptable pour cette question.
>
> Les erreurs ne sont confinées qu'aux cœurs des méthodes `main` des deux
> classes.

<details>
<summary>Afficher la réponse</summary>

### Erreurs identifiées

1. `Client.java`, ligne 7 : Mauvaise utilisation du constructeur de
   `FileInputStream` avec un charset. Le charset n'est pas nécessaire pour les
   fichiers binaires.
2. `Client.java`, ligne 8 : Absence de `BufferedOutputStream` pour améliorer les
   performances d'écriture.
3. `Client.java`, ligne 9 : Absence de `BufferedInputStream` pour améliorer les
   performances de lecture.
4. `Client.java`, ligne 12 : Mauvaise condition de fin de fichier (EOF). Doit
   être `-1` au lieu de `0`.
5. `Server.java`, ligne 7 : Mauvaise utilisation du constructeur de
   `ServerSocket` sans spécifier de port.
6. `Server.java`, ligne 9 : Absence d'utilisation d'une structure
   try-with-resources pour gérer automatiquement la fermeture des ressources.
7. `Server.java`, ligne 10 : Absence de la méthode `accept()` pour accepter les
   connexions entrantes.
8. `Server.java`, ligne 16 : Mauvaise méthode de lecture des données. Doit
   utiliser `read()` au lieu de `readLine()`.

### Corrections proposées

```java
// CorrectClient.java
import java.io.*;
import java.net.*;

class Client {
  public static void main(String[] args) {
    try (InputStream fis = new FileInputStream("file.png");
        BufferedInputStream bis = new BufferedInputStream(fis);
        Socket socket = new Socket("localhost", 1234);
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream()); ) {
      int b;
      while ((b = bis.read()) != -1) {
        out.write(b);
      }

      out.flush();
      out.close();
      bis.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
```

```java
// WrongClient.java
import java.io.*;
import java.net.*;

class Client {
  public static void main(String[] args) {
    try (InputStream fis = new FileInputStream("file.png", StandardCharsets.UTF_8); // Charset added while not needed
        // Missing BufferedInputStream
        Socket socket = new Socket("localhost", 1234);
        OutputStream out = socket.getOutputStream(); // Missing BufferedOutputStream ) {
      int b;
      while ((b = bis.read()) != 0) { // Wrong EOF number
        out.write(b);
      }

      out.flush();
      out.close();
      bis.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
```

```java
// CorrectServer.java
import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(1234)) {
     while (!serverSocket.isClosed()) {
        try (Socket socket = serverSocket.accept();
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
            OutputStream fos = new FileOutputStream("file.bak.png");
            BufferedOutputStream bos = new BufferedOutputStream(fos); ) {
          int b;
          while ((b = in.read()) != -1) {
            bos.write(b);
          }

          in.close();
          bos.close();
        } catch (IOException e) {
          System.err.println("[Server] IO exception: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("[Server] IO exception: " + e);
    }
  }
}
```

```java
// WrongServer.java
import java.io.*;
import java.net.*;

class Server {
  public static void main(String args[]) {
    try (ServerSocket serverSocket = new ServerSocket(); // Missing port number ) {
      while (!serverSocket.isClosed()) {
        try { // Missing try-with-resources
          // Missing accept() call
          BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
          OutputStream fos = new FileOutputStream("file.bak.png");
          BufferedOutputStream bos = new BufferedOutputStream(fos);

          int b;
          while ((b = in.readLine()) != -1) { // Wrong method to read data
            bos.write(b);
          }

          bos.flush();
          bos.close();
          in.close();
        } catch (IOException e) {
          System.err.println("[Server] IO exception: " + e);
        }
      }
    } catch (IOException e) {
      System.err.println("[Server] IO exception: " + e);
    }
  }
}
```

</details>

## Question 13 (2 points)

Décrivez la notion de fiabilité avec TCP :

1. Pourquoi TCP est-il considéré comme fiable.
2. Quelles sont les implications de cette caractéristique pour la transmission
   de données.
3. Quelle est la différence avec UDP.
4. Donnez un exemple d'utilisation pour chacun des deux protocoles.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

1. TCP est un protocole de transport. Il est considéré comme fiable car il offre
   une garantie de livraison des paquets.
2. Cela signifie que les paquets envoyés via TCP arriveront à destination sans
   perte, en double, ou dans le désordre. TCP utilise des mécanismes tels que la
   retransmission des paquets perdus, le contrôle de flux et la gestion de la
   congestion pour assurer cette fiabilité.
3. En revanche, UDP est un protocole de transport non fiable. Il n'offre pas de
   garantie de livraison des paquets, ce qui signifie que les paquets peuvent
   être perdus, dupliqués ou arriver dans le désordre.
4. TCP est utilisé pour des applications où la fiabilité est cruciale, comme le
   transfert de fichiers ou la navigation web. UDP est souvent utilisé pour les
   applications en temps réel comme le streaming vidéo ou les jeux en ligne, où
   la rapidité est plus importante que la fiabilité.

</details>

## Question 14 (6 points)

Dominique, une connaissance de longue date, a développé une application réseau
qui permet de gérer des listes de courses partagées entre plusieurs
utilisateurs.

Depuis ces débuts, son application fonctionnait très bien, même lorsque
plusieurs centaines de personnes l'utilisaient simultanément.

Répondez aux questions suivantes :

1. Quel mécanisme utilise Dominique pour gérer plusieurs connexions simultanées
   ?
2. Quels problèmes pourraient survenir si ce mécanisme n'était pas en place ?
3. Quelle serait la meilleure stratégie de mise en œuvre pour gérer efficacement
   les ressources ?

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

1. Dominique utilise probablement la gestion de la concurrence côté serveur, en
   utilisant des threads ou un pool de threads pour gérer chaque connexion
   client de manière indépendante.
2. Sans ce mécanisme, le serveur pourrait devenir bloqué lorsqu'il traite une
   connexion, empêchant ainsi d'autres clients de se connecter ou de recevoir
   des réponses en temps opportun. Cela pourrait entraîner des délais d'attente
   prolongés, des erreurs de connexion et une mauvaise expérience utilisateur.
3. L'utilisation d'un pool de threads (virtuels ou non) serait la meilleure
   stratégie, car elle permet de réutiliser un nombre fixe de threads pour gérer
   les connexions entrantes, ce qui améliore les performances et réduit la
   surcharge liée à la création et à la destruction fréquente de threads.
   Dominique devrait également s'assurer que les ressources partagées sont
   correctement protégées pour éviter les conditions de course.

</details>

## Question 15 (2 points)

Affirmations sur TCP et UDP, cochez les réponses correctes.

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] TCP est un protocole sans connexion.
- [ ] UDP ne garantit pas la livraison des paquets.
- [ ] Par défaut, UDP n'offre pas de mécanisme pour assurer l'ordre des paquets.
- [ ] UDP est plus rapide que TCP grâce à la connexion initiale nécessaire.
- [ ] UDP est utilisé pour les applications en temps réel comme le streaming
      vidéo.
- [ ] TCP est utilisé pour les applications nécessitant une transmission fiable
      des données.
- [ ] UDP utilise le mécanisme de retransmission pour gérer les paquets perdus.
- [ ] TCP établit une connexion avant de transmettre des données.
- [ ] UDP prend en charge la transmission de données broadcast et multicast
      uniquement.
- [ ] TCP est souvent utilisé pour les applications où la fiabilité est plus
      importante que la rapidité.

<details>
<summary>Afficher la réponse</summary>

- [ ] TCP est un protocole sans connexion.
- [x] UDP ne garantit pas la livraison des paquets.
- [x] Par défaut, UDP n'offre pas de mécanisme pour assurer l'ordre des paquets.
- [ ] UDP est plus rapide que TCP grâce à la connexion initiale nécessaire.
- [x] UDP est utilisé pour les applications en temps réel comme le streaming
      vidéo.
- [x] TCP est utilisé pour les applications nécessitant une transmission fiable
      des données.
- [ ] UDP utilise le mécanisme de retransmission pour gérer les paquets perdus.
- [x] TCP établit une connexion avant de transmettre des données.
- [ ] UDP prend en charge la transmission de données broadcast et multicast
      uniquement.
- [x] TCP est souvent utilisé pour les applications où la fiabilité est plus
      importante que la rapidité.

</details>

## Question 16 (6 points)

Un partenaire industriel vous demande de concevoir une application de chat en
temps réel. L'application doit supporter des conversations privées entre deux
personnes ainsi que des discussions de groupe.

Argumentez les choix technologiques suivants pour cette application :

1. Choix entre TCP et UDP pour la transmission des messages.
2. Utilisation de threads ou d'un pool de threads pour gérer les connexions
   simultanées.
3. Comment gérer les conversations privées entre deux personnes et les
   discussions de groupe.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Ce type de question est parmi les plus difficiles à traiter car il n'y a pas de
réponse unique.

Il y a par contre des éléments dans vos réponses qui doivent être présents pour
être considérées comme justifiées et convaincantes, permettant d'obtenir les
points.

Lorsque vous dialoguez avec un partenaire industriel (un client externe qui vous
mandate pour un projet), il est important de montrer que vous comprenez ses
besoins et que vous pouvez proposer des solutions adaptées en justifiant vos
choix et en expliquant les compromis associés.

Pour cela, il est nécessaire de présenter des arguments clairs et pertinents
pour chaque choix technologique. Il faut donc expliciter et mettre en avant les
deux choix technologiques proposés (TCP **et** UDP).

Comme étudié en cours, toute application peut être réalisée avec TCP ou UDP,
mais les compromis sont différents.

Dans le cas de cette application de chat en temps réel, TCP est souvent préféré
en raison de sa fiabilité et de son ordre de livraison garanti, ce qui est
crucial pour assurer que les messages arrivent correctement et dans le bon
ordre.

Cependant, UDP peut être envisagé pour des fonctionnalités spécifiques, comme
les notifications en temps réel, où la rapidité est peut être jugée plus
importante que la fiabilité. De plus, avec l'utilisation du multicast, les
messages peuvent être très facilement envoyés à plusieurs destinataires
simultanément.

Pour gérer les connexions simultanées, l'utilisation d'un pool de threads est
souvent recommandée. Cela permet de limiter le nombre de threads actifs, ce qui
réduit la surcharge liée à la création et à la destruction fréquente de threads,
tout en assurant une gestion efficace des ressources.

Si par contre l'application utilise des threads virtuels (disponibles depuis
Java 19), cela peut être une excellente alternative, car ils permettent de gérer
un grand nombre de connexions avec une empreinte mémoire réduite et une
meilleure scalabilité.

Enfin, pour gérer les conversations privées et les discussions de groupe, tout
dépend du choix du protocole de transport.

Si TCP est utilisé, chaque conversation privée peut être gérée via une connexion
TCP dédiée entre les deux utilisateurs : le client 1 communique le message au
serveur, qui le relaie au client 2.

Pour les discussions de groupe, le serveur peut maintenir une liste des
participants. Lorsqu'un message est reçu, il est envoyé à tous les membres du
groupe en utilisant une boucle d'envoi (boucle `for` ou `while`), qui permet de
parcourir la liste des participants et d'envoyer le message à chacun.

Si UDP est utilisé, les conversations privées peuvent également être gérées via
des connexions dédiées en unicast entre le client 1 et le client 2. La
difficulté pour cet aspect-là réside dans la découverte des adresses IP et ports
des clients (comment savoir où envoyer les messages). Cela peut être résolu en
utilisant un serveur de découverte ou en implémentant un protocole d'inscription
où chaque client communique son adresse IP et port au serveur.

Les conversations de groupe peuvent être efficacement gérées en utilisant le
multicast UDP, où un message envoyé à une adresse multicast est reçu par tous
les membres du groupe abonnés à cette adresse, pour autant que le réseau
supporte le multicast (réseau local uniquement). Sans quoi, nous retombons sur
une solution en unicast avec une boucle d'envoi côté serveur, comme pour TCP.

Dans les deux cas (conversation de groupe ou conversation privée), UDP n'offrant
aucun mécanisme de fiabilité, la principale difficulté réside dans la gestion de
cette fiabilité, qui doit être implémentée au niveau de l'application afin de
garantir que les messages sont correctement reçus et dans le bon ordre.

Lorsque vous répondez à ce type de question, il est important de structurer
votre réponse de manière claire, en abordant chaque point séparément et en
fournissant des exemples concrets pour illustrer vos arguments.

De plus, c'est vous les expert.es techniques, les personnes en charge de la mise
en œuvre.

Il est donc important de montrer que vous comprenez les besoins du client et que
vous pouvez proposer des solutions adaptées. Il faut à tout prix éviter les
réponses vagues ou génériques qui ne montrent pas une compréhension approfondie
du sujet (par exemple : "Il faut utiliser TCP car c'est plus fiable", "je pense
que", "j'imagine que c'est mieux"). Cela ne met pas en valeur votre expertise et
peut donner l'impression que vous ne maîtrisez pas le sujet (perte de
confiance).

En tant qu'expert.es techniques, vous devez démontrer votre expertise et votre
capacité à fournir des solutions techniques solides et bien justifiées.

Comme cette question est complexe, il est possible que certaines réponses
n'incluent pas tous les points mentionnés ci-dessus et que vous ayez quand-même
obtenu des points. Cela dépend de la qualité et de la pertinence des arguments
fournis dans chaque réponse.

En raison de la difficulté de cette question, le nombre de points total de
l'évaluation est de 44 points au lieu des 48 points indiqués initialement.

</details>
