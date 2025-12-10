# DAI-TIC-C - Évaluation 3

Cette évaluation porte sur les notions suivantes :

- SSH et SCP
- HTTP et curl
- Les infrastructures web
- Mise en cache et performance

Vous pouvez répondre aux questions en français ou en anglais.

L'évaluation dure 1h. Une fois que vous avez terminé, veuillez marquer votre
évaluation comme terminée.

Validez avec le corps enseignant que le système a bien enregistré votre
évaluation. Vous pourrez ensuite quitter la salle de façon silencieuse.

Ressources autorisées :

- Deux feuilles (recto-verso, soit quatre pages recto) papier avec vos propres
  notes

Toute tentative de tricherie sera sanctionnée avec la note 1.

---

## Question 1 (10 points)

Pour chacune des affirmations suivantes, sélectionnez la réponse correcte parmi
les choix A, B, C ou D.

1. Quel est l'objectif principal d'un protocole sécurisé ?
   - A. Assurer la rapidité des échanges
   - B. Garantir la confidentialité et l'intégrité des données
   - C. Assurer l'accès aux données
   - D. Améliorer la compatibilité entre systèmes
2. Quel est le code de statut HTTP pour une requête réussie ?
   - A. 302
   - B. 500
   - C. 200
   - D. 404
3. Quel en-tête HTTP indique le type de contenu d'une requête ou réponse ?
   - A. `User-Agent`
   - B. `Accept`
   - C. `Set-Cookie`
   - D. `Content-Type`
4. Quelle est la principale différence entre les exigences fonctionnelles et
   non-fonctionnelles ?
   - A. Les exigences fonctionnelles concernent l'architecture du système,
     tandis que les non-fonctionnelles concernent les performances
   - B. Les exigences fonctionnelles définissent les fonctionnalités d'un
     système, tandis que les non-fonctionnelles concernent des critères comme la
     sécurité et la disponibilité
   - C. Les exigences fonctionnelles sont liées aux utilisateurs finaux, tandis
     que les non-fonctionnelles sont pour les administrateurs système
   - D. Les exigences fonctionnelles sont liées aux coûts de développement,
     tandis que les non-fonctionnelles sont liées aux besoins des utilisateurs
5. Quel est le rôle principal d'un reverse proxy ?
   - A. Augmenter les performances en réduisant le nombre de serveurs
     nécessaires
   - B. Protéger les serveurs en filtrant les requêtes et en les dirigeant vers
     le serveur correct
   - C. Servir des contenus statiques en cache
   - D. Aucune des réponses ci-dessus
6. Quelle est la différence principale entre un forward proxy et un reverse
   proxy ?
   - A. Un forward proxy se situe entre le client et les serveurs, tandis qu'un
     reverse proxy se situe entre le serveur et les clients
   - B. Un forward proxy cache les réponses, tandis qu'un reverse proxy filtre
     les requêtes
   - C. Un reverse proxy est utilisé pour gérer plusieurs clients tandis qu'un
     forward proxy est utilisé pour gérer plusieurs serveurs
   - D. Il n'y a pas de différence
7. Qu'est-ce que la scalabilité horizontale dans une infrastructure web ?
   - A. Ajouter plus de ressources à un seul serveur
   - B. Ajouter plus de serveurs pour répartir la charge de travail
   - C. Ajouter des caches pour améliorer les performances
   - D. Améliorer les protocoles de sécurité pour réduire la latence
8. Quels sont les principaux critères pour déterminer les stratégies de
   scalabilité dans un système web ?
   - A. Les ressources matérielles disponibles
   - B. Le nombre de serveurs dans l'infrastructure
   - C. Les exigences non-fonctionnelles du système et les goulots
     d'étranglement identifiés
   - D. La vitesse du réseau
9. Quel est l'objectif principal du cache dans un système ?
   - A. Réduire la quantité de données traitées par le serveur
   - B. Accélérer la mise en place de bases de données
   - C. Augmenter la complexité du système
   - D. Stocker temporairement des données pour accélérer les requêtes futures
10. Dans le modèle d'expiration du cache, que signifie l'en-tête `Cache-Control`
    ?
    - A. Il définit la durée pendant laquelle une ressource peut être considérée
      comme valide
    - B. Il définit le temps maximal que le client doit attendre avant de
      recevoir une nouvelle ressource
    - C. Il indique le temps de vie d'une session
    - D. Il désactive le cache pour une ressource donnée

<details>
<summary>Afficher la réponse</summary>

1. B
2. C
3. D
4. B
5. B
6. A
7. B
8. C
9. D
10. A (D aussi acceptée)

</details>

## Question 2 (5 points)

Qu'est-ce qu'une empreinte de clé SSH, et comment aide-t-elle à prévenir les
attaques de type homme du milieu (MitM) ?

<details>
<summary>Afficher la réponse</summary>

Une empreinte de clé SSH est un condensé cryptographique (hash) généré à partir
d'une clé publique SSH. (2.5 points)

Une attaque de type homme du milieu (MitM) consiste à intercepter la
communication entre deux parties (par exemple, un client SSH et un serveur) pour
écouter, modifier ou usurper les messages échangés. L'attaquant pourrait
présenter sa propre clé publique au client pour se faire passer pour le serveur.

L'empreinte de clé SSH aide à prévenir ces attaques grâce aux étapes suivantes
(2.5 points) :

1. Première connexion : l'empreinte permet de vérifier l'authenticité d'un
   serveur en comparant l'empreinte affichée avec celle obtenue par un canal
   sûr.
2. Connexions suivantes : si la clé du serveur change (ex. lors d'une attaque),
   l'empreinte ne correspondra pas à celle stockée localement, et un
   avertissement sera affiché.

</details>

## Question 3 (4 points)

Expliquez la différence entre les codes de statut HTTP 200 et 201. Dans quel
scénario chacun serait-il utilisé ?

<details>
<summary>Afficher la réponse</summary>

- Code 200 - OK : indique que la requête a été traitée avec succès par le
  serveur
  - Scénario : lorsqu'une ressource est récupérée avec succès (`GET`) ou lorsque
    des données sont soumises avec succès (`POST`), mais que cela n'entraîne pas
    la création d'une nouvelle ressource distincte. (1 point)
- Code 201 - Created : indique que la requête a abouti à la création d'une
  nouvelle ressource sur le serveur. (1 point)
  - Scénario : lorsqu'une ressource est créée avec succès (`POST`), comme
    l'ajout d'un nouvel utilisateur ou d'un nouvel article. (1 point)

</details>

## Question 4 (4 points)

Expliquez la différence entre les paramètres de chemin (path parameters) et les
paramètres de requête (query parameters). Donnez un exemple d'URL utilisant les
deux types de paramètres.

<details>
<summary>Afficher la réponse</summary>

- Paramètres de chemin (path parameters) : intégrés directement dans l'URL pour
  identifier une ressource spécifique. (1 point)
  - Exemple : `/users/123` où `123` est l'ID d'un utilisateur. (1 point)
- Paramètres de requête (query parameters) : ajoutés après le "?" dans l'URL
  pour fournir des informations supplémentaires. (1 point)
  - Exemple : `/users/123?sort=name` où `sort` et affine les résultats. (1
    point)

</details>

## Question 5 (6 points)

Expliquez le processus de gestion du cache en utilisant les en-têtes HTTP
`Cache-Control`, `Last-Modified` et `ETag`. Comment ces mécanismes
interagissent-ils pour garantir que les clients reçoivent des données
actualisées lorsque nécessaire ?

<details>
<summary>Afficher la réponse</summary>

1. `Cache-Control` : définit les règles de cache et informe les clients sur la
   durée de validité d'une ressource. (1 point)
   - Le serveur peut répondre à une requête avec l'entête
     `Cache-Control: max-age=3600` indiquant que la ressource peut être utilisée
     pendant une heure sans vérification/requête envers le server (1 point)
   - Permet un cache côté client ou proxy, limitant les requêtes vers le
     serveur.
2. `Last-Modified` : validation basée sur la date et indique la dernière date de
   modification de la ressource. (1 point)
   - Lorsqu'un client possède une version en cache, il envoie une requête avec
     l'en-tête `If-Modified-Since`. Le serveur compare cette date et répond :
     - `304 Not Modified` si la ressource n’a pas changé. (0.5 point)
     - `200 OK` avec une nouvelle version si elle a été mise à jour (0.5 point).
3. `ETag` : validation basée sur un identifiant unique et contient une signature
   unique (hash) ou un numéro de version de la ressource. (1 point)
   - Lorsqu’un client envoie une requête, il inclut `If-None-Match` avec l’ETag
     de sa version en cache. Le serveur compare les ETags et répond :
     - `304 Not Modified` si l'ETag correspond (0.5 point)
     - `200 OK` avec une version mise à jour sinon. (0.5 point)

</details>

## Question 6 (6 points)

Vous travaillez dans une startup qui développe le nouveau réseau social à la
mode (images, vidéos, audios). Votre infrastructure est composée d'une
application mobile, de serveurs distribués sur chaque continent et d'un data
center en Suisse. Vous avez 100'000 utilisateurs actifs par jour et vous
souhaitez optimiser les performances des communications. A ce jour, aucun
système de cache n'est utilisé. Citez 3 avantages de l'utilisation d'un système
de cache dans ce contexte et expliquez à quel(s) niveau(x) vous pourriez mettre
en place un tel système.

<details>
<summary>Afficher la réponse</summary>

Trois parmi les avantages suivants (1 point par avantage) :

1. Réduction de la latence
2. Réduction de la bande passante
3. Réduction de la charge sur les serveurs
4. Réduction des coûts
5. Amélioration de la disponibilité
6. Amélioration de la sécurité

Le système de cache peut être mis en place au niveau de l'application mobile,
des serveurs distribués ou du data center. (3 points)

</details>

## Question 7 (8 points)

Dans le cadre du cours de DAI, vous avez dû utiliser à plusieurs reprises Docker
et Docker Compose.

Expliquez le but de ces deux technologies, leurs différences, ainsi que leurs
forces et faiblesses par rapport à une façon traditionnelle de développer et
maintenir des logiciels.

Argumentez votre discours avec des fichiers d'exemple et des cas d'utilisation
concrets.

<details>
<summary>Afficher la réponse</summary>

- Explication des objectifs des outils (2 points) :
  - 1 point pour Docker, 1 point pour Docker Compose.
- Description des différences (2 points) :
  - Mentionner au moins deux différences pertinentes.
- Analyse des forces/faiblesses (2 points) :
  - 1 point pour les forces.
  - 1 point pour les faiblesses.
- Exemple et cas d’utilisation (2 points) :
  - 1 point pour le fichier `Dockerfile`.
  - 1 point pour le fichier `docker-compose.yaml`

</details>

## Question 8 (16 points)

Votre entreprise vous a mandaté de créer une application web pour gérer les
réservations des salles de conférence de l'entreprise.

Décrivez les différentes ressources/endpoints/routes que vous allez devoir
implémenter avec leurs paramètres d'entrées/sorties ainsi que les méthodes et
les codes de retour pour réaliser cette application.

Il n'est pas demandé d'implémenter l'application.

<details>
<summary>Afficher la réponse</summary>

- Opérations CRUD pour gérer les réservations (5 points au total):
  - Créer une réservation (0.5 point) - `POST /reservations` (0.5 point)
  - Récupérer toutes les réservations (0.5 point) - `GET /reservations` (0.5
    point)
  - Récupérer une réservation spécifique (0.5 point) - `GET /reservations/{id}`
  - Modifier/mettre à jour une réservation spécifique (0.5 point) -
    `PUT /reservations/{id}` ou `PATCH /reservations/{id}` (0.5 point)
  - Supprimer une réservation spécifique (0.5 point) -
    `DELETE /reservations/{id}` (0.5 point)
- Il faut un moyen de comprendre la structure de données qui compose une
  réservation (1 point). Un exemple pour une réservation simple d'une personne
  pour une salle pour toute la journée :

  ```json
  {
    "id": 1,
    "user": "Jane Doe",
    "roomName": "J01",
    "date": "20.01.2025"
  }
  ```

- Les entrées des différentes opérations CRUD sont exprimées et explicites (1
  point)
- Les sorties des différentes opérations CRUD sont exprimées et explicites (1
  point)

</details>
