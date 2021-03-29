# AutoCalc
## Video Demo:  <URL HERE>
## Description:
My first android app is called "AutoCalc". It's auto's cost calculator.
My app is useful for people who want to know how much money they already spend or will spend for their car.

#### Main page and Menu
First of all I created main page of my app and menu.
Main page contains my app's logo and title. Menu is used for navigation.
Base function of my app is calculating car cost for period of time, but in the future i want to add tire size calculator as well.
So i added tire size calc button in menu but i disable it temporarily.

#### Auto Cost Calc
Then i created AutoCostCalcActivity as a form for communicating with users.
In this form users should input his data for calculating, then they should push "Calculate!" button and recieve the result.
So on, when button is pushed, all inputed data send to the constructor of AutoCalculator class.
This class needed for manipulating with the data from activity and calculating a lot of parametres and then give back the result to activity.
If you don't know some data to input just leave it blank. This parameter will be skipped.

#### Settings
My application don't have a lot of settings, so i added some info about app and developer here.
I have a few ideas that I can add to the settings. One of them is the choice of currency, but this is in my future plans.
For now, you can only get the result in Russian rubles.
