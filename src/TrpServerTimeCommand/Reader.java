package TrpServerTimeCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
public final class Reader {
    public static File file1;
    public static File file2;
    public static FileConfiguration config ;
    public static FileConfiguration data;
    static{
        file1 = new File(Main.instance.getDataFolder(),"config.yml");
        file2 = new File(Main.instance.getDataFolder(),"playerData.yml");
        config = YamlConfiguration.loadConfiguration(file1);
        data = YamlConfiguration.loadConfiguration(file2);
    }
    public static void reloadFiles(){
        file1 = new File(Main.instance.getDataFolder(),"config.yml");
        config = YamlConfiguration.loadConfiguration(file1);
    }
}
