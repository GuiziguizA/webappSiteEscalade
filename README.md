
	Prerequis:

installer java 8

installer maven 3.6 

creer une base de données mysql  

l'url de la base de données : jdbc:mysql://localhost:3306 

avec pour nom utilisateur :root 

pw : (vide) 

Possibilité de changer les paramètres de la base de données dans le fichier applications.properties

creer une table banqueescalade 

	Packaging:

cloner le projet

se placer à la racine du projet

executer la commande : mvn package

	
	Deploiement:

se placer a la racine du projet et executer : java -jar target\SiteEscalade-0.0.1-SNAPSHOT.jar

	Execution:

http://localhost:8080/login

