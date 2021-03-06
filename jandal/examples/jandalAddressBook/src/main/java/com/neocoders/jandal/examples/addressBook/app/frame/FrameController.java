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
package com.neocoders.jandal.examples.addressBook.app.frame;

import com.neocoders.jandal.core.*;
import com.neocoders.jandal.examples.addressBook.app.frame.addressBook.AddressBookController;

/**
 * Controls the frame around the AddressBook application. Has a child-Controller
 * that controls the actual address book.
 * 
 * @author lindsay
 * 
 */
public class FrameController extends Controller {

    public FrameController() throws JandalCoreException {
	super("frameController");
    }

    protected void onStart() throws JandalCoreException {
	addInitialState(new State("frame") {

	    protected void onEntry() throws JandalCoreException {
		setOutput("template", "frame.ftl");
		addChildController(new AddressBookController());
	    }
	});
    }
}
