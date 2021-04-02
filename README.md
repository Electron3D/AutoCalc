# AutoCalc
## Video Demo:  <https://youtu.be/48A3oEzclbw>
## Description:
My first android app is called "AutoCalc". It's auto's cost calculator.
My app is useful for people who want to know how much money they already spend or will spend for their car.

### Main page and Menu
First of all I created main page of my app and menu.
Main page contains my app's logo and title. Menu is used for navigation.
Base function of my app is calculating car cost for period of time, but in the future i want to add tire size calculator as well.
So i added tire size calc button in menu. I disable it temporarily.

### Auto Cost Calc
Then i created AutoCostCalcActivity as a form for communicating with users.
In this form users should input their data for calculating, then they should push "Calculate!" button and recieve the result.
So on, when button is pushed, all inputed data send to the constructor of AutoCalculator class.
This class needed for manipulating with the data from activity and calculating a lot of parametres and then give back the result to activity.
If you don't know some data to input just leave it blank. This parameter will be skipped.
In the most difficult points, you can press the help button to see a hint.
This application calculates many parameters such as car tax, gasoline spending or overpayment for a loan and loss of car value.

I used the Toolbar widget to create the title.
In order for this activity to scroll, I used a ScrollView. In it, I placed the LinearLayout as a container for the RelativeLayout,
for the buttons for calculating and clearing the entered data, and for placing TextViews for outputting the result.
RelativeLayout is convenient for marking up an activity due to its flexibility in customization and the ability
to build dependencies of one element on another. For example, aligning to the parent or finding an element relative to another
element in this block. For example, under it.

### Settings
My application don't have a lot of settings, so i added some info about app and developer here.
For the hints in AutoCostCalcActivity and activities on buttons "About developer" and "About app" I used the Dialog theme.
This greatly changes the style and appearance of these activities in a more usable way.
I have implemented the application in Russian and English. English is the default language, but if the system language is Russian,
the application will automatically switch.
I have a few ideas that I can add to the settings. One of them is the choice of currency, but this is in my future plans.
For now, you can only get the result in Russian rubles.
