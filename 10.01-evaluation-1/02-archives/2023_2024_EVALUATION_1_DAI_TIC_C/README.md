# Évaluation

Cette évaluation porte sur les notions suivantes :

- Git, GitHub et Markdown
- Java, IntelliJ IDEA et Maven
- Entrées/sorties (IO) avec Java

Vous pouvez répondre aux questions en français ou en anglais.

L'évaluation dure 1h. Une fois que vous avez terminé, veuillez fermer votre
ordinateur et attendre la fin de l'évaluation. Il s'agit d'une limitation
technique que nous espérons pouvoir résoudre dans le futur.

Vous aurez le droit aux éléments suivants:

- Le contenu du cours présenté dans l'organisation GitHub:
  https://github.com/heig-vd-dai-course (support de cours, présentations, codes
  d'exemple ainsi que vos notes personnelles)
- Vos dépôts GitHub que vous avez créés pour les contenu pratiques et les
  travaux pratiques
- La documentation officielle de Java:
  https://docs.oracle.com/en/java/javase/17/docs/api/

La communication avec d'autres outils (ChatGPT et autres) ou personnes ou encore
l'accès à d'autres sites Internet ne sont pas autorisés.

Toute tentative de tricherie sera sanctionnée avec la note 1.

Le nombre total de points est de 63. La note finale sera calculée selon le
barème fédéral, soit: `note = (points obtenus / points totaux) * 5 + 1`.

## Question 1 (4 points - 8x 0.5 points)

Rédigez un document Markdown qui présente les points suivants:

- Un titre "Ma présentation"
- Un tableau avec les colonnes suivantes:
  - Nom
  - Prénom
  - GitHub username
  - Adresse email
- Une description de vous-même
- Un lien vers votre profil GitHub
- Une image de votre choix
- Une liste à puces ordonnée de 2-3 points de vos compétences, dans l'ordre de
  maîtrise (de la plus maîtrisée à la moins maîtrisée)
- Une liste à puces non-ordonnée de 2-3 points de vos qualités
- Un block de code Java avec le contenu de votre choix

<details>
<summary>Afficher la réponse</summary>

````markdown
# John Doe

| Nom | Prénom | GitHub Username | Adresse Email      |
| --- | ------ | --------------- | ------------------ |
| Doe | John   | johndoe         | john.doe@email.com |

## À propos de moi

Je suis un développeur passionné par la technologie et l'informatique. J'adore
résoudre des problèmes complexes, apprendre de nouvelles compétences et
collaborer avec d'autres passionnés de la technologie.

Vous pouvez en apprendre davantage sur moi en visitant
[mon profil GitHub](https://github.com/johndoe).

![Photo de profil](lien_vers_votre_image.jpg)

## Compétences

1. Développement Web (HTML, CSS, JavaScript)
2. Programmation en Python
3. Gestion de base de données SQL

## Qualités

- Esprit d'équipe
- Créatif et innovant
- Bonnes compétences en communication

## Code

```java
System.out.println("Hello World!");
```
````

</details>

## Question 2 (3 points - 6x 0.5 point)

Dans votre travail pratique, vous avez utilisé Git et GitHub. Expliquez quel
était le workflow que vous avez utilisé pour contribuer à votre projet et
pourquoi.

<details>
<summary>Afficher la réponse</summary>

- Ouvrez une issue pour discuter de la fonctionnalité (facultatif, mais
  recommandé)
- Clonez ou forker le projet et basculez vers une nouvelle branche
- Effectuez vos modifications, effectuez des commits et poussez-les aussi
  souvent que vous le souhaitez
- Créez la pull request
- Les mainteneurs examinent et mergent si tout est en ordre
- Vous pouvez supprimer la branche ou le fork

Il s'agit d'un workflow permettant d'intégrer de façon collaborative et efficace
de nouvelles fonctionnalités dans un projet.

</details>

## Question 3 (2 points - 2x 1 point)

Quel est l'avantage de cloner un repository Git avec SSH plutôt que HTTPS ?

<details>
<summary>Afficher la réponse</summary>

1. Cloner avec SSH est plus sécurisé car il utilise une clé publique/privée pour
   s'authentifier et non un nom d'utilisateur et un mot de passe à chaque fois.
2. Pas besoin de s'authentifier à chaque fois que vous poussez ou tirez du code.

</details>

## Question 4 (2 points - 2x 1 point)

Comment est-ce que vous faites pour ignorer des fichiers avec Git et à quoi cela
sert-il ? Donnez un example commenté.

<details>
<summary>Afficher la réponse</summary>

1. Pour ignorer des fichiers avec Git, utilisez un fichier `.gitignore` dans
   votre dépôt. Par exemple, pour ignorer tous les fichiers `.jar` dans le
   dossier `target` :

   ```sh
   target/*.jar
   ```

2. Cela évite d'inclure des fichiers inutiles ou sensibles dans le dépôt, et
   maintenir le projet propre.

</details>

## Question 5 (4 points - 2x 2 points)

Quelle est l'utilité d'utiliser un wrapper pour Maven? Pourquoi ne pas
simplement utiliser la version de Maven installée localement? Argumentez.

<details>
<summary>Afficher la réponse</summary>

- Les wrappers Maven, tels que Maven Wrapper (mvnw), garantissent que chaque
  développeur utilise la même version de Maven, éliminant ainsi les problèmes de
  compatibilité entre les différentes versions de Maven installées localement.
- Ils simplifient le processus d'intégration continue (CI/CD) en garantissant
  que le projet utilise la version spécifique de Maven requise, sans nécessiter
  d'installation manuelle.

</details>

## Question 6 (2 points - 2x 1 point)

En quoi est-ce utile de signer ses commits avec SSH ou GPG? Argumentez.

<details>
<summary>Afficher la réponse</summary>

- Preuve cryptographique que le commit a été créé par vous et qu'il n'a pas été
  altéré en transit.
- Renforce la confiance dans le code que vous contribuez.

</details>

## Question 7 (4 points - 4x 1 point)

Markdown est-il adapté dans les cas suivants, vrai ou faux ?

1. Markdown prend en charge la création de formulaires interactifs et d'éléments
   de saisies.
2. Les documents Markdown peuvent inclure des images.
3. Markdown est une norme ouverte et n'appartient à aucune entreprise
   spécifique.
4. Markdown est un langage de programmation.

<details>
<summary>Afficher la réponse</summary>

1. Faux
2. Vrai
3. Vrai
4. Faux

</details>

## Question 8 (2 points - 1x 2 points)

Citez un avantage majeur de l’utilisation du langage Java par rapport à un autre
language ?

<details>
<summary>Afficher la réponse</summary>

Java est portable grâce à la JVM, ce qui signifie qu'il peut être exécuté sur
diverses plates-formes sans nécessiter de modification majeure du code source
(write once, run anywhere (WORA)).

</details>

## Question 9 (1 point - 1x 1 point)

Qu'est-ce qu'un fichier JAR et à quoi sert-il ?

<details>
<summary>Afficher la réponse</summary>

Un fichier JAR est une archive Java qui contient des classes, des métadonnées et
d'autres ressources, facilitant la distribution d'applications et de
bibliothèques Java.

</details>

## Question 10 (3 points - 6x 0.5 point)

Vrai ou Faux

1. ASCII est une table d'encodage qui représente les caractères en utilisant 8
   bits.
2. UTF-8 est un codage de caractères à longueur variable qui peut représenter
   tous les caractères Unicode.
3. Unicode est un codage de caractères sur 16 bits qui couvre tous les
   caractères utilisés dans l'informatique moderne.
4. En Java, la classe `InputStreamReader` peut être utilisée pour lire des
   données de caractères à partir d'un flux d'entrée tout en spécifiant
   l'encodage de caractères.
5. ASCII est un sous-ensemble d'UTF-8, ce qui signifie que tous les caractères
   ASCII sont des caractères UTF-8 valides.
6. La classe `FileReader` de Java IO détecte automatiquement le codage de
   caractères d'un fichier et le lit en conséquence.

<details>
<summary>Afficher la réponse</summary>

1. Faux
2. Vrai
3. Faux
4. Vrai
5. Vrai
6. Faux

</details>

## Question 11 (2 points - 1x 2 points)

Vous avez créé un projet Java avec IntelliJ et Maven ainsi que picocli et vous
souhaitez le compiler pour en créer un JAR. Cependant, une fois le projet
compilé, lorsque vous le lancez, l'erreur suivante s'affiche. Donner la/les
causes du/des problèmes et la/les éventuelles solutions ou vérifications à
faire.

```sh
$> mvn dependency:resolve clean compile package
$> java -jar target/cli-example-1.0-SNAPSHOT.jar

Exception in thread "main" java.lang.NoClassDefFoundError: picocli/CommandLine
	at ch.heigvd.dai.Main.main(Main.java:7)
Caused by: java.lang.ClassNotFoundException: picocli.CommandLine
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:525)
	... 1 more
```

<details>
<summary>Afficher la réponse</summary>

- Le JAR généré ne contient pas les dépendances (Picocli). Il faut donc utiliser
  le plugin `maven-shade-plugin` pour créer un JAR avec les dépendances
  incluses.
- Si le plugin `maven-shade-plugin` est déjà utilisé, alors il faut s'assurer de
  lancer le bon JAR, celui qui contient les dépendances.

</details>

## Question 12 (4 points - 4x 1 point)

Quelle est la différence entre un fichier texte et un fichier binaire ? A quoi
devez-vous faire attention ? Argumentez.

<details>
<summary>Afficher la réponse</summary>

La principale différence entre un fichier texte et un fichier binaire réside
dans la manière dont les données sont stockées et interprétées :

- **Fichier Texte :** Un fichier texte stocke les données sous forme de
  caractères lisibles par l'homme (lettres, chiffres, symboles). Ces fichiers
  sont généralement codés en utilisant un encodage de texte standard tel
  qu'UTF-8.

- **Fichier Binaire :** Un fichier binaire stocke les données sous forme de
  séquences d'octets, qui peuvent représenter n'importe quel type de données.
  Ils ne sont pas directement lisibles par l'homme et nécessitent une
  interprétation spécifique.

Lorsque vous manipulez ces types de fichiers, voici ce à quoi vous devez faire
attention :

- **Fichier Texte :** Vous devez prêter attention à l'encodage du texte (UTF-8,
  UTF-16, etc.), car une mauvaise interprétation de l'encodage peut entraîner
  des caractères illisibles.

- **Fichier Binaire :** La manipulation incorrecte de fichiers binaires peut
  entraîner des erreurs de corruption de données.

</details>

## Question 13 (3 points - 3x 1 point)

Vous faites partie d'une équipe de développement qui utilise principalement Java
et IntelliJ IDEA comme IDE. Donnez 3 bonnes raisons pour lesquelles vous devriez
partager avec vos collègues une configuration de projet IntelliJ IDEA (Package
as JAR file).

<details>
<summary>Afficher la réponse</summary>

- Pour que tous les membres de l'équipe utilisent la même configuration IntelliJ
  IDEA. (store as project file)
- Pour que tous les membres de l'équipe utilisent le wrapper Maven (use maven
  wrapper)
- Pour que tous les membres de l'équipe utilisent la même commande pour compiler
  le projet (dependency:resolve clean compile package)

</details>

## Question 14 (5 points - 5x 1 point)

Soit le code suivant:

```java
import java.io.*;

public class ReadWriteTextualFile {

    public static void main(String[] args) {
        FileReader reader = new FileReader("input_file.txt");
        FileInputStream writer = new FileInputStream("output_file.txt");

        int character;
        while ((character = reader.read()) != 0) {
            writer.write(character);
        }

        reader.close();
    }
}
```

Expliquez quels seraient les problèmes qui pourraient survenir et quelles
seraient les bonnes pratiques à suivre pour que le code fonctionne correctement.

Argumentez.

<details>
<summary>Afficher la réponse</summary>

```java
import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReadWriteTextualFile {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input_file.txt", StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output_file.txt", StandardCharsets.UTF_8))) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }

        } catch (IOException e) {
            e.printStackTrace(); // Or any other appropriate exception handling.
        }
    }
}
```

- Utiliser `FileReader` et `FileWriter` pour lire et écrire des données (1pt)
- Utiliser un `BufferedReader` et un `BufferedWriter` pour améliorer les
  performances. (1pt)
- Spécifier l'encodage de caractères lors de la lecture et de l'écriture de
  données textuelles. (1pt)
- Utiliser un `try-with-resources` pour fermer automatiquement les ressources ou
  `try-catch-finally`, un `throws IOException` (mais pas propre du tout) pour
  fermer les ressources manuellement. (1pt)
- Utiliser `read()` jusqu'à ce que la valeur retournée soit `-1` et non `0`.
  (1pt)

</details>

## Question 15 (5 points - 5x 1 point)

A quoi sert le fichier `pom.xml`, doit-il être versionné et pourquoi ?

<details>
<summary>Afficher la réponse</summary>

Un Project Object Model (POM) est le fichier central dans Maven. Il s'agit d'un
fichier XML qui contient des informations sur le projet et des détails de
configuration utilisés par Maven pour construire le projet. Dans ce fichier se
trouvent des informations telles que:

1. Les métadonnées/informations du projet
2. Les dépendances utilisées par le projet
3. Les plugins utilisés pour construire le projet

Ce fichier doit être versionné car il contient des informations essentielles sur
le projet (ses dépendances, sa structure et son processus de build) qui est
partagé avec tous les développeur-euse-s.

</details>

## Question 16 (7 points - 3x 1 point + 2x 2 points)

Dans le cadre du développement d'une application de traitement de données
médicales, vous devez mettre en place une fonctionnalité de sauvegarde des
images médicales de manière sécurisée et efficace. Cette fonctionnalité
permettra aux utilisateurs autorisés d'accéder aux images même en l'absence
d'une connexion réseau fiable, assurant ainsi la continuité des soins.
Implémentez une fonction permettant de dupliquer le contenu d'une image médicale
vers une fichier de sortie possédant le même nom que le fichier d'entrée mais
avec l'extension `.bak`.

```java
import java.io.*;

public class BackupFile {

    public static void main(String[] args) {
        // Complete here
    }
}
```

> [!NOTE]
>
> Cette question a été supprimée de l'évaluation car elle était trop difficile.
> Tous les points ont été attribués.

<details>
<summary>Afficher la réponse</summary>

```java
import java.io.*;

public class BackupFile {

    public static void main(String[] args) {
        String inputFile = "medical_image.jpg"; // Fichier d'entrée
        String outputFile = inputFile.substring(0, inputFile.lastIndexOf('.')) + ".bak"; // Fichier de sortie avec l'extension .bak

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {

            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

            System.out.println("L'image médicale a été sauvegardée avec succès.");

        } catch (IOException e) {
            e.printStackTrace(); // Ou tout autre traitement approprié des exceptions.
        }
    }
}
```

- Utiliser `FileInputStream` et `FileOutputStream` pour lire et écrire des
  données à partir d'un fichier binaire. (2pt)
- Utiliser un `BufferedInputStream` et un `BufferedOutputStream` pour améliorer
  les performances. (2pt)
- Utiliser un `try-with-resources` pour fermer automatiquement les ressources ou
  `try-catch-finally` pour fermer les ressources manuellement. (1pt)
- Utiliser `read()` jusqu'à ce que la valeur retournée soit `-1` et non `0`.
  (1pt)
- Ajouter une extension `.bak` au fichier de sortie. (1pt)

</details>

## Question 17 (2 points - 2x 1 point)

Décrivez les avantages de l'utilisation de la mise en mémoire tampon (buffering)
lors de la lecture et de l'écriture de données dans les opérations d'IO. Comment
améliore-t-elle les performances ?

<details>
<summary>Afficher la réponse</summary>

- L'utilisation de la mise en mémoire tampon (buffering) améliore les
  performances des opérations d'IO en minimisant le nombre d'accès au disque ou
  à d'autres ressources lentes.
- Les données sont lues ou écrites en blocs plus importants, ce qui réduit le
  temps nécessaire pour ces opérations. Cela réduit la surcharge d'E/S et
  améliore l'efficacité globale du processus.

</details>

## Question (6 points - 6x 1 point)

Une équipe de développement utilise Java pour développer une application.

Toutes les personnes n'utilisent pas forcément les mêmes outils ou les mêmes
versions de ces outils et chaque personne compile l'application à la main. Elles
se partagent le code au travers de clés USB.

Expliquez quelles seraient les bonnes pratiques à suivre pour que l'équipe
puisse travailler efficacement. Argumentez.

<details>
<summary>Afficher la réponse</summary>

A mettre en place :

- Unifier les versions de Java en utilisant par exemple un gestionnaire de
  version comme SDKMAN!
- Utiliser un outil comme Maven pour aider à la compilation de l'application
- Utiliser un outil de gestion de code source comme Git pour versionner le code
- Partager le code sur une plateforme comme GitHub pour que chaque personne
  puisse récupérer le code
- Mettre en place un workflow de développement avec Git pour que chaque personne
  puisse travailler efficacement
- Documenter le projet (avec Markdown) pour que chaque personne puisse
  comprendre le projet comment travailler efficacement

</details>

## Question (2 points - 2x 1 point)

Qu'est-ce que GitHub et comment s'intègre-t-il avec Git ?

<details>
<summary>Afficher la réponse</summary>

1. GitHub est une plateforme de développement collaborative basée sur le web qui
   facilite la gestion de projets, le stockage de code, la collaboration, le
   suivi des problèmes, et plus encore.
2. GitHub s'intègre avec Git en fournissant un service web pour héberger des
   dépôts Git, permettant aux développeurs de cloner, pousser, et tirer des
   dépôts Git directement depuis la plateforme web, simplifiant ainsi la
   collaboration et le suivi des changements dans un projet.

</details>
