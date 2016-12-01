# tpnote2
TP noté n°2 de COO en M1MIAGEFA - Evaluation du personnel

## Présentation générale
Au cours de chaque année, l’activité professionnelle de chaque personnel de l’université doit être évaluée par une personne de l’université appelée son père. Chaque personnel a au plus un père mais peut avoir à évaluer plusieurs personnes : ses fils.

## Architecture
* gui : IHM - Intéraction de l'utilisateur en Swing et appels de services
* service : Traitements métiers de l'application - Communication controller / mapper
* persistence : Accès à la base de données - Transformation en objet Java
* domain : Objets métiers

## UML
Disponible à la racine du projet dans le fichier UML.png

## Executable
Vous avez à votre disposition un .jar exécutable de l'application dans le dossier target.

## Pré-requis
* Java 8
* Maven

## Tâches Maven
* `mvn clean install` : Installation des dépendances du projet
* `mvn exec:java` : Execution du projet
* `mvn clean compile assembly:single` : Génération d'un fichier JAR exécutable

## Ne pas oublier
* Installer le plugin Lombok (si vous utilisez IntelliJ)
* Modifier le fichier config.yml pour se connecter à une base de données

## Contributeurs
[Ludovic LANDSCHOOT](http://github.com/landschoot) & [Laurent THIEBAULT](http://github.com/lauthieb)
