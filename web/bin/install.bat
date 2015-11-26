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
cd ..
set basePath=%cd%

echo Install Parent
cd %basePath%/parent
call mvn clean install -Dmaven.test.skip=true

echo Install Commons
cd %basePath%/modules/commons
call mvn clean install -Dmaven.test.skip=true

echo Install Base
cd %basePath%/modules/base
call mvn clean install -Dmaven.test.skip=true

echo Install MVC
cd %basePath%/modules/mvc
call mvn clean install -Dmaven.test.skip=true

pause