# DAI-TIC-C - Evaluation 2

Cette évaluation porte sur les notions suivantes :

- Docker and Docker Compose
- SSH and SCP
- HTTP and curl
- Web infrastructures
- Caching and performance

Vous pouvez répondre aux questions en français ou en anglais.

L'évaluation dure 1h30 (90 minutes). Une fois que vous avez terminé, veuillez
marquer votre évaluation comme terminée.

Validez avec le corps enseignant que le système a bien enregistré votre
évaluation. Vous pourrez ensuite quitter la salle de façon silencieuse.

Ressources autorisées :

- Deux (2) feuilles recto-verso (soit quatre (4) pages recto) papier avec vos
  propres notes.

Toute tentative de tricherie sera sanctionnée avec la note 1.

## Question 1 (10 points)

Vous avez été mandaté.e pour créer et déployer une application web avec son
infrastructure web associée.

Cette application web a pour but de servir des données météorologiques
(uniquement la température pour le moment) de différentes villes à des fins de
statistiques. Plusieurs centaines d'utilisateur.trices peuvent accéder à
l'application simultanément, et les statistiques peuvent changer de minutes en
minutes. Les données sont publiques.

En tant que spécialiste, répondez aux questions suivantes :

1. Citez et expliquez au moins trois (3) besoins non-fonctionnels importants
   pour cette application web.
2. Proposez une API pour gérer les données météorologiques, en précisant les
   endpoints, les méthodes HTTP utilisées, les types de données échangées, et
   les codes (ou messages) de retour attendus.
3. Expliquez comment vous assureriez la performance et la scalabilité de cette
   infrastructure web.
4. Décrivez si et comment vous utiliseriez un système de cache pour améliorer la
   performance de l'application, en précisant quel type de cache vous
   recommanderiez, à quel niveau, et pourquoi.
5. Si vous utilisez un système de cache, indiquez le modèle adopté ainsi qu'une
   explication de son fonctionnement.

Vos réponses doivent être détaillées et justifiées.

<details>
<summary>Afficher la réponse</summary>

1. Besoins non-fonctionnels importants :
   - **Scalabilité** : l'application doit pouvoir gérer un grand nombre
     d'utilisateurs simultanés sans dégradation des performances.
   - **Performance** : les temps de réponse doivent être rapides, surtout
     lorsque les utilisateurs demandent des statistiques météorologiques.
   - **Disponibilité** : l'application doit être disponible 24/7, avec un temps
     d'arrêt minimal.
   - Etc.
2. Proposition d'API :
   - `GET /weather` : Récupère les données météorologiques.
     - Méthode HTTP : GET
     - Type de données échangées : JSON
     - Codes de retour : 200 (OK)
   - `GET /weather/{city-id}` : Récupère les données météorologiques pour une
     ville spécifique.
     - Méthode HTTP : GET
     - Type de données échangées : JSON
     - Codes de retour : 200 (OK), 404 (Not Found)
   - `POST /weather` : Ajoute une donnée météorologique pour une ville.
     - Méthode HTTP : POST
     - Type de données échangées : JSON
     - Codes de retour : 201 (Created), 400 (Bad Request)
   - `PATCH /weather/{id}` : Met à jour une donnée météorologique existante.
     - Méthode HTTP : PATCH
     - Type de données échangées : JSON
     - Codes de retour : 200 (OK), 404 (Not Found)
   - `DELETE /weather/{id}` : Supprime une donnée météorologique.
     - Méthode HTTP : DELETE
     - Codes de retour : 204 (No Content), 404 (Not Found)
3. Performance et scalabilité :
   - Mise en place de mécanismes de mise en cache pour réduire la charge sur la
     base de données et améliorer les temps de réponse.
   - Utilisation de techniques de montée en charge (horizontale ou verticale)
     pour assurer la scalabilité.
   - Surveillance continue des performances et ajustement de l'infrastructure en
     conséquence.
   - Etc.
4. Utilisation d'un système de cache :
   - Recommandation d'utiliser un cache de type mémoire pour stocker les données
     météorologiques fréquemment consultées.
   - Le cache serait placé entre l'application web et la base de données pour
     réduire le nombre de requêtes directes à la base de données.
   - Cela améliorerait la performance en réduisant la latence et en diminuant la
     charge sur la base de données.
5. Modèle de cache adopté :
   - Utilisation du modèle de cache HTTP basé sur la validation à l'aide d'un
     entête `Last-Modified` ou `ETag`.
   - Lorsqu'une donnée météorologique est demandée par un client pour la
     première fois, une requête est envoyée à l'application web.
   - La donnée est récupérée depuis la base de données, stockée dans le cache
     avec un timestamp ou un identifiant unique (ETag), et renvoyée au client
     avec l'entête `Last-Modified` ou `ETag`.
   - Le client stocke cette information pour les futures requêtes.
   - Lors d'un prochain appel de la même donnée, le client envoie une requête
     avec l'entête `If-Modified-Since` ou `If-None-Match` pour demander au
     serveur si la donnée a été modifiée depuis la dernière récupération.
   - Si la donnée n'est plus valide (c'est-à-dire qu'elle n'est plus dans le
     cache ou qu'elle a été modifiée), l'application récupère la donnée depuis
     la base de données, la stocke dans le cache, et la renvoie à l'utilisateur
     avec les entêtes `Last-Modified` ou `ETag`.
   - Si la donnée est toujours valide, le serveur renvoie une réponse
     `304 Not Modified`, indiquant au client d'utiliser la donnée stockée dans
     son cache. Les échanges de données et les interactions avec la base de
     données sont ainsi minimisés, améliorant la performance globale de
     l'application.

Note pour la correction : les données échangées dans l'API peuvent être plus
complètes (par exemple la description complète de l'objet JSON), mais
l'essentiel est de montrer la compréhension des concepts.

</details>

## Question 2 (4 points)

Dans un contexte de répartition de charge (_"load balancing"_), expliquez le
fonctionnement de la méthode de répartition de charge dite "round-robin".

Voyez-vous un problème potentiel avec cette méthode dans le cas d'une
application web qui gère des sessions utilisateurs ? Justifiez votre réponse. Il
n'est pas nécessaire de proposer une solution.

<details>
<summary>Afficher la réponse</summary>

La méthode de répartition de charge "round-robin" fonctionne en distribuant les
requêtes entrantes de manière cyclique et équitable entre un ensemble de
serveurs ou d'instances d'application. Chaque nouvelle requête est envoyée au
serveur suivant dans la liste, et une fois que le dernier serveur a été atteint,
le cycle recommence à partir du premier serveur.

Un problème potentiel avec la méthode "round-robin" dans le cas d'une
application web qui gère des sessions utilisateurs est qu'elle ne prend pas en
compte l'état de la session. Si un utilisateur établit une session sur un
serveur spécifique, mais que les requêtes suivantes sont dirigées vers un autre
serveur en raison de la répartition "round-robin", l'utilisateur pourrait perdre
son état de session. Cela peut entraîner des problèmes tels que la nécessité de
se reconnecter ou la perte de données temporaires associées à la session.

</details>

## Question 3 (8 points)

Vous souhaitez déployer plusieurs applications web derrière un même nom de
domaine avec des sous-domaines différents (par exemple, `app1.mondomaine.com` et
`app2.mondomaine.com`).

Répondez aux questions suivantes :

1. Quelle technologie ou outil principal avez-vous utilisé sur votre serveur
   (machine virtuelle) que vous avez acquis sur Azure ?
2. Expliquez brièvement son rôle dans une infrastructure web.
3. Comment utilise-t-il l'entête HTTP "Host" pour accomplir cette tâche ?
4. Expliquez comment vous avez utilisé Docker et Docker Compose pour déployer
   ces applications web derrière ce même nom de domaine.

<details>
<summary>Afficher la réponse</summary>

1. Le principal outil utilisé sur le serveur (machine virtuelle) Azure pour
   déployer plusieurs applications web derrière un même nom de domaine est un
   reverse-proxy, tel que Traefik, Nginx ou Apache HTTP Server.
2. Le rôle d'un reverse-proxy dans une infrastructure web est de recevoir les
   requêtes des clients et de les acheminer vers les différentes applications
   web hébergées sur le serveur, en fonction de critères tels que le nom de
   domaine, le chemin d'URL ou d'autres règles de routage. Le reverse-proxy agit
   comme un intermédiaire entre les clients et les applications web, permettant
   ainsi de gérer efficacement le trafic, d'améliorer la sécurité et de
   simplifier la configuration des applications.
3. Le reverse-proxy utilise l'entête HTTP "Host" pour déterminer à quelle
   application web acheminer la requête. Lorsque le client envoie une requête
   HTTP, il inclut l'entête "Host" qui spécifie le nom de domaine demandé. Le
   reverse-proxy lit cette information et utilise des règles de routage
   préconfigurées pour diriger la requête vers l'application web appropriée en
   fonction du nom de domaine spécifié dans l'entête "Host".
4. Pour déployer plusieurs applications web derrière un même nom de domaine en
   utilisant Docker et Docker Compose avec un reverse-proxy, par exemple
   Traefik, à l'aide d'un fichier `compose.yml`.

   Puis chaque application web est définie et déployée à l'aide de fichiers
   `compose.yml` séparés, en configurant chaque application pour qu'elle utilise
   le réseau Docker du reverse-proxy et en ajoutant des labels spécifiques à
   Traefik pour définir les règles de routage basées sur le nom de domaine.

</details>

## Question 4 (2 points)

Expliquez ce qu'est la montée en charge verticale (_scale up_) et donnez un
exemple concret de situation où elle serait appropriée.

<details>
<summary>Afficher la réponse</summary>

La montée en charge verticale (_scaling up_) consiste à augmenter les ressources
d'un seul serveur ou d'une seule instance d'application pour améliorer ses
performances. Cela peut inclure l'ajout de CPU, de mémoire RAM, de stockage ou
d'autres ressources matérielles.

Un exemple concret où la montée en charge verticale serait appropriée est
lorsqu'une application nécessite plus de mémoire pour gérer des charges de
travail intensives en données, comme une base de données qui doit traiter de
grandes quantités d'informations. **Mais cela n'est possible que si le serveur
physique ou la machine virtuelle le permet (qu'il est possible d'ajouter des
ressources)**. Si le serveur est déjà à ses limites matérielles, il sera
nécessaire de trouver une solution alternative.

</details>

## Question 5 (4 points)

Quel outil peut-on utiliser pour copier des fichiers entre une machine locale et
un serveur distant via SSH ?

Donnez ensuite un exemple de commande pour copier un fichier local vers un
serveur distant.

<details>
<summary>Afficher la réponse</summary>

On peut utiliser l'outil `scp` (Secure Copy) pour copier des fichiers entre une
machine locale et un serveur distant via SSH.

Exemple de commande pour copier un fichier local vers un serveur distant :

```bash
scp /chemin/fichier/local.txt <utilisateur>@<adresse IP du serveur>:/chemin/fichier/distant.txt
```

</details>

## Question 6 (4 points)

Expliquez les étapes que vous avez entrepris pour être capable d'accéder à votre
serveur (machine virtuelle) distant sur Azure via SSH.

Donnez ensuite la commande SSH que vous utilisez pour vous connecter à ce
serveur.

<details>
<summary>Afficher la réponse</summary>

Pour accéder à un serveur distant via SSH, les étapes suivantes sont
généralement entreprises :

1. Génération d'une paire de clés SSH : Utilisation d'un outil comme
   `ssh-keygen` pour créer une paire de clés publique/privée sur la machine
   locale.
2. Ajout de la clé publique au serveur distant (lors de la création de la
   machine virtuelle sur Azure, on peut spécifier la clé publique par exemple).
3. Configuration du client SSH pour utiliser la clé privée lors de la connexion
   au serveur distant si nécessaire.
4. Utilisation de la commande SSH pour se connecter au serveur distant en
   spécifiant l'adresse IP ou le nom de domaine du serveur, ainsi que le nom
   d'utilisateur.

Exemple de commande SSH pour se connecter à un serveur distant :

```bash
ssh -i /chemin/clé/privée <utilisateur>@<adresse IP du serveur>
```

</details>

## Question 7 (6 points)

Soit le bout de code Java suivant :

```java
  public void create(Context ctx) {
    User newUser =
        ctx.bodyValidator(User.class)
            .check(obj -> obj.firstName() != null, "Missing first name")
            .check(obj -> obj.lastName() != null, "Missing last name")
            .check(obj -> obj.email() != null, "Missing email")
            .check(obj -> obj.password() != null, "Missing password")
            .get();

    for (User user : users.values()) {
      if (newUser.email().equalsIgnoreCase(user.email())) {
        throw new ConflictResponse();
      }
    }

    newUser =
        new User(
            uniqueId.getAndIncrement(),
            newUser.firstName(),
            newUser.lastName(),
            newUser.email(),
            newUser.password());

    users.put(newUser.id(), newUser);

    ctx.status(HttpStatus.CREATED);
    ctx.json(newUser);
  }
```

Répondez aux questions suivantes :

- Décrivez brièvement le but de ce code.
- Le type de requête HTTP associée à ce code.
- Les différents scénarios de traitement possibles avec leurs code (ou message)
  de retour HTTP associés.

<details>
<summary>Afficher la réponse</summary>

1. Ce code Java définit une méthode `create` qui gère la création d'un nouvel
   utilisateur dans une application web.
2. Type de requête HTTP : Ce code est associé à une requête HTTP de type `POST`,
   qui est utilisée pour créer une nouvelle ressource sur le serveur (dans ce
   cas, un utilisateur).
3. Scénarios de traitement possibles :
   - Si les données de l'utilisateur sont valides et qu'aucun utilisateur avec
     le même e-mail n'existe déjà, un nouvel utilisateur est créé, stocké dans
     la collection `users`, et une réponse avec le code HTTP `201 Created` est
     renvoyée avec les détails de l'utilisateur créé.
   - Si les données de l'utilisateur sont invalides (par exemple, si le prénom,
     le nom de famille, l'e-mail ou le mot de passe sont manquants), une
     exception `BadRequestResponse` est levée, ce qui correspond à un code de
     retour HTTP `400 Bad Request`.
   - Si un utilisateur avec le même e-mail existe déjà dans la collection
     `users`, une exception `ConflictResponse` est levée, ce qui correspond à un
     code de retour HTTP `409 Conflict`.

</details>

## Question 8 (4 points)

Qu'est-ce qu'un entête HTTP (_"HTTP header"_) et à quoi sert-il ?

Donnez deux (2) exemples d'entêtes HTTP couramment utilisés avec leur
description.

<details>
<summary>Afficher la réponse</summary>

Un entête HTTP (HTTP header) est une partie de la requête ou de la réponse HTTP
qui contient des informations supplémentaires sur la requête ou la réponse. Les
entêtes HTTP sont utilisés pour transmettre des métadonnées, telles que le type
de contenu, les informations d'authentification, les préférences de langue, etc.

Exemples d'entêtes HTTP couramment utilisés :

- `Content-Type` : indique le type de contenu de la ressource (par exemple,
  `text/html`, `application/json`).
- `Content-Length` : indique la taille du corps de la requête ou de la réponse
  en octets.
- Etc.

</details>

## Question 9 (5 points)

Le protocole HTTP définit 5 méthodes principales :

- `GET`.
- `POST`.
- `PUT`.
- `PATCH`.
- `DELETE`.

Pour chacune des méthodes :

- Décrivez à quoi elle sert.
- Donnez un exemple concret d'utilisation.

<details>
<summary>Afficher la réponse</summary>

- `GET` : récupérer une ressource depuis le serveur.
  - Exemple : récupérer la page d'accueil d'un site web.
- `POST` : envoyer des données au serveur pour créer une nouvelle ressource.
  - Exemple : créer un nouvel utilisateur.
- `PUT` : mettre à jour une ressource existante en remplaçant entièrement son
  contenu.
  - Exemple : mettre à jour les informations d'un profil utilisateur.
- `PATCH` : mettre à jour partiellement une ressource existante.
  - Exemple : mettre à jour uniquement l'adresse e-mail d'un utilisateur.
- `DELETE` : supprimer une ressource du serveur.
  - Exemple : supprimer un article de blog.

Note pour la correction : les explications pour les méthodes `PUT` et `PATCH`
peuvent être les mêmes.

</details>

## Question 10 (4 points)

Soit l'URL suivante : `http://20.204.68.32/liste-des-utilisateurs?age=39`

Identifiez et décrivez les quatre (4) parties principales de cette URL.

<details>
<summary>Afficher la réponse</summary>

L'URL `http://20.204.68.32/liste-des-utilisateurs?age=39` se compose des parties
suivantes :

- `http://` : le schéma (ou protocole) utilisé pour accéder à la ressource, ici
  HTTP (HyperText Transfer Protocol).
- `20.204.68.32` : l'adresse IP (ou hôte) qui identifie le serveur où la
  ressource est hébergée.
- `/liste-des-utilisateurs` : le chemin d'accès à la ressource sur le serveur,
  ici une ressource liste des utilisateurs.
- `?age=39` : la chaîne de requête (query string) qui contient des paramètres
  supplémentaires pour la requête, ici un paramètre `age` avec la valeur `39`.

</details>

## Question 11 (2 points)

HTTP parle de notion de "ressource". Expliquez ce qu'est une ressource dans le
contexte du protocole HTTP.

<details>
<summary>Afficher la réponse</summary>

Une ressource dans le contexte du protocole HTTP est une entité identifiable sur
le web, telle qu'une page web, une image, un fichier ou tout autre type de
donnée. Chaque ressource est accessible via une URL (Uniform Resource Locator),
qui spécifie son emplacement sur le serveur.

</details>
