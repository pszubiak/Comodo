#*******************************************************************************
# ALMA - Atacama Large Millimiter Array
# (c) UNSPECIFIED - FILL IN, 2009 
# 
# This library is free software; you can redistribute it and/or
# modify it under the terms of the GNU Lesser General Public
# License as published by the Free Software Foundation; either
# version 2.1 of the License, or (at your option) any later version.
# 
# This library is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
# Lesser General Public License for more details.
# 
# You should have received a copy of the GNU Lesser General Public
# License along with this library; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA
#
#  "@(#) $Id$"
#
# who                when       what
# ----------------  ----------  ----------------------------------------------
# COMODO                        Created.
# 


#/usr/bin/env python
'''
DESCRIPTION
OCJavaImpTestPy Class.
Test Methods:
	-	testExecuteRAB()
	-	testGetReportsList()
	-	testGetReport()
	-	testGetSensorsList()
	-	testGetSensorStatus()
	-	testGetRobotsList()
	-	testGetRobotStatus()
'''

import unittest
from Acspy.Clients.SimpleClient import PySimpleClient

from MARSCommon *
from FDInterface import *
from OCInterface import *
from SCInterface import *
from TRDInterface import *
from TSInterface import *

class OCJavaImpTestPy(unittest.TestCase):

	################################################
	# lifecycle
	################################################
	
	def setUp(self):
		self.simpleClient = PySimpleClient()
		self.componentName = "testInstanceOCJavaImp"
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.setUp()...")
        self.simpleClient.getLogger().logInfo("Get component " + self.componentName)
        self.component = self.simpleClient.getComponent(self.componentName)
	#__pPp__	    	           
	
	def tearDown(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.tearDown()...")
		self.simpleClient.getLogger().logInfo("Releasing component " + self.componentName)
		self.simpleClient.releaseComponent(self.componentName)
		self.simpleClient.disconnect()
	#__pPp__       
        
	################################################
	# test methods
	################################################
	
	def testExecuteRAB(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testExecuteRAB()...")
		response = None
		type = 0
		pos = position()
		response = self.component.executeRAB(type, pos)
		# no return is expected, response should be None
		assert response is None
	#__pPp__
			    
	def testGetReportsList(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testGetReportsList()...")
		response = None
		response = self.component.getReportsList()
		# a return is expected, response should be not None
		assert response is not None
	#__pPp__
			    
	def testGetReport(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testGetReport()...")
		response = None
		iD = 0
		response = self.component.getReport(iD)
		# a return is expected, response should be not None
		assert response is not None
	#__pPp__
			    
	def testGetSensorsList(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testGetSensorsList()...")
		response = None
		response = self.component.getSensorsList()
		# a return is expected, response should be not None
		assert response is not None
	#__pPp__
			    
	def testGetSensorStatus(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testGetSensorStatus()...")
		response = None
		id = 0
		response = self.component.getSensorStatus(id)
		# a return is expected, response should be not None
		assert response is not None
	#__pPp__
			    
	def testGetRobotsList(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testGetRobotsList()...")
		response = None
		response = self.component.getRobotsList()
		# a return is expected, response should be not None
		assert response is not None
	#__pPp__
			    
	def testGetRobotStatus(self):
		self.simpleClient.getLogger().logInfo("pyUnitTestOCJavaImp.OCJavaImpTestPy.testGetRobotStatus()...")
		response = None
		id = 0
		response = self.component.getRobotStatus(id)
		# a return is expected, response should be not None
		assert response is not None
	#__pPp__
			    

if __name__ == "__main__":
	unittest.main()
	print "End of OCJavaImpTestPy test __oOo__"
