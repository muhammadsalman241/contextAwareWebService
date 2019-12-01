call wsdl2java.bat -uri http://localhost:8080/axis2/services/TimeTableService?wsdl -o .
copy Client.java src\ws\timetable
cd src\ws\timetable
javac -cp %AXIS2_HOME%\lib\* *.java