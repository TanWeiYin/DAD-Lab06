package melaka.rmi.sensor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TempSensor  extends Remote
{
	public int getTemperature() throws RemoteException;
	
	public double getAvgTemp() throws RemoteException;
}
