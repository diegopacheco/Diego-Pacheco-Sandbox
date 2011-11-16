@echo OFF

if /i "%1" == "arch" goto arch
if /i "%1" == "services" goto services

goto error
  
:arch
set MR_HOME=D:\Diego\svn-repos\wcsiLegra\cortellis\Architecture-SRC\ngm-ztest-mr-conf\windows_dev
goto :done

:services
set MR_HOME=D:\Diego\svn-repos\wcsiLegra\cortellis\Services-SRC\conf\tr_dev\mr_home
goto :done

:error
echo invalid option '%1' use 'arch' or 'services'

:done
echo using mr_home '%MR_HOME%'