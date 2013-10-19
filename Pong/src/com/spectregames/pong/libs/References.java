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
package com.spectregames.pong.libs;

/**
 * Project Name: Pong
 * Package Name: com.spectregames.pong.libs
 * File Name:    References.java
 * Class:        References
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class References {
	
	public static final int WIDTH = 800, HEIGHT = 600, TABLE_WIDTH = 700, TABLE_HEIGHT = 450, TABLE_TOP = 100, TABLE_BOTTOM = 550, 
			CENTER_X = WIDTH / 2, CENTER_Y = HEIGHT / 2, PADDLE1_START = 0, PADDLE2_START = 0, PADDLE_INCREMENT = 4;
	
	public static boolean isRunning = false, isInDevelopment = true, isInDemoMode = false, isInDeBugMode = false, wasBallServed = false;
	
	public static final String TITLE = "Pong", SPRITES_DIR = "/sprites/", AUDIO_DIR = "/audio/";
	

}
