package utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {
	
	public static  Connection connexionBdd;
	
	
	public static void getConnexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex1) {
			System.out.println("Pilote non trouvé!");
			System.exit(1);
		}
		try {
			Connection connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/cinema","root", "");
			System.out.println("Connected!");
			connexionBdd =  connection;
		}
		catch (SQLException ex2) {
			System.out.println("Erreur JDBC: "+ex2);
			System.exit(1);
		}
	}
	
	public static void creerJeuDeDonnee() {
		try {
			Statement statement = connexionBdd.createStatement();
			
			statement.executeUpdate("DROP TABLE IF EXISTS `projection`;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `projection` (\r\n"
					+ "  `idFilm` int(11) NOT NULL,\r\n"
					+ "  `idSalle` int(11) NOT NULL,\r\n"
					+ "  `heure` time DEFAULT NULL,\r\n"
					+ "  `dateDebut` date NOT NULL,\r\n"
					+ "  `dateFin` date NOT NULL,\r\n"
					+ "  PRIMARY KEY (`idFilm`,`idSalle`),\r\n"
					+ "  KEY `idSalle` (`idSalle`)\r\n"
					+ ");");
			
			statement.executeUpdate("INSERT INTO `projection` (`idFilm`, `idSalle`, `heure`, `dateDebut`, `dateFin`) VALUES\r\n"
					+ "(1, 1, '15:00:00', '2022-12-07', '2022-12-14'),\r\n"
					+ "(2, 2, '20:15:00', '2022-12-07', '2022-12-14');");
			
			statement.executeUpdate("DROP TABLE IF EXISTS `salle`;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `salle` (\r\n"
					+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nom` varchar(50) DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`id`)\r\n"
					+ ");");
			
			statement.executeUpdate("INSERT INTO `salle` (`id`, `nom`) VALUES\r\n"
					+ "(1, 'Chanon'),\r\n"
					+ "(2, 'Brossais');");
			
			statement.executeUpdate("DROP TABLE IF EXISTS `appreciation`;");
			statement.executeUpdate(""
					+ " CREATE TABLE IF NOT EXISTS appreciation("
					+ " `idSpectateur` int(11) NOT NULL,"
					+ " `idFilm` int(11) NOT NULL,"
					+ " `note` int(11) DEFAULT NULL,"
					+ " PRIMARY KEY (`idSpectateur`,`idFilm`),"
					+ " KEY `idFilm` (`idFilm`)"
					+ ");");
			
			statement.executeUpdate("INSERT INTO `appreciation` (`idSpectateur`, `idFilm`, `note`) VALUES\r\n"
					+ "(1, 1, 1),\r\n"
					+ "(1, 2, 3),\r\n"
					+ "(2, 1, 2),\r\n"
					+ "(2, 2, 1);");
			
			statement.executeUpdate("DROP TABLE IF EXISTS `spectateur`;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `spectateur` (\r\n"
					+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `nom` varchar(50) DEFAULT NULL,\r\n"
					+ "  `prenom` varchar(50) DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`id`)\r\n"
					+ ");");
			
			statement.executeUpdate("INSERT INTO `spectateur` (`id`, `nom`, `prenom`) VALUES\r\n"
					+ "(1, 'Jean', 'ValJean'),\r\n"
					+ "(2, 'Aurelien', 'DeFonseca');");
			
			
			statement.executeUpdate("DROP TABLE IF EXISTS `film`;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `film` (\r\n"
					+ "  `id` int(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `titre` varchar(100) NOT NULL,\r\n"
					+ "  `duree` varchar(50) DEFAULT NULL,\r\n"
					+ "  `visa_exploitation` varchar(100) DEFAULT NULL,\r\n"
					+ "  `realisateur` varchar(100) NOT NULL,\r\n"
					+ "  `annee_sortie` date DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`id`)\r\n"
					+ ");");
			
			statement.executeUpdate("INSERT INTO `film` (`id`, `titre`, `duree`, `visa_exploitation`, `realisateur`, `annee_sortie`) VALUES\r\n"
					+ "(1, 'Kaamelott', '3', 'Projection', 'Astier', '2022-12-04'),\r\n"
					+ "(2, 'RapideEtFurieux', '2', 'Projection', 'TheRock', '2022-12-11');");
			
			
			statement.executeUpdate("ALTER TABLE `appreciation`\r\n"
					+ "  ADD CONSTRAINT `appreciation_ibfk_1` FOREIGN KEY (`idSpectateur`) REFERENCES `spectateur` (`id`),\r\n"
					+ "  ADD CONSTRAINT `appreciation_ibfk_2` FOREIGN KEY (`idFilm`) REFERENCES `film` (`id`);");
			
			statement.executeUpdate("ALTER TABLE `projection`\r\n"
					+ "  ADD CONSTRAINT `projection_ibfk_1` FOREIGN KEY (`idFilm`) REFERENCES `film` (`id`),\r\n"
					+ "  ADD CONSTRAINT `projection_ibfk_2` FOREIGN KEY (`idSalle`) REFERENCES `salle` (`id`);");
			
			//statement.executeUpdate("");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
