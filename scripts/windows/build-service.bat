@ECHO OFF

if /i "%1" == "/?" goto options

CALL j6
CALL set-mrhome services

SET BASE_WORK_DIR=D:\diego\svn-repos\wcsiLegra\cortellis\trunk\Services-SRC\services

if /i "%1" == "mr" goto mr
if /i "%1" == "se" goto search
if /i "%1" == "ex" goto export
if /i "%1" == "es" goto export_search
if /i "%1" == "re" goto retrieve
if /i "%1" == "on" goto ontology
if /i "%1" == "ac" goto autocomplete
if /i "%1" == "ch" goto chemistry
if /i "%1" == "tw" goto ti_wrapper
if /i "%1" == "al" goto alert
if /i "%1" == "rr" goto retrieve_regulatory

goto error

:mr
SET build_tmp_path_dir=%BASE_WORK_DIR%\..\management-routing\ngs-mr-parent
goto build_it

:search
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-search\ngs-search-parent
goto build_it

:export
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-export\ngs-export-parent
goto build_it

:export_search
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-export-search\ngs-export-search-parent
goto build_it

:retrieve
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-retrieve\ngs-retrieve-parent
goto build_it

:ontology
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-ontology\ngs-ontology-parent
goto build_it

:autocomplete
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-autocomplete\ngs-autocomplete-parent
goto build_it

:chemistry
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-chemistry\ngs-chemistry-parent
goto build_it

:ti_wrapper
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-ti-wrapper\ngs-ti-wrapper-parent
goto build_it

:alert
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-alert\ngs-alert-parent
goto build_it

:retrieve_regulatory
SET build_tmp_path_dir=%BASE_WORK_DIR%\ngs-retrieve-regulatory\ngs-retrieve-regulatory-parent
goto build_it

:build_it
pushd %build_tmp_path_dir%
mvn clean install
goto done

:options
echo options avaliable [mr, se, re, ex, es, on, ac, ch, tw, al, rr]
goto done

:error
echo invalid option '%1' use one of this valid options [mr, se, re, ex, es, on, ac, ch, tw, al, rr]

:done
echo DONE

