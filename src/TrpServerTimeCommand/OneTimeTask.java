package TrpServerTimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Iterator;
public class OneTimeTask extends BukkitRunnable {
    public int id;
    public OneTimeTask(int _id){
        id=_id;
    }
    @Override
    public void run() {
        Iterator onlinePlayers = Bukkit.getServer().getOnlinePlayers().iterator();
        while(onlinePlayers.hasNext()){
            String command = Reader.config.getString("timeTask."+id+".command");
            String message = Reader.config.getString("timeTask."+id+".message");
            Player player = (Player) onlinePlayers.next();
            int oneTime = Reader.data.getInt("oneTime."+player.getName());
            int time = Reader.config.getInt("timeTask."+id+".time");
            if(oneTime%time==0) {
                command = ChatColor.translateAlternateColorCodes('&',command.replaceAll("%playerName%",player.getName()));
                message = ChatColor.translateAlternateColorCodes('&', message.replaceAll("%oneTimeMin%",Integer.toString(oneTime)));
                player.sendMessage(Main.pluginName+message);
                if(!command.equals("@no")){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }
            }
        }

    }
}
