/*******************************************************************************
 *    ALMA - Atacama Large Millimiter Array
 *
 *    (c) European Southern Observatory, 2002
 *    Copyright by ESO (in the framework of the ALMA collaboration)
 *    and Cosylab 2002, All rights reserved
 *  
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation; either
 *    version 2.1 of the License, or (at your option) any later version.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public
 *    License along with this library; if not, write to the Free Software
 *    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
 *
 * "@(#) $Id$" 
 *
 * who                when       what
 * ----------------  ----------  ----------------------------------------------
 * COMODO                        Created.
 * 
 */

package alma.prototype;

import static org.junit.Assert.*;
import org.junit.Before;

import java.util.List;
import java.util.logging.Logger;

import alma.acs.logging.ClientLogManager;
import alma.acs.component.client.ComponentClientTestCase;

import alma.prototype.*;
import alma.prototype.FilterImpl;

import alma.ACS.*;
import alma.ACS.jbaci.*;
import alma.ACS.impl.*;

public class FilterImplTest extends ComponentClientTestCase {
	private Logger logger;
	private String componentName = "testInstanceFilterImpl";
	private FilterImpl component;

	/////////////////////////////////////////////////////////////
	// Lifecycle
	/////////////////////////////////////////////////////////////

	public FilterImplTest(String name) throws Exception {
		super("FilterImpl");
	}//

	protected void setUp() throws Exception {
		super.setUp();
		logger = ClientLogManager.getAcsLogManager().getLoggerForApplication(
				getClass().getSimpleName(), false);
		this.component = (FilterImpl) this.getContainerServices().getComponent(
				this.componentName);
	}//

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		this.getContainerServices().releaseComponent(this.componentName);
	}//

	/////////////////////////////////////////////////////////////
	// Test Methods
	/////////////////////////////////////////////////////////////

	@org.junit.Test
	public void testMove() throws Exception {
		this.component.move();
	}//

	@org.junit.Test
	public void testStandby() throws Exception {
		this.component.standby();
	}//

	@org.junit.Test
	public void testOnline() throws Exception {
		this.component.online();
	}//

	@org.junit.Test
	public void testOff() throws Exception {
		this.component.off();
	}//

	@org.junit.Test
	public void testSetup() throws Exception {
		String val = new String();
		long timeout = 0L;
		this.component.setup(val, timeout);
	}//

}
