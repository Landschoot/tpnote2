/****************** Configuration de la Base ******************/
-- Création de la base
DROP DATABASE IF EXISTS personnels;
CREATE DATABASE personnels CHARACTER SET 'utf8';
USE personnels;

/****************** Création des tables ******************/
-- Table des utilisateurs
DROP TABLE IF EXISTS USER;
CREATE TABLE USER (
  identifiant varchar(20) NOT NULL primary key,
  name varchar(15) NOT NULL,
  firstname varchar(15) NOT NULL,
  evaluation varchar(200) NOT NULL,
  father varchar(20)
);

ALTER TABLE PERSONNE
  ADD CONSTRAINT fk_personne_pere foreign key (father) REFERENCES PERSONNE(identifiant);