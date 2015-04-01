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

#include "MARSCommonC.h"
#include "SCInterfaceC.h"

maci::SimpleClient client;

class SCJavaImpTest: public CppUnit::TestFixture 
{
	private:
	
		MARS::SCInterface *SCInterfaceComponent;
		
	public:
	
		void setUp() 
		{
			SCInterfaceComponent = client.getComponent<MARS::SCInterface>("testInstanceSCInterface", 0, true);
		}//

		void tearDown()
		{
			client.releaseComponent("testInstanceSCInterface");
		}//
		
		///////////////////////////////////////////////////////////
		// Test methods
		///////////////////////////////////////////////////////////
		
		void testReset()
		{
			// TODO (generator autoimplementation)
		}//
		void testStatus()
		{
			// TODO (generator autoimplementation)
		}//
		void testGetPosition()
		{
			// TODO (generator autoimplementation)
		}//
		void testSensorType()
		{
			// TODO (generator autoimplementation)
		}//
};

int main(int argc, char *argv[]) 
{
	client.init(argc, argv);
	
	client.login();
	
	// testReset
	CppUnit::TestCaller<SCJavaImpTest> ResetTest ("testInstanceSCJavaImp", &SCJavaImpTest::testReset);
	
	// testStatus
	CppUnit::TestCaller<SCJavaImpTest> StatusTest ("testInstanceSCJavaImp", &SCJavaImpTest::testStatus);
	
	// testGetPosition
	CppUnit::TestCaller<SCJavaImpTest> GetPositionTest ("testInstanceSCJavaImp", &SCJavaImpTest::testGetPosition);
	
	// testSensorType
	CppUnit::TestCaller<SCJavaImpTest> SensorTypeTest ("testInstanceSCJavaImp", &SCJavaImpTest::testSensorType);
	
	
	client.logout();
}
