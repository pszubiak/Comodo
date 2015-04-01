#*******************************************************************************
#    E.S.O. - VLT project
#  
#    "@(#) $Id$"
#
# who                when       what
# ----------------  ----------  ----------------------------------------------
# COMODO            -           Created.
# 
#************************************************************************
#   NAME
#   wsf2ex5TestStdCommands - Automatic test for standard commands
#
#   SYNOPSIS
#   wsf2ex5TestStdCommands <wsEnv> <dbPath> <simulationFlag>
#
#   DESCRIPTION
#   This sequencer script drives the testing of standard commands for the wsf2ex5
#   module. For every action a proper diagnostic output is produced.
#   It performs the following steps:
#   - Wait for the wsf2ex5Control process to be running 
#   - Initializes wsf2ex5
#   - Send a sequence of standard commands, for each one waiting
#     for reply (): 
#   - Send a sequence of standard commands, without waiting for reply ()
#
#   Look at the source code of the test script for the detailed sequence 
#   of steps.
#
#   FILES
#
#   ENVIRONMENT
#
#   RETURN VALUES
#
#   CAUTIONS
#
#   EXAMPLES wsf2ex5TestStdCommands wat0tcs :Appl_data:wsf2ex5 1
#
#   SEE ALSO
#
#   BUGS     
#
#------------------------------------------------------------------------
#

global dbPathControl 

testProlog 1 "Test of Standard commands" wsf2ex5Control

testStepHeader "Test  standard commands one by one"

testCmdNormalReply wsf2ex5Control VERSION ""
testCmdNormalReply wsf2ex5Control STATE ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control SELFTST ""

testCmdNormalReply wsf2ex5Control VERBOSE "On"
testDbValue "$dbPathControl.verbose"
testCmdNormalReply wsf2ex5Control VERBOSE "Console"
testDbValue "$dbPathControl.verbose"

testCmdNormalReply wsf2ex5Control DEBUG "On"
testDbValue "$dbPathControl.debug"
testCmdNormalReply wsf2ex5Control DEBUG "Off"
testDbValue "$dbPathControl.debug"

testCmdNormalReply wsf2ex5Control SIMULAT ""
testDbValue "$dbPathControl.simulation"
testCmdNormalReply wsf2ex5Control STOPSIM ""
testDbValue "$dbPathControl.simulation"

testCmdNormalReply wsf2ex5Control STATUS "" 
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control INIT ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control OFF ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control ONLINE ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control STANDBY ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control STOP ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control ONLINE ""
testCmdNormalReply wsf2ex5Control STOP ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testCmdNormalReply wsf2ex5Control ONLINE ""
testCmdNormalReply wsf2ex5Control STATUS ""
testCmdNormalReply wsf2ex5Control STATE ""
testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testStepHeader  "Test standard commands asynchronously"

set cmdId0  [testSendCommand wsf2ex5Control OFF     ""]
set cmdId1  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId2  [testSendCommand wsf2ex5Control ONLINE  ""]
set cmdId3  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId4  [testSendCommand wsf2ex5Control STANDBY ""]
set cmdId5  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId6  [testSendCommand wsf2ex5Control STOP    ""]
set cmdId7  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId8  [testSendCommand wsf2ex5Control ONLINE  ""]
set cmdId9  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId10 [testSendCommand wsf2ex5Control STOP    ""]
set cmdId11 [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId12 [testSendCommand wsf2ex5Control INIT     ""]
set cmdId13 [testSendCommand wsf2ex5Control STATUS  ""]

testRecvNormalReply $cmdId0
testRecvNormalReply $cmdId1
testRecvNormalReply $cmdId2
testRecvNormalReply $cmdId3
testRecvNormalReply $cmdId4
testRecvNormalReply $cmdId5
testRecvNormalReply $cmdId6
testRecvNormalReply $cmdId7
testRecvNormalReply $cmdId8
testRecvNormalReply $cmdId9 
testRecvNormalReply $cmdId10 
testRecvNormalReply $cmdId11 
testRecvNormalReply $cmdId12 
testRecvNormalReply $cmdId13 

testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

set cmdId0  [testSendCommand wsf2ex5Control OFF     ""]
set cmdId1  [testSendCommand wsf2ex5Control OFF     ""]
set cmdId2  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId3  [testSendCommand wsf2ex5Control ONLINE  ""]
set cmdId4  [testSendCommand wsf2ex5Control ONLINE  ""]
set cmdId5  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId6  [testSendCommand wsf2ex5Control STANDBY ""]
set cmdId7  [testSendCommand wsf2ex5Control STANDBY ""]
set cmdId8  [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId9  [testSendCommand wsf2ex5Control STOP    ""]
set cmdId10 [testSendCommand wsf2ex5Control STOP    ""]
set cmdId11 [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId12 [testSendCommand wsf2ex5Control ONLINE  ""]
set cmdId13 [testSendCommand wsf2ex5Control ONLINE  ""]
set cmdId14 [testSendCommand wsf2ex5Control STATUS  ""]
set cmdId15 [testSendCommand wsf2ex5Control INIT  ""]
set cmdId16 [testSendCommand wsf2ex5Control INIT  ""]
set cmdId17 [testSendCommand wsf2ex5Control STATUS  ""]

testRecvNormalReply $cmdId0
testRecvNormalReply $cmdId1
testRecvNormalReply $cmdId2 
testRecvNormalReply $cmdId3
testRecvNormalReply $cmdId4
testRecvNormalReply $cmdId5 
testRecvNormalReply $cmdId6
testRecvNormalReply $cmdId7
testRecvNormalReply $cmdId8 
testRecvNormalReply $cmdId9
testRecvNormalReply $cmdId10
testRecvNormalReply $cmdId11
testRecvNormalReply $cmdId12
testRecvNormalReply $cmdId13
testRecvNormalReply $cmdId14
testRecvNormalReply $cmdId15
testRecvNormalReply $cmdId16
testRecvNormalReply $cmdId17

testDbValue "$dbPathControl.state"
testDbValue "$dbPathControl.substate"

testEpilog wsf2ex5Control

# ___oOo___

