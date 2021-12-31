# Info-Desk And Online Consultancy 


This project is done by the following 3rd year SiTE students
 
-> Kalab Taye		UGR/0490/12	section 2
-> Nebiyu Yohannes	UGR/8159/12	Section 3
-> Kaleab Tekalign UGR/3664/12 section 2
 
 
 
 

this project is about guiding people trying to acomplish some task that usually require some procedural steps which are not familiar to the users' daily routine and others which they can't find closely. 

an example situation can be if somebody wants to start a court case but dont have the know how of the process he can read a blog written by some consultant with requirements.

in addition to the procedural guidance this platform will provide users with the opprtunity to closely get personal advices from private consultants who have closer encounters with situations like theirs


#The platform will include the following features

>>Two types of user(consultants and info-seeking customers)

>>The consultants will have the functionality of CRUD on the data they put on the platform

>>The customers can either access the posted data available or they can get access to contact with the consultants

>>both users must have an account to access their functionalities but the posted blogs will be accessible for visitors without an account

>>the customers and the consultants can send direct mesages to admins through telegram api bot for any inquiry suggestion or additional things

>>a search engine will be available for the info seeking customers

>>a commenting section specifically for a blog posted by a consultant will be available for the info-seeking customers in which they will be abel to share their experiences during their attempt to accomplish their task

>>the customers will have CRUD functionality on the comments they have given


#We will be using the following to design our platform

>>spring boot framework will be used for the backend

>>we will be using a relational database to store the files (specifically SQL), this is choosen because we will store only large text files for the blogs which are well structured and use relativeley lower storage, and it is also well suited for our search functionality as it has more concistency and control over the contents of the text files 

>>we will be using spring security for authentication and authorization

>>
