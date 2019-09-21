# Installation

## Java JDK 11

La **version 11 du JDK** étant la nouvelle ***LTS*** (*Long Term Support*), il est **fortement conseillé** de l'utiliser.
Pour ceux utilisant Java 12 ou 13, j'interdis l'utilisation de la nouvelle syntaxe pour les switchs pour des raisons de compatibilité.

### Windows
Vous pouvez utiliser la version du JDK d'**[Oracle](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)** ou bien son homologue OpenSource, **[OpenJdk](https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_windows-x64_bin.zip)**.

### Linux / Mac
Récuppérez **OpenJDK** depuis votre manageur de paquets sinon réccuperez les binaires depuis **[Oracle](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)**
ou **[OpenJdk](https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_linux-x64_bin.tar.gz)**.


## Installer Eclipse
Si ce n'est pas déjà fait, installez **[Eclipse](https://www.eclipse.org/downloads/)**:

Choisissez **Eclipse IDE for Java Developers**
(car nous n'utiliserons pas les outils additionnels de la version entreprise,
mais si vous l'avez déjà installer, ce n'est pas grave).

## Installer GIT
**GIT** est un outil pour gérér différentes version de son code.
Il permet de remonter dans le temps et de pouvoir dévelloper en parrallèle avec d'autres personnes sans avoir a échanger 100000 fichiers par mails ou ftp.
> Note: L'outil fonctionne en console, mais il existe **Github Desktop**, un outil graphique que je vous recommande d'utiliser dans un premier temps.

Faire une réelle explication serait aussi long qu'un cours, donc je vous expliquerai directement au besoin.

## Spigot, CraftBukkit et Bukkit
**Spigot** et **CraftBukkit** sont deux **programmes Java** qui permettent de lancer un **serveur Minecraft**. Ils **implémentent** tous deux la **API Bukkit**, qui permet d'appeler des **constructeurs** et des **méthodes** pour créer et manipuler tous les objets Minecraft (et même plus).

Nous allons utiliser **Spigot** c'est un **serveur minecraft** plus **léger** et plus **sécurisé** que les serveurs de base. Il existe des alternatives possiblement plus performantes (telle TacoSpigot), mais pour des raisons de simplicité, et d'unicité, nous utiliserons **Spigot**.

Pour ne pas tout faire à la main, on aura qu'a télécharger **[BuildTools.jar](https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar)** et le lancer avec notre terminal à l'endroit où l'on veut mettre tous nos fichiers pour le serveur.

> java -jar BuildTools.jar --rev 1.14.4

# Préparer son environnement
## Importer ou créer un nouveau projet

## Bukkit
Comme je l'ai dit avant, **Spigot** n'est que le serveur. Pour pouvoir programmer dans de bonnes conditions, il nous faut importer l'**API BUKKIT** dans **Eclipse** afin d'avoir automatiquement les suggestions et acceder à la **documentation** facilement.

### Ajouter Bukkit à notre projet
Allez dans les propriétés du projet > Java Build Path(menu de gauche) > Libraries(3ème onglet).
Cliquez ensuite sur "Modulepath" puis dans le menu de droite "Add External JARs..." et choisissez le fichier .jar "VotreDossier/Bukkit/target/bukkit-1.14XXXXXXXXXXXXXXXX-SNAPSHOT-shaded.jar".

Maintenant, vous devriez voir votre nouveau ".jar" au dessus du jre. Il nous reste plus qu'a ajouter la javadoc.

### Ajouter la javadoc
Cliquez sur le chevron à droite du "bukkitXXX.jar", et éditez Javadoc location afin de mettre l'addresse suivante :
> https://hub.spigotmc.org/javadocs/bukkit/ 

# Compiler et lancer le plugin
