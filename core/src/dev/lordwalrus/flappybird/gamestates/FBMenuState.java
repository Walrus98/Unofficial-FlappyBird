package dev.lordwalrus.flappybird.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.lordwalrus.flappybird.background.FBBackground;
import dev.lordwalrus.flappybird.resources.FBResources;

public class FBMenuState extends FBGameState {

	private FBBackground background;
	private FBBackground backgroundBase;
	
	private Texture playButton;

	public FBMenuState(FBGameStateManager gameState) { 
		this.gameStateManager = gameState;

//		orthographicCamera = new OrthographicCamera(480, 800);
		background = new FBBackground(0, 200, 480, 600);
		backgroundBase = new FBBackground(0, 0, 480, 200);
		playButton = FBResources.PLAY_BUTTON;
	}

	@Override
	public void update() {
		if (Gdx.input.justTouched()) {
			gameStateManager.setState(new FBPlayState(gameStateManager));
		}
		background.update();
		backgroundBase.update();
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		spriteBatch.begin();
		
//		spriteBatch.setProjectionMatrix(orthographicCamera.combined);
		background.render(background.getBackgroundTexture(), spriteBatch);
		backgroundBase.render(backgroundBase.getBackgroundBaseTexture(), spriteBatch);		
		spriteBatch.draw(playButton, (FBResources.WIDTH / 2) - (playButton.getWidth() / 2), (FBResources.HEIGHT + 200) / 2 - (playButton.getHeight() / 2), playButton.getWidth(), playButton.getHeight());
		spriteBatch.end();
	}

	@Override
	public void dispose() {
		background.dispose();
		backgroundBase.dispose();
		playButton.dispose();
	}

}
