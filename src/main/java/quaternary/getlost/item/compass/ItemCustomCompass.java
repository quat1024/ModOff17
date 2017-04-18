package quaternary.getlost.item.compass;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import quaternary.getlost.GetLost;
import quaternary.getlost.item.compass.provider.ICompassLocationProvider;

import javax.annotation.Nullable;

public class ItemCustomCompass extends Item {
	
	ICompassLocationProvider p;
	String mynamejeff;
	
	private static double epsilon = 0.0001; //correct some error, so pointing *exactly* north works
	
	public ItemCustomCompass(String name, ICompassLocationProvider p_) {
		setUnlocalizedName(name);
		setRegistryName(name);
		GameRegistry.register(this);
		
		p = p_;
		mynamejeff = name;
		
		this.addPropertyOverride(new ResourceLocation("angle"), new IItemPropertyGetter() {
			@Override
			public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity) {
				
				//So you can do item frames, dropped items, etc.
				if(entity == null) return 0;
				
				//God dammit just pass in the correct world the first time Mojang
				if(world == null) world = entity.world;
				
				double angFacing = -entity.rotationYaw;
				double angCompass = p.getAngle(entity.posX, entity.posY);
				
				float combined = MathHelper.positiveModulo((float) ((angFacing - angCompass) + epsilon), 360f);
				
				GetLost.log.info(combined);
				
				return combined;
			}
		});
	}
	
	public void registerModel() {
		GetLost.proxy.registerItemModel(this, mynamejeff);
	}
	
}
