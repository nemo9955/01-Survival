package com.nemo9955.survival10.game.terrain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.nemo9955.survival10.storage.Assets;
import com.nemo9955.survival10.storage.SU;


public class TerrainChunk {


	HeightField		field;
	Renderable		ground;

	final int		MAX_PIXEL_COLOR	= 255 * 255 * 255;
	final int		MAX_HEIGHT		= 40;
	float			map[][];
	int				size;
	ShapeRenderer	sr				= SU.shapeRend;

	public TerrainChunk() {
		Pixmap pix = Assets.HEIGHT_MAP.asset(Pixmap.class);
		if (pix.getFormat() != Pixmap.Format.Alpha)
			throw new GdxRuntimeException("Pixmap must be format Pixmap.Alpha (8-bit Grayscale), not: "
					+ pix.getFormat());

		size = pix.getHeight();
		Gdx.app.log("terrain", "size : " + size);
		map = new float[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				float h = pix.getPixel(i, j) * -1f;
				// h += MAX_PIXEL_COLOR / 2;
				// h /= MAX_PIXEL_COLOR / 2;
				// h *= MAX_HEIGHT;
				map[i][j] = h;
				System.out.print(h + " ");
			}
			System.out.print("\n");
		}


	}


	public void render(ModelBatch mb, PerspectiveCamera cam) {
		sr.setProjectionMatrix(cam.combined);
		sr.begin(ShapeType.Point);
		sr.setColor(Color.CYAN);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				sr.point(i * 5, map[i][j], j * 5);

			}
		sr.end();


	}
}
