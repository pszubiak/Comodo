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


#include <cppunit/TestFixture.h>
#include <cppunit/TestCaller.h>
#include <maciSimpleClient.h>

#include "prototypeCommonC.h"
#include "DeviceC.h"
#include "CCDImagC.h"

maci::SimpleClient client;

class CCDImagImplTest: public CppUnit::TestFixture 
{
	private:
	
		prototype::Device *DeviceComponent;
		prototype::CCDImag *CCDImagComponent;
		
	public:
	
		void setUp() 
		{
			DeviceComponent = client.getComponent<prototype::Device>("testInstanceDevice", 0, true);
			CCDImagComponent = client.getComponent<prototype::CCDImag>("testInstanceCCDImag", 0, true);
		}//

		void tearDown()
		{
			client.releaseComponent("testInstanceDevice");
			client.releaseComponent("testInstanceCCDImag");
		}//
		
		///////////////////////////////////////////////////////////
		// Test methods
		///////////////////////////////////////////////////////////
		
		void testStandby()
		{
			// TODO (generator autoimplementation)
		}//
		void testOnline()
		{
			// TODO (generator autoimplementation)
		}//
		void testOff()
		{
			// TODO (generator autoimplementation)
		}//
		void testSetup()
		{
			// TODO (generator autoimplementation)
		}//
};

int main(int argc, char *argv[]) 
{
	client.init(argc, argv);
	
	client.login();
	
	// testStandby
	CppUnit::TestCaller<CCDImagImplTest> StandbyTest ("testInstanceCCDImagImpl", &CCDImagImplTest::testStandby);
	
	// testOnline
	CppUnit::TestCaller<CCDImagImplTest> OnlineTest ("testInstanceCCDImagImpl", &CCDImagImplTest::testOnline);
	
	// testOff
	CppUnit::TestCaller<CCDImagImplTest> OffTest ("testInstanceCCDImagImpl", &CCDImagImplTest::testOff);
	
	// testSetup
	CppUnit::TestCaller<CCDImagImplTest> SetupTest ("testInstanceCCDImagImpl", &CCDImagImplTest::testSetup);
	
	
	client.logout();
}
