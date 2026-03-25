package week2.day2.assignment;

public class AC {
    public String power = "off";
    public int temperature = 16;
    private int minTemp = 16;
    private int maxTemp = 30;

    public void turnOn() {
        this.power = "on";
    }

    public void turnOff() {
        this.power = "off";
    }

    public void increaseTemp(int amount) {
        if (this.power.equals("off")) {
            System.out.println("AC is off");
            return;
        }
        if (this.temperature >= maxTemp) {
            System.out.println("Maximum temperature reached");
            return;
        }

        this.temperature = Math.min(this.temperature + amount, maxTemp);
        System.out.printf("Temperature: %d%n", this.temperature);
    }

    public void decreaseTemp(int amount) {
        if (this.power.equals("off")) {
            System.out.println("AC is off");
            return;
        }
        if (this.temperature <= minTemp) {
            System.out.println("Minimum temperature reached");
            return;
        }

        this.temperature = Math.max(this.temperature - amount, minTemp);
        System.out.printf("Temperature: %d%n", this.temperature);
    }
}