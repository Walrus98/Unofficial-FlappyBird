package dev.lordwalrus.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.lordwalrus.flappybird.gamestates.FBGameStateManager;
import dev.lordwalrus.flappybird.gamestates.FBMenuState;

public class FlappyBird extends ApplicationAdapter {

	private SpriteBatch spriteBatch;	
	private FBGameStateManager gameStateManager;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		gameStateManager = new FBGameStateManager();
		gameStateManager.setState(new FBMenuState(gameStateManager));
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update();
		gameStateManager.render(spriteBatch);
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		gameStateManager.dispose();
	}
}
