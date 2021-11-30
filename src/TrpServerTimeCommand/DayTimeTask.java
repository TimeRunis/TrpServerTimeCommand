package TrpServerTimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.Iterator;
public class DayTimeTask extends BukkitRunnable {
    public int id;
    public DayTimeTask(int _id){
        id=_id;
    }
    @Override
    public void run() {
        Iterator onlinePlayers = Bukkit.getServer().getOnlinePlayers().iterator();
        while(onlinePlayers.hasNext()){
            String command = Reader.config.getString("dayTimeTask."+id+".command");
            String message = Reader.config.getString("dayTimeTask."+id+".message");
            Player player = (Player) onlinePlayers.next();
            int dayTime = Reader.data.getInt("dayTime."+player.getName());
            int time = Reader.config.getInt("dayTimeTask."+id+".time");
            if(dayTime%time==0) {
                command = ChatColor.translateAlternateColorCodes('&',command.replaceAll("%playerName%",player.getName()));
                message = ChatColor.translateAlternateColorCodes('&', message.replaceAll("%dayTimeMin%",Integer.toString(dayTime)));
                player.sendMessage(Main.pluginName+message);
                if(!command.equals("@no")){
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                }
            }
        }

    }
}
