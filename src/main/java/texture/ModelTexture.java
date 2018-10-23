package texture;

public class ModelTexture {

	
	public float getShineDamper() {
		return shineDamper;
	}

	public float getReflectivity() {
		return reflectivity;
	}

	private int textureID;
	
	private float shineDamper = 1;
	private float reflectivity = 0;
	private boolean hasTransparency = false;

	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}

	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}

	public ModelTexture(int textureID) {
		this.textureID = textureID;
	}

	public boolean isHasTransparency() {
		return hasTransparency;
	}

	public int getID() {
		return textureID;
	}
	
}
