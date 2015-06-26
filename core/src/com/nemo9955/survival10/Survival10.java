package com.nemo9955.survival10;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.bullet.Bullet;
import com.nemo9955.survival10.states.SplashScreen;
import com.nemo9955.survival10.storage.SU;

public class Survival10 extends Game {

	{
		Bullet.init();
	}


	@Override
	public void create() {
		SU.game = this;

		Gdx.app.setLogLevel(Application.LOG_INFO);

		setScreen(new SplashScreen());
	}

	@Override
	public void dispose() {
		SU.shapeRend.dispose();
		SU.spritesBatch.dispose();
		SU.manager.dispose();
		Gdx.app.log("life", "All resources succesfully disposed !");
	}

}
