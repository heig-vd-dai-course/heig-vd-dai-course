# DAI-TIC-C - Évaluation 2

Cette évaluation porte sur les notions suivantes :

- Définir un protocol applicatif
- Programmation TCP en Java
- Programmation UDP en Java
- Concurrence réseau en Java
- SMTP et ncat

Vous pouvez répondre aux questions en français ou en anglais.

L'évaluation dure 1h et est composé de deux parties :

| Parties  | Points |
| :------- | -----: |
| Partie 1 |     40 |
| Partie 2 |     40 |

Une fois la première partie terminée, venez récupérer la seconde partie.

Chaque partie est pensée pour être réalisée en ~30 minutes.

Une fois que que vous avez terminé, vous pouvez rendre la seconde partie et
quitter la salle de façon silencieuse.

Ressources autorisées :

- Deux feuilles et demie (2.5) de résumé (recto) papier avec vos propres notes

Toute tentative de tricherie sera sanctionnée avec la note 1.

---

## Partie 1

### Question 1 (13 points)

Pour chacune des affirmations suivantes, sélectionnez la réponse correcte parmi
les choix suivants: A, B, C ou D.

1. Quelle est la fonction principale d'un protocole d'application ?
   - A. Définir les règles de communication entre deux applications
   - B. Traduire les adresses IP en noms de domaine
   - C. Assurer la sécurité des messages entre client et serveur
   - D. Partager une seule adresse IP entre plusieurs ordinateurs
2. Quelle est la plage des ports dits "bien connus" ?
   - A. 0 à 1023
   - B. 1024 à 49151
   - C. 49152 à 65535
   - D. 8080 à 8181
3. Que représente un port dans le contexte d'un réseau informatique ?
   - A. Une adresse physique d'un serveur
   - B. Un identifiant pour un processus ou service spécifique
   - C. Une adresse IP unique
   - D. Un protocole utilisé pour la communication
4. Quel document définit un protocole d'application ?
   - A. Un DNS
   - B. Un NAT
   - C. Une RFC (Request for Comments)
   - D. Un diagramme de séquence
5. Quel est le rôle d'un diagramme de séquence dans un protocole d'application ?
   - A. Protéger les données échangées
   - B. Définir l'ordre des messages échangés
   - C. Analyser les erreurs d'un protocole
   - D. Encoder les messages en binaire
6. Lequel des éléments suivants est nécessaire pour qu'une connexion TCP soit
   établie ?
   - A. Une adresse IP et un numéro de port
   - B. Uniquement une adresse IP
   - C. Uniquement un numéro de port
   - D. Une connexion UDP préalable
7. Quelle est la principale différence entre un `ServerSocket` et un `Socket` ?
   - A. `ServerSocket` est utilisé pour recevoir des données, Socket pour les
     envoyer
   - B. `ServerSocket` écoute les connexions entrantes, Socket établit des
     connexions sortantes
   - C. `ServerSocket` fonctionne uniquement en multicast
   - D. Socket est un protocole alors que `ServerSocket` est une classe
8. Quel est le rôle de la méthode `getInputStream()` dans un socket TCP ?
   - A. Écrire des données dans le socket
   - B. Initialiser le socket
   - C. Fermer le socket
   - D. Lire les données reçues depuis le socket
9. Lorsqu'un client se connecte à un serveur TCP, que fait le serveur avec la
   méthode `accept()` ?
   - A. Il établit une nouvelle connexion et retourne un socket pour la
     communication avec le client
   - B. Il met fin à toutes les connexions actives
   - C. Il génère une erreur si aucune donnée n'est reçue
   - D. Il transfère la connexion à un autre serveur
10. Si une connexion TCP doit rester ouverte pour exécuter plusieurs commandes,
    quelle structure est idéale ?
    - A. Un protocole unidirectionnel
    - B. Une méthode bind() continue
    - C. Une boucle REPL (Read-Eval-Print Loop)
    - D. Une connexion UDP parallèle
11. Quel est l'objectif principal du protocole UDP ?
    - A. Offrir une connexion sécurisée.
    - B. Permettre des communications rapides et légères.
    - C. Assurer une livraison garantie des messages.
    - D. Permettre uniquement des transmissions de données locales.
12. Qu'est-ce qu'un service de découverte actif ?
    - A. Une méthode pour envoyer des annonces périodiques.
    - B. Une requête envoyée pour trouver un service.
    - C. Une technique de cryptage des datagrammes.
    - D. Une communication TCP sécurisée.
13. Quel est un exemple d'application qui pourrait utiliser UDP ?
    - A. Serveur FTP.
    - B. Site web HTTPS.
    - C. Client de messagerie.
    - D. Application de streaming vidéo.
14. Qu'est-ce qu'un datagramme UDP ?
    - A. Un message fragmenté et ordonné.
    - B. Une structure réseau.
    - C. Une unité de données indépendante envoyée sans connexion.
    - D. Un flux continu de données.
15. Quel type de service repose sur les protocoles de découverte comme multicast
    ?
    - A. Les services sécurisés.
    - B. Les services nécessitant des connexions persistantes.
    - C. Les services de découverte de réseau.
    - D. Les services de messagerie.
16. Quel est l'intérêt de limiter le nombre de threads dans un serveur ?
    - A. Réduire les coûts matériels
    - B. Prévenir la saturation des ressources système
    - C. Simplifier le code du serveur
    - D. Éviter les conditions de concurrence
17. Pourquoi la programmation multi-processus peut-elle être moins efficace que
    la programmation multi-threadée ?
    - A. Parce que les processus consomment plus de ressources système
    - B. Parce que les processus ne permettent pas de gérer plusieurs clients
    - C. Parce que les processus sont plus rapides que les threads
    - D. Parce que les processus ne fonctionnent pas sur les protocoles TCP
18. Quel est un désavantage de l'utilisation de threads illimités ?
    - A. Une meilleure gestion des ressources
    - B. Une consommation excessive de mémoire et de CPU
    - C. Une complexité accrue dans le code
    - D. Une latence accrue pour chaque client
19. Quel est l'objectif principal d'un serveur multi-threadé ?
    - A. Accélérer les connexions réseau
    - B. Limiter le nombre de clients connectés
    - C. Gérer des connexions UDP efficacement
    - D. Permettre à plusieurs clients de se connecter simultanément
20. Quelle est une solution courante pour gérer les conflits lors du partage de
    ressources entre threads ?
    - A. Utiliser un autre protocole réseau
    - B. Introduire des mécanismes de synchronisation
    - C. Limiter le nombre de threads
    - D. Augmenter la mémoire allouée au serveur
21. Quel est le rôle principal du protocole SMTP ?
    - A. Récupérer les emails d'un serveur
    - B. Envoyer des emails à un serveur
    - C. Synchroniser les emails entre plusieurs clients
    - D. Stocker les emails sur un serveur
22. Quel est un avantage majeur d'IMAP par rapport à POP3 ?
    - A. IMAP est plus rapide pour télécharger les emails
    - B. IMAP est plus sécurisé que POP3
    - C. IMAP est utilisé uniquement pour les connexions non sécurisées
    - D. IMAP permet de synchroniser les états de lecture des emails entre
      plusieurs clients
23. Pourquoi est-il essentiel d'utiliser des serveurs SMTP de test lors des
    développements ?
    - A. Pour vérifier les performances des emails envoyés à grande échelle
    - B. Pour éviter des problèmes de configuration réseau en production
    - C. Pour limiter l'envoi d'emails réels accidentels ou non autorisés
    - D. Pour tester uniquement les protocoles POP3 et IMAP
24. Que fait la commande `HELO` ou `EHLO` dans une session SMTP ?
    - A. Elle termine la connexion
    - B. Elle identifie le client auprès du serveur SMTP
    - C. Elle spécifie l'adresse email de l'expéditeur
    - D. Elle envoie les données du contenu de l'email
25. Pourquoi le port 25 n'est-il plus recommandé pour les connexions SMTP
    modernes ?
    - A. Il est trop lent pour les connexions modernes
    - B. Il n'offre pas de chiffrement par défaut
    - C. Il est incompatible avec les clients modernes
    - D. Il ne prend pas en charge l'authentification
26. Quel port est recommandé pour une connexion SMTP sécurisée ?
    - A. 25
    - B. 110
    - C. 465
    - D. 587

<details>
<summary>Afficher la réponse</summary>

1. A
2. A
3. B
4. C
5. B
6. A
7. B
8. D
9. A
10. C
11. B
12. B
13. D
14. C
15. C
16. B
17. A
18. B
19. D
20. B
21. B
22. D
23. C
24. B
25. B
26. C ou D

</details>

### Question 2 (10 points)

Vous avez développé une application Java qui utilise Maven pour la construction
de l'application. Une fois l'application construite, vous obtenez un fichier
`java-intellij-idea-and-maven-1.0-SNAPSHOT.jar` dans la structure de fichier
suivante:

```text
.
├── dependency-reduced-pom.xml
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
│   └── ...
└── target
    ├── java-intellij-idea-and-maven-1.0-SNAPSHOT.jar
    └── ...
```

Lorsque vous exécutez le fichier
`java-intellij-idea-and-maven-1.0-SNAPSHOT.jar`, l'aide suivante est affichée :

```sh
Usage: java-intellij-idea-and-maven-1.0-SNAPSHOT.jar [-hV] <name> [COMMAND]
A small CLI with subcommands to demonstrate picocli.
      <name>      The name of the user (default: World).
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
Commands:
  hello    Print a 'Hello World!' type of message.
  goodbye  Print a 'Goodbye World!' type of message.
```

Vous souhaitez maintenant partager votre application à vos connaissances pour
qu'elles puissent la tester avec l'aide de Docker.

Rédigez le Dockerfile (visible dans la structure de fichiers fournie) qui permet
de construire une image Docker de cette application.

Lorsque le container est lancé il doit exécuter la commande `goodbye` par
défaut.

Vous devez toujours être capable de spécifier au container une des
sous-commandes `hello` ou `goodbye` pour exécuter la commande correspondante.

Donnez ensuite les commandes pour construire l'image Docker et démarrer
l'application (uniquement avec l'aide de Docker, pas Docker Compose).

Vous ne pouvez pas modifier la structure de fichiers fournie (déplacer des
fichiers, renommer des fichiers, etc.).

<details>
<summary>Afficher la réponse</summary>

Fichier `Dockerfile` (6 points) :

```dockerfile
# 1 point 0.5 point commande `FROM` et 0.5 point image de base
FROM eclipse-temurin:21-jre

# 2 points - 1 point commande `COPY`, 0.5 point source et 0.5 point destination
COPY target/java-intellij-idea-and-maven-1.0-SNAPSHOT.jar java-intellij-idea-and-maven-1.0-SNAPSHOT.jar

# 2 points - 1 point commande `ENTRYPOINT`, 0.5 point `java -jar` et 0.5 fichier JAR en argument
ENTRYPOINT ["java", "-jar", "java-intellij-idea-and-maven-1.0-SNAPSHOT.jar"]

# 1 point - 0.5 point commande `CMD` et 0.5 point valeur par défaut
CMD ["goodbye"]
```

```sh
# Construire l'image Docker (2 points - 1 point commande `docker build .` et 1 point tag)
docker build -t java-intellij-idea-and-maven .
```

```sh
# Démarrer l'application (2 points - 1 point commande `docker run` et 1 point tag)
docker run java-intellij-idea-and-maven [hello|goodbye|--help|--version]
```

</details>

### Question 3 (17 points)

Vous travaillez pour la vidéothèque de Lausanne. La vidéothèque souhaite
développer une application réseau permettant à ses utilisateurs d'emprunter et
de rendre des films.

Un utilisateur a la possibilité de consulter des films disponibles par son
titre.

Les films sont identifiés par un identifiant unique et un titre.

L'utilisateur peut emprunter un film ou le rendre en spécifiant l'identifiant de
celui-ci.

Votre objectif est de concevoir le protocole applicatif pour gérer les
interactions entre les utilisateurs et le système de la vidéothèque.

Rédigez un document décrivant le protocole applicatif que vous avez conçu selon
la structure vue en cours.

<details>
<summary>Afficher la réponse</summary>

> [!NOTE]
>
> A nouveau, il s'agit d'une solution possible. D'autres solutions sont
> acceptées mais doivent contenir les éléments décrits dans cette solution.

# Protocole applicatif pour la vidéothèque de Lausanne

## Section 1 - Aperçu (1 point)

_1 point si le protocole applicatif est brièvement décrit pour en comprendre le
but_

Le protocole applicatif pour la vidéothèque de Lausanne permet aux utilisateurs
d'effectuer des recherches de films, d'emprunter des exemplaires disponibles, et
de retourner des films empruntés de la vidéothèque.

## Section 2 - Protocole de transport (5 points)

Le protocole utilise **TCP** (_1 point si le protocol est stipulé_) sur le port
**7122** (_1 point si le port est stipulé_) pour garantir la fiabilité des
communications.

- Encodage des messages : **UTF-8** (_1 point si l'encodage est stipulé_)
- Délimiteur des messages : les messages sont délimités par un caractère de
  nouvelle ligne (**\n**) (_1 point si le délimiteur est stipulé_)

Les messages sont strictement textuels (_0.5 point si la forme des messages est
stipulée_), et les clients initient toutes les communications avec le serveur
(_0.5 point si l'initiation des communications est stipulée_).

## Section 3 - Messages (9 points)

### Rechercher un film

Le client demande au serveur de rechercher un film par son titre. (_0.5 point si
la fonctionnalité est stipulée_)

#### Requête

_1 point si la requête est correctement définie et permet de répondre au cas
d'utilisation_

```text
SEARCH <title>
```

- `<title>` : le titre du film ou une partie du titre.

#### Réponse

_1 point si la réponse est correctement définie et permet de répondre au cas
d'utilisation_

- `RESULT <movie1> <movie2> ... <movieN>` : liste des titres correspondant à la
  recherche.
- `ERROR 1` : aucun film trouvé.

### Emprunter un film

Le client demande au serveur d'emprunter un exemplaire disponible d'un film
identifié par son Id unique. (_0.5 point si la fonctionnalité est stipulée_)

#### Requête

_1 point si la requête est correctement définie et permet de répondre au cas
d'utilisation_

```text
BORROW <movieId>
```

- `<movieId>` : identifiant unique du film.

#### Réponse

_1 point si la réponse est correctement définie et permet de répondre au cas
d'utilisation_

- `OK` : le film a été emprunté avec succès.
- `ERROR 2` : le film n'est pas disponible (exemplaires épuisés).
- `ERROR 3` : le film n'existe pas.

### Retourner un film

Le client informe le serveur qu'il retourne un film emprunté. (_0.5 point si la
fonctionnalité est stipulée_)

#### Requête

1 point si la requête est correctement définie et permet de répondre au cas
d'utilisation

```text
RETURN <movieId>
```

- `<movieId>` : identifiant unique du film.

#### Réponse

_1 point si la réponse est correctement définie et permet de répondre au cas
d'utilisation_

- `OK` : le film a été retourné avec succès.
- `ERROR 3` : le film n'existe pas.

### Message inconnu

Si le serveur reçoit une commande inconnue, il répond par une erreur générique.
(_0.5 point si la fonctionnalité est stipulée_)

#### Réponse

_1 point si la réponse est correctement définie et permet de répondre au cas
d'utilisation_

- `ERROR -1` : commande inconnue.

## Section 4 - Exemples (3 points)

Un exemple fonctionnel de l'utilisation du protocole applicatif (_0.5 point si
un exemple fonctionnel est présent_ et _1 point si l'exemple fonctionnel est
correctement défini et permet de répondre au cas d'utilisation_)

Un exemple non fonctionnel de l'utilisation du protocole applicatif (_0.5 point
si un exemple non fonctionnel est présent_ et _1 point si l'exemple non
fonctionnel est correctement défini et permet de répondre au cas d'utilisation_)

</details>

---

## Partie 2

Implémentez le protocole applicatif suivant avec Java.

Le pseudo-code est accepté mais il doit être clair, précis et démontrer tous les
cas d'utilisation du protocole et appliquer toutes les bonnes pratiques de
programmation réseau.

### Protocole applicatif ping-pong

#### Section 1 - Aperçu

Le protocole applicatif ping-pong permet aux utilisateurs d'envoyer un message
`PING` au serveur qui répondra par un message `PONG` dans le but de tester la
connexion.

Le serveur doit être capable de gérer au moins deux clients simultanément.

#### Section 2 - Protocole de transport

Le protocole utilise **TCP** sur le port **8139** pour garantir la fiabilité des
communications.

- Encodage des messages : **UTF-8**
- Délimiteur des messages : les messages sont délimités par un caractère de
  nouvelle ligne (**`\n`**)

Les messages sont strictement textuels, et les clients initient toutes les
communications avec le serveur.

#### Section 3 - Messages

##### Ping

Le client demande au serveur de répondre par un message `PONG` pour savoir si la
connexion est active.

###### Requête

```text
PING
```

###### Réponse

- `PONG` : le serveur répond à la requête.

##### Message inconnu

Si le serveur reçoit une commande inconnue, il répond par une erreur générique.

###### Réponse

- `ERROR -1` : commande inconnue.

#### Section 4 - Exemples

##### Functional example

![Functional example](./images/example-1-functional.png)

##### Non-functional example

![Non-functional example](./images/example-2-non-functional.png)

<details>
<summary>Afficher la réponse</summary>

```java
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// Total des points : 16
public class PingPongClient {
  private static final String HOST = "localhost";

  private static final int PORT = 8139;

  private static final String END_OF_LINE = "\n";

  public static void main(String[] args) {
    // 1 point pour le bloc try-with-resources
    try (
    // 1 point pour le Socket
    // 1 point pour l'hôte
    // 1 point pour le port
    Socket socket = new Socket(HOST, PORT);
        // 1 point pour le socket.getInputStream()
        // 1 point pour le StandardCharsets.UTF_8
        InputStreamReader isr =
            new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        // 1 point pour le buffer
        BufferedReader in = new BufferedReader(isr);
        // 1 point pour le socket.getOutputStream()
        // 1 point pour le StandardCharsets.UTF_8
        OutputStreamWriter osw =
            new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        // 1 point pour le buffer
        BufferedWriter out = new BufferedWriter(osw)) {
      System.out.println("[Client] Connected to server at " + HOST + ":" + PORT);

      // 1 point pour l'envoi du message à travers le socket
      // 1 point pour le caractère de fin de ligne
      String request = "PING";
      out.write(request + END_OF_LINE);

      // 1 point pour le vidage du tampon
      out.flush();

      // 1 point pour la lecture de la réponse du serveur
      String response = in.readLine();

      // 1 point pour le fait de vérifier si la réponse du serveur est nulle (la connexion s'est terminée du côté du serveur)
      if (response == null) {
        System.out.println("[Client] Server disconnected.");
      } else {
        // 1 point pour l'affichage de la réponse du serveur
        System.out.println("[Client] Response from server: " + response);
      }
    } catch (IOException e) {
      System.err.println("[Client] Error: " + e.getMessage());
    }
  }
}
```

```java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Total des points : 24
public class PingPongServer {
  private static final int PORT = 8139;

  private static final String END_OF_LINE = "\n";

  private static final int NUMBER_OF_THREADS = 2;

  public static void main(String[] args) {
    System.out.println("[Server] Starting...");

    // 1 point pour le bloc try-with-resources
    try (
    // 1 point pour le ServerSocket
    // 1 point pour le port
    ServerSocket serverSocket = new ServerSocket(PORT);
        // 1 point pour une stratégie de gestion de la concurrence
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)) {
      System.out.println("[Server] Listening on port " + PORT);

      // 1 point pour la boucle infinie pour accepter les connexions
      while (!serverSocket.isClosed()) {
        // 1 point pour l'acceptation d'une connexion
        Socket clientSocket = serverSocket.accept();

        // 1 point pour la soumission d'une tâche à l'executor
        executor.submit(new ClientHandler(clientSocket));
      }
    } catch (IOException e) {
      System.err.println("[Server] Exception: " + e.getMessage());
    }
  }

  // 1 point pour la classe ClientHandler
  static class ClientHandler implements Runnable {
    private final Socket socket;

    public ClientHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      // 1 point pour le bloc try-with-resources
      try (
      // 1 point pour le socket dans le try-with-resources
      socket;
          // 1 point pour le socket.getInputStream()
          // 1 point pour le StandardCharsets.UTF_8
          InputStreamReader isr =
              new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
          // 1 point pour le buffer
          BufferedReader in = new BufferedReader(isr);
          // 1 point pour le socket.getOutputStream()
          // 1 point pour le StandardCharsets.UTF_8
          OutputStreamWriter osw =
              new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
          // 1 point pour le buffer
          BufferedWriter out = new BufferedWriter(osw)) {
        System.out.println(
            "[Server] New client connected from "
                + socket.getInetAddress().getHostAddress()
                + ":"
                + socket.getPort());

        // 1 point pour la lecture du message du client
        String request = in.readLine();

        // 1 point pour le fait de vérifier si la requête du client est nulle (la connexion s'est terminée du côté du client)
        if (request == null) {
          System.out.println("[Server] Client disconnected.");
          return;
        } else {
          String response;

          // 1 point pour la vérification du message
          if (request.equalsIgnoreCase("PING")) {
            // 1 point pour la réponse PONG
            response = "PONG";
          } else {
            // 1 point pour la réponse ERROR -1
            response = "ERROR -1";
          }

          // 1 point pour l'envoi du message à travers le socket
          // 1 point pour le caractère de fin de ligne
          out.write(response + END_OF_LINE);

          // 1 point pour le vidage du tampon
          out.flush();
        }
      } catch (IOException e) {
        System.err.println("[Server] Connection error: " + e.getMessage());
      }
    }
  }
}
```

</details>
