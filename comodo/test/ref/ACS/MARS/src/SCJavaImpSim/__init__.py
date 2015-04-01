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


import TYPES
import Acspy.Clients.SimpleClient
from Acspy.Common.Log import getLogger

def reset():
	logger = getLogger("SCJavaImp Log")
	logger.logTrace( "reset executed...")
	
def status():
	logger = getLogger("SCJavaImp Log")
	logger.logTrace( "status executed...")
	
def getPosition():
	logger = getLogger("SCJavaImp Log")
	logger.logTrace( "getPosition executed...")
	
def sensorType():
	logger = getLogger("SCJavaImp Log")
	logger.logTrace( "sensorType executed...")
	
# ___oOo___
