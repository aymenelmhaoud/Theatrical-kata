# Theatrical Players - Kata en Java

Cette solution est une implémentation Java du kata "Theatrical Players", issu du livre Refactoring de Martin Fowler. Elle illustre l'évolution d'un code impératif vers une version refactorisée, plus claire et orientée objets.

## Objectif

Le programme génère une facture pour un client de théâtre qui assiste à plusieurs pièces. Chaque pièce peut être un drame ou une comédie. Le montant dû et les crédits fidélité sont calculés selon des règles spécifiques à chaque type de pièce.

## Exécution

L'entrée est une structure contenant :

- une liste de pièces (nom, type)
- des représentations (nom de la pièce, nombre de spectateurs)

Le programme affiche ensuite une facture textuelle avec :

- le total à payer
- les crédits accumulés
- le détail des pièces jouées

## Règles de calcul

Pour les drames :

- 40000 unités pour les 30 premiers spectateurs
- 1000 unités en plus par spectateur au-delà de 30

Pour les comédies :

- 30000 unités de base
- 300 unités en plus par spectateur
- 10000 unités supplémentaires si plus de 20 spectateurs
- Crédit supplémentaire : 1 crédit par 5 spectateurs

Crédits fidélité :

- 1 crédit par représentation avec plus de 30 spectateurs
- +1 crédit pour chaque tranche de 5 spectateurs d'une comédie

## Structure du projet

- InvoicePrinter : classe principale qui produit la facture
- Performance : représentation d'une pièce
- Play : définition d'une pièce (nom, type)
- StatementGenerator : logique métier du calcul
- Données fournies au format JSON en entrée ou directement via des objets

## Lancement

1. Cloner le projet
   git clone https://github.com/aymenelmhaoud/theatrical-players-java.git
   cd theatrical-players-java

2. Compiler le projet
   mvn compile

3. Lancer la classe main
   mvn exec:java -Dexec.mainClass="com.exemple.Main"

## Étapes de refactorisation (optionnel)

La version brute initiale est ensuite refactorisée en plusieurs classes :

- Separation des données et de la logique
- Introduction des stratégies de calcul selon le type de pièce
- Passage à un modèle orienté objets

## Références

- Kata original : Refactoring de Martin Fowler
- Version Java basée sur les principes de clean code

