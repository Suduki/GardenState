package main;

import java.util.Random;

import org.joml.Vector3f;

import display.DisplayManager;
import entities.Camera;
import entities.Entity;
import model.Loader;
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
		camera = new Camera();
		
		float[] vertices = {
				-0.5f, 0.5f, 0,
				-0.5f, -0.5f, 0,
				0.5f, -0.5f, 0,
				0.5f, 0.5f, 0f
		};

		int[] indices = {
				0,1,3,
				3,1,2
		};
		
		float[] textureCoords = {
				0,0,		//V0
				0,1,		//V1
				1,1,		//V2
				1,0 		//V3
		};
		
		RawModel model = loader.loadToVAO(vertices, textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("logo"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		Entity entity = new Entity(texturedModel, new Vector3f(0,0,-1), 0,0,0,1);
		
		while (DisplayManager.continueUpdating()) {
			renderer.prepare();
			shader.start();
			renderer.render(entity, shader);
			entity.increasePosition(0,0,-0.1f);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}
}
