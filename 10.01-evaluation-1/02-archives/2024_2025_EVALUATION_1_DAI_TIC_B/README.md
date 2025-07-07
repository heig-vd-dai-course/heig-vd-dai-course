# DAI-TIC-B - Évaluation 1

Cette évaluation porte sur les notions suivantes :

- Git, GitHub et Markdown
- Java, IntelliJ IDEA et Maven
- Entrées/sorties (IOs) avec Java
- Docker et Docker Compose
- Travail pratique 1

Vous pouvez répondre aux questions en français ou en anglais.

L'évaluation dure 1h. Une fois que vous avez terminé, veuillez marquer votre
évaluation comme terminée.

Validez avec le corps enseignant que le système a bien enregistré votre
évaluation. Vous pourrez ensuite quitter la salle de façon silencieuse.

Ressources autorisées :

- Une feuille de résumé (recto) papier avec vos propres notes

Toute tentative de tricherie sera sanctionnée avec la note 1.

---

## Question 1 (2 points)

Qu'est-ce qu'une branche dans Git et pourquoi est-il important d'utiliser des
branches ?

<details>
<summary>Afficher la réponse</summary>

Une branche dans Git est une version distincte du dépôt qui permet de travailler
sur différentes fonctionnalités ou corrections sans affecter le reste du projet
(1 point). L'utilisation de branches facilite le développement en parallèle et
aide à gérer les différentes versions du projet (1 point).

</details>

## Question 2 (1 point)

Vrai ou faux : La méthode `readLine()` renvoie une chaîne contenant les
caractères de fin de ligne.

<details>
<summary>Afficher la réponse</summary>

Faux (1 point)

</details>

## Question 3 (2 points)

Qu'est-ce que le principe "Write Once, Run Anywhere" (WORA) en Java et comment
cela est-il possible ?

<details>
<summary>Afficher la réponse</summary>

Le principe WORA signifie que le code Java compilé peut fonctionner sur toutes
les plateformes qui supportent Java (1 point), grâce à la machine virtuelle Java
(JVM) (1 point).

</details>

## Question 4 (8 points)

Écrivez un programme Java qui lit le contenu d'un fichier texte (`input.txt`),
puis écrit son contenu dans un autre fichier texte (`output.txt`). Assurez-vous
d'utiliser toutes les bonnes pratiques vues en cours.

```java
class FileCopy {

  public static void main(String[] args) {
    // TODO: Implement the file copy program
  }
}
```

<details>
<summary>Afficher la réponse</summary>

```java
import java.io.*;
import java.nio.charset.StandardCharsets;

class FileCopy {

  public static void main(String[] args) {
    try ( // Try-with-resources to automatically close the resources (1 point)
        Reader reader = new FileReader("input.txt", StandardCharsets.UTF_8); // Use FileReader (0.5 point) with UTF-8 encoding (0.5 point)
        BufferedReader br = new BufferedReader(reader); // Use BufferedReader for efficiency (1 point)
        Writer writer = new FileWriter("output.txt", StandardCharsets.UTF_8); // Use FileWriter (0.5 point) with UTF-8 encoding (0.5 point)
        BufferedWriter bw = new BufferedWriter(writer) // Use BufferedWriter for efficiency (1 point)
    ) {
      int c;
      // Read the file character by character until the end of the file (1 point)
      while ((c = br.read()) != -1) {
        // Write the character to the output file (1 point)
        bw.write(c);
      }

      // Flush the buffer to ensure all data is written (1 point)
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
```

</details>

## Question 5 (2 points)

Comment compile-t-on et exécute-t-on une application Java simple et quelle est
la différence avec un fichier JAR ?

<details>
<summary>Afficher la réponse</summary>

Une application Java est compilée avec la commande `javac NomDuFichier.java`
(0.5 point) et exécutée avec la commande `java NomDuFichier` (0.5 point). La
différence avec un fichier JAR est qu'un fichier JAR une archive contenant le
bytecode et les ressources associées à une application Java (0.5 point), et peut
être exécuté avec la commande `java -jar NomDuFichier.jar` (0.5 point).

</details>

## Question 6 (1 point)

Quel est l'objectif principal du code ASCII ?

1. Supporter plusieurs alphabets
2. Mapper 128 valeurs binaires à 128 caractères
3. Encoder des caractères en UTF-8
4. Supporter des emojis

<details>
<summary>Afficher la réponse</summary>

Mapper 128 valeurs binaires à 128 caractères (1 point)

</details>

## Question 7 (3 points)

Quel est le rôle du fichier `pom.xml` dans un projet Maven ?

<details>
<summary>Afficher la réponse</summary>

Le fichier `pom.xml` contient la configuration du projet Maven (1 point),
incluant les dépendances (1 point) et les informations de construction du projet
(1 point).

</details>

## Question 8 (4 points)

Rédigez un document Markdown qui présente les points suivants:

- Un titre "Mes benchmarks"
- Un paragraphe avec une brève introduction fictive
- Un sous-titre "Résultats"
- Un tableau avec les colonnes suivantes et qui comporte trois données fictives:
  - Itération
  - Temps (en secondes)
- Un sous-titre "Conclusion"
- Une liste à puces non-ordonnée de 2-3 points fictifs sur les conclusions de
  vos benchmarks

<details>
<summary>Afficher la réponse</summary>

```markdown
# Mes benchmarks (0.5 point)

Ceci est une introduction fictive. (0.5 point)

## Résultats (0.5 point)

| Itération (0.5 point) | Temps (en secondes) (0.5 point) |
| --------------------- | ------------------------------- |
| 1 (0.5 point)         | 10                              |
| 2                     | 15                              |
| 3                     | 20                              |

## Conclusion (0.5 point)

- Les résultats montrent que... (0.5 point)
- Les performances sont...
```

</details>

## Question 9 (1 point)

Vrai ou faux : L'utilisation de try-with-resources garantit que les ressources
sont fermées même en cas d'erreur.

<details>
<summary>Afficher la réponse</summary>

Vrai (1 point)

</details>

## Question 10 (2 points)

Quels sont les deux types principaux de données que vous pouvez traiter avec
Java ? Donnez des exemples concrets de chaque type.

<details>
<summary>Afficher la réponse</summary>

1. Des fichiers texte (0.5 point). Exemple, lire et écrire des données dans un
   fichier Markdown (0.5 point).
2. Des fichiers binaires (0.5 point). Exemple, lire et écrire des données dans
   un fichier PDF. (0.5 point)

</details>

## Question 11 (3 points)

Vous rejoignez une équipe de développement pour contribuer à un projet open
source. Quelles étapes suivez-vous pour proposer une nouvelle fonctionnalité
dans le projet ?

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

## Question 12 (1 point)

Que signifie le terme "image" dans le contexte de la spécification OCI ?

1. Une instance en cours d'exécution d'un conteneur
2. Un modèle en lecture seule avec des instructions pour créer un conteneur
3. Un service qui stocke des conteneurs
4. Aucune de ces réponses

<details>
<summary>Afficher la réponse</summary>

Un modèle en lecture seule avec des instructions pour créer un conteneur (1
point)

</details>

## Question 13 (8 points)

Des erreurs et des mauvaises pratiques se sont glissées dans le code suivant.
Identifiez-les et proposez une correction.

```java
    InputStream fis = null;

    try {
      fis = new FileInputStream(filename);

      int b;
      while ((b = filename.read()) != 0) {
        // Do nothing - simulate processing
      }
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      try {
        fis.close();
      } catch (IOException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
```

<details>
<summary>Afficher la réponse</summary>

```java
    // Commentaires
    InputStream fis = null;

    try {
      fis = new FileInputStream(filename); // Non-buffered (1 point + 1 point pour la correction)

      int b;
      while ((b = filename.read()) != 0) { // On lit la variable filename au lieu de fis (1 point + 1 point pour la correction) + Different de 0 au lieu de -1 (1 point + 1 point pour la correction)
        // Do nothing - simulate processing
      }
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      // La condition `if (fis != null)` est manquante (1 point + 1 point pour la correction)
        try {
          fis.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
    }
```

```java
    // Corrections
    InputStream fis = null;

    try {
      fis = new FileInputStream(filename);BufferedInputStream bis = new BufferedInputStream(fis);

      int b;
      while ((b = bis.read()) != -1) {
          System.out.print(b);
      }

      bis.close();
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
        if (fis != null) {
            try {
              fis.close();
            } catch (IOException e) {
              System.err.println("Error: " + e.getMessage());
            }
        }
    }
```

</details>

## Question 14 (1 point)

Quel est l'outil principal utilisé pour gérer les conteneurs Docker ?

1. Docker Compose
2. Docker CLI
3. Docker Hub
4. Dockerfile

<details>
<summary>Afficher la réponse</summary>

Docker CLI (1 point)

> [!NOTE]
>
> Docker Compose peut gérer des conteneurs mais il ne s'agit pas de l'outil
> principal pour cette tâche. Pour les personnes qui avaient sélectionner
> _"Docker Compose"_, nous vous avons donné tous les points car la question peut
> effectivement porter à confusion.

</details>

## Question 15 (2 points - 2x 1 point)

Qu'est-ce que GitHub et quelle est sa principale différence avec Git ?

<details>
<summary>Afficher la réponse</summary>

GitHub est une plateforme de service basée sur le cloud pour le développement de
logiciels et le contrôle de version utilisant Git (1 point). La principale
différence est que Git est un outil de versionnement local, tandis que GitHub
fournit une interface web et des fonctionnalités sociales pour gérer des dépôts
Git en ligne. (1 point)

</details>
