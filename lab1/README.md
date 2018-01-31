# ITMD415 - Lab 1

Class functions:
* HLib - Has extra methods.
* IntHolder - Used to pass integers by reference.
* MathClient - Acts as the client, running the main will invoke a repl.
* MathE - Keeps variables used throughout all classes.
* MathLib - Used to create random sets of queries for ease in testing.
* MathServer - Acts as the overall server, running the main will start the server.
* MathServerThread - Acts as the go between for MathClient and MathServer aka implements the threading.
* Message - Has extra methods for the ObjectOutputStreams
* Statement - Holds together the operands and operator for use in other classes.
* Tests - Used for many tests as we made all classes. Current methods of importance in Tests are...
... * testClientConnectivity(int n) which will initiate as many clients as wanted and connect them to the server
... * testClientMassUse(int clients, int ops) which will initiate as many clients as wanted and have each client made request as many operations as wanted to the server.
        
Suggested Testing:

Method 1:

Run MathServer.java

Run MathClient.java (Can run as many as wanted)

Method 2:

Run MathServer.java

Run Tests.java

Note: Tests is currently set to create 100 Clients and have each client send 50 random operations to the server.
      This can be changed to any number of clients and operations by simply changing the parameters of "Tests.testClientMassUse(100, 50);" inside the main method of Tests.java