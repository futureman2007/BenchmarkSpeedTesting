::@ECHO OFF
cd /D %~dp0
rmdir /Q /S deploy
mkdir deploy
cd target
rmdir /Q /S classes
rmdir /Q /S generated-sources
rmdir /Q /S maven-archiver
rmdir /Q /S maven-status
jlink --module-path ".;%JAVA_HOME%/jmods" ^
--add-modules speed.testing ^
--compress=2 ^
--output ../deploy/SpeedTestJRE
pause
