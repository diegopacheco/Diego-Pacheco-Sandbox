@ECHO OFF

cls

if /i "%1" == "/?" goto options

SET ngs_version=NGS-12.2.2.3
SET base_services=D:\diego\svn-repos\wcsiLegra\cortellis\trunk\Services-SRC\services
SET base_jboss=D:\diego\bin\jboss-5.1.0.GA-jdk6\server\default
SET jboss_deploy=%base_jboss%\deploy
SET jboss_libs_dir=%base_jboss%\lib
SET runtime_jboss_dir=%base_services%\..\services-build\ngs-runtime-jboss

echo Clean up directories: data, log, tmp and work...

DEL %base_jboss%\data\ /F /S /Q
DEL %base_jboss%\log\ /F /S /Q
DEL %base_jboss%\tmp\ /F /S /Q
DEL %base_jboss%\work\ /F /S /Q

cls

if /i "%1" == "mr" goto mr
if /i "%1" == "se" goto search
if /i "%1" == "ex" goto export
if /i "%1" == "es" goto export_search
if /i "%1" == "re" goto retrieve
if /i "%1" == "on" goto ontology
if /i "%1" == "al" goto alert

goto error

:options
echo options avaliable [mr, se, re, ex, es, on, al]
goto done

:mr
copy %base_services%\..\management-routing\ngs-mr-ear\target\ngs-mr-ear-%ngs_version%.ear %jboss_deploy%\ngs-mr-ear-%ngs_version%.ear
goto deploy_libs

:search
copy %base_services%\ngs-search\ngs-search-ear\target\ngs-search-ear-%ngs_version%.ear %jboss_deploy%\ngs-search-ear-%ngs_version%.ear
goto deploy_libs

:export
copy %base_services%\ngs-export\ngs-export-ear\target\ngs-export-ear-%ngs_version%.ear %jboss_deploy%\ngs-export-ear-%ngs_version%.ear
goto deploy_libs

:export_search
copy %base_services%\ngs-export-search\ngs-export-search-ear\target\ngs-export-search-ear-%ngs_version%.ear %jboss_deploy%\ngs-export-search-ear-%ngs_version%.ear
goto deploy_libs

:retrieve
copy %base_services%\ngs-retrieve\ngs-retrieve-ear\target\ngs-retrieve-ear-%ngs_version%.ear %jboss_deploy%\ngs-retrieve-ear-%ngs_version%.ear
goto deploy_libs

:ontology
copy %base_services%\ngs-ontology\ngs-ontology-ear\target\ngs-ontology-ear-%ngs_version%.ear %jboss_deploy%\ngs-ontology-ear-%ngs_version%.ear
goto deploy_libs

:alert
copy %base_services%\ngs-alert\ngs-alert-ear\target\ngs-alert-ear-%ngs_version%.ear %jboss_deploy%\ngs-alert-ear-%ngs_version%.ear
copy %base_services%\ngs-alert\ngs-alert-seda-core-feed-ear\target\ngs-alert-seda-core-feed-ear-%ngs_version%.ear %jboss_deploy%\ngs-alert-seda-core-feed-ear-%ngs_version%.ear
copy %base_services%\ngs-alert\ngs-alert-seda-core-processor-ear\target\ngs-alert-seda-core-processor-ear-%ngs_version%.ear %jboss_deploy%\ngs-alert-seda-core-processor-ear-%ngs_version%.ear
copy %base_services%\ngs-alert\ngs-alert-seda-delivery-ear\target\ngs-alert-seda-delivery-ear-%ngs_version%.ear %jboss_deploy%\ngs-alert-seda-delivery-ear-%ngs_version%.ear
goto deploy_libs

:deploy_libs
pushd %runtime_jboss_dir%
mvn clean install -P windows.arch
goto done

:error
echo invalid option '%1' use one of this valid options [mr, se, re, ex, es, on]

:done
echo Deploy DONE 
