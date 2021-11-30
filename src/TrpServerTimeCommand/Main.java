package TrpServerTimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends JavaPlugin {
    public static JavaPlugin instance;
    public static String pluginName;
    @Override
    public void onLoad() {
        saveDefaultConfig();
    }
    @Override
    public void onEnable() {
        instance = this;
        pluginName = ChatColor.translateAlternateColorCodes('&',Reader.config.getString("name") );
        getLogger().info("当你看到这个的时候，TrServerTimeCommand已经加载到你的服务器中了~");
        getLogger().info("\nTrpServerTimeCommand  Copyright (C) 2021  TimeRunis\n" +
                "该程序不提供任何担保。\n" +
                "本插件是自由软件\n" +
                "你可以在一些条件下重新分发它\n"+
                "请参考 GNU 通用公共许可证（第三版)");
        countClear();
        if(!(new File(getDataFolder(), "playerData.yml")).exists()){
            saveResource("playerData.yml", false);}
        (new CountTask()).runTaskTimer(this,1200,1200);
        regTask();
        regEvent();
        Objects.requireNonNull(Bukkit.getPluginCommand("TrpServerTimeCommand")).setExecutor(new CommandHandler());
    }
    public void regTask(){
        int count = 1;
        while(Reader.config.get("timeTask."+ count)!=null){
            OneTimeTask t = new OneTimeTask(count);
            t.runTaskTimer(this,1200,1200);
            count++;
        }
        count = 1;
        while(Reader.config.get("allTimeTask."+ count)!=null){
            AllTimeTask t = new AllTimeTask(count);
            t.runTaskTimer(this,1200,1200);
            count++;
        }
        count = 1;
        while(Reader.config.get("dayTimeTask."+ count)!=null){
            DayTimeTask t = new DayTimeTask(count);
            t.runTaskTimer(this,1200,1200);
            count++;
        }
    }

    public void regEvent(){
        int count = 1;
        while(Reader.config.get("dayTimeEvent."+ count)!=null){
            DayTimeEvent t = new DayTimeEvent(count);
            t.runTaskTimer(this,1200,1200);
            count++;
        }
        count = 1;
        while(Reader.config.get("oneTimeEvent."+ count)!=null){
            OneTimeEvent t = new OneTimeEvent(count);
            t.runTaskTimer(this,1200,1200);
            count++;
        }
        count = 1;
        while(Reader.config.get("allTimeEvent."+ count)!=null){
            AllTimeEvent t = new AllTimeEvent(count);
            t.runTaskTimer(this,1200,1200);
            count++;
        }
    }
    public void countClear(){
        Reader.data.set("oneTime",null);
        getLogger().info("已清空oneTime记录！");
        try {
            Reader.data.save(Reader.file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
