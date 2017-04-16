package quaternary.getlost;

import akka.actor.dsl.Inbox;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quaternary.getlost.block.ModBlocks;
import quaternary.getlost.block.te.ModTes;
import quaternary.getlost.item.ModItems;
import quaternary.getlost.misc.GetLostCreativeTab;
import quaternary.getlost.proxy.CommonProxy;
import quaternary.getlost.recipe.ModRecipes;

@Mod(modid = GetLost.MODID, version = GetLost.VERSION)
public class GetLost {
	public static final String MODID = "getlost";
	public static final String VERSION = "oh man";
	
	public static Logger log;
	
	@SidedProxy(serverSide = "quaternary.getlost.proxy.CommonProxy", clientSide = "quaternary.getlost.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static final GetLostCreativeTab tab = new GetLostCreativeTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		log = LogManager.getLogger(MODID);
		log.info("Oh man I am not good with computer please to help".toUpperCase());
		
		ModItems.doTheThing();
		ModTes.doTheThing();
		ModBlocks.doTheThing();
		ModRecipes.doTheThing();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
}
