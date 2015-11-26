@echo off

rem /**
rem  * GitHub:https://github.com/hualuomoli/plat/tree/web
rem  *
rem  * Author:hualuomoli
rem  */
echo.
echo [Message] Install
echo.


cd %~dp0

set basePath=%cd%

echo Install Parent
cd %basePath%/parent
call mvn clean install -Dmaven.test.skip=true

echo Install Commons
cd %basePath%/commons
call mvn clean install -Dmaven.test.skip=true

echo Install Base
cd %basePath%/base
call mvn clean install -Dmaven.test.skip=true

echo Install MVC
cd %basePath%/mvc
call mvn clean install -Dmaven.test.skip=true

pause