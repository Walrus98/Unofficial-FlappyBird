package dev.lordwalrus.flappybird.resources;

import com.badlogic.gdx.graphics.Texture;

public class FBResources {
	
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;	
	public static final String NAME = "Flappy Bird";
	
	// Background
	public static final Texture BACKGROUND_DAY;
	public static final Texture BACKGROUND_NIGHT;
	public static final Texture BACKGROUND_BASE;

	public static final Texture TUBE_TOP;
	public static final Texture TUBE_BOTTOM;
	
	// Player
	public static final Texture YELLOWBIRD_MIDFLAP;
	
	// UI
	public static final Texture PLAY_BUTTON;
	
	static {
		BACKGROUND_DAY = new Texture("sprites/background-day.png");
		BACKGROUND_NIGHT = new Texture("sprites/background-night.png");
		BACKGROUND_BASE = new Texture("sprites/base.png");
		
		TUBE_TOP = new Texture("sprites/pipe-green-top.png");
		TUBE_BOTTOM = new Texture("sprites/pipe-green-bottom.png");
		
		YELLOWBIRD_MIDFLAP = new Texture("sprites/birds/yellowbird-midflap.png");
		
		PLAY_BUTTON = new Texture("sprites/message.png");
	}
	
}
