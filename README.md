<h3 align="center">LP RPG Textuel</h3>
<p align="center">Création d'un jeu RPG textuel avec le langage Java</p>

## Histoire

**Salut et bienvenue, aventurier !**

Tu as été capturé et te retrouves prisonnier de ce mystérieux donjon. Pour t'en échapper, tu devras explorer ses sombres couloirs et trouver la sortie.

Mais attention ! Ce donjon est peuplé de monstres redoutables et parsemé d'obstacles qui barreront ta route. Pas de panique, cependant : grâce à ton pouvoir de télépathie, tu pourras invoquer le menu des armes pour t'équiper et renforcer tes chances de survie.

En détruisant les obstacles, tu auras aussi une chance de trouver des potions de vie qui te redonneront un peu d'énergie.

Ton objectif ultime ? Atteindre la sortie, située en bas à droite de la carte, et vaincre le boss final pour retrouver ta liberté.

Prépare-toi, car l'aventure commence maintenant !

## Fonctionnalités
Voici les fonctionnalités du jeu.
- Le joueur renseigne son pseudo puis choisis sa classe.
- Le joueur commence la partie avec aucune arme dans son inventaire. Il a la possibilité de choisir une arme et d'en acheter une.
- Le joueur peut se déplacer dans la maps et peu rencontrer des monstres et des obstacles (chaque partie et unique).
- Le joueur peut appuyer sur F pour ouvrir le menu d'achat d'arme.
- Le joueur peut appuyer sur E pour voir son inventaire.
- Le joueur voit ses statistiques tout le temps.
- Lors de la destruction d'un obstacle, le joueur à 1 chance sur 3 de drop une potion de santé.
- Le joueur peut appuyyer sur P pour utiliser une potion de santé.
- Lors d'un combat, l'utilisateur peut choisir de fuire ou 2 types d'attaques (attaque classique ou attaque special) cette dernière utilise du mana.
- A chaque combat gagné le joueur récupère du mana et gagne de l'XP, tout les 100Xp le joueur gagne un niveau et gagne 10 point de vie supplémentaire.
- Lors de la victoire face au Boss la partie est fini.

## Prérequis
Avant de commencer, assurez-vous d'avoir une connexion haut débit et installé les outils suivants sur votre machine :

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Java SDK** : [Lien du site de Java](https://www.oracle.com/java/technologies/downloads/)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Git** : [Lien du site de Git](https://git-scm.com/downloads)

Vous pouvez vérifier leurs versions installées avec les commandes suivantes depuis votre terminal de commande :

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`javac --version` -> Affiche votre version de Node.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`git --version` -> Affiche votre version de Git.


## Installation

### 1. Cloner le projet
   
Ouvrez votre terminal et exécutez la commande suivante pour cloner le dépôt :

```git clone https://github.com/Souyyy/LP_RPG_Textuel/```

### 2. Accéder au répertoire
Naviguez dans le dossier du projet :

```cd LP_RPG_Textuel```

### 4. Lancer l'application depuis votre terminal

Démarrez le serveur de développement :

```java Main.java```


## Technologies
Ce projet utilise plusieurs technologies modernes pour créer une expérience 3D interactive:

<table align="center">
  <tbody>
    <tr>
      <td  border="0">
        <img width="70" src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/121px-Java_programming_language_logo.svg.png" alt="Java">
        <p align="center">Java</p>
      </td>
    </tr>
  </tbody>
</table>

## Structure du projet

Ce projet comporte plusieurs package comme suit: 
- combats
- consommables
- destructibles
- maps
- personnages
- weapons

Ains que de plusieurs class.

## Licence
Ce programme est sous licence MIT.
