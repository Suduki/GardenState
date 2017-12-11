package display;

import static org.lwjgl.glfw.GLFW.*;
import main.Main;

public class KeyboardManager {

	public long window;

	public KeyboardManager(long window) {
		this.window = window;
	}


	public void handleKeyboardEvents(int action, int key) {
		if (action == GLFW_PRESS) {
			switch (key) {
				case GLFW_KEY_W:
					Main.camera.moveNorth(true);
					break;
				case GLFW_KEY_S:
					Main.camera.moveSouth(true);
					break;
				case GLFW_KEY_A:
					Main.camera.moveWest(true);
					break;
				case GLFW_KEY_D:
					Main.camera.moveEast(true);
					break;
				case GLFW_KEY_Q:
					Main.camera.moveUp(true);
					break;
				case GLFW_KEY_E:
					Main.camera.moveDown(true);
					break;
			}
		}
		if (action == GLFW_RELEASE) {
			switch (key) {
				case GLFW_KEY_ESCAPE:
					glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
					break;
				case GLFW_KEY_W:
					Main.camera.moveNorth(false);
					break;
				case GLFW_KEY_S:
					Main.camera.moveSouth(false);
					break;
				case GLFW_KEY_A:
					Main.camera.moveWest(false);
					break;
				case GLFW_KEY_D:
					Main.camera.moveEast(false);
					break;
				case GLFW_KEY_Q:
					Main.camera.moveUp(false);
					break;
				case GLFW_KEY_E:
					Main.camera.moveDown(false);
					break;
			}
		}
	}

}
