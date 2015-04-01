#ifndef wsf2ex6ACTION_MGR_H
#define wsf2ex6ACTION_MGR_H
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

#ifndef wsf2libACTION_MGR_H
#include "wsf2libACTION_MGR.h"
#endif


class wsf2ex6CONFIG;
class wsf2ex6DATA;
class wsf2libFSM;
class evhTHREADS;


class wsf2ex6ACTION_MGR : public wsf2libACTION_MGR
{
  public:
    wsf2ex6ACTION_MGR(const dbSYMADDRESS& dbRoot,
		      vltINT32 argCount, 
		      char* arg[],
		      wsf2libCMDH_MGR* eventMgr);
    virtual ~wsf2ex6ACTION_MGR();


    virtual ccsCOMPL_STAT Init();
    virtual ccsCOMPL_STAT CreateActions();
    virtual ccsCOMPL_STAT CreateActivities(const char* procName, wsf2libFSM* fsm, evhTHREADS& threadsHandler);

    /* data related methods */
    virtual wsf2ex6CONFIG&  GetConfig();
    virtual wsf2ex6DATA&    GetData();

  private:
    wsf2ex6CONFIG* mConfig;
    wsf2ex6DATA*   mData;

    wsf2ex6ACTION_MGR(const wsf2ex6ACTION_MGR&);
    wsf2ex6ACTION_MGR& operator= (const wsf2ex6ACTION_MGR&);
};

#endif // !wsf2ex6ACTION_MGR_H

