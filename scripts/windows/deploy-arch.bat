cls

SET ngmversion=3.0.0
SET base_arch=D:\diego\svn-repos\wcsiLegra\cortellis-architecture\Architecture-SRC\
SET base_jboss=D:\diego\bin\jboss-5.1.0.GA-jdk6\server\default
SET jboss_deploy=%base_jboss%\deploy

echo Clean up directories: data, log, tmp and work...

DEL %base_jboss%\data\ /F /S /Q
DEL %base_jboss%\log\ /F /S /Q
DEL %base_jboss%\tmp\ /F /S /Q
DEL %base_jboss%\work\ /F /S /Q

cls

copy %base_arch%\ngm-core-cache-jmx\target\ngm-core-cache-jmx-%ngmversion%.jar %jboss_deploy%\ngm-core-cache-jmx-%ngmversion%.jar
copy %base_arch%\ngm-ztest-mr-ear\target\ngm-ztest-mr-ear-%ngmversion%.ear %jboss_deploy%\ngm-ztest-mr-ear-%ngmversion%.ear
copy %base_arch%\ngm-ztest-drug-si-wk-ear\target\ngm-ztest-drug-si-wk-ear-%ngmversion%.ear %jboss_deploy%\ngm-ztest-drug-si-wk-ear-%ngmversion%.ear

echo OFF
cls
echo Deploy Time: %DATE%-%TIME% :: to deploy again run: deploy-arch.bat
echo Deploy {MR, WAR, JMX} DONE - Using NGM [%ngmversion%] on [%base_jboss%]

