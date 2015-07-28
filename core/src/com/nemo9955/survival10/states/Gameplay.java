package com.nemo9955.survival10.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.nemo9955.survival10.game.shaders.TestShader;
import com.nemo9955.survival10.game.terrain.TerrainChunk;
import com.nemo9955.survival10.storage.SU;

public class Gameplay extends InputAdapter implements Screen {

	public Environment				environment;
	public PerspectiveCamera		cam;
	public CameraInputController	camController;
	public ModelBatch				mb		= SU.modelBatch;
	ShapeRenderer					sr		= SU.shapeRend;
	public Model					model;
	public ModelInstance			instance;
	Shader							shader;

	TerrainChunk					terr	= new TerrainChunk();

	@Override
	public void show() {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 10f, 10f);
		cam.lookAt(0, 0, 0);
		cam.near = 1f;
		cam.far = 1000f;
		cam.update();

		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createSphere(2f, 2f, 2f, 20, 20, new Material(), Usage.Position | Usage.Normal
				| Usage.TextureCoordinates);
		instance = new ModelInstance(model);
		ColorAttribute atr = ColorAttribute.createDiffuse(Color.RED);
		instance.materials.get(0).set(atr);

		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);

		shader = new TestShader();
		shader.init();
	}

	@Override
	public void render(float delta) {
		camController.update();

		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		mb.begin(cam);
		sr.setProjectionMatrix(cam.combined);
		sr.begin(ShapeType.Point);
		sr.setColor(Color.CYAN);

		// mb.render(instance, shader);
		terr.render(cam, shader);

		mb.end();
		sr.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		model.dispose();
		shader.dispose();
		instance.model.dispose();
	}

}
