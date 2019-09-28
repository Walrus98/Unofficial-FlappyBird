package dev.lordwalrus.flappybird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import dev.lordwalrus.flappybird.FlappyBird;
import dev.lordwalrus.flappybird.resources.FBResources;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = FBResources.NAME;
		config.width = FBResources.WIDTH;
		config.height = FBResources.HEIGHT;
		new LwjglApplication(new FlappyBird(), config);
	}
}
