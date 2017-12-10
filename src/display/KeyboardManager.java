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
					Main.camera.moveUp(false);
					break;
			}
		}
		if (action == GLFW_RELEASE) {
			switch (key) {
				case GLFW_KEY_ESCAPE:
					glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
					break;
				case GLFW_KEY_W:
					Main.camera.moveUp(true);
					break;
			}
		}
	}

}
