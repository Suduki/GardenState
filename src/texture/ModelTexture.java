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

	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}

	public ModelTexture(int textureID) {
		this.textureID = textureID;
	}

	public int getID() {
		return textureID;
	}
	
}
