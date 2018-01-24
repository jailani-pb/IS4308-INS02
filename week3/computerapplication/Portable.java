package week3.computerapplication;

public class Portable extends Computer {

	int batteryCapacity;
	
	public Portable(String operatingSystem) {
		super(operatingSystem);
		batteryCapacity = 0;
	}
	
	public int getBatteryPercentage() {
		return batteryCapacity;
	}
	
	public void chargeBattery(int percentage) {
		if(percentage >= 0) {
			batteryCapacity += percentage;
			if(batteryCapacity > 100) {
				batteryCapacity = 100;
			}
		}
	}
	
	public void useDevice() {
		batteryCapacity -= 5;
		if(batteryCapacity < 0) {
			batteryCapacity = 0;
			shutDown();
		}
	}
	
}



