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

import java.util.logging.Logger;

import alma.acs.container.ComponentHelper;

import alma.acs.component.ComponentLifecycle;

import alma.prototype.LampPOATie;
import alma.prototype.LampOperations;
import alma.prototype.DevicePOATie;
import alma.prototype.DeviceOperations;
import alma.prototype.Lamp2POATie;
import alma.prototype.Lamp2Operations;

/**
 * @see alma.prototypeCommon
 * @see alma.prototype.Lamp
 * @see alma.prototype.LampOperations
 * @see alma.prototype.Device
 * @see alma.prototype.DeviceOperations
 * @see alma.prototype.Lamp2
 * @see alma.prototype.Lamp2Operations
 * @see alma.acs.component.ComponentLifecycle
 * @author ACS Component Code Generator
 * @version $Id$
 */
public class Lamp2ImplHelper extends ComponentHelper {

	/**
	 * Passes a logger to the callback object.
	 * @param containerLogger
	 */
	public Lamp2ImplHelper(Logger containerLogger) {
		super(containerLogger);
	}

	/**
	 * Gets an instance of the implementation class of the LampAccess component.
	 * @return ComponentLifecycle
	 * @see alma.acs.container.ComponentHelper#_createComponentImpl()
	 */
	protected ComponentLifecycle _createComponentImpl() {
		return new Lamp2Impl();
	}

	/**
	 * Gets an instance of the POATie class of the LampAccess component.
	 * @return Class
	 * @see alma.acs.container.ComponentHelper#_getPOATieClass()
	 */
	protected Class _getPOATieClass() {
		return Lamp2POATie.class;
	}

	/**
	 * Gets an instance of the operations of the LampAccess component.
	 * @return Class
	 * @see alma.acs.container.ComponentHelper#getOperationsInterface()
	 */
	protected Class _getOperationsInterface() {
		return Lamp2Operations.class;
	}

}
