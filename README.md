# Context Aware Web Service
Prototype of Axis2 Soap Engine based Context Aware Web Service.
This webservice provide time table, and project contain software sensor, which sense where user are and where it should be according to time table and current time and date, It just a model presenting that how the Pervasive Systems are act.
### System Behaviour 
This project is written in java [POJO](http://axis.apache.org/axis2/java/core/docs/pojoguide.html) style based web service which is deployed on [Standalone Axis2 webserver](http://axis.apache.org/axis2/java/core/docs/installationguide.html#standalone2), project contain a service which provide timetable, and a client who get time table from soap service and show to user, but among them there is a sensor which grab context from client and show a notification.


## Installation

Download and [Install](http://axis.apache.org/axis2/java/core/docs/installationguide.html#standalone2) [Axis2](http://www.apache.org/dyn/closer.lua/axis/axis2/java/core/1.7.9/axis2-1.7.9-bin.zip) binary version and Make these Enviroment Variables, then download this repo and follow bellow given steps.

```bash
AXIS2_HOME = installationDirectory\axis2-1.7.9
Path = %Path%;installationDirectory\axis2-1.7.9\bin
```

## Usage
### How to Build & run Service
1. Go to [timeTable](wservice/ws/timeTable) directory and run [comileService.bat](wservice/ws/timeTable/comileService.bat) that will compile Service Class.
2. Go to [wservice](wservice/) directory and run [buildService.bat](wservice/buildService.bat) that will make service .aar file, then upload that file to 'axis2-1.7.9\repository\services'.
3. Go to master directory and run [startServer.bat](startServer.bat) that will start axis2 Server.
4. Go to [wserviceClient](wserviceClient/) directory and run [buildClient.bat](wserviceClient/buildClient.bat) that will create Stub classes and compile the client & other classess.
5. Again go to [wserviceClient](wserviceClient/) and run [runClient.bat](wserviceClient/runClient.bat) that will execute Client code.

## Results
 ![Start](https://github.com/muhammadsalman241/contextAwareWebService/blob/master/Screenshot%20(10).png)
 ![Result](https://github.com/muhammadsalman241/contextAwareWebService/blob/master/Screenshot%20(11).png)
