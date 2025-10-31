# DAI-TIC-B - Évaluation 3

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

- Deux feuilles recto-verso (soit quatre pages recto) papier avec vos propres
  notes

Toute tentative de tricherie sera sanctionnée avec la note 1.

---

## Question 1 (10 points)

Pour chacune des affirmations suivantes, sélectionnez la réponse correcte parmi
les choix A, B, C ou D.

1. Comment le client est-il authentifié lors d'une connexion SSH ?
   - A. Avec un certificat SSL
   - B. En envoyant une clé privée au serveur
   - C. Par cryptographie asymétrique avec une clé publique/privée
   - D. Par un mot de passe uniquement
2. Quel code de statut HTTP indique que le client n'est pas autorisé pour
   accéder à cette ressource ?
   - A. 404
   - B. 401
   - C. 500
   - D. 301
3. L'en-tête `Accept` est utilisé pour :
   - A. Indiquer le type de contenu que le client accepte
   - B. Spécifier les cookies à envoyer
   - C. Indiquer le serveur qui héberge l'API
   - D. Indiquer la longueur du contenu
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
5. Quel est l'objectif principal d'un load balancer ?
   - A. Gérer les requêtes clients et répondre avec les ressources les plus
     proches
   - B. Répartir le trafic réseau ou d'application entre plusieurs serveurs
   - C. Ajouter une couche de sécurité supplémentaire contre les attaques
   - D. Créer un CDN pour distribuer le contenu à travers différents serveurs
6. Quelle est la différence principale entre un forward proxy et un reverse
   proxy ?
   - A. Un forward proxy se situe entre le client et les serveurs, tandis qu'un
     reverse proxy se situe entre le serveur et les clients
   - B. Un forward proxy cache les réponses, tandis qu'un reverse proxy filtre
     les requêtes
   - C. Un reverse proxy est utilisé pour gérer plusieurs clients tandis qu'un
     forward proxy est utilisé pour gérer plusieurs serveurs
   - D. Il n'y a pas de différence
7. Qu'est-ce que la scalabilité verticale dans une infrastructure web ?
   - A. Ajouter plus de ressources à un seul serveur
   - B. Ajouter plus de serveurs pour répartir la charge de travail
   - C. Ajouter des caches pour améliorer les performances
   - D. Améliorer les protocoles de sécurité pour réduire la latence
8. Quand choisir de scaler horizontalement plutôt que verticalement ?
   - A. Lorsque l'application nécessite plus de CPU mais pas plus de serveurs
   - B. Lorsque la base de données nécessite plus d'espace disque
   - C. Lorsque le serveur atteint sa limite de ressources et ne peut plus être
     amélioré
   - D. Lorsque le cache n'est plus à jour
9. Quel est le rôle d'un CDN dans l'optimisation des performances ?
   - A. Fournir un serveur de base de données plus rapide
   - B. Augmenter la sécurité des requêtes HTTP
   - C. Réduire la consommation d'énergie des serveurs
   - D. Servir du contenu statique aux utilisateurs à partir du serveur le plus
     proche
10. Dans le modèle de validation du cache, que signifie l'en-tête
    `Last-Modified` ?
    - A. La première fois qu'une ressource a été demandée
    - B. L'heure actuelle
    - C. Le temps d'expiration d'une ressource
    - D. La dernière fois qu'une ressource a été modifiée

<details>
<summary>Afficher la réponse</summary>

1. C
2. B
3. A
4. B
5. B
6. A
7. A
8. C
9. D
10. D

</details>

## Question 2 (5 points)

Expliquez ce qui se passe lors de la première connexion SSH à un serveur et
pourquoi cela implique un avertissement concernant l'authenticité de l'hôte.

<details>
<summary>Afficher la réponse</summary>

1. Lors de la première connexion, il vous est demandé de confirmer l'empreinte
   de la clé publique du serveur distant. (1 point)
2. Ce message d'avertissement vous demande de confirmer ou non l'authenticité de
   cette empreinte (1 point)

Cette étape permet d'éviter les attaques Man-in-the-middle (2 points) car si,
lors d'une prochaine connexion, cette empreinte a changé, un message
d'avertissement survient, vous indiquant que la machine a été compromise par
quelqu'un d'autre. (1 point)

</details>

## Question 3 (4 points)

Expliquez la différence entre les codes de statut HTTP 400 et 404. Dans quel
scénario chacun serait-il utilisé ?

<details>
<summary>Afficher la réponse</summary>

- Code 400 - Bad Request : indique que la requête envoyée au serveur est
  invalide ou mal formée. (1 point)
  - Scénario : une API reçoit un JSON mal structuré ou un paramètre requis est
    manquant. (1 point)
- Code 404 - Not Found : signale que la ressource demandée n'existe pas sur le
  serveur. (1 point)
  - Scénario : une URL pointe vers une page ou une ressource inexistante, comme
    `/products/123` pour un produit introuvable. (1 point)

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

En quoi le modèle d'expiration du cache est-il différent du modèle de validation
? Quelles sont les situations où chacun de ces modèles serait plus adapté ?

Pensez à décrire les entêtes utilisés et leur signification.

<details>
<summary>Afficher la réponse</summary>

1. Modèle d'expiration :
   - Basé sur une durée définie pendant laquelle une ressource est considérée
     comme valide. (1 point)
   - Utilise des en-têtes comme `Cache-Control` (ex. : `max-age=3600`) indiquer
     au client combien de temps il peut utiliser une ressource sans vérifier
     auprès du serveur. (1 point)
   - Adapté pour des ressources qui changent rarement ou ont un cycle de mise à
     jour prévisible, comme des images ou fichiers statiques. (1 point)
2. Modèle de validation :
   - Basé sur une vérification avec le serveur pour s'assurer qu'une ressource
     est encore valide. (1 point)
   - Utilise les en-têtes `Last-Modified` (date de dernière modification) ou
     `ETag` (identifiant unique de la version d'une ressource). (1 point)
   - Adapté pour des ressources susceptibles d’être modifiées fréquemment ou
     dont l’état doit être contrôlé en temps réel. (1 point)

</details>

## Question 6 (6 points)

Vous travaillez pour une entreprise de e-commerce qui vend des produits en
ligne. Votre infrastructure est composée d'un site web de vente en ligne, de
serveurs distribués sur chaque continent et d'un data center en Suisse. Vous
avez environ 50'000 visiteurs uniques par jour et vous souhaitez améliorer la
rapidité d'accès aux informations produits et optimiser les délais de paiement.
À ce jour, aucun système de cache n'est utilisé. Citez 3 avantages de
l'utilisation d'un système de cache dans ce contexte et expliquez à quel(s)
niveau(x) vous pourriez mettre en place un tel système.

<details>
<summary>Afficher la réponse</summary>

Trois parmi les avantages suivants (1 point par avantage):

1. Réduction de la latence
2. Réduction de la bande passante
3. Réduction de la charge sur les serveurs
4. Réduction des coûts
5. Amélioration de la disponibilité
6. Amélioration de la sécurité

Le système de cache peut être mis en place au niveau de l'application web, des
serveurs distribués ou du data center. (3 points)

</details>

## Question 7 (8 points)

Dans le cadre du cours de DAI, vous avez dû utiliser à plusieurs reprises Docker
et Docker Compose.

Expliquez le but de ces deux technologies, leurs différences entre elles, ainsi
que leurs forces et faiblesses par rapport à une façon traditionnelle de
développer, maintenir et déployer des logiciels.

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

## Question 8 (8 points)

Votre entreprise vous a mandaté de créer une application web pour gérer les
réservations des places de parking de l'entreprise.

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
  pour une place de park pour toute la journée :

  ```json
  {
    "id": 1,
    "user": "Jane Doe",
    "parkingSpaceNumber": 102,
    "date": "20.01.2025"
  }
  ```

- Les entrées des différentes opérations CRUD sont exprimées et explicites (1
  point)
- Les sorties des différentes opérations CRUD sont exprimées et explicites (1
  point)

</details>
