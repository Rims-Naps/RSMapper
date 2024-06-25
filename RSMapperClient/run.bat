@echo off
@title RSMapper

:compile
@echo Compiling
"C:\Program Files\zulu\zulu-8\bin\javac.exe" -d bin -classpath bin;resources/* -sourcepath src src/ClientLoader.java
if %errorlevel% neq 0 goto compileerror

:run
java -Xmx6G -Xms2048m -server -Dsun.java2d.noddraw=true -XX:+DisableExplicitGC -XX:-OmitStackTraceInFastThrow -XX:+AggressiveOpts -XX:+UseAdaptiveGCBoundary -XX:MaxGCPauseMillis=300 -XX:SurvivorRatio=16 -XX:+UseParallelGC -classpath bin;resources/* ClientLoader
goto run

:compileerror
echo Compilation failed. Please check your code and try again.
pause
