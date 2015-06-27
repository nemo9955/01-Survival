package com.nemo9955.survival10.storage;

import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public enum Assets {
	//@foff
	HEIGHT_MAP("world/heightmap.png",Pixmap.class),
	TEXTURE_MAP("world/texture.png",Texture.class),
	SKIN_ATLAS("img/uiskin.atlas", TextureAtlas.class), 
	D_OLD_MODERN("fonts/D_OLD_MODERN.ttf", FreeTypeFontGenerator.class);
	
	//@fonn
	final String	pth;
	final Class<?>	cls;

	private Assets(String pth, final Class<?> cls) {
		this.pth = pth;
		this.cls = cls;
	}

	public void loadAsset() throws Exception {
		if (cls == Texture.class) {
			TextureParameter param = new TextureParameter();
			param.minFilter = TextureFilter.Linear;
			param.magFilter = TextureFilter.Linear;
			SU.manager.load(pth, Texture.class, param);
		} else {
			SU.manager.load(pth, cls);
		}
	}

	public <T> T asset(Class<T> type) {
		return SU.manager.get(pth, type);
	}

	public String assetPath() {
		return pth;
	}

	public Class<?> assetClass() {
		return cls;
	}

}
