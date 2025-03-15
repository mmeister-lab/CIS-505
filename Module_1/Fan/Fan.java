
/*Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc*/
public class Fan{
private static int STOPPED = 0;
private static int SLOW = 1;
private static int MEDIUM = 2;
private static int FAST = 3;
private int SPEED;

private boolean on;
private double radius;

private String color;
/*Constructor with no arguments*/
public Fan()
{
SPEED = STOPPED;
on = false;
radius = 6;
color = "white";
}
/*Argument Constructor using speed, on, color, and radius*/
public Fan(int fSpeed, boolean fOnOff, double fRadius,String fColor)
{
    if(fSpeed == 1){
    SPEED = SLOW; } 
    else if(fSpeed == 2)  {SPEED = MEDIUM;}
    else if(fSpeed == 3) {SPEED = FAST;}
    else {SPEED = STOPPED;
    on = false;}

    
    
    on = fOnOff;
    color = fColor;
    radius = fRadius;
}
/*Speed mutator*/
public void setFanSpeed(int fSpeed)
{
    SPEED = fSpeed;
}
/*Speed accessor*/
public int getFanSpeed()
{
    return SPEED;
}
/*On or off mutator*/
public void setFanOnOff(boolean fOnOff)
{
    on = fOnOff;
}
/*On or off accessor*/
public boolean getFanOnOff()
{
    return on;
}
/*Color mutator*/
public void setColor(String fColor)
{
    color = fColor;
}
/*Color accessor*/
public String getColor()
{
    return color;
}
/*Radius mutator*/
public void setRadius(double fRadius)
{
    radius = fRadius;
}
/*Radius accessor*/
public double getRadius()
{
    return radius;
}

    /*Overriding toString() method of String class*/
    @Override
    public String toString() {
        if(on){
        return "The fan speed is set to " + this.SPEED + " with a color of " + this.color + " and a radius of " + this.radius;
        } else {
        return "The fan is " + this.color + " with a radius of " + this.radius + " and the fan is off";}
    }
}