package com.nemo9955.survival10.storage;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public enum Fonts {

	D_OLD_MODERN_D(Assets.D_OLD_MODERN, 32);


	int		size;
	Assets	aset;

	private Fonts(Assets aset, int size) {
		this.size = size;
		this.aset = aset;
	}

	public static void loadFonts() {

		for (Fonts fnt : Fonts.values()) {
			FreeTypeFontGenerator gen = SU.manager.get(fnt.aset.assetPath(), FreeTypeFontGenerator.class);
			FreeTypeFontParameter parameter = new FreeTypeFontParameter();
			parameter.size = fnt.size;
			BitmapFont font = gen.generateFont(parameter);

			SU.skin.add(fnt.name(), font, BitmapFont.class);
		}
	}
}
