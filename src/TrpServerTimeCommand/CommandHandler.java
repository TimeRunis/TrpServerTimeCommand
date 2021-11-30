package TrpServerTimeCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import javax.annotation.ParametersAreNonnullByDefault;


public class CommandHandler implements CommandExecutor {
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (command.getName().equals("TrpServerTimeCommand")&&args[0].equals("reload")) {
            Reader.reloadFiles();
            Player player = (Player) sender;
            player.sendMessage(Main.pluginName+"配置已经重载");
            return true;
        }
        if (command.getName().equals("TrpServerTimeCommand")) {
            Player player = (Player) sender;
            String allTime = Reader.data.getString("allTime."+args[0]);
            String oneTime = Reader.data.getString("oneTime."+args[0]);
            String dayTime = Reader.data.getString("dayTime."+args[0]);
            player.sendMessage(Main.pluginName + "\n玩家"+args[0]+"\n今日在线："+dayTime+"分钟\n"+"开服后在线："+oneTime+"分钟\n"+"总在线："+allTime+"分钟\n");
            return true;
        }
        return true;
    }
}
