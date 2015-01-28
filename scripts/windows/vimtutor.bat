@echo off
rem -- Run Vim --

set VIM_EXE_DIR=D:\diego\bin\Vim\vim74
if exist "%VIM%\vim74\vimtutor.bat" set VIM_EXE_DIR=%VIM%\vim74
if exist "%VIMRUNTIME%\vimtutor.bat" set VIM_EXE_DIR=%VIMRUNTIME%

if exist "%VIM_EXE_DIR%\vimtutor.bat" goto havevim
echo "%VIM_EXE_DIR%\vimtutor.bat" not found
goto eof

:havevim
rem collect the arguments in VIMARGS for Win95
set VIMARGS=
:loopstart
if .%1==. goto loopend
set VIMARGS=%VIMARGS% %1
shift
goto loopstart
:loopend

if .%OS%==.Windows_NT goto ntaction

"%VIM_EXE_DIR%\vimtutor.bat"  %VIMARGS%
goto eof

:ntaction
rem for WinNT we can use %*
"%VIM_EXE_DIR%\vimtutor.bat"  %*
goto eof


:eof
set VIMARGS=
