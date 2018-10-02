# weather-messaging-app

# Summary:
This project is a weather messaging application where a user can text a message asking for the weather at a specific location either in lattitude and longitude or using the city and state and recieve a response with the weather and forcast for that location. The purpose of this application is to help hikers who are on long hikes and have no access to wifi and cannot tell if inclement weather is in the area. By using a messaging platform, hikers will not require wifi on their hikes to keep up with any weather changes and will only need their phones and a cellular signal.

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
P2: Mainly its people related issues. Someone will want to do something else and wander off or someone trips. Very minor stuff. We also had to turn back around one time because a storm was coming so that was bad. 
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
