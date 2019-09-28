package dev.lordwalrus.flappybird.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import dev.lordwalrus.flappybird.resources.FBResources;

public class FBPlayer {
	
	private final float GRAVITY = -0.5F;
	private final int GROUND_POSITION = 200;
		
	private Vector2 playerPosition;
	private Vector2 playerVelocity;		
	private Texture playerTexture;
	private Sprite playerSprite;
	
	public Rectangle playerHitbox;	
	
	public FBPlayer(int xPosition, int yPosition) {
		playerPosition = new Vector2(xPosition, yPosition);
		playerVelocity = new Vector2(0, 0);
		playerTexture = FBResources.YELLOWBIRD_MIDFLAP;		
		playerSprite = new Sprite(playerTexture);
		playerHitbox = playerSprite.getBoundingRectangle();
	}
	
	public void update() {		
		if (Gdx.input.justTouched()) {
			playerVelocity.set(0, 0);
			playerVelocity.add(0, 10);
			playerSprite.setRotation(40);
		} 
		
		if (playerSprite.getRotation() > -90) {
			playerSprite.rotate(-1.2F);
		}
		
		if (playerPosition.y > GROUND_POSITION) {
			playerVelocity.add(0, GRAVITY); 
			playerPosition.add(0, playerVelocity.y);
		} else {
			playerVelocity.set(0, 0);
			playerPosition.y = GROUND_POSITION;	
			playerSprite.setRotation(-90);		
		}
		
		playerHitbox.setPosition(playerPosition.x, playerPosition.y);
	}
	
	public void render(SpriteBatch spriteBatch) {
		playerSprite.setPosition(playerPosition.x, playerPosition.y);
		playerSprite.setSize(44, 33);
		playerSprite.draw(spriteBatch);
//		spriteBatch.draw(playerTexture, playerPosition.x, playerPosition.y, 44, 34);
	}
	
	public void dispose() {
		playerTexture.dispose();
	}

}
