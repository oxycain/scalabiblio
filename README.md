#  Projet de Gestion de Bibliothèque en Scala

Ce projet de Gestion de Bibliothèque en Scala est conçu pour permettre la gestion de livres dans une bibliothèque. Il offre des fonctionnalités de base, telles que l'ajout de livres, l'emprunt de livres et le rendu de livres. De plus, le projet implémente certaines fonctionnalités avancées, notamment la gestion des erreurs, la sauvegarde de l'état de la bibliothèque dans un fichier CSV et la recherche de livres par titre ou auteur.

##  Contenu du Projet

Le projet se compose de trois fichiers source principaux :

**Livre.scala** : Cette classe définit la structure des livres, avec des attributs tels que le titre, l'auteur, l'année de publication et l'état d'emprunt.

###### _Attributs de la classe Livre :_

`titre` (String) : Le titre du livre.

`auteur` (String) : Le nom de l'auteur du livre.

`anneeDePublication` (Int) : L'année de publication du livre.

`estEmprunte` (Boolean) : Un indicateur de l'état d'emprunt du livre.

###### _Méthodes de la classe Livre :_

`emprunter()` : met à jour l'état d'emprunt d'un livre qui vient d'etre emprunté.

`rendre()` : met à jour l'état d'emprunt d'un livre qui vient d'etre rendu.

**Bibliotheque.scala :** Cette classe représente la bibliothèque, avec des fonctionnalités pour ajouter, emprunter, rendre et rechercher des livres. Elle prend également en charge la sauvegarde de l'état de la bibliothèque dans un fichier CSV et le chargement de données depuis un fichier.

###### _Attributs de la classe Bibliotheque :_

`listeDeLivres (ListBuffer[Livre])` : Une liste de livres dans la bibliothèque.

###### _Méthodes de la classe Bibliotheque :_

`ajouterLivre(livre: Livre)` : Permet d'ajouter un livre à la bibliothèque.

`emprunterLivre(titre: String)` : Permet d'emprunter un livre en fonction du titre.

`rendreLivre(titre: String)` : Permet de rendre un livre en fonction du titre.

`rechercherParAuteur(auteur: String)` : Permet de rechercher un livre par auteur.

`rechercherParTitre(titre: String)` : Permet de rechercher un livre par titre.

`sauvegarderDansFichier(nomFichier: String)` : Sauvegarde l'état de la bibliothèque dans un fichier CSV.

`chargerDepuisFichier(nomFichier: String)` : Charge les données depuis un fichier CSV pour restaurer l'état de la bibliothèque.

**main.scala** : C'est le fichier principal de l'application qui interagit avec l'utilisateur. Il propose un menu permettant d'ajouter des livres, d'effectuer des opérations d'emprunt et de rendu, de rechercher des livres, de sauvegarder l'état de la bibliothèque, etc.

## Utilisation
Pour utiliser ce projet, vous pouvez suivre ces étapes :

1) Clonez le référentiel GitHub : en choisissant le protocole que vous souhaitez.

2) Compilez le code source à l'aide de SBT ou de l'IDE Scala de votre choix.

3) Exécutez le fichier main.scala pour lancer l'application de gestion de bibliothèque.

4) Suivez les instructions du menu pour ajouter des livres, effectuer des opérations d'emprunt ou de rendu, rechercher des livres, sauvegarder l'état de la bibliothèque, etc.

### Sauvegarde et Mise à Jour des Données
La classe Bibliotheque prend en charge la sauvegarde de l'état actuel de la bibliothèque dans un fichier CSV. On utilise la méthode `sauvegarderDansFichier(nomFichier: String)` pour sauvegarder les données. Pour charger des données à partir d'un fichier CSV et restaurer l'état de la bibliothèque, on utilise la méthode `chargerDepuisFichier(nomFichier: String)`.

### Tests Unitaires
Ce projet est accompagné de tests unitaires pour vérifier le bon fonctionnement des fonctionnalités. Les tests unitaires sont conçus pour valider les différentes opérations de gestion de bibliothèque, y compris l'ajout de livres, l'emprunt, le rendu et la recherche. De part leurs natures (tests unitaires), nous avons testé chaque fonction en l'isolant du reste. On a également testé des fonctions qu'on a override comme `equals`. Les tests ont été réalisés en utilisant Scalatest, un framework de test qui permet de réaliser les tests unitaires mais également ceux d'intégration. Nous utilisons le style de test : FlatsTest qui comme son nom l'indique implique une approche plate et non pas hiérarchique dans l'organisation des tests. 