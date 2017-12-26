package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import display.DisplayManager;
import entities.Camera;
import entities.Entity;
import entities.Light;
import shaders.StaticShader;

public class MasterRenderer {

	private static final float FOV = 70;
	private static final float NEAR_PLANE = 0.1f;
	private static final float FAR_PLANE = 1000;
	
	private Matrix4f projectionMatrix;
	
	private StaticShader shader;
	private EntityRenderer renderer;
	
	private Map<TexturedModel, List<Entity>> entities = new HashMap<>();
	
	public MasterRenderer() {
		shader = new StaticShader();
		createProjectionMatrix();
		renderer = new EntityRenderer(shader, projectionMatrix);
	}
	
	public void render(Light sun, Camera camera) {
		prepare();
		shader.start();
		shader.loadLight(sun);
		shader.loadViewMatrix(camera);
		renderer.render(entities);
		shader.stop();
		entities.clear();
	}
	
	public void processEntity(Entity entity) {
		TexturedModel entityModel = entity.getModel();
		List<Entity> batch = entities.get(entityModel);
		if (batch != null) {
			batch.add(entity);
		}
		else {
			List<Entity> newBatch = new ArrayList<>();
			newBatch.add(entity);
			entities.put(entityModel, newBatch);
		}
	}
	
	public void cleanUp() {
		shader.cleanUp();
	}
	
	private void prepare() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(1, 0, 0, 1);
	}
	
	private void createProjectionMatrix() {
		
		float aspectRatio = ((float) DisplayManager.TOTAL_PIXEL_X) /  (float) DisplayManager.TOTAL_PIXEL_Y;
		float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f)) * aspectRatio));
		float x_scale = y_scale / aspectRatio;
		float frustum_length = FAR_PLANE - NEAR_PLANE;
		
		projectionMatrix = new Matrix4f();
		projectionMatrix.m00(x_scale);
		projectionMatrix.m11(y_scale);
		projectionMatrix.m22(-((FAR_PLANE + NEAR_PLANE) / frustum_length));
		projectionMatrix.m23(-1);
		projectionMatrix.m32(-(2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
		projectionMatrix.m33(0);
		
	}
}
