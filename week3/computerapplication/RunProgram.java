package week3.computerapplication;

public class RunProgram {

	public static void main(String[] args) {
		Desktop desktop = new Desktop("Windows 10");
		System.out.println(desktop.operatingSystem);
		desktop.bootUp();
		System.out.println(desktop.powerStateOn);
		
		SmartPhone smartPhone = new SmartPhone("Android");
		System.out.println(smartPhone.operatingSystem);
		smartPhone.chargeBattery(50);
		System.out.println(smartPhone.getBatteryPercentage());
		System.out.println(smartPhone.displayOn);
		smartPhone.bootUp();
		System.out.println(smartPhone.displayOn);
	}
	
}
