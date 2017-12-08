package display;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

public class DisplayManager {

	private static final int TOTAL_PIXEL_X = 600;
	private static final int TOTAL_PIXEL_Y = 800;
	private static final int FPS = 60;
	private static long window;

	public static void createDisplay() {
		if (!glfwInit()) {
			System.err.println("ERR: GLFW FAILED TO INITIALIZE");
		}
		
		window = initGL();
	}
	
	public static void closeDisplay () {
		glfwTerminate();
	}
	
	public static void updateDisplay() {
		glfwPollEvents();
		glfwSwapBuffers(window);
	}
	
	
	private static long initGL() {
		long win = glfwCreateWindow(TOTAL_PIXEL_Y, TOTAL_PIXEL_X, "WINDOW THING", 0, 0);
		glfwMakeContextCurrent(win);
		GL.createCapabilities();
		glfwSwapInterval(FPS);
		glfwShowWindow(win);
		
		return win;
	}

	public static boolean continueUpdating() {
		return !glfwWindowShouldClose(window);
	}
}
