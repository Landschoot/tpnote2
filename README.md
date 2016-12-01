# tpnote2
TP noté n°2 de COO en M1MIAGEFA - Evaluation du personnel

## Présentation générale
Au cours de chaque année, l’activité professionnelle de chaque personnel de l’université doit être évaluée par une personne de l’université appelée son père. Chaque personnel a au plus un père mais peut avoir à évaluer plusieurs personnes : ses fils.

## Architecture
* gui : IHM - Intéraction de l'utilisateur en Swing et appels de services
* service : Traitements métiers de l'application - Communication controller / mapper
* persistence : Accès à la base de données - Transformation en objet Java
* domain : Objets métiers

## Tâches Maven
* `mvn clean install` : Installation des dépendances du projet
* `mvn exec:java` : Execution du projet
* `mvn clean compile assembly:single` : Génération d'un fichier JAR exécutable

## Ne pas oublier
* Installer le plugin Lombok sur IntelliJ
* Ajouter un fichier config.yml dans resources contenant :
db:  
    driver: jdbc:mysql  
    hote: localhost:8889  
    base: personnels     
    login: root  
    password: root  

## Contributeurs
[Ludovic LANDSCHOOT](http://github.com/landschoot) & [Laurent THIEBAULT](http://github.com/lauthieb)
