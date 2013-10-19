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
package com.spectregames.pong.screens;

import java.awt.Graphics;

import com.spectregames.pong.libs.References;
import com.spectregames.pong.utils.Images;



/**
 * Project Name: Pong
 * Package Name: com.spectregames.pong.screens
 * File Name:    SplashScreen.java
 * Class:        SplashScreen
 *
 * @author Phantom Coder
 * @license http://www.apache.org/license/LICENSE-2.0
 *
 */
public class SplashScreen {
	
	public void render(Graphics g){
		g.drawImage(Images.splash_screen, 0, 0, References.WIDTH, References.HEIGHT, null);
	}

}
