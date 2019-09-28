package dev.lordwalrus.flappybird.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class FBGameState {	
		
//	protected OrthographicCamera orthographicCamera;
	/**
	 * Variabile per cambiare i GameStates
	 */
	protected FBGameStateManager gameStateManager;	

	/**
	 * Chiama il metodo update
	 */
	protected abstract void update();	
	
	/**
	 * Chiama il metodo render per renderizzare immagini sullo schermo
	 *
	 * @param spriteBatch 	lo spritebach per disegnare immagini su schermo
	 */
	protected abstract void render(SpriteBatch spriteBatch);
	
	/**
	 * Chiama il metodo dispose
	 */
	protected abstract void dispose();
}
