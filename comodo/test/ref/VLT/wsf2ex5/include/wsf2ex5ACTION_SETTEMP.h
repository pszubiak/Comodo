#ifndef wsf2ex5ACTION_SETTEMP_H
#define wsf2ex5ACTION_SETTEMP_H
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

#ifndef wsf2libACTION_H
#include "wsf2libACTION.h"
#endif


class wsf2ex5ACTION_MGR;    
class wsf2ex5CONFIG;
class wsf2ex5DATA;
class wsf2libCONTROL;


/** 
 * SETTEMP action class.    
 */
class wsf2ex5ACTION_SETTEMP : public wsf2libACTION
{
  public:
    wsf2ex5ACTION_SETTEMP(wsf2ex5ACTION_MGR& actionMgr,
		       wsf2libCONTROL& control, 
		       wsf2ex5CONFIG& config, 
		       wsf2ex5DATA& data);
    virtual ~wsf2ex5ACTION_SETTEMP();

    virtual ccsCOMPL_STAT Init();
    virtual ccsCOMPL_STAT Execute();
    virtual ccsCOMPL_STAT Complete();
    virtual ccsCOMPL_STAT Abort();
    virtual ccsCOMPL_STAT Reject();
    virtual ccsCOMPL_STAT Supersede();
   
  private:
    wsf2ex5ACTION_MGR& mActionMgr;
    wsf2libCONTROL&    mControl;
    wsf2ex5CONFIG&     mConfig;
    wsf2ex5DATA&       mData;

    wsf2ex5ACTION_SETTEMP(const wsf2ex5ACTION_SETTEMP&);
    wsf2ex5ACTION_SETTEMP& operator= (const wsf2ex5ACTION_SETTEMP&);
};

	

#endif // !wsf2ex5ACTION_SETTEMP_H

