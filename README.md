# contextAwareWebService
Prototype of Axis2 Soap Engine based Context Aware Web Service.
This webservice provide time table, and project contain software sensor, which sense where user are and where it should be according to time table and current time and date.

## Installation

Download and Install Axis2 binary [axis2](http://www.apache.org/dyn/closer.lua/axis/axis2/java/core/1.7.9/axis2-1.7.9-bin.zip) and Make these Enviroment Variables, then download this repo and follow bellow given steps.

```bash
AXIS2_HOME = installationDirectory\axis2-1.7.9
```

## Usage
1. Go to [wservice](wservice/ws/timeTable) and run [comileService.bat](wservice/ws/timeTable/comileService.bat) that will compile Service Class.
2. Go to [wservice](wservice/) and run [buildService.bat](wservice/buildService.bat) that will make service .aar file, then upload that file to 'axis2-1.7.9\repository\services'.
3. Go to [master](./) directory and run [startServer.bat](startServer.bat) that will that will on axis2 Server.
4. Go to [wserviceClient](wserviceClient/) and run [buildClient.bat](wserviceClient/buildClient.bat) that will create Stub classes and compile the client & other classess.
5. Again go to [wserviceClient](wserviceClient/) and run [runClient.bat](wserviceClient/runClient.bat) that will execute Client code.

## Results
 ![Start](https://github.com/muhammadsalman241/contextAwareWebService/blob/master/Screenshot%20(10).png)
 ![Result](https://github.com/muhammadsalman241/contextAwareWebService/blob/master/Screenshot%20(11).png)
