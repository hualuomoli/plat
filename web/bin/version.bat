@echo off

rem /**
rem  * GitHub:https://github.com/hualuomoli/plat/tree/web
rem  *
rem  * Author:hualuomoli
rem  */
echo.
echo [Message] Version
echo.

cd %~dp0
set basePath=%cd%

set /p version=Please Input Your Version:
echo.

echo Update project to %version%

echo update parent
cd %basePath%/parent
call mvn versions:set -DnewVersion=%version%

echo update commons
cd %basePath%/commons
call mvn versions:set -DnewVersion=%version%

echo update base
cd %basePath%/base
call mvn versions:set -DnewVersion=%version%

echo update mvc
cd %basePath%/mvc
call mvn versions:set -DnewVersion=%version%

echo update demo
cd %basePath%/demo
call mvn versions:set -DnewVersion=%version%

pause