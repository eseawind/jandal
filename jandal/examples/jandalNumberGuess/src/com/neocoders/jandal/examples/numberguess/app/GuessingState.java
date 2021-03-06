/*
 * Copyright (C) 2007 Lindsay S. Kay, All rights Reserved.
 *
 * This software is provided "as-is", without any express or implied warranty. In no event will the 
 * author be held liable for any damages arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose, including commercial 
 * applications, and to alter it and redistribute if freely, subject to the following restrictions:
 *
 *  1. The origin of this software must not be misrepresented: you must not claim that you wrote 
 * 	the original software. if you use this software in a product, an acknowledgement in the product 
 * 	documentation would be appreciated but is not required.
 * 
 *  2. Altered source versions must be plainly marked as such, and must not be misrepresented 
 * 	as the original software.
 * 
  * 3. This notice must not be removed or altered from any source distribution.
 */
package com.neocoders.jandal.examples.numberguess.app;

import com.neocoders.jandal.core.*;
import com.neocoders.jandal.examples.numberguess.service.*;

public class GuessingState extends State {
	public GuessingState() throws JandalCoreException {
		super("guessingState");
	}

	protected void onEntry() throws JandalCoreException {

		setOutput("template", "guessing.ftl");

		addViewEventProcessor(new EventProcessor("guess") {

			public void onEvent() throws JandalCoreException {
				
				String numberStr = (String) getParam("number");
				
				int number = 0;
				try {
					number = Integer.parseInt(numberStr);
				} catch (Exception cce) {
					
					doTransition("incorrectState", new Params().add("message",
							"Not an integer!"));
					return; // Don't forget this
				}
				NumberGeneratorService numGenService = (NumberGeneratorService) getService("numberGenerator");

				int numberToGuess = numGenService.nextNumber();
				if (number < numberToGuess) {
					doTransition("incorrectState", new Params().add("message",
							"Number too low"));
				} else if (number > numberToGuess) {
					doTransition("incorrectState", new Params().add("message",
							"Number too high"));
				} else {
					doTransition("correctState");
				}
			}
		});

	}
}
