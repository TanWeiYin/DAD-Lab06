import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Locale;

import melaka.rmi.sensor.TempSensor;

public class TempClient 
{

	public static void main(String[] args) 
	{
		try 
		{	
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Look-up for the remote object
			TempSensor remoteSensorAyerKeroh = (TempSensor) rmiRegistry.lookup("SensorAyerKeroh");
			
			// Invoke method from the remote object
			int currentTemperature = remoteSensorAyerKeroh.getTemperature();
			double AvgTemp = remoteSensorAyerKeroh.getAvgTemp();
			
			String weekday = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
			
			System.out.println("Current temperature in Ayer Keroh on " + weekday + " is " + currentTemperature + " Celcius");
			System.out.println("Average temperature in Ayer Keroh in this week is " + String.format("%.2f", AvgTemp) + " Celcius");
			
		} 
		catch (RemoteException | NotBoundException e) 
		{
			e.printStackTrace();
		}

	}

}
