# Info-Desk And Online Consultancy


This project is done by the following 3rd year SiTE students

-> Kalab Taye		UGR/0490/12	section 2
-> Nebiyu Yohannes	UGR/8159/12	Section 3
-> Kaleab Tekalign UGR/3664/12 section 2
-> Beka Dessalegn UGR/4605/12 Section 2

!NB usage guideline provided at the end of the page



this project is about guiding people trying to accomplish some task that usually require some procedural steps which are not familiar to the users' daily routine and others which they can't find closely.

an example situation can be if somebody wants to start a court case but doesn't have the know how of the process he can read a blog written by some consultant with requirements.

in addition to the procedural guidance this platform will provide users with the opportunity to closely get personal advices from private consultants who have closer encounters with situations like theirs


#The platform will include the following features

>>Two types of user(consultants and info-seeking customers)

>>The consultants will have the functionality of CRUD on the data they put on the platform

>>The customers can either access the posted data available or they can get access to contact with the consultants

>>both users must have an account to access their functionalities but the posted blogs will be accessible for visitors without an account

>>the customers and the consultants can send direct messages to admins through telegram API bot for any inquiry suggestion or additional things

>>a search engine will be available for the info seeking customers

>>a commenting section specifically for a blog posted by a consultant will be available for the info-seeking customers in which they will be able to share their experiences during their attempt to accomplish their task

>>the customers will have CRUD functionality on the comments they have given


#We will be using the following to design our platform

>>spring boot(MVC) framework will be used for the backend

>>we will be using a relational database to store the files (specifically SQL), this is chosen because we will store only large text files for the blogs which are well structured and use relatively lower storage, and it is also well suited for our search functionality as it has more consistency and control over the contents of the text files

>>we will be using spring security for authentication and authorization

>>





#useage guidlines
>> users will be directed to the index page as soon as they open site
>> users can access blogs posted on the site but they need an account to post any new ones
>> it is not possible to have an admin account in the registration so to test that feature a person will need to to insert data on the database manually with the following format      with email address- 'testemail@email.com', and password- 'password' (you need an encryption for the password so it is recomended to use the password and email provided below)
>> 
>> INSERT INTO `users` (`first_name`,`last_name`,`email`, `password`, `enabled`) VALUES ('fisrname','lastname','testemail@email.com', '$2a$10$4xZlnU7Gpg/T2c1iCrIU9eZvFmcbE4PIeUAS7dJh/eTS0u2rRfin2', 1);
>> 
>> the password encryption is the following
>> ...


