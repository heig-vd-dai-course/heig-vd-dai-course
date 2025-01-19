# Évaluation

Cette évaluation porte sur les notions suivantes :

- HTTP et curl
- Les infrastructures web

Vous pouvez répondre aux questions en français ou en anglais.

Ressources autorisées :

- Une feuille de résumé (recto) papier avec vos propres notes

Toute tentative de tricherie sera sanctionnée avec la note 1.

## Partie théorique (24.5 points)

### Question 1 (2 points)

Rédigez une requête HTTP de type `GET` permettant de récupérer la ressource
`/documents/123` au format `json` sur le serveur `www.example.com` en utilisant
le protocole HTTP/1.1.

<details>
<summary>Afficher la réponse</summary>

```http
GET /documents/123 HTTP/1.1 (0.5 point)
Host: www.example.com (0.5 point)
Accept: application/json (0.5 point)
(0.5 point - On doit voir mentionner le fait qu'il faut une ligne vide à la fin de la requête)
```

</details>

### Question 2 (2.5 points - 5 x 0.5 points)

Dans l'URL suivante, donnez tous les éléments qui la composent (port, protocole,
etc...):

`https://www.example.com:8080/path/to/page.html?foo=bar&baz=qux`

<details>
<summary>Afficher la réponse</summary>

- Protocole : `https` (0.5 point)
- Domaine : `www.example.com` (0.5 point)
- Port : `8080` (0.5 point)
- Chemin : `/path/to/page.html` (0.5 point)
- Paramètres : `foo=bar&baz=qux` (0.5 point)

</details>

### Question 3 (3 points - 6 x 0.5 points)

HTTP vrai ou faux :

- HTTP est un protocole sans état qui ne conserve pas d'informations sur l'état
  du client entre les requêtes.
- HTTP est un protocole de couche applicative qui sert de fondation à la
  communication de données sur le World Wide Web.
- Par défaut, HTTP permet un envoi sécurisé (chiffré) de données entre un client
  et un serveur contrairement à TCP.
- Les en-têtes HTTP ne sont lisibles que par le client et le serveur.
- L'entête `Accept` permet de spécifier le type de contenu que le client
  souhaite recevoir.
- HTTP ne peut être utilisé qu'au travers d'un navigateur web.

<details>
<summary>Afficher la réponse</summary>

- Vrai
- Vrai
- Faux
- Faux
- Vrai
- Faux

</details>

### Question 4 (4 points - 8 x 0.5 points)

Que signifie l'acronyme CRUD ? Quelles méthodes HTTP sont utilisées pour les
opérations CRUD ?

<details>
<summary>Afficher la réponse</summary>

CRUD signifie Create, Read, Update, Delete. Les méthodes HTTP utilisées sont
respectivement POST, GET, PUT/PATCH et DELETE.

</details>

### Question 5 (3 points - 3 x 1 points)

Vous travaillez dans une entreprise en charge du développement d'une application
de gestion de bibliothèque. Vous devez développer une site web permettant aux
utilisateurs de consulter le catalogue de la bibliothèque, et d'ajouter des
livres à sa liste de lecture ou dans un panier afin de les emprunter plus tard
(données mémorisées pendant un certain temps). Ce site web sera utilisé par tous
les étudiants de la HES-SO (environ 20'000 étudiants) et votre infrastructure
web sera composée de 3 serveurs web utilisant du load balancing.

Citez une problématique liée à la gestion de la session utilisateur dans ce
contexte, et expliquez comment vous la résoudriez (Donner 2 solutions et
expliquez leur fonctionnement).

<details>
<summary>Afficher la réponse</summary>

Ici, le problème se situe à deux niveaux (1 point l'identification de la
problématique) :

- Comment assurer que les requêtes soient toujours bien renvoyées sur le même
  serveur malgré le load balancing ?
- Comment gérer/récupérer la session utilisateur sur le serveur comme HTTP est
  sans état ?

Pour la première problématique, on peut utiliser un load balancing de type
sticky session. Cela permet de toujours renvoyer les requêtes d'un même client
sur le même serveur. (1 point)

Pour la deuxième problématique, on peut utiliser un mécanisme de session
utilisateur. Il existe plusieurs solutions pour cela (1 point):

- Par paramètre : L'identifiant de session est envoyé au serveur dans la requête
  HTTP dans l'URL à l'aide d'un paramètre (exemple:
  `https://www.example.com?session=123`). Le serveur extrait l'identifiant de
  session de la requête HTTP et le compare à la base de données pour savoir à
  qui appartient la session.
- Par cookie : L'identifiant de session est envoyé au client dans la réponse
  HTTP au travers d'un cookie. L'identifiant de session est envoyé au serveur
  dans la requête HTTP dans l'URL à l'aide d'un cookie. Le serveur extrait
  l'identifiant de session de la requête HTTP et le compare à la base de données
  pour savoir à qui appartient la session.

</details>

### Question 6 (5 points - 5 x 1 points)

L'entreprise dans laquelle vous travaillez à connu une forte croissance ces
derniers mois. Suite à cela, vous constatez que le serveur web de l'entreprise
(1vCPU / 2GB RAM / 256GB SSD) est souvent surchargé et que les utilisateurs se
plaignent de lenteurs. Donnez 2 solutions pour résoudre ce problème, et
expliquez les avantages et inconvénients de chacune d'entre elles. Laquelle
choisiriez-vous en premier et pourquoi ?

<details>
<summary>Afficher la réponse</summary>

- Scaling vertical : Ajouter des ressources au serveur existant (RAM, CPU, SSD)
  (1 point)
- Scaling horizontal : Ajouter un nouveau serveur web et utiliser du load
  balancing (1 point)

L'argumentation doit mentionner les avantages (1 point) et inconvénients (1
point) de chaque solution et le choix définit (1 point)

</details>

### Question 7 (5 points - 6 x 0.5 + 2 x 1 points)

Le protocole HTTP définit 2 méthodes de gestion de cache. Expliquez ces deux
méthodes et leur fonctionnement.

<details>
<summary>Afficher la réponse</summary>

Modèle d'expiration (1 point)

- Le serveur indique au client la durée de validité de la ressource dans les
  entêtes (`Cache-Control`, `Expires`) (0.5 point)
- Le client stocke la ressource en cache et la réutilise jusqu'à expiration (0.5
  point)

Modèle de validation (1 point)

Avec ETag

- Le serveur indique au client un identifiant unique de la ressource dans
  l'entête `ETag` (0.5 point)
- Lors d'une requête ultérieure, le client envoie l'identifiant unique au
  serveur dans l'entête `If-None-Match` (0.5 point)
- Le serveur compare l'identifiant unique avec la ressource actuelle et renvoie
  un code 304 si la ressource n'a pas changé (0.5 point)
- Si la ressource a changé, le serveur renvoie la nouvelle ressource avec un
  code 200 ainsi que le nouveau ETag (0.5 point)

ou

Avec Last-Modified

- Le serveur indique au client la date de dernière modification de la ressource
  dans l'entête `Last-Modified` (0.5 point)
- Lors d'une requête ultérieure, le client envoie la date de dernière
  modification au serveur dans l'entête `If-Modified-Since` (0.5 point)
- Le serveur compare la date de dernière modification avec la ressource actuelle
  et renvoie un code 304 si la ressource n'a pas changé (0.5 point)
- Si la ressource a changé, le serveur renvoie la nouvelle ressource avec un
  code 200 ainsi que la nouvelle date de dernière modification (0.5 point)

</details>
