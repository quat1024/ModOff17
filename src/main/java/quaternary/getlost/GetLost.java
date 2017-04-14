package quaternary.getlost;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = GetLost.MODID, version = GetLost.VERSION)
public class GetLost
{
    public static final String MODID = "getlost";
    public static final String VERSION = "oh man";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        System.out.println("WASSUP BRO I AM A SAMPLE MOD!!!!!!!!!!!!!!!!");
    }
}
