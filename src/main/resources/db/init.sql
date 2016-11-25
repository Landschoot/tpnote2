/****************** Insertion des personnes ******************/
INSERT INTO PERSONNE VALUES (default, "Landschoot", "Charles", "Bien", null);
INSERT INTO PERSONNE VALUES (default, "Landschoot", "Guy", "Moyen", (SELECT id FROM PERSONNE WHERE prenom="Charle");
INSERT INTO PERSONNE VALUES (default, "Landschoot", "Ludovic", "Super", (SELECT id FROM PERSONNE WHERE prenom="Guy"));
INSERT INTO PERSONNE VALUES (default, "Landschoot", "Alicia", "Bof", (SELECT id FROM PERSONNE WHERE prenom="Guy"));
INSERT INTO PERSONNE VALUES (default, "Landschoot", "Tony", "Bof aussi", (SELECT id FROM PERSONNE WHERE prenom="Guy"));
