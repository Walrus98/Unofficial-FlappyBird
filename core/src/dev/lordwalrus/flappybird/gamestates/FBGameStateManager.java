package dev.lordwalrus.flappybird.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FBGameStateManager {

	/**
	 * Variabile per cambiare i GameStates
	 */
	private FBGameState gameState;	
	
	/**
	 * Cambio GameState
	 *
	 * @param newGameState 	Sostituisce il vecchio GameState con quello nuovo
	 */
	public void setState(FBGameState newGameState) {
		gameState = newGameState;
	}
	
	/**
	 * Restituisce il GameState attivo in questo momento
	 *
	 * @return il gameState attuale
	 */	
	public FBGameState getState() {
		return gameState;	
	}

	/**
	 * Chiama il metodo update
	 */
	public void update() {
		gameState.update();		
	}
	
	/**
	 * Chiama il metodo render per renderizzare immagini sullo schermo
	 *
	 * @param spriteBatch 	lo spritebach per disegnare immagini su schermo
	 */
	public void render(SpriteBatch spriteBatch) {
		gameState.render(spriteBatch);		
	}

	/**
	 * Chiama il metodo dispose
	 */
	public void dispose() {
		gameState.dispose();
	}
	
}
