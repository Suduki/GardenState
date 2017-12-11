package entities;

import org.joml.Vector3f;

public class Camera {
	private Vector3f position = new Vector3f(0,0,0);
	private float pitch;
	private float yaw;
	private float roll;
	
	public void move() {
		if (moveUp) {
			position.z -= 0.02f;
		}
		if (moveDown) {
			position.z += 0.02f;
		}
		if (moveWest) {
			position.x -= 0.02f;
		}
		if (moveEast) {
			position.x += 0.02f;
		}
		if (moveSouth) {
			position.y -= 0.02f;
		}
		if (moveNorth) {
			position.y += 0.02f;
		}
		
	}
	
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
	}
	private boolean moveDown;
	public void moveDown(boolean b) {
		moveDown = b;
	}
	private boolean moveWest;
	public void moveWest(boolean b) {
		moveWest = b;
	}
	private boolean moveEast;
	public void moveEast(boolean b) {
		moveEast = b;
	}

	private boolean moveNorth;
	public void moveNorth(boolean b) {
		moveNorth = b;
	}

	private boolean moveSouth;
	public void moveSouth(boolean b) {
		moveSouth = b;
	}
	
	
	
}
