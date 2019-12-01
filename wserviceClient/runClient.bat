@echo off
cd src\
java -cp %AXIS2_HOME%/lib/*; ws.timetable.Client
pause