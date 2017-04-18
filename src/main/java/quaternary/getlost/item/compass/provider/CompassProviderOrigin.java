package quaternary.getlost.item.compass.provider;

public class CompassProviderOrigin implements ICompassLocationProvider {
	
	public CompassProviderOrigin() {
		//bla
	}
	
	public float getAngle(double playerX, double playerY) {
		return (float) Math.atan2(-playerY, -playerX) * 57.2958f; //That's to make it degrees.
	}
	
}
