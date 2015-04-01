#ifndef wsf2ex5ACTION_STANDBY_H
#define wsf2ex5ACTION_STANDBY_H
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

#ifndef wsf2libACTION_STANDBY_H
#include "wsf2libACTION_STANDBY.h"
#endif


class wsf2ex5ACTION_MGR;    
class wsf2ex5CONFIG;
class wsf2ex5DATA;
class wsf2libCONTROL;


/** 
 * STANDBY action class.    
 */
class wsf2ex5ACTION_STANDBY : public wsf2libACTION_STANDBY
{
  public:
    wsf2ex5ACTION_STANDBY(wsf2ex5ACTION_MGR& actionMgr,
		       wsf2libCONTROL& control, 
		       wsf2ex5CONFIG& config, 
		       wsf2ex5DATA& data);
    virtual ~wsf2ex5ACTION_STANDBY();
   
       
  private:
    wsf2ex5ACTION_MGR& mActionMgr;
    wsf2libCONTROL&     mControl;
    wsf2ex5CONFIG&     mConfig;
    wsf2ex5DATA&       mData;

    wsf2ex5ACTION_STANDBY(const wsf2ex5ACTION_STANDBY&);
    wsf2ex5ACTION_STANDBY& operator= (const wsf2ex5ACTION_STANDBY&);
};

	

#endif // !wsf2ex5ACTION_STANDBY_H

