package fr.s1b.mytestplugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("Plugin démarré");
    	
        //Créer le fichier de config dans le serveur s'il n'existe pas
        saveDefaultConfig();
    	
	    CommandExecutor testExecutor = new TestCommandExecutor();
	    getCommand("mytestplugin").setExecutor(testExecutor);
    }
    
    public void onDisable(){
        getLogger().info("Plugin arrêté");
    }
}
