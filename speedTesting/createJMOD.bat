::@ECHO OFF
cd /D %~dp0
rmdir /Q /S deploy
mkdir deploy
cd target/classes
jmod create --class-path "." --main-class speed.testing.Speedtest --target-platform "windows-amd64" speedtestmod.jmod
pause
