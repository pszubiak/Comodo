#ifndef wsf2ex4ACTION_OFF_H
#define wsf2ex4ACTION_OFF_H
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

#ifndef wsf2libACTION_OFF_H
#include "wsf2libACTION_OFF.h"
#endif


class wsf2ex4ACTION_MGR;    
class wsf2ex4CONFIG;
class wsf2ex4DATA;
class wsf2libCONTROL;


/** 
 * OFF action class.    
 */
class wsf2ex4ACTION_OFF : public wsf2libACTION_OFF
{
  public:
    wsf2ex4ACTION_OFF(wsf2ex4ACTION_MGR& actionMgr,
		       wsf2libCONTROL& control, 
		       wsf2ex4CONFIG& config, 
		       wsf2ex4DATA& data);
    virtual ~wsf2ex4ACTION_OFF();
   
       
  private:
    wsf2ex4ACTION_MGR& mActionMgr;
    wsf2libCONTROL&     mControl;
    wsf2ex4CONFIG&     mConfig;
    wsf2ex4DATA&       mData;

    wsf2ex4ACTION_OFF(const wsf2ex4ACTION_OFF&);
    wsf2ex4ACTION_OFF& operator= (const wsf2ex4ACTION_OFF&);
};

	

#endif // !wsf2ex4ACTION_OFF_H
