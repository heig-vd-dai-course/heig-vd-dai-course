# DAI-TIC-B - Évaluation 2

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
les choix A, B, C ou D.

1. Qu'est-ce qu'une RFC ?
   - A. Une méthode pour traduire des noms de domaines
   - B. Un protocole utilisé pour l'échange de données
   - C. Un document définissant des standards ou des protocoles pour Internet
   - D. Un type spécifique d'adresse IP
2. Pourquoi les ports de 0 à 1023 sont-ils considérés comme "réservés" ?
   - A. Ils sont uniquement utilisés pour les protocoles de messagerie
   - B. Ils sont attribués aux protocoles standards et ne devraient pas être
     utilisés par des applications utilisateur
   - C. Ils ne peuvent être utilisés que par des applications propriétaires
   - D. Ils sont réservés aux tests internes des réseaux
3. À quoi sert l'adresse IP d'un ordinateur connecté à Internet ?
   - A. À sécuriser la communication entre client et serveur
   - B. À identifier de manière unique l'ordinateur sur le réseau
   - C. À convertir un nom de domaine en adresse physique
   - D. À fournir une connexion plus rapide
4. Dans un protocole applicatif, que signifie la notion de "message" ?
   - A. Une commande ou action échangée entre un client et un serveur
   - B. Une séquence d'adresses IP enregistrées dans un DNS
   - C. Un document RFC servant de référence
   - D. Un fichier binaire utilisé pour établir une connexion
5. Pourquoi est-il important de définir les cas d'erreurs dans un protocole
   d'application ?
   - A. Pour éviter les limitations imposées par les ports dynamiques
   - B. Pour assurer que le protocole est compatible avec toutes les versions de
     TCP
   - C. Pour garantir un comportement clair et éviter les ambiguïtés en cas de
     problème
   - D. Pour réduire la taille des messages échangés
6. Quelle est la principale caractéristique de TCP ?
   - A. C'est un protocole orienté connexion
   - B. C'est un protocole sans connexion
   - C. Il fonctionne uniquement en mode multicast
   - D. Il ne garantit pas la livraison des données
7. À quoi sert la méthode `accept()` dans une application serveur TCP en Java ?
   - A. À envoyer des données à un client
   - B. À accepter une nouvelle connexion entrante
   - C. À fermer une connexion existante
   - D. À écouter sur un port spécifique
8. Quelle classe Java est utilisée pour créer un socket côté client ?
   - A. `ServerSocket`
   - B. `ClientSocket`
   - C. `SocketServer`
   - D. `Socket`
9. Pourquoi est-il important de "flusher" le flux de sortie dans une application
   TCP ?
   - A. Pour libérer de la mémoire
   - B. Pour envoyer les données restantes dans le tampon au destinataire
   - C. Pour fermer automatiquement le socket
   - D. Pour garantir la réception des données dans le bon ordre
10. À quoi correspond une boucle REPL dans un serveur TCP ?
    - A. Une boucle utilisée pour tester les connexions des clients
    - B. Une boucle qui permet d'exécuter des commandes successives sans fermer
      la connexion
    - C. Une méthode pour transmettre des données fixes
    - D. Une boucle de validation des ports
11. Quelle est la principale différence entre TCP et UDP ?
    - A. TCP est orienté connexion, UDP est sans connexion.
    - B. TCP est plus rapide qu'UDP.
    - C. UDP garantit l'ordre des messages, TCP non.
    - D. UDP est utilisé uniquement pour les communications locales.
12. Qu'est-ce que la "fire-and-forget pattern" en UDP ?
    - A. Un mécanisme pour assurer la livraison des messages.
    - B. Une méthode pour retransmettre les messages perdus.
    - C. Une technique pour ordonner les messages reçus.
    - D. Une communication où le message est envoyé sans attendre de réponse.
13. Quelle est une limitation des adresses de multicast/broadcast ?
    - A. Elles ne peuvent pas être utilisées sur les réseaux locaux.
    - B. Elles sont limitées aux communications TCP.
    - C. Elles peuvent être bloquées par un pare-feu ou un routeur.
    - D. Elles sont incompatibles avec Java.
14. Quels types de communication sont pris en charge par UDP ?
    - A. Unicast, multicast et broadcast.
    - B. Unicast uniquement.
    - C. Multicast uniquement.
    - D. Broadcast uniquement.
15. Qu'est-ce qu'un broadcast en UDP ?
    - A. Une communication d'un point à un autre.
    - B. Une communication d'un point vers tous les points du réseau.
    - C. Une communication vers un groupe spécifique.
    - D. Une communication sécurisée.
16. Qu'est-ce que la concurrence dans le contexte de la programmation réseau ?
    - A. La capacité d'exécuter du code plus rapidement
    - B. La capacité d'ouvrir plusieurs ports en même temps
    - C. La capacité d'utiliser moins de mémoire
    - D. La capacité de gérer plusieurs clients simultanément
17. Quel est l'avantage principal d'utiliser un pool de threads au lieu d'un
    nombre illimité de threads ?
    - A. Réduction de la latence
    - B. Accélération des opérations réseau
    - C. Limitation de la consommation des ressources système
    - D. Suppression des conflits entre threads
18. Dans une architecture multi-threadée, quel est un risque majeur lié au
    partage de la mémoire entre les threads ?
    - A. Une réduction de la vitesse de traitement
    - B. Une consommation excessive de ports
    - C. Des conditions de concurrence et des incohérences
    - D. Une augmentation de la taille des données transférées
19. Qu'est-ce qui différencie un processus d'un thread ?
    - A. Les processus partagent la mémoire, contrairement aux threads
    - B. Les processus sont utilisés uniquement pour la communication réseau
    - C. Les threads ont besoin d'un coeur (core) dédié pour fonctionner
    - D. Les threads sont moins coûteux en ressources que les processus
20. Comment un serveur multi-threadé peut-il éviter les conditions de
    concurrence lorsqu'il partage des ressources entre clients ?
    - A. En utilisant des structures adaptées pour les threads accédant aux
      ressources partagées
    - B. En utilisant des connexions UDP
    - C. En limitant le nombre de connexions simultanées
    - D. En utilisant un protocole propriétaire
21. Quel est le rôle principal du protocole SMTP ?
    - A. Récupérer les emails d'un serveur
    - B. Envoyer des emails à un serveur
    - C. Synchroniser les emails entre plusieurs clients
    - D. Stocker les emails sur un serveur
22. Quelle est la différence principale entre les protocoles POP3 et IMAP ?
    - A. POP3 permet de synchroniser les emails, tandis qu'IMAP ne le permet pas
    - B. IMAP synchronise les emails entre le serveur et les clients, tandis que
      POP3 les télécharge uniquement
    - C. POP3 est utilisé pour envoyer des emails, tandis qu'IMAP est utilisé
      pour les recevoir
    - D. IMAP est plus rapide que POP3 pour récupérer les emails
23. Quel est l'objectif principal d'utiliser un serveur SMTP factice comme
    Mailpit ?
    - A. Simuler l'envoi d'emails pour des tests sans risquer de provoquer des
      problèmes réels
    - B. Envoyer des emails en production de manière sécurisée
    - C. Recevoir des emails pour une boîte mail personnelle
    - D. Configurer un serveur pour des campagnes de spam
24. Lors d'une communication SMTP, quelle commande est utilisée pour spécifier
    le contenu de l'email ?
    - A. `MAIL FROM`
    - B. `RCPT TO`
    - C. `DATA`
    - D. `HELO`
25. Pourquoi le protocole SMTP peut-il être vulnérable aux abus, comme le spam ?
    - A. Parce qu'il ne nécessite pas de chiffrement ni d'authentification
      obligatoire
    - B. Parce qu'il exige l'utilisation de ports non sécurisés
    - C. Parce qu'il synchronise automatiquement les emails entre serveurs
    - D. Parce qu'il limite le nombre d'expéditeurs autorisés
26. Quel port est recommandé pour une connexion SMTP sécurisée ?
    - A. 25
    - B. 110
    - C. 465
    - D. 587

<details>
<summary>Afficher la réponse</summary>

1. C
2. B
3. B
4. A
5. C
6. A
7. B
8. D
9. B
10. B
11. A
12. D
13. C
14. A
15. B
16. D
17. C
18. C
19. D
20. A
21. B
22. B
23. A
24. C
25. A
26. C ou D

</details>

### Question 2 (10 points)

Vous avez développé une application Java qui utilise Maven pour la construction
de l'application. Une fois l'application construite, vous obtenez un fichier
`java-intellij-idea-and-maven-1.0-SNAPSHOT.jar` dans la structure de fichiers
suivante :

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

Lorsque le container est lancé il doit exécuter la commande `hello` par défaut.

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
CMD ["hello"]
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

Vous travaillez pour la bibliothèque municipale de Lausanne. La bibliothèque
souhaite développer une application réseau permettant à ses utilisateurs
d'emprunter et de rendre des livres.

Un utilisateur a la possibilité de consulter les livres disponibles par son
titre.

Les livres sont identifiés par un identifiant unique et un titre.

L'utilisateur peut emprunter un livre ou le rendre en spécifiant l'identifiant
de celui-ci.

Votre objectif est de concevoir le protocole applicatif pour gérer les
interactions entre les utilisateurs et le système de la bibliothèque.

Rédigez un document décrivant le protocole applicatif que vous avez conçu selon
la structure vue en cours.

<details>
<summary>Afficher la réponse</summary>

> [!NOTE]
>
> A nouveau, il s'agit d'une solution possible. D'autres solutions sont
> acceptées mais doivent contenir les éléments décrits dans cette solution.

# Protocole applicatif pour la bibliothèque municipale de Lausanne

## Section 1 - Aperçu (1 point)

_1 point si le protocole applicatif est brièvement décrit pour en comprendre le
but_

Le protocole applicatif pour la bibliothèque municipale de Lausanne permet aux
utilisateurs d'effectuer des recherches de livres, d'emprunter des exemplaires
disponibles, et de retourner des livres empruntés de la bibliothèque.

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

### Rechercher un livre

Le client demande au serveur de rechercher un livre par son titre. (_0.5 point
si la fonctionnalité est stipulée_)

#### Requête

_1 point si la requête est correctement définie et permet de répondre au cas
d'utilisation_

```text
SEARCH <title>
```

- `<title>` : le titre du livre ou une partie du titre.

#### Réponse

_1 point si la réponse est correctement définie_

- `RESULT <book1> <book2> ... <bookN>` : liste des titres correspondant à la
  recherche.
- `ERROR 1` : aucun livre trouvé.

### Emprunter un livre

Le client demande au serveur d'emprunter un exemplaire disponible d'un livre
identifié par son Id unique.(_0.5 point si la fonctionnalité est stipulée_)

#### Requête

_1 point si la requête est correctement définie et permet de répondre au cas
d'utilisation_

```text
BORROW <bookId>
```

- `<bookId>` : identifiant unique du livre.

#### Réponse

_1 point si la réponse est correctement définie_

- `OK` : le livre a été emprunté avec succès.
- `ERROR 2` : le livre n'est pas disponible (exemplaires épuisés).
- `ERROR 3` : le livre n'existe pas.

### Retourner un livre

Le client informe le serveur qu'il retourne un livre emprunté. (_0.5 point si la
fonctionnalité est stipulée_)

#### Requête

_1 point si la requête est correctement définie et permet de répondre au cas
d'utilisation_

```text
RETURN <bookId>
```

- `<bookId>` : identifiant unique du livre.

#### Réponse

_1 point si la réponse est correctement définie_

- `OK` : le livre a été retourné avec succès.
- `ERROR 3` : le livre n'existe pas.

### Message inconnu

Si le serveur reçoit une commande inconnue, il répond par une erreur générique.
(_0.5 point si la fonctionnalité est stipulée_)

#### Réponse

_1 point si la réponse est correctement définie_

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

_Le pseudo-code est accepté mais il doit être clair, précis et démontrer tous
les cas d'utilisation du protocole et appliquer toutes les bonnes pratiques de
programmation réseau._

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
