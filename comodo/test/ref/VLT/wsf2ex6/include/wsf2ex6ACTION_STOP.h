#ifndef wsf2ex6ACTION_STOP_H
#define wsf2ex6ACTION_STOP_H
/*******************************************************************************
*    E.S.O. - VLT project
*
*    "@(#) $Id$"
*
* who                when       what
* ----------------  ----------  ----------------------------------------------
* COMODO            -           Created.
* 
*/

#ifndef __cplusplus
#error This is a C++ include file and cannot be used from plain C
#endif

#ifndef wsf2libACTION_STOP_H
#include "wsf2libACTION_STOP.h"
#endif


class wsf2ex6ACTION_MGR;    
class wsf2ex6CONFIG;
class wsf2ex6DATA;
class wsf2libCONTROL;


/** 
 * STOP action class.    
 */
class wsf2ex6ACTION_STOP : public wsf2libACTION_STOP
{
  public:
    wsf2ex6ACTION_STOP(wsf2ex6ACTION_MGR& actionMgr,
		       wsf2libCONTROL& control, 
		       wsf2ex6CONFIG& config, 
		       wsf2ex6DATA& data);
    virtual ~wsf2ex6ACTION_STOP();
   
       
  private:
    wsf2ex6ACTION_MGR& mActionMgr;
    wsf2libCONTROL&     mControl;
    wsf2ex6CONFIG&     mConfig;
    wsf2ex6DATA&       mData;

    wsf2ex6ACTION_STOP(const wsf2ex6ACTION_STOP&);
    wsf2ex6ACTION_STOP& operator= (const wsf2ex6ACTION_STOP&);
};

	

#endif // !wsf2ex6ACTION_STOP_H
