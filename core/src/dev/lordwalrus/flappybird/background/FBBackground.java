package dev.lordwalrus.flappybird.background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import dev.lordwalrus.flappybird.resources.FBResources;

public class FBBackground {
	
	private final float BACKGROUND_VELOCITY = -1.5F;
	
	private Texture background;
	private Texture backgroundBase;	
	private Vector2 backgroundPosition;
	private Vector2 backgroundVelocity;
	
	public Rectangle backgroundBaseHitbox = new Rectangle(0, 0, 480, 200);
	
	private int height;
	private int width;	
	
	public FBBackground(int xPosition, int yPosition, int width, int height) {		
		this.width = width;
		this.height = height;
		
		background = FBResources.BACKGROUND_DAY;
		backgroundBase = FBResources.BACKGROUND_BASE;
		
		backgroundPosition = new Vector2(xPosition, yPosition);
		backgroundVelocity = new Vector2(0, 0);		
	}
	
	public void update() {
		if (backgroundPosition.x <= -480) {
			backgroundPosition.x = 0;
		}
		backgroundVelocity.set(BACKGROUND_VELOCITY, 0);
		backgroundPosition.add(backgroundVelocity.x, 0);
	}
	
	public void render(Texture backgroundTexture, SpriteBatch spriteBatch) {
		spriteBatch.draw(backgroundTexture, backgroundPosition.x, backgroundPosition.y, width, height);
		spriteBatch.draw(backgroundTexture, backgroundPosition.x + 480, backgroundPosition.y, width, height);	
	}
	
	public void dispose() {
		background.dispose();
	}
	
	public Texture getBackgroundTexture() {
		return background;
	}

	public Texture getBackgroundBaseTexture() {
		return backgroundBase;
	}	
	
}
