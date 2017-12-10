package entities;

import org.joml.Vector3f;

public class Camera {
	private Vector3f position = new Vector3f(0,0,0);
	private float pitch;
	private float yaw;
	private float roll;
	
	
	public Vector3f getPosition() {
		return position;
	}
	public float getPitch() {
		return pitch;
	}
	public float getYaw() {
		return yaw;
	}
	public float getRoll() {
		return roll;
	}
	private boolean moveUp;
	public void moveUp(boolean b) {
		moveUp = b;
		position.z -= 0.02f;
	}
	
	
	
}
