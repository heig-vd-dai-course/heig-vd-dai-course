# DAI-TIC-A - Evaluation 2

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

---

## Question 1 (10 points)

Vous avez été mandaté.e pour créer et déployer une application web avec son
infrastructure web associée.

Cette application web a pour but de servir des images satellite à des
utilisateur.trices du monde entier. Plusieurs centaines d'utilisateur.trices
peuvent accéder à l'application simultanément, et les images doivent être
servies rapidement pour une bonne expérience de navigation. Les données sont
publiques.

En tant que spécialiste, répondez aux questions suivantes :

1. Citez et expliquez au moins trois (3) besoins non-fonctionnels importants
   pour cette application web.
2. Proposez une API pour gérer les images satellite, en précisant les endpoints,
   les méthodes HTTP utilisées, les types de données échangées, et les codes (ou
   message) de retour attendus.
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
   - `GET /images` : Récupérer une liste d'images satellite.
     - Méthode HTTP : GET
     - Type de données : JSON
     - Codes de retour : 200 (OK)
   - `GET /images/{id}` : Récupérer une image satellite spécifique par ID.
     - Méthode HTTP : GET
     - Type de données : Image (JPEG/PNG)
     - Codes de retour : 200 (OK), 404 (Not Found)
   - `POST /images` : Ajouter une nouvelle image satellite.
     - Méthode HTTP : POST
     - Type de données : Multipart/form-data
     - Codes de retour : 201 (Created), 400 (Bad Request)
   - `PATCH /images/{id}` : Mettre à jour les métadonnées d'une image satellite.
     - Méthode HTTP : PATCH
     - Type de données : JSON
     - Codes de retour : 200 (OK), 404 (Not Found)
   - `DELETE /images/{id}` : Supprimer une image satellite par ID.
     - Méthode HTTP : DELETE
     - Codes de retour : 204 (No Content), 404 (Not Found)
3. Pour assurer la performance et la scalabilité :
   - Mise en place de mécanismes de mise en cache pour réduire la charge sur la
     base de données et améliorer les temps de réponse.
   - Utilisation de techniques de montée en charge (horizontale ou verticale)
     pour assurer la scalabilité.
   - Surveillance continue des performances et ajustement de l'infrastructure en
     conséquence.
   - Etc.
4. Utilisation d'un système de cache :
   - Deux solutions envisagées : cache au niveau de l'application et cache
     distribué avec un CDN.
   - Cache au niveau de l'application :
     - Utilisation d'un cache en mémoire pour stocker les images satellite
       fréquemment demandées. Cela permet de réduire le temps de récupération
       des images et de diminuer la charge sur la base de données.
   - Cache distribué de type CDN (Content Delivery Network) :
     - Utilisation d'un CDN pour stocker et distribuer les images satellite.
       Cela permet de rapprocher les images des utilisateurs finaux, réduisant
       ainsi la latence et améliorant la performance.
5. Stratégie de cache :
   - Utilisation du modèle de cache HTTP basé sur l'expiration à l'aide d'un
     entête `Cache-Control: max-age=<nombre de secondes>`.
   - Lorsqu'une image satellite est demandée par un client pour la première
     fois, une requête est envoyée à l'application web.
   - L'image est retournée au client avec l'entête `Cache-Control` spécifiant la
     durée pendant laquelle l'image peut être mise en cache.
   - Pour les requêtes ultérieures pour la même image, si l'image est encore
     valide dans le cache (c'est-à-dire que le temps spécifié dans `max-age` n'a
     pas expiré), le client peut utiliser l'image mise en cache sans avoir à
     refaire une requête au serveur.
   - Si l'image a expiré, le client doit refaire une requête au serveur pour
     obtenir une version mise à jour de l'image.

Note pour la correction : les données échangées dans l'API peuvent être plus
complètes (par exemple la description complète de l'objet JSON), mais
l'essentiel est de montrer la compréhension des concepts.

Aussi, le modèle par validation est aussi valide dans le point 5.

</details>

## Question 2 (4 points)

Dans un contexte de répartition de charge (_"load balancing"_), expliquez le
fonctionnement de la méthode de répartition de charge dite "sticky-session".

Grâce à quel mécanisme technique cette méthode peut-elle être mise en œuvre ?

<details>
<summary>Afficher la réponse</summary>

La méthode de répartition de charge "sticky-session" fonctionne en associant
chaque utilisateur à un serveur spécifique pour la durée de sa session. Ainsi,
toutes les requêtes d'un même utilisateur sont dirigées vers le même serveur, ce
qui permet de maintenir l'état de la session.

Ce mécanisme peut être mis en œuvre grâce à l'utilisation de cookies ou d'autres
identifiants de session qui permettent au répartiteur de charge de reconnaître
et de diriger les requêtes vers le serveur approprié.

</details>

## Question 3 (2 points)

Expliquez ce qu'est la montée en charge horizontale (_"scale out"_) et donnez un
exemple concret de situation où elle serait appropriée.

<details>
<summary>Afficher la réponse</summary>

La montée en charge horizontale (_"scale out"_) consiste à ajouter davantage
d'instances de serveurs ou de ressources pour gérer une augmentation de la
charge de travail.

Un exemple concret où la montée en charge horizontale serait appropriée est
lorsqu'une application web connaît une augmentation soudaine du trafic, par
exemple lors d'une promotion ou d'un événement spécial et qu'il n'est plus
possible d'améliorer les capacités matérielles d'un seul serveur. En ajoutant
plus d'instances de serveurs pour héberger l'application, on peut répartir la
charge de travail entre ces instances, améliorant ainsi la performance et la
disponibilité de l'application pour les utilisateurs.

</details>

## Question 4 (8 points)

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

1. Le principal outil utilisé pour déployer plusieurs applications web derrière
   un même nom de domaine est un reverse-proxy, tel que Traefik, Nginx ou Apache
   HTTP Server.
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

## Question 5 (4 points)

Quel outil peut-on utiliser pour copier des fichiers entre un serveur distant et
une machine locale via SSH ?

Donnez ensuite un exemple de commande pour copier un fichier du serveur distant
vers la machine locale.

<details>
<summary>Afficher la réponse</summary>

On peut utiliser l'outil `scp` (Secure Copy) pour copier des fichiers entre une
machine locale et un serveur distant via SSH.

Exemple de commande pour copier un fichier du serveur distant vers la machine
locale :

```bash
scp ubuntu@<adresse IP du serveur>:/path/to/remote/file /path/to/local/directory/
```

</details>

## Question 6 (4 points)

Pour vous connecter à votre serveur (machine virtuelle) que vous avez acquis sur
Azure, vous utilisez la commande SSH suivante :

```bash
ssh ubuntu@<adresse IP du serveur>
```

Pour permettre au corps enseignant de faire de même, de quoi avez-vous besoin et
pourquoi ?

Expliquez ensuite les étapes que vous avez entrepris pour permettre au corps
enseignant de se connecter à votre serveur via SSH.

<details>
<summary>Afficher la réponse</summary>

Pour permettre au corps enseignant de se connecter au serveur via SSH, il est
nécessaire d'avoir la clé publique SSH du corps enseignant pour les autoriser à
accéder au serveur.

Il faut suivre les étapes suivantes :

1. Ajouter la clé publique SSH du corps enseignant au fichier
   `~/.ssh/authorized_keys` sur le serveur distant. Cela permet au corps
   enseignant de s'authentifier et d'accéder au serveur via SSH.
2. Informer le corps enseignant de l'adresse IP du serveur et du nom
   d'utilisateur à utiliser pour la connexion SSH.

</details>

## Question 7 (6 points)

Soit le bout de code Java suivant :

```java
 public void update(Context ctx) {
    Integer id = ctx.pathParamAsClass("id", Integer.class).get();

    if (!users.containsKey(id)) {
      throw new NotFoundResponse();
    }

    User updateUser =
        ctx.bodyValidator(User.class)
            .check(obj -> obj.firstName() != null, "Missing first name")
            .check(obj -> obj.lastName() != null, "Missing last name")
            .check(obj -> obj.email() != null, "Missing email")
            .check(obj -> obj.password() != null, "Missing password")
            .get();

    for (User user : users.values()) {
      if (updateUser.email().equalsIgnoreCase(user.email())) {
        throw new ConflictResponse();
      }
    }

    users.put(id, updateUser);

    ctx.status(HttpStatus.OK);
    ctx.json(updateUser);
  }
```

Répondez aux questions suivantes :

- Décrivez brièvement le but de ce code.
- Le type de requête HTTP associée à ce code.
- Les différents scénarios de traitement possibles avec leurs code (ou message)
  de retour HTTP associés.

<details>
<summary>Afficher la réponse</summary>

1. Ce code Java définit une méthode `update` qui gère la mise à jour d'un
   utilisateur existant dans une application web.
2. Type de requête HTTP : Ce code est associé à une requête HTTP de type `PUT`
   ou `PATCH`, qui est utilisée pour mettre à jour une ressource existante sur
   le serveur (dans ce cas, un utilisateur).
3. Scénarios de traitement possibles :
   - Si l'utilisateur avec l'ID spécifié n'existe pas dans la collection
     `users`, une exception `NotFoundResponse` est levée, ce qui correspond à un
     code de retour HTTP `404 Not Found`.
   - Si les données fournies dans le corps de la requête ne contiennent pas
     certains champs obligatoires (prénom, nom, email, mot de passe), une
     exception `BadRequestResponse` est levée avec un message d'erreur
     approprié, ce qui correspond à un code de retour HTTP `400 Bad Request`.
   - Si l'email fourni dans les données de mise à jour existe déjà pour un autre
     utilisateur, une exception `ConflictResponse` est levée, ce qui correspond
     à un code de retour HTTP `409 Conflict`.
   - Si toutes les validations passent, l'utilisateur est mis à jour dans la
     collection `users`, et une réponse HTTP avec le code `200 OK` est renvoyée,
     accompagnée des données JSON de l'utilisateur mis à jour.

</details>

## Question 8 (4 points)

Une réponse HTTP contient les éléments suivants :

```text
Content-Type: application/json
Content-Length: 85
```

Où retrouve-t-on ces deux (2) éléments dans le contexte d'une réponse HTTP et à
quoi servent-ils ?

Expliquez le but de chacun de ces deux éléments.

<details>
<summary>Afficher la réponse</summary>

Ces deux éléments sont des entêtes HTTP (_"HTTP headers"_) qui fournissent des
informations supplémentaires sur la réponse HTTP.

- `Content-Type` : Indique le type de contenu de la ressource renvoyée par le
  serveur. Dans cet exemple, `application/json` signifie que le corps de la
  réponse contient des données au format JSON (JavaScript Object Notation). Cela
  permet au client de savoir comment interpréter et traiter les données reçues.
- `Content-Length` : Indique la taille du corps de la réponse en octets. Dans
  cet exemple, `85` signifie que le corps de la réponse fait 85 octets. Cela
  permet au client de savoir combien de données il doit s'attendre à recevoir,
  ce qui est utile pour la gestion du téléchargement et de la mémoire.

</details>

## Question 9 (5 points)

Le protocole HTTP définit 5 groupes de codes de retour:

- `1xx`.
- `2xx`.
- `3xx`.
- `4xx`.
- `5xx`.

Pour chacun des groupes :

- Décrivez à quoi correspondent-ils ?
- Donnez un exemple de code de retour et la signification de ce code.

<details>
<summary>Afficher la réponse</summary>

- `1xx` : Informations - La requête a été reçue et le processus continue.
  - Exemple : `101 Switching Protocols` - Le serveur comprend et accepte de
    changer de protocole selon la demande du client.
- `2xx` : Succès - La requête a été reçue, comprise et acceptée.
  - Exemple : `201 Created` - La requête a été accomplie et a conduit à la
    création d'une nouvelle ressource.
- `3xx` : Redirection - Des actions supplémentaires sont nécessaires pour
  compléter la requête.
  - Exemple : `304 Not Modified` - La ressource demandée n'a pas été modifiée
    depuis la dernière requête.
- `4xx` : Erreurs client - La requête contient une mauvaise syntaxe ou ne peut
  pas être satisfaite.
  - Exemple : `404 Not Found` - La ressource demandée n'a pas été trouvée sur le
    serveur.
- `5xx` : Erreurs serveur - Le serveur a échoué à traiter une requête
  apparemment valide.
  - Exemple : `500 Internal Server Error` - Le serveur a rencontré une condition
    inattendue qui l'a empêché de satisfaire la requête.

</details>

## Question 10 (4 points)

Soit la ressource suivante : `http://184.158.24.26/liste-des-animaux?age=5`

Identifiez et décrivez les quatre (4) parties principales de cette ressource.

<details>
<summary>Afficher la réponse</summary>

La ressource `http://184.158.24.26/liste-des-animaux?age=5` se compose des
parties suivantes :

- `http://` : Le schéma (ou protocole) utilisé pour accéder à la ressource, ici
  HTTP (HyperText Transfer Protocol).
- `184.158.24.26` : L'adresse IP (ou hôte) qui identifie le serveur où la
  ressource est hébergée.
- `/liste-des-animaux` : Le chemin d'accès à la ressource sur le serveur.
- `?age=5` : La chaîne de requête (query string) qui contient des paramètres
  supplémentaires pour la requête, ici un paramètre `age` avec la valeur `5`.

</details>

## Question 11 (2 points)

HTTP parle de notion d'"URL". Expliquez ce qu'est une URL dans le contexte du
protocole HTTP.

<details>
<summary>Afficher la réponse</summary>

Une URL (Uniform Resource Locator) dans le contexte du protocole HTTP est une
adresse qui permet d'identifier et de localiser une ressource sur le web. Elle
est composée de plusieurs parties, notamment le schéma (protocole), l'hôte
(adresse du serveur), le chemin d'accès à la ressource, et éventuellement des
paramètres de requête.

</details>
