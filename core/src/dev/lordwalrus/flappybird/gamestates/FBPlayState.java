package dev.lordwalrus.flappybird.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dev.lordwalrus.flappybird.background.FBBackground;
import dev.lordwalrus.flappybird.obstacles.FBTube;
import dev.lordwalrus.flappybird.player.FBPlayer;
import dev.lordwalrus.flappybird.resources.FBResources;

public class FBPlayState extends FBGameState {
	
	private FBBackground background;
	private FBBackground backgroundBase;
	
	private FBPlayer playerBird;
	private FBTube[] tubes = new FBTube[2];
	
	private int xTubePosition = 407;
//	xTubePosition += 207 + 67;

	public FBPlayState(FBGameStateManager gameManager) {
		gameStateManager = gameManager;
		
		background = new FBBackground(0, 200, 480, 600);
		backgroundBase = new FBBackground(0, 0, 480, 200);
		
		playerBird = new FBPlayer(100, (200 + FBResources.HEIGHT - 34) / 2);
		
		for (int i = 0; i < tubes.length; i++) {
			tubes[i] = new FBTube(xTubePosition += 274);
		}			
	}

	@Override
	public void update() {
		
		playerBird.update();		
		for (FBTube tube : tubes) {
			if (playerBird.playerHitbox.overlaps(tube.getTubeTopHitbox()) || playerBird.playerHitbox.overlaps(tube.getTubeBottomHitbox())) { // playerBird.playerHitbox.overlaps(backgroundBase.backgroundBaseHitbox)
				gameStateManager.setState(new FBPlayState(gameStateManager));
			}
			tube.update();
		}
		background.update();
		backgroundBase.update();
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		spriteBatch.begin();
		background.render(background.getBackgroundTexture(), spriteBatch);	
		for (FBTube tube : tubes) {
			tube.render(spriteBatch);
		}
		backgroundBase.render(backgroundBase.getBackgroundBaseTexture(), spriteBatch);		
		playerBird.render(spriteBatch);		

		spriteBatch.end();
	}

	@Override
	public void dispose() {
		background.dispose();		
		for (FBTube tube : tubes) {
			tube.dispose();
		}
		backgroundBase.dispose();
		playerBird.dispose();
	}

}
