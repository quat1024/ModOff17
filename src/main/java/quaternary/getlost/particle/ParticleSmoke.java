package quaternary.getlost.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.NoiseGeneratorPerlin;

import java.util.Random;

public class ParticleSmoke extends Particle {
	
	final float MAX_PARTICLE_SCALE = 16;
	
	private float particleAngleSpeed;
	
	static NoiseGeneratorPerlin perlin = new NoiseGeneratorPerlin(new Random(), 4);;
	
	public ParticleSmoke(World w, double x, double y, double z, double mx, double my, double mz) {
		this(w, x, y, z, mx, my, mz, 7);
	}
	
	public ParticleSmoke(World w, double x, double y, double z, double mx, double my, double mz, float scale) {
		super(w, x, y, z);
		motionX = mx;
		motionY = my;
		motionZ = mz;
		particleScale = MAX_PARTICLE_SCALE;
		particleAge = 0;
		particleMaxAge = (int) (rand.nextFloat()*40) + 200;
		
		float brightness = 0.95f - rand.nextFloat() * 0.1f;
		particleRed = brightness;
		particleGreen = brightness;
		particleBlue = brightness;
		
		particleAngle = rand.nextFloat()*6.28f;
		particleAngleSpeed = (rand.nextFloat()*0.1f)-0.05f;
	}
	
	public void renderParticle(VertexBuffer buf, Entity e, float pt, float rx, float ry, float rz, float rxy, float rxz) {
		float timeFract = ((float) particleAge / particleMaxAge);
		
		timeFract = MathHelper.clamp(timeFract, 0f, 1f) + 0.4f;
		
		float currentScale = timeFract * MAX_PARTICLE_SCALE;
		
		particleScale = currentScale;
		super.renderParticle(buf, e, pt, rx, ry, rz, rxy, rxz);
	}
	
	public void onUpdate() {
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		prevParticleAngle = particleAngle;
		
		particleAge++;
		if(particleAge > particleMaxAge) setExpired();
		
		this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
		
		motionY += 0.004;
		//todo do I want particles to collide with stuff in the way vanilla particles do?
		move(motionX, motionY, motionZ);
		
		//todo make these move in a more interesting pattern than "straight up"
		
		float windX = (float) perlin.getValue(0, world.getWorldTime() * 0.05);
		float windZ = (float) perlin.getValue(123, 45 + (world.getWorldTime()*0.055));
		
		//this is a super subtle effect
		motionX += windX * 0.0005;
		motionZ += windZ * 0.0005;
		
		motionX *= 0.98;
		motionZ *= 0.98;
		
		particleAngle += particleAngleSpeed;
		particleAngleSpeed *= 0.99f;
	}
	
	
	
}
