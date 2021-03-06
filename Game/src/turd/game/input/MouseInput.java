package turd.game.input;


import org.lwjgl.glfw.GLFW;

import turd.game.GameState;
import turd.game.Window;
import turd.game.entities.Player;

public class MouseInput {

	private static MouseInput instance = null;
	private boolean bIsClicked = false;
	
	//Singleton
	private MouseInput() {}

	public static MouseInput getInstance() {
    	if(instance == null) {
    		instance = new MouseInput();
    	}
    	
    	return instance;
	}
	
	public int getXPosition(Window window, Player player) {
		
		//Finds the centre of the camera and normalises line to that
		float flCenterX = player.aabb.p0.x + (player.aabb.p1.x / 2.f);
		
		float flCameraX = flCenterX - (window.getWidth() / 2);
		
		return (int)(window.getMouseX() + flCameraX);
	}
	
	public int getYPosition(Window window, Player player) {
		
		//Finds the centre of the camera and normalises line to that
		float flCenterY = player.aabb.p0.y + (player.aabb.p1.y / 2.f);
		float flCameraY = flCenterY - (window.getHeight() / 2);
		

		return (int)(window.getMouseY() + flCameraY);
	}
	
	
	public void updateMouse(Window window, int button, int action, int mods) {
		
		if(button == GLFW.GLFW_MOUSE_BUTTON_1 && action == GLFW.GLFW_PRESS) {
			this.bIsClicked = true;
		}
		else {
			this.bIsClicked = false;
		}
	}
	
	public boolean getMouseClicked() {
		return this.bIsClicked;
	}
	
}

