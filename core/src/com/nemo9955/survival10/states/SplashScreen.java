package com.nemo9955.survival10.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nemo9955.survival10.storage.Assets;
import com.nemo9955.survival10.storage.Fonts;
import com.nemo9955.survival10.storage.SU;

public class SplashScreen extends ScreenAdapter {
	@Override
	public void show() {

		FileHandleResolver resolver = new InternalFileHandleResolver();
		SU.manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		SU.manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

		for (Assets aset : Assets.values()) {
			try {
				aset.loadAsset();
			}
			catch (Exception e) {
				Gdx.app.error("assets", "problem loading asset :" + aset.assetPath(), e);
			}
		}
	}

	@Override
	public void render(float delta) {

		// Gdx.app.debug("assets", "loaded : " + SF.manager.getProgress());
		if (SU.manager.update())
			SU.game.setScreen(SU.mc);
	}

	@Override
	public void hide() {

		// Gdx.app.log("life", "leave splash screen");
		// SU.atlas = Assets.HEXAS.asset(TextureAtlas.class);

		SU.skin = new Skin();
		Fonts.loadFonts();
		SU.skin.addRegions(Assets.SKIN_ATLAS.asset(TextureAtlas.class));
		SU.skin.load(Gdx.files.internal("img/uiskin.json"));

		// added windowStyle programmatically until possible bug is fixed

		// WindowStyle wsd = new WindowStyle(SU.skin.getFont("D_OLD_MODERN_D"),
		// Color.CYAN, SU.skin.getDrawable("pix30"));
		// WindowStyle wse = new WindowStyle(SU.skin.getFont("ARIAL_D"),
		// Color.BLACK, SU.skin.getDrawable("pix100"));
		// SU.skin.add("default", wsd, WindowStyle.class);
		// SU.skin.add("error", wse, WindowStyle.class);

		SU.mainMenu = new MainMenu();
		SU.gameplay = new Gameplay();

	}
}
