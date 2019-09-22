package fr.s1b.mytestplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommandExecutor implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Si c'est un joueur qui a fait la commande
		if(sender instanceof Player) {
        	// On récupère le joueur.
            Player player = (Player)sender;

            sender.sendMessage("Bonjour " + player.getName() + ", vous m'avez envoyé: " + args.toString());
        }
		// Sinon, c'est la console
		else {
            sender.sendMessage("Bonjour maître, vous m'avez envoyé: " + args.toString());
        }
        return true;
	}

}
