
/**
 * Author:  Admin
 * Created: 22 mai 2019
 */

DROP DATABASE IF EXISTS school;
CREATE DATABASE school DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE school;

CREATE TABLE Ecole(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, Nom varchar(50) NOT NULL);
CREATE TABLE Niveau(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, Nom varchar(50) NOT NULL);
CREATE TABLE Discipline(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, Nom varchar(50) NOT NULL);

CREATE TABLE AnneeScolaire(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, annee int NOT NULL);
CREATE TABLE Trimestre(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, Numero int NOT NULL, Debut DATE NOT NULL, Fin DATE NOT NULL,annee_scolaire int NOT NULL, FOREIGN KEY(annee_scolaire) REFERENCES annee_scolaire(Id));
CREATE TABLE Classe(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, Nom varchar(50) NOT NULL, ecole int NOT NULL, FOREIGN KEY(ecole) REFERENCES ecole(Id), niveau int NOT NULL, FOREIGN KEY(niveau) REFERENCES niveau(Id),annee_scolaire int NOT NULL, FOREIGN KEY(annee_scolaire) REFERENCES annee_scolaire(Id));

CREATE TABLE Personne(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, Nom varchar(50) NOT NULL,Prenom varchar(50) NOT NULL);
CREATE TABLE Enseignant(personne int NOT NULL, FOREIGN KEY(personne) REFERENCES personne(Id));
CREATE TABLE Eleve(personne int NOT NULL, FOREIGN KEY(personne) REFERENCES personne(Id));

CREATE TABLE Enseignement(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,classe int NOT NULL, FOREIGN KEY(classe) REFERENCES classe(Id), discipline int NOT NULL, FOREIGN KEY(discipline) REFERENCES discipline(Id), enseignant int NOT NULL, FOREIGN KEY(enseignant) REFERENCES enseignant(Id) );
CREATE TABLE Inscription(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,classe int NOT NULL, FOREIGN KEY(classe) REFERENCES classe(Id), eleve int NOT NULL, FOREIGN KEY(eleve) REFERENCES eleve(Id));
CREATE TABLE Bulletin(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,Appreciation varchar(50) NOT NULL, trimestre int NOT NULL, FOREIGN KEY(trimestre) REFERENCES trimestre(Id),inscription int NOT NULL, FOREIGN KEY(inscription) REFERENCES inscription(Id));


CREATE TABLE DetailBulletin(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,Appreciation varchar(50) NOT NULL, enseignement int NOT NULL, FOREIGN KEY(enseignement) REFERENCES enseignement(Id), bulletin int NOT NULL, FOREIGN KEY(bulletin) REFERENCES bulletin(Id));
CREATE TABLE Evaluation(Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,Appreciation varchar(50) NOT NULL,Note int NOT NULL, detail_bulletin int NOT NULL, FOREIGN KEY(detail_bulletin) REFERENCES detail_bulletin(Id));



INSERT INTO Ecole(Nom) VALUES( 'ECE');
INSERT INTO Niveau(Nom) VALUES( 'ING1');
INSERT INTO Discipline(Nom) VALUES( 'Informatique');
INSERT INTO AnneeScolaire(annee) VALUES(2019);
INSERT INTO Trimestre(Numero, Debut, Fin, annee_scolaire) VALUES(1, '2018-09-09', '2018-12-01', 1);
INSERT INTO Classe(Nom, ecole, niveau, annee_scolaire) VALUES('TD1', 1,1,1);

INSERT INTO Personne(Nom, Prenom) VALUES('Legrand', 'Adriana');
INSERT INTO Personne(Nom, Prenom) VALUES( 'Dupont', 'Paul');
INSERT INTO Enseignant(personne) VALUES( 1);
INSERT INTO Eleve(personne) VALUES( 2);

INSERT INTO Enseignement(classe, discipline,enseignant ) VALUES(1, 1,1);
INSERT INTO Inscription(classe, eleve ) VALUES(1, 1);
INSERT INTO Bulletin(Appreciation, trimestre, inscription) VALUES('Excellent', 1, 1);
INSERT INTO DetailBulletin(Appreciation,enseignement, bulletin) VALUES('Excellent',1,1);
INSERT INTO Evaluation(Appreciation,Note,detail_bulletin) VALUES('Bien',14,1);









