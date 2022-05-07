# coffee-delivery-app
A restaurant order and delivery application for a fictional coffee store selling different types of (highly overpriced) coffee. Runs on Android OS.

## Overview

The app contains three separate activities accessible through buttons that initiate intents to start the consecutive activity.

<ol>
  <li>The first activity displays an option for the user to choose the desired drink(s).</li>
  <li>The second activity takes input data about the customer and delivery place.</li> 
  <li>The last activity shows the summary and status of the order.</li>
</ol>

## Demo
[![Demo Delivery App](https://j.gifs.com/lRLVYl.gif)]

## Development Process

### Exploring Tools and Developing a RESTful API
For the application backend, I started out by reading about the tools and technologies that
would be involved in the development process: REST API (Representational State Transfer
Application Programming Interface, a standard that allows information transfer between
applications and servers over the internet), Postman (software to test API requests), and Flask
(a web framework integrated in Python, used to create API’s).
Initially, I used Repl.it - a web IDE - to program and test Flask programs through so-called
“multi-page flask templates”. Using Postman, I was able to simulate a client and send various
API requests (GET, PUT, POST, DELETE) that would update and return information from that
server, seen in Picture 1. This worked well initially, until I wanted to include more complex
libraries and create local databases. I therefore switched to the PyCharm IDE, which allowed
me to access a large variety of libraries as well create tables of records that I then would display
with the application DB Browser for SQLite (Picture 2).

![image](https://user-images.githubusercontent.com/74726737/167269236-dfb32601-6aca-4d95-8937-c901dca1950c.png)

*Picture 1: Sending API requests to Flask server using Postman*

![image](https://user-images.githubusercontent.com/74726737/167269252-30c4458e-9b0e-40b1-b251-c87f44010600.png)

*Picture 2.1: Viewing Database Record in DB Browser for SQLite*

![image](https://user-images.githubusercontent.com/74726737/167269263-2eea440e-e4a0-447e-a802-0a17277c1163.png)

*Picture 2.2: Table Entries in DB Browser for SQLite*

### Backend Development
Once I felt familiar with these development tools, I went ahead and specified the REST API
methods for what data to pass over the local network as well methods for instantiating
transferable SQLite database records. These included methods to get, create, update and
delete the records of orders and customers. Then I simply implemented these specifications in
code using Python and Flask. Several libraries were included to implement the functionalities,
such as SQLAlchemy for creating and working with databases, Marshmallow to serialize
database records into a network-transferable format, and . An example method is provided in
picture 3, where we can see how the header name and method type is declared in the decorator
above the function implementation.<br>


![image](https://user-images.githubusercontent.com/74726737/167269281-04e870b5-cd11-4133-951d-4ee6b035c2e7.png)
*Picture 3: Example of REST API method in Flask to update customer record*

As for the backend database, I continued to use SQLite as in the previous iteration. However,
instead of implementing the database next to the Android Java code, I used Python and Flask
for this purpose, as it turned out to be relatively straightforward to implement. An example class
is provided in picture 4. It also facilitated the process of working with the API.


![image](https://user-images.githubusercontent.com/74726737/167269312-841a5d39-8019-46c6-8112-8a0b3efc7c35.png)

*Picture 4. Example of backend database model in Flask to hold customer records*

The next logical step was to update the Android application itself with the ability to send data to
the server using the RESTful API.


### Modifying the Application to send API Requests
The question to address for this last part was: how would I be able to pass data from the client
(customer-side of the application) to the server database?
As we have implemented a basic RESTful API, we would like to use a library to be able to send
requests to our API. This Android library is called Volley and it provides the methods that allow
for API requests over a network. In contrast to the Flask and Python development, trying to use
Volley turned out to be quite a bit more challenging. First, I had to change the Android manifest
to allow for internet permission. However, it was not entirely clear where to put this new line of
code, and at first I incorrectly placed it under my application section. This caused my app to not
launch at all and I spent a significant amount of time debugging this issue and figuring out
where to place the line of code instead. Turns out it it was simply supposed to be placed out in
the general manifest section (Picture. 5).

![image](https://user-images.githubusercontent.com/74726737/167269322-1c5b5e1e-eed9-46f5-88f5-0ec8a9862c90.png)

*Picture 5. Updated Android Manifest with Internet Permissions*

To use the volley library, and in particular, to pass jsonfied-formated data objects over the web
from an app activity, the recommended approach was to create a separate application class (in
contrast to an application activity) following the singleton software design pattern. This singleton
was to be responsible for keeping a network Request Queue (picture 6). The purpose of this
separation of code was to allow web requests for the entire duration of the acivity lifecycle. A
singleton instance would then be instantiated in the activity while the app is running.

![image](https://user-images.githubusercontent.com/74726737/167269326-2042b304-2331-4d9d-ae09-e96736888299.png)

*Picture 6. Implementation of a singleton class responsible for network requests*

I wanted my app to send API POST requests in two instances: firstly, the customer’s new order
(consisting of chosen items) after the third activity and secondly after the fourth activity, with the
customer delivery information.Hence, in these activities I would call the singleton class and make the appropriate API
requests, which would be sent to the backend server.

