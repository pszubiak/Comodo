#ifndef wsf2ex2ACTION_SIMULAT_H
#define wsf2ex2ACTION_SIMULAT_H
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

#ifndef wsf2libACTION_SIMULAT_H
#include "wsf2libACTION_SIMULAT.h"
#endif


class wsf2ex2ACTION_MGR;    
class wsf2ex2CONFIG;
class wsf2ex2DATA;
class wsf2libCONTROL;


/** 
 * SIMULAT action class.    
 */
class wsf2ex2ACTION_SIMULAT : public wsf2libACTION_SIMULAT
{
  public:
    wsf2ex2ACTION_SIMULAT(wsf2ex2ACTION_MGR& actionMgr,
		       wsf2libCONTROL& control, 
		       wsf2ex2CONFIG& config, 
		       wsf2ex2DATA& data);
    virtual ~wsf2ex2ACTION_SIMULAT();
   
       
  private:
    wsf2ex2ACTION_MGR& mActionMgr;
    wsf2libCONTROL&     mControl;
    wsf2ex2CONFIG&     mConfig;
    wsf2ex2DATA&       mData;

    wsf2ex2ACTION_SIMULAT(const wsf2ex2ACTION_SIMULAT&);
    wsf2ex2ACTION_SIMULAT& operator= (const wsf2ex2ACTION_SIMULAT&);
};

	

#endif // !wsf2ex2ACTION_SIMULAT_H
