package week2.day2.assignment;

public class TV {
    public String power = "off";
    public int channel = 1;
    public int volume = 0;
    private int minChannel = 1;
    private int maxChannel = 100;
    private int minVolume = 0;
    private int maxVolume = 100;

    public void turnOn() {
        this.power = "on";
    }

    public void turnOff() {
        this.power = "off";
    }

    public void increaseVolume(int amount) {
        if (this.power.equals("off")) {
            System.out.println("TV is off");
            return;
        }
        if (this.volume >= maxVolume) {
            System.out.println("Maximum volume reached");
            return;
        }
        this.volume = Math.min(this.volume + amount, maxVolume);
        System.out.printf("Volume: %d%n", this.volume);
    }

    public void decreaseVolume(int amount) {
        if (this.power.equals("off")) {
            System.out.println("TV is off");
            return;
        }
        if (this.volume <= minVolume) {
            System.out.println("Minimum volume reached");
            return;
        }
        this.volume = Math.max(this.volume - amount, minVolume);
        System.out.printf("Volume: %d%n", this.volume);
    }

    public void increaseChannel(int amount) {
        if (this.power.equals("off")) {
            System.out.println("TV is off");
            return;
        }
        if (this.channel >= maxChannel) {
            System.out.println("Maximum channel reached");
            return;
        }
        this.channel = Math.min(this.channel + amount, maxChannel);
        System.out.printf("Channel: %d%n", this.channel);
    }

    public void decreaseChannel(int amount) {
        if (this.power.equals("off")) {
            System.out.println("TV is off");
            return;
        }
        if (this.channel <= minChannel) {
            System.out.println("Minimum channel reached");
            return;
        }
        this.channel = Math.max(this.channel - amount, minChannel);
        System.out.printf("Channel: %d%n", this.channel);
    }
}