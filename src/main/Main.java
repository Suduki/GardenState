package main;

import java.util.ArrayList;
import java.util.List;
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


		RawModel model = OBJLoader.loadObjModel("tree", loader);

		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("treeTexture")));

		TexturedModel grass = new TexturedModel(OBJLoader.loadObjModel("grassModel", loader),
				new ModelTexture(loader.loadTexture("grassTexture")));

		TexturedModel fern = new TexturedModel(OBJLoader.loadObjModel("fern", loader),
				new ModelTexture(loader.loadTexture("fern")));


		List<Entity> entities = new ArrayList<Entity>();
		Random random = new Random(1);
		for (int i = 0; i < 6000; i++){

			//TexturedModel model,    Vector3f position,     float rotX,    float rotY,   float rotZ,    float scale   

			entities.add(new Entity(staticModel, new Vector3f(random.nextFloat() * 800 , 0, random.nextFloat() * 800), 0, 0, 0, 1));

			grass.getTexture().setHasTransparency(true);

			entities.add(new Entity(grass, new Vector3f(random.nextFloat() * 800, 0, random.nextFloat() * 800), 0, 0, 0, 0.1f));

			fern.getTexture().setHasTransparency(true);

			entities.add(new Entity(fern, new Vector3f(random.nextFloat() * 800, 0, random.nextFloat() * 800), 0, 0, 0, random.nextFloat()*0.1f)); 
		}

		camera = new Camera();

		Light light = new Light(new Vector3f(2000,2000,2000), new Vector3f(1,1,1));
		Terrain terrain = new Terrain (0, 0, loader, new ModelTexture(loader.loadTexture("grass")));
		MasterRenderer renderer = new MasterRenderer();
		while (DisplayManager.continueUpdating()) {
			camera.move();

			renderer.processTerrain(terrain);

			for(Entity d:entities) {
				renderer.processEntity(d);
			}

			renderer.render(light, camera);
			DisplayManager.updateDisplay();


		}
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}