package dev.lordwalrus.flappybird.obstacles;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import dev.lordwalrus.flappybird.resources.FBResources;

public class FBTube {

	private final int TUBE_GAP = 155;
	
	private Texture tubeTopSprite, tubeBottomSprite;
	private Vector2 tubeTopPosition, tubeBottomPosition;
	private Vector2 tubeVelocity;
	private Rectangle tubeTopHitbox;
	private Rectangle tubeBottomHitbox;
	
	private Random random;
	
	/**
	 * tubeHeihgt = 416
	 * 
	 * topPosition = 700;
	 * bottomPosition = 129;
	 * Distanza fra i 2 tubi = 155;
	 */

	public FBTube(int xPosition) {
		tubeTopSprite = FBResources.TUBE_TOP;
		tubeBottomSprite = FBResources.TUBE_BOTTOM;		
		
		random = new Random();
		tubeBottomPosition = new Vector2(xPosition, 129 - random.nextInt(245));
		tubeTopPosition = new Vector2(xPosition, TUBE_GAP + tubeBottomPosition.y + 416);
		tubeVelocity = new Vector2(0, 0);
		
		tubeTopHitbox = new Rectangle(tubeTopPosition.x, tubeTopPosition.y, tubeTopSprite.getWidth() * 1.3F, tubeTopSprite.getHeight() * 1.3F);
		tubeBottomHitbox = new Rectangle(tubeBottomPosition.x, tubeBottomPosition.y, tubeBottomSprite.getWidth() * 1.3F, tubeBottomSprite.getHeight() * 1.3F);
	}
	
	public Rectangle getTubeTopHitbox() {
		return tubeTopHitbox;
	}
	
	public Rectangle getTubeBottomHitbox() {
		return tubeBottomHitbox;
	}

	public void update() {
		tubeVelocity.set(-2.0F, 0);
		tubeTopPosition.add(tubeVelocity.x, 0);
		tubeBottomPosition.add(tubeVelocity.x, 0);
		
		tubeTopHitbox.setPosition(tubeTopPosition.x, tubeTopPosition.y);		
		tubeBottomHitbox.setPosition(tubeBottomPosition.x, tubeBottomPosition.y);
		
		if ((int) tubeTopPosition.x < -67 || (int) tubeBottomPosition.x < -67) {
			reposition();
		}
	}
	
	public void reposition() {
		tubeBottomPosition.x = 480;	
		tubeBottomPosition.y = 129 - random.nextInt(245);
		
		tubeTopPosition.x = 480;
		tubeTopPosition.y = TUBE_GAP + tubeBottomPosition.y + 416;
	}
	
	public void render(SpriteBatch spriteBatch) {
		spriteBatch.draw(tubeTopSprite, tubeTopPosition.x, tubeTopPosition.y, tubeTopSprite.getWidth() * 1.3F, tubeTopSprite.getHeight() * 1.3F);
		spriteBatch.draw(tubeBottomSprite, tubeBottomPosition.x, tubeBottomPosition.y, tubeBottomSprite.getWidth() * 1.3F, tubeBottomSprite.getHeight() * 1.3F);
	}
	
	public void dispose() {
		tubeTopSprite.dispose();
		tubeBottomSprite.dispose();
	}

}
