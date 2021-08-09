package TrpServerTimeCommand;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class CountTask extends BukkitRunnable{

    public void countTask(){}

    public void run(){
        SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm");
        String t = nowTime.format(new Date());
        String endTime = Reader.config.getString("endTime");
        if(Objects.equals(endTime, t)){
            Reader.data.set("dayTime",null);
            try {
                Reader.data.save(Reader.file2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(Bukkit.getServer().getOnlinePlayers().size()==0)
            return;
        Iterator onlinePlayers = Bukkit.getServer().getOnlinePlayers().iterator();

        while(onlinePlayers.hasNext()){
            Player player = (Player) onlinePlayers.next();
            if(Reader.data.getString("oneTime."+player.getPlayer().getName())==null){
                Reader.data.set("oneTime."+player.getPlayer().getName(),0);
            }
            if(Reader.data.getString("allTime."+player.getPlayer().getName())==null){
                Reader.data.set("allTime."+player.getPlayer().getName(),0);
            }
            if(Reader.data.getString("dayTime."+player.getPlayer().getName())==null){
                Reader.data.set("dayTime."+player.getPlayer().getName(),0);
            }
            int t1 = Reader.data.getInt("oneTime."+player.getPlayer().getName());
            int t2 = Reader.data.getInt("allTime."+player.getPlayer().getName());
            int t3 = Reader.data.getInt("dayTime."+player.getPlayer().getName());
            Reader.data.set("oneTime."+player.getPlayer().getName(),t1+1);
            Reader.data.set("allTime."+player.getPlayer().getName(),t2+1);
            Reader.data.set("dayTime."+player.getPlayer().getName(),t3+1);
            try {
                Reader.data.save(Reader.file2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
