@echo OFF

if /i "%1" == "arch" goto arch
if /i "%1" == "services" goto services
if /i "%1" == "science"  goto science
if /i "%1" == "api" goto api

goto error
  
:arch
set MR_HOME=D:\diego\svn-repos\wcsiLegra\SAFE_SAMMI_Cortellis\trunk\Architecture-SRC\ngm-ztest-mr-conf\windows_dev
goto :done

:services
set MR_HOME=D:\diego\svn-repos\wcsiLegra\SAFE_SAMMI_Cortellis\trunk\Services-SRC\conf\tr_dev_ngsi\mr_home
goto :done

:science
set MR_HOME=D:\diego\svn-repos\wcsiLegra\SAFE_SAMMI_Cortellis\trunk\Services-SRC\conf\tr_dev_ngsi\mr_home
goto :done

:api
set MR_HOME=D:\diego\svn-repos\wcsiLegra\SAFE_SAMMI_Cortellis_api\api-src\conf\tr_dev\mr_home
goto :done

:error
echo invalid option '%1' use 'arch' or 'services'

:done
echo using mr_home '%MR_HOME%'
