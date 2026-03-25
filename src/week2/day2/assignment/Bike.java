package week2.day2.assignment;

public class Bike {
    public String power = "off";
    public int speed = 0;
    private int limit = 85;
    public void turnOn() {
        this.power = "on";
    }

    public void turnOff() {
        this.power = "off";
    }

    public void accelerate(int throttle) {
        if (this.power.equals("off")) return;
        if (this.speed >= limit) {
            System.out.println("Speed limit reached");
            return;
        };

        int acc;
        if (this.speed > 40) {
            System.out.println("Entering Gear 4");
            acc = gearFour(throttle);
        } else if (this.speed > 30) {
            System.out.println("Entering Gear 3");
            acc = gearThree(throttle);
        } else if (this.speed > 20) {
            System.out.println("Entering Gear 2");
            acc = gearTwo(throttle);
        } else {
            acc = throttle;
        }
        this.speed = this.speed + acc;
        System.out.printf("Speed: %d%n", this.speed);

        if (this.speed >= limit){
            this.speed = limit;
        }
    }

    public int gearTwo(int throttle){
        return throttle * 2;
    }

    public int gearThree(int throttle){
        return throttle * 3;
    }

    public int gearFour(int throttle){
        return throttle * 4;
    }

    public void decelerate(int throttle) {
        if (this.power.equals("off")) return;
        if (this.speed <= 0) {
            System.out.println("Bike is not moving");
            return;
        }

        int acc;
        if (this.speed > 40) {
            System.out.println("Leaving Gear 4");
            acc = gearFour(throttle);
        } else if (this.speed > 30) {
            System.out.println("Leaving Gear 3");
            acc = gearThree(throttle);
        } else if (this.speed > 20) {
            System.out.println("Leaving Gear 2");
            acc = gearTwo(throttle);
        } else {
            acc = throttle;
        }

        this.speed = Math.max(this.speed - acc, 0);
        System.out.printf("Speed: %d%n", this.speed);
    }
}
