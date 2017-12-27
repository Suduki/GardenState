package main;

import java.util.Random;

import org.joml.Vector3f;

import display.DisplayManager;
import entities.Camera;
import entities.Entity;
import entities.Light;
import model.Loader;
import model.MasterRenderer;
import model.OBJLoader;
import model.RawModel;
import model.EntityRenderer;
import model.TexturedModel;
import shaders.StaticShader;
import terrains.Terrain;
import texture.ModelTexture;

public class Main {
	public static Camera camera;
	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();
		RawModel model = OBJLoader.loadObjModel("dragon", loader);

		ModelTexture texture = new ModelTexture(loader.loadTexture("dragonTexture"));
		texture.setShineDamper(10);
		texture.setReflectivity(1);
		
		TexturedModel texturedModel = new TexturedModel(model, texture);

		Entity entity = new Entity(texturedModel, new Vector3f(15,15,-30), 0,0,90,1);
		Entity entity2 = new Entity(texturedModel, new Vector3f(-5,0,-25), 0,0,0,1);
		camera = new Camera();
		
		Light light = new Light(new Vector3f(2000,2000,2000), new Vector3f(1,1,1));
		
		Terrain terrain = new Terrain (-1, -1, loader, new ModelTexture(loader.loadTexture("logo")));
		
		MasterRenderer renderer = new MasterRenderer();
		while (DisplayManager.continueUpdating()) {
			entity.increaseRotation(0f,1.2f,0.3f);
			entity2.increaseRotation(0f,1,0.3f);
			camera.move();
			
			
			renderer.processTerrain(terrain);
			
			renderer.processEntity(entity);
			renderer.processEntity(entity2);
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}
		

		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
