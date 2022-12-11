-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 11 déc. 2022 à 17:37
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bibliothequetp4`
--

-- --------------------------------------------------------

--
-- Structure de la table `associe`
--

DROP TABLE IF EXISTS `associe`;
CREATE TABLE IF NOT EXISTS `associe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `associe`
--

INSERT INTO `associe` (`id`, `nom`, `prenom`) VALUES
(1, 'jean', 'dumat'),
(2, 'pierre', 'vende');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) NOT NULL,
  `nbExemplaire` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `titre` (`titre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `titre`, `nbExemplaire`) VALUES
(1, 'kaamelott', 4),
(2, 'the witcher', 3),
(5, 'les miserables', 0);

-- --------------------------------------------------------

--
-- Structure de la table `pret`
--

DROP TABLE IF EXISTS `pret`;
CREATE TABLE IF NOT EXISTS `pret` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idLivre` int NOT NULL,
  `idAssocie` int NOT NULL,
  `DateDebut` date NOT NULL,
  `dateRendu` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FOREIGN KEY Livre` (`idLivre`),
  KEY `FOREIGN KEY Associe` (`idAssocie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `pret`
--

INSERT INTO `pret` (`id`, `idLivre`, `idAssocie`, `DateDebut`, `dateRendu`) VALUES
(2, 1, 1, '2022-12-01', '2022-12-08');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `pret`
--
ALTER TABLE `pret`
  ADD CONSTRAINT `pret_ibfk_1` FOREIGN KEY (`idLivre`) REFERENCES `livre` (`id`),
  ADD CONSTRAINT `pret_ibfk_2` FOREIGN KEY (`idAssocie`) REFERENCES `associe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
