# weather-messaging-app

# Note
I was not able to deploy the application to AWS because I was using clj-http library to make my api calls. I intially copied over the assignment 4 code and was able to successfuly deploy to AWS and use twilio but after writing all my code for this assignment I attempted again and got the clj-http exception from AWS. I did not understand the error and emailed Professor White about the issue, he told me that the library only compiles in Java and that it would not work in AWS because it compiles code in Javascript. He also provided me some starter code for the HTTP library which would work in AWS. I was able to use this to get a valid promise back but I could not figure out how to isolate the JSON object returned. Any function I attempted on the promise turned it into another promise. I also tried using threads but I ran into seperate issue with clojure on that. As a result of my failure, I reverted my code to the clj-http library and ran the project locally.

# Summary:
This project is a weather messaging application where a user can text a message asking for the weather at a specific location using the city and recieve a response with the weather and forcast for that location for every three hours for the next 120 hours. The purpose of this application is to help hikers who are on long hikes and have no access to wifi and cannot tell if inclement weather is in the area. By using a messaging platform, hikers will not require wifi on their hikes to keep up with any weather changes and will only need their phones and a cellular signal.

By interviewing and questioning the employees of the Vanderbilt Outdoor Recreational Center, weather turned out to be the most severe problem. Specifically, on long hikes the group would often have to turn back around because of inclement weather that would suddenly be enveloping them. Internet access would not be available because of the isolated location of the hikers so they would have no time to prepare for the weather and as a result turn back around and lose ground on the hike.

The project can be broken down into the following steps: receiving user input, parsing the message according to the format received, connecting with a weather api, querying for the weather at the specified location, parsing the output from the weather api, and returning the data to the user. Each individual step is broken down into its own method and made modular for easy reuse. In addition, Twilio is used to send and recieve messages and the application itself lives on AWS as a EC2 instance.  

# Questions:
  1. Why did you join the Outdoor Rec Center?
  2. How often do you go on or lead trips?
  3. What kind of feedback do you recieve about the ORC trips?
  4. What are some of the problems you have with trips before actually going on the trip?
  5. What are some of the problems you have with trips during the trip?
  6. What are some of the problems you have with trips after the trip is over?
  7. Which of these problems is the most severe?
  8. Is there any mechanism in place to help solve this problem?
  9. Could you see a way in which technology could help in solving the problem?
  10. Do you think others would be willing to use this as well?

# Answers:
*Target group: employees of the Outdoor Rec Center

## Question 1: 
P1: I needed to get a job to help pay for school.

P2: I like being outdoors and the extra income obviously helps.

P3: I liked the idea of going on trips and meeting new people. I've been a avid hiker my whole life so I was interested in doing this since my freshman year.

## Question 2:
P1: A couple a semester.

P2: Abount once a month.

P3: About once every two weeks, but we have less and less trips as the year goes on so the frequency goes down as winter approaches.

## Question 3:
P1: Never really asked anyone but people seem to have fun and think it's worth the money.

P2: Usually positive! Every once in a while we'll have to cancel because of weather but other than that everyone is happy!

P3: Always good feedback! People love getting off campus and enjoying the outdoors!

## Question 4:
P1: Weather. Sometimes we have to cancel.

P2: Weather mainly, and one time we had no one sign up so obviously that was an issue.

P3: Usually weather because everything is outdoors so we'll have to cancel.

## Question 5:
P1: Don't really have any issues unless someone get hurt or needs emergency care.

P2: Mainly its people related issues. Someone will want to do something else and wander off or someone trips. Very minor stuff. We also 
had to turn back around one time because a storm was coming so that was bad. 

P3: Usually have no problems. Most of the people who come on the trips, regardless of magnitude, are experienced so everyone knows what to expect. Also one time we lost our signal and actually got lost in the Rockys but ended up finding our way back. I've also had to turn us around a couple of times because of weather but mostly its a very smooth process.

## Question 6:
P1: No problems.

P2: Reimbursements if the trips get cancelled because they can be a pain.

P3: No problems, unless someone got hurt in which case we have to fill out a really long form.

## Question 7:
P1: The weather.

P2: The weather, not getting off trail, and injuries.

P3: The weather and getting lost.

## Question 8:
P1: We can't control the weather, so if it gets cancelled, there's nothing we can do about it beforehand.

P2: Make a high tech suit that lets you see the trail and track where you are going and is also equipped with injury proof materials.

P3: I don't know what you could do about the weather. I guess you could do something about knowing if inclement weather is coming our way if we are on long trips and tracking our location at all times.

## Question 9:
P1: No.

P2: Refer to Question 8 P2.

P3: Make an app that tracks location and updates the weather constantly regardless of signal or wifi and also alerts the user if there are any drastic changes coming.

## Question 10:
P1: I didn't give a suggestion so I'm not sure.

P2: Yeah! I think people would love it, but it would probably cost a lot of money!

P3: Yeah I think they would.

# Requirements

The project requires the use of VSCode, Twilio, AWS s3, and the openweather API which aggregates and returns weather data based on location. Code from assignment 3 is used as starter code to build upon the messaging platform. Once the application is up and running, the user will need a Twilio account to access the program on AWS and cellphone signal so that the messages are sent. 

# Development

1) Present a brief overview of project to all clients interviewed and ask for feedback on final product and any additional functionality that can be added to the project. 
2) Use feedback received from clients to make any reasonable - based on time and implentation difficulty - changes to the project. 
3) Once the exact functionalities of the project are finalized, copy over assignment 3 code to new repo
4) Write method to establish connection to openweather API and test stability of connection to API. 
5) Once connection is established, modify and integrate starter to code to recieve user input in lattitude and longitude, parse the input, call on openweather with input and return the response to the client. Write and modify tests for each function modified or added (unit testing) and add integration tests (methods working together to test overall funcitonality of the program).
6) Once all code is written and local tests are passing, conduct testing of code by using the application. If there are mitigations or inadequate exception handling, then note them down.
7) Make any changes needed based on step 6 and add or modify testing code.
8) Once minimum viable product is ready give access to small group of clients to use the application.
9) Ask for feedback regularly (once a month) from clients and modify application based on desired functionalites and any issues that need to be fixed. Continue this cycle until project is either shelfed or passed on to another developer.

