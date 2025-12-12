# DAI-TIC-A - Evaluation 1

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

Expliquez ce qu'est un conflit avec Git et comment le résoudre.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Un conflit avec Git se produit lorsque deux branches ont des modifications
concurrentes sur les mêmes lignes d'un fichier ou lorsque des fichiers ont été
supprimés dans une branche mais modifiés dans une autre.

Git ne peut pas automatiquement fusionner ces modifications et demande à
l'utilisateur de résoudre le conflit manuellement.

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
- Une liste à puces non ordonnée avec 3 éléments
- Un block de code Java simple qui affiche `Hello, World!` dans la console (la
  ligne à afficher est `System.out.println("Hello, World!");`)

<details>
<summary>Afficher la réponse</summary>

````markdown
# Titre de niveau 1

## Titre de niveau 2

Ceci est un paragraphe de texte.

[Ceci est un lien vers example.com](https://www.example.com)

- Élément 1
- Élément 2
- Élément 3

```java
System.out.println("Hello, World!");
```
````

</details>

## Question 4 (2 points)

Dans un environnement Java, quel est le but du JRE ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Utilisé pour développer des applications Java, comprend le compilateur et
      les outils de développement.
- [ ] Utilisé pour exécuter des applications Java, comprend uniquement
      l'environnement d'exécution.

<details>
<summary>Afficher la réponse</summary>

- [ ] Utilisé pour développer des applications Java, comprend le compilateur et
      les outils de développement.
- [x] Utilisé pour exécuter des applications Java, comprend uniquement
      l'environnement d'exécution.

</details>

## Question 5 (2 points)

Dans un environnement Java, quel est le but de la JVM ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Fournir une machine virtuelle pour exécuter des applications Java.
- [ ] Compiler le code source Java en bytecode.
- [ ] Gérer les dépendances et les bibliothèques externes.

<details>
<summary>Afficher la réponse</summary>

- [x] Fournir une machine virtuelle pour exécuter des applications Java.
- [ ] Compiler le code source Java en bytecode.
- [ ] Gérer les dépendances et les bibliothèques externes.

</details>

## Question 6 (2 points)

En quoi un utilitaire comme Maven est-il utile pour développer en Java ?

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Maven est un outil de gestion de projet et de construction pour les projets
Java. Il facilite la gestion des dépendances, la compilation du code,
l'exécution des tests, la génération de documentation et le déploiement des
applications. Maven utilise un fichier de configuration appelé `pom.xml` pour
définir les dépendances, les plugins et les configurations du projet, ce qui
permet d'automatiser et de standardiser le processus de développement.

</details>

## Question 7 (2 points)

Pourquoi est-il utile de partager les configurations IntelliJ IDEA entre les
membres d'une équipe de développement ?

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

Partager les configurations IntelliJ IDEA entre les membres d'une équipe de
développement permet de garantir que tous les développeurs utilisent les mêmes
paramètres de projet, ce qui facilite la collaboration et réduit les problèmes
liés aux différences de configuration. Cela inclut des aspects tels que les
paramètres de compilation, les configurations d'exécution, les inspections de
code et les styles de codage. En partageant ces configurations, l'équipe peut
maintenir une cohérence dans le développement, ce qui améliore la qualité du
code et accélère le processus de développement.

</details>

## Question 8 (2 points)

Quel est le but d'un fichier `Dockerfile` dans le contexte de Docker ?

_Il est possible qu'il y ait zéro, plusieurs ou toutes les réponses qui soient
possibles. Tout doit être correct pour obtenir les points._

- [ ] Décrire la configuration réseau d'un conteneur Docker.
- [ ] Définir les étapes pour construire une image Docker.
- [ ] Gérer les volumes de données pour les conteneurs Docker.
- [ ] Démarrer plusieurs conteneurs Docker simultanément.

<details>
<summary>Afficher la réponse</summary>

- [ ] Décrire la configuration réseau d'un conteneur Docker.
- [x] Définir les étapes pour construire une image Docker.
- [ ] Gérer les volumes de données pour les conteneurs Docker.
- [ ] Démarrer plusieurs conteneurs Docker simultanément.

</details>

## Question 9 (2 points)

Soit le fichier `compose.yaml` suivant :

```yaml
networks:
  my-network:

services:
  web:
    image: nginx:latest
    ports:
      - "8080:80"
    networks:
      - my-network
```

Expliquez le rôle de chaque instruction du bloc `services` (le bloc `service` y
compris) dans ce fichier `compose.yaml`.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

- `services`: Définit les services qui seront créés dans le conteneur Docker.
- `web`: Nom du service web qui utilise l'image Nginx.
- `image: nginx:latest`: Spécifie l'image Docker à utiliser pour le service web,
  ici la dernière version de Nginx.
- `ports`: Mappe le port 8080 de l'hôte au port 80 du conteneur, permettant
  l'accès au serveur web via le port 8080.
- `networks`: Associe le service web au réseau `my-network`, permettant la
  communication avec d'autres services sur le même réseau.

</details>

## Question 10 (2 points)

Quel est le but du protocole SMTP dans le contexte des communications réseau ?

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

- [x] Envoyer des e-mails entre un client de messagerie et un serveur de
      messagerie.
- [ ] Recevoir des e-mails depuis un serveur de messagerie vers un client de
      messagerie.
- [x] Envoyer des e-mails entre serveurs de messagerie.
- [ ] Synchroniser le statut des e-mails entre plusieurs appareils.

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
import java.nio.charset.StandardCharsets;

class Client {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("localhost", 1234);
      Reader in = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
      Writer out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);

      out.write("Salut server, ça va ?");
      out.flush();

      System.out.println(in.readLine());

      out.close();
      in.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
```

```java
// Server.java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket()) {
      while (!serverSocket.isClosed()) {
        try (
            Reader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(reader);
            Writer writer =
                new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter out = new BufferedWriter(writer)) {
          System.out.println(in.readLine());

          out.write("Salut client, ça va bien, merci !" + "\n");

          out.close();
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

---

Le but (initial) de ce code était le suivant :

> Créer un client et un serveur TCP en Java qui communiquent en s'envoyant des
> messages textuels encodés en UTF-8. Le client se connecte à l'hôte `localhost`
> et envoie un message au serveur (qui tourne également sur `localhost`), qui le
> reçoit et répond avec un autre message. Toutes les bonnes pratiques doivent
> être utilisées. Il n'est pas demander de gérer la concurrence côté serveur.

Mais celui-ci ne marche pas comme prévu.

> [!IMPORTANT]
>
> **Note lors de la correction**
>
> J'ai (Ludovic) réalisé à la correction qu'il y avait une erreur dans la
> consigne. Il n'y a non pas 8 erreurs, mais 9 erreurs.
>
> Pour plus de détails sur la correction, voir la section "Afficher la réponse"
> ci-dessous.

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

> [!IMPORTANT]
>
> **Note lors de la correction**
>
> J'ai (Ludovic) réalisé à la correction qu'il y avait une erreur dans la
> consigne. Il n'y a non pas 8 erreurs, mais 9 erreurs.
>
> Pour compenser cette erreur, voici ce que j'ai fait :
>
> - Si vous avez soulevé qu'il manquait l'utilisation de Buffers côté client
>   qu'une seule fois au lieu des deux fois, j'ai compté automatiquement pour
>   les deux fois.
> - La même chose pour l'encodage de caractères côté serveur. Cette erreur vaut
>   pour 2 points (maximum 8 points pour la question).

### Erreurs identifiées

1. `Client.java`, ligne 7 : Absence de `try-with-resources` pour gérer la
   fermeture automatique des ressources.
2. `Client.java`, ligne 8 : Absence de `BufferedReader` pour améliorer la
   lecture des données.
3. `Client.java`, ligne 9 : Absence de `BufferedWriter` pour améliorer
   l'écriture des données.
4. `Client.java`, ligne 11 : Absence de caractère de fin de ligne (`\n`) à la
   fin du message envoyé, ce qui peut empêcher le serveur de reconnaître la fin
   du message.
5. `Server.java`, ligne 6 : Absence du numéro de port lors de la création du
   `ServerSocket`, ce qui empêche le serveur d'écouter sur un port spécifique.
6. `Server.java`, ligne 8 : Absence de l'appel à `serverSocket.accept()` pour
   accepter les connexions entrantes.
7. `Server.java`, ligne 9 : Absence de spécification du charset UTF-8 lors de la
   création des flux de lecture et d'écriture.
8. `Server.java`, ligne 18 : Absence de l'appel à `flush()` après l'écriture du
   message, ce qui peut empêcher le message d'être envoyé immédiatement.

### Corrections proposées

```java
// CorrectClient.java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 1234);
        Reader reader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        Writer writer = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        BufferedWriter out = new BufferedWriter(writer); ) {

      out.write("Salut server, ça va ?" + "\n");
      out.flush();

      System.out.println(in.readLine());

      out.close();
      in.close();
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
import java.nio.charset.StandardCharsets;

class Client {
  public static void main(String[] args) {
    try { // Missing try-with-resources
      Socket socket = new Socket("localhost", 1234);
      Reader in = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
      // Missing BufferedReader
      Writer out = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
      // Missing BufferedWriter

      out.write("Salut server, ça va ?"); // Missing EOF character
      out.flush();

      System.out.println(in.readLine());

      out.close();
      in.close();
    } catch (IOException e) {
      System.err.println("[Client] IO exception: " + e);
    }
  }
}
```

```java
// CorrectServer.java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(1234)) {

      while (!serverSocket.isClosed()) {
        try (Socket socket = serverSocket.accept();
            Reader reader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader in = new BufferedReader(reader);
            Writer writer =
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
            BufferedWriter out = new BufferedWriter(writer)) {
          System.out.println(in.readLine());

          out.write("Salut client, ça va bien, merci !" + "\n");
          out.flush();

          out.close();
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

```java
// WrongServer.java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket()) { // Missing port number
      while (!serverSocket.isClosed()) {
        try ( // Missing accept() call
            Reader reader = new InputStreamReader(socket.getInputStream()); // Missing charset
            BufferedReader in = new BufferedReader(reader);
            Writer writer =
                new OutputStreamWriter(socket.getOutputStream()); // Missing charset
            BufferedWriter out = new BufferedWriter(writer)) {
          System.out.println(in.readLine());

          out.write("Salut client, ça va bien, merci !" + "\n");
          // Missing flush()

          out.close();
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

Décrivez la notion de fiabilité avec UDP :

1. Pourquoi UDP est-il considéré comme peu fiable.
2. Quelles sont les implications de cette caractéristique pour la transmission
   de données.
3. Quelle est la différence avec TCP ?
4. Donnez un exemple d'utilisation pour chacun des deux protocoles.

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

1. UDP est un protocole de transport. Il est considéré comme peu fiable car il
   n'offre pas de garantie de livraison des paquets.
2. Cela signifie que les paquets peuvent être perdus, dupliqués ou arrivés dans
   le désordre et c'est à l'application de gérer ces cas de figure.
3. En revanche, TCP est un protocole de transport fiable qui garantit la
   livraison des paquets dans le bon ordre et sans perte.
4. UDP est souvent utilisé pour les applications en temps réel comme le
   streaming vidéo ou les jeux en ligne, où la rapidité est plus importante que
   la fiabilité. TCP est utilisé pour des applications où la fiabilité est
   cruciale, comme le transfert de fichiers ou la navigation web.

</details>

## Question 14 (6 points)

Dominique, une connaissance de longue date, a développé une application réseau
qui permet de gérer des listes de courses partagées entre plusieurs
utilisateurs.

A ces débuts, son application fonctionnait très bien car uniquement son
entourage l'utilisait de façon sporadique.

Depuis quelques temps, son application a gagné en succès et sa clientèle
n'arrive pas à accéder à l'application simultanément. Certaines requêtes
semblent même perdues.

Répondez aux questions suivantes :

1. Quel est le problème sous-jacent ?
2. Comment pourrait-il être résolu ?
3. Quelle serait la meilleure stratégie de mise en œuvre pour résoudre ce
   problème ?

Vos réponses doivent être justifiées et convaincantes.

<details>
<summary>Afficher la réponse</summary>

1. Le problème sous-jacent est que le serveur de l'application n'est pas conçu
   pour gérer plusieurs connexions simultanées, ce qui entraîne des conflits et
   des pertes de requêtes lorsque plusieurs utilisateurs tentent d'accéder à
   l'application en même temps.
2. Pour résoudre ce problème, Dominique doit implémenter la gestion de la
   concurrence côté serveur, en utilisant des threads ou un pool de threads pour
   gérer chaque connexion client de manière indépendante.
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

- [ ] TCP est un protocole orienté connexion.
- [ ] UDP garantit la livraison des paquets.
- [ ] TCP utilise des numéros de séquence pour assurer l'ordre des paquets.
- [ ] UDP est plus rapide que TCP en raison de l'absence de mécanismes de
      contrôle de flux liés à la connexion.
- [ ] TCP est utilisé pour les applications en temps réel comme le streaming
      vidéo.
- [ ] UDP est utilisé pour les applications nécessitant une transmission fiable
      des données.
- [ ] TCP utilise le mécanisme de retransmission pour gérer les paquets perdus.
- [ ] UDP établit une connexion avant de transmettre des données.
- [ ] TCP et UDP prennent en charge la transmission de données unicast,
      broadcast et multicast.
- [ ] UDP est souvent utilisé pour les applications où la rapidité est plus
      importante que la fiabilité.

<details>
<summary>Afficher la réponse</summary>

- [x] TCP est un protocole orienté connexion.
- [ ] UDP garantit la livraison des paquets.
- [x] TCP utilise des numéros de séquence pour assurer l'ordre des paquets.
- [x] UDP est plus rapide que TCP en raison de l'absence de mécanismes de
      contrôle de flux liés à la connexion.
- [ ] TCP est utilisé pour les applications en temps réel comme le streaming
      vidéo.
- [ ] UDP est utilisé pour les applications nécessitant une transmission fiable
      des données.
- [x] TCP utilise le mécanisme de retransmission pour gérer les paquets perdus.
- [ ] UDP établit une connexion avant de transmettre des données.
- [ ] TCP et UDP prennent en charge la transmission de données unicast,
      broadcast et multicast.
- [x] UDP est souvent utilisé pour les applications où la rapidité est plus
      importante que la fiabilité.

</details>

## Question 16 (6 points)

Un partenaire vous demande de concevoir une application de chat en temps réel.
L'application doit supporter des conversations privées entre deux personnes
ainsi que des discussions de groupe.

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
