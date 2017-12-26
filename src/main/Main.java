package main;

import java.util.Random;

import org.joml.Vector3f;

import display.DisplayManager;
import entities.Camera;
import entities.Entity;
import entities.Light;
import model.Loader;
import model.OBJLoader;
import model.RawModel;
import model.Renderer;
import model.TexturedModel;
import shaders.StaticShader;
import texture.ModelTexture;

public class Main {
	public static Camera camera;
	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		RawModel model = OBJLoader.loadObjModel("dragon", loader);
		ModelTexture texture = new ModelTexture(loader.loadTexture("dragonTexture"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		Entity entity = new Entity(texturedModel, new Vector3f(15,15,-30), 0,0,90,1);
		Entity entity2 = new Entity(texturedModel, new Vector3f(-5,0,-25), 0,0,0,1);
		camera = new Camera();
		
		Light light = new Light(new Vector3f(0,0,-20), new Vector3f(1,1,1));
		
		while (DisplayManager.continueUpdating()) {
			entity.increaseRotation(0f,1.2f,0.3f);
			entity2.increaseRotation(0f,1,0.3f);
			camera.move();
			
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity2, shader);
			renderer.render(entity, shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
