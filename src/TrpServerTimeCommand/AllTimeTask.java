package TrpServerTimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Iterator;

public class AllTimeTask extends BukkitRunnable {
    public int id;

    public AllTimeTask(int _id) {
        id = _id;
    }

    @Override
    public void run() {
        Iterator onlinePlayers = Bukkit.getServer().getOnlinePlayers().iterator();
        while (onlinePlayers.hasNext()) {
            String command = Reader.config.getString("allTimeTask." + id + ".command");
            String message = Reader.config.getString("allTimeTask." + id + ".message");
            Player player = (Player) onlinePlayers.next();
            int allTime = Reader.data.getInt("allTime." + player.getName());
            int time = Reader.config.getInt("allTimeTask." + id + ".time");
            if (allTime % time == 0) {
                command = ChatColor.translateAlternateColorCodes('&', command.replaceAll("%playerName%", player.getName()));
                message = ChatColor.translateAlternateColorCodes('&', message.replaceAll("%allTimeMin%", Integer.toString(allTime)));
                player.sendMessage(Main.pluginName + message);
                if (!command.equals("@no")) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }
            }
        }
    }
}