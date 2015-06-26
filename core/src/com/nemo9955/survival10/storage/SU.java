package com.nemo9955.survival10.storage;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nemo9955.survival10.Survival10;
import com.nemo9955.survival10.states.Gameplay;
import com.nemo9955.survival10.states.MainMenu;
import com.nemo9955.survival10.states.MenuController;

public class SU {

	public static final AssetManager	manager			= new AssetManager();
	public static final SpriteBatch		spritesBatch	= new SpriteBatch();
	public static final ShapeRenderer	shapeRend		= new ShapeRenderer();

	public static Survival10			game;


	public static MenuController		mc				= new MenuController();
	public static MainMenu				mainMenu;
	public static Gameplay				gameplay;

	public static Skin					skin;
	public static TextureAtlas			atlas;

}
