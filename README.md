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

# Créer son premier plugin
C'est là que les choses se corsent, et surtout là que ça devient intérressant.

Clairement, le **niveau "requis"** ici est bien **supérieur** a celui que la plupart d'entre vous a pour l'instant.
Mais on compte bien changer ça non ? Donc pas de panique, on va voir ça au fûr et à mesure.
> Note: Certaines explications ne seront que partiellement correcte, pour des raisons de simplicité.


La **règle absolue à respecter** dès à présent est la suivante :
> Je ne comprends/connais pas ? Je me renseigne !
> **Se renseigner**, c'est aussi bien **demander** à vos **camarades**, à **moi** ou regarder sur **internet**.

## Prêt à programmer ?
C'est parti !!!

## Classe principale
Pendant le cours, nous avons vu que le **point d'entrée** de notre **programme** était la **fonction main**.
> public static void **main**(String... args) {}

Mais ça, c'est quand notre projet est lui-même le programme principal !


Dans notre cas, le **programme principal** est le serveur **Spigot**.
Il va donc falloir fournir à **Spigot** un moyen d'utiliser **nos fonctions**. 

### Hériter de JavaPlugin
En **Java**, est dans les autres **langages orientés objets**, on retrouve la notion d'**héritage**.
L'**héritage** sert à avoir toutes les **caractéristiques de son parent** en plus d'**avoir les siennes**.

Au jugé, on peut dire que si la phrase "X est un Y" alors il y a des chances de pouvoir en hériter.
> Pour de plus amples informations, on peux regarder sur le [wikibook](https://fr.wikibooks.org/wiki/Programmation_Java/H%C3%A9ritage).

Notre **"classe principale"** est un **JavaPlugin**, on exprime cela avec le mot clef **extends** :
> class Main **extends** JavaPlugin {

### Redéfinir les methodes onEnable et onDisable
En **héritant** de la classe **JavaPlugin**, nous **héritons** aussi de toutes ses **méthodes et attributs *public* et *protected***.

Nous avons donc accès à [de nombreuses méthodes](https://jd.bukkit.org/org/bukkit/plugin/java/JavaPlugin.html).

Dans un premier temps, nous n'utiliserons que les méthodes onEnable() et onDisable().
> public void **onDisable()**
> *Called when this plugin is disabled*

> public void	**onEnable()**
> *Called when this plugin is enabled*

Nous pouvons donc ajouter ces méthodes dans notre classe !
Cependant, il nous faut préciser que l'on veut remplacer les méthodes de JavaPlugin.

Le mot-clé **@override** est utilisé pour définir une **méthode** qui est **héritée de la classe parente**. 
On ne l'utilise donc que dans le cas de l'héritage. En plaçant ce mot-clé juste au dessus de la méthode réécrite, le **compilateur vérifiera** que la **méthode** est **correctement redéfinie** (mêmes **arguments**, même **type de valeur de retour**) et affichera un message d'avertissement si ce n'est pas le cas.

> **@override** \
> public void **onEnable**() {
>
> }


# Compiler et lancer le plugin
Pour compiler votre projet, vous devez choisir d'exporter votre projet au format **.jar**.
Il vous suffira ensuite de mettre se **.jar** dans le dossier **plugins** de votre serveur et de **redémarrer** le serveur.


# Troubleshooting
## Mon plugin n'est pas trouvé par le serveur
Assurez-vous de l'avoir placé au bon endroit, et que vous avez bien mis les différents **.yml** lors de l'export.

## Mon plugin est bien activé, mais beaucoup de lignes d'erreurs sont affichées juste après
Le plus problable dans ce cas la, c'est qu'il y ait une erreur dans **plugin.yml** ou dans **permissions.yml**.
Maintenant, l'erreur la plus probable risque d'être une faute dans le nom de la commande et/ou de la permission associée.
> Note: Pour débugger plus facilement, copiez toutes les commandes et le permissions dans un autre fichier, et réintegrez les progressivement jusqu'à ce que le plugin casse, et vous aurez sûrement localisé l'erreur.
