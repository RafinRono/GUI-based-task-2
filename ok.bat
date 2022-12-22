@echo off
:home
echo running a gui
pause
javac Classes/User.java
javac Classes/Login.java
javac Classes/Home.java
javac Classes/ForgotPass.java
javac Classes/Register.java
javac Classes/Update.java
javac Classes/Final.java
javac Start.java
color 04
echo compiled successfully
pause
java Start
echo continue to open gui again
pause
goto home
