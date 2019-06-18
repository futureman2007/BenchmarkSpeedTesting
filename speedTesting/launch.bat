@ECHO OFF
CD %~dp0
ECHO WORKING IN
ECHO %~dp0
CD deploy\SpeedTestJRE\bin
JAVA -m speed.testing/speed.testing.Speedtest
PAUSE
