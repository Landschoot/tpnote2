/****************** Configuration de la Base ******************/
-- Création de la base
DROP DATABASE IF EXISTS personnels;
CREATE DATABASE personnels CHARACTER SET 'utf8';
USE personnels;

/****************** Création des tables ******************/
-- Table des utilisateurs
DROP TABLE IF EXISTS PERSONNE;
CREATE TABLE PERSONNE (
  id int NOT NULL AUTO_INCREMENT primary key,
  nom varchar(15) NOT NULL,
  prenom varchar(15) NOT NULL,
  evaluation varchar(200) NOT NULL,
  pere varchar(100) NOT NULL
);

/*
ALTER TABLE PERSONNE
  ADD CONSTRAINT fk_personne_pere foreign key (pere) REFERENCES PERSONNE(id);
*/