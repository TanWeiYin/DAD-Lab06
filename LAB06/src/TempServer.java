import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import melaka.rmi.manager.TempSensorManager;
import melaka.rmi.sensor.TempSensor;

public class TempServer 
{

	public static void main(String[] args) 
	{
		try 
		{
			// Create interface object
			TempSensor sensorAyerKeroh = new TempSensorManager();
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Register interface object as remote object
			rmiRegistry.rebind("SensorAyerKeroh", sensorAyerKeroh);
			
			System.out.println("SensorAyerKeroh is successfully registered");
			
		} 	
		catch (RemoteException e) 
		{
			e.printStackTrace();
		}

	}

}
