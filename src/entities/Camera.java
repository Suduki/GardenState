package entities;

import org.joml.Vector3f;

public class Camera {
	private Vector3f position = new Vector3f(500,7,500);
	private float pitch;
	private float yaw;
	private float roll;
	
	private float directionX = 0, directionZ = 1;
	
	public void move() {
		if (moveUp) {
			position.y -= 0.2f;
			if (position.y < 0.1f) {
				position.y = 0.1f;
			}
		}
		if (moveDown) {
			position.y += 0.2f;
		}
		if (moveWest) {
			position.z -= directionX;
			position.x -= directionZ;
		}
		if (moveEast) {
			position.z += directionX;
			position.x += directionZ;
		}
		if (moveSouth) {
			position.z += directionZ;
			position.x -= directionX;
		}
		if (moveNorth) {
			position.z -= directionZ;
			position.x += directionX;
		}
		if (rotate) {
			pitch +=1;
		}
		if (rotateR) {
			yaw += 1;
			directionX = (float) Math.sin(Math.toRadians(yaw));
			directionZ = (float) Math.cos(Math.toRadians(yaw));
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
	
	private boolean rotate;
	public void rotate(boolean b) {
		rotate = b;
	}
	
	private boolean rotateR;
	public void rotateR(boolean b) {
		rotateR = b;
	}
}
