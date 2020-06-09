# attendance-management

Hi,

To run you need mysql installed and a database name AMS, tables would be created by the code because,
I have set spring.jpa.hibernate.ddl-auto=update, default user is root and password is left blank.

Code has several api's namely 

(a) "/register/add" : 

used for registration 
payload would be {"name":"aloha","password":"pass","role":"student","username":"shas71"} here role can be teacher or student

(b) "/student/viewAll" :

used to view all attendance records for a particular student
params required are student username and password

(c) "/student/viewByDate": 

used to view attendance record of a particular date
params required are date(format =  "2020-06-09") & student username and password

(d) "/teacher/markattendance": 

used for marking attendance of students only teachers can use it cause it requires
teacher username and password and a payload of type 

{ requestListId_Status:{"studentId":"status"}}

here status can be present or absent and studentId is id of the student present in database

(e) "/teacher/student/list": 

used for viewing all students
teacher username and password are required

swagger link is: http://localhost:8080/swagger-ui.html

I have used 3 tables namely student, teacher and attendance their structure can be viewed in Entities defined in code
username column for both student and teacher are unique
passwords are stored after encryption so that No one can view passwords just by opening the database

