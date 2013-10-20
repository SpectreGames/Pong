/*
*	Date: Oct 17, 2013
*	Company: Spectre Games
*	Web Address: http://www.spectregames.com
* 
*	Copyright 2013 Phantom Coder(Richard Tester)
* 	Based on code from the following YouTube Channels:
*			BossLetsPlays(Matthew Rogers)
*			RealTutsGML(Zack Berenger)
*
*  	Licensed under the Apache License, Version 2.0 (the "License");
*  	you may not use this file except in compliance with the License.
*  	You may obtain a copy of the License at
*
*	http://www.apache.org/licenses/LICENSE-2.0
*
*  	Unless required by applicable law or agreed to in writing, software
*  	distributed under the License is distributed on an "AS IS" BASIS,
*  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  	See the License for the specific language governing permissions and
*  	limitations under the License.
*/
package com.spectregames.pong.utils;

import java.io.IOException;

import com.spectregames.pong.libs.GameConstants;



/**
 * Project Name: Pong
 * Package Name: com.spectregames.pong.utils
 * File Name:    ResourceLoader.java
 * Class:        ResourceLoader
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class ResourceLoader {
	private static BufferedImageLoader imageLoader = new BufferedImageLoader();
	
	public static void loadImages(){
		// Image for the SplashScreen.
		try{
			//Images.splash_screen = imageLoader.loadImage("splash.png");
			Images.splash_screen = imageLoader.loadImage(GameConstants.SPRITES_DIR + "splash.png");
		} catch(IOException e){ e.printStackTrace(); }
		
		// Image for the Games Background.
		try{
			//Images.game_board = imageLoader.loadImage("pong_field.png");
			Images.game_board = imageLoader.loadImage(GameConstants.SPRITES_DIR + "pong_field.png");
		} catch(IOException e){ e.printStackTrace(); }
	}
	
	// Loads all of the games audio assets.
	public static void loadAudio(){
		//AudioInputStream ais = AudioSystem.getAudioInputStream( url );
	}
}
