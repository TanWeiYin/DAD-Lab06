package melaka.rmi.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import melaka.rmi.sensor.TempSensor;

public class TempSensorManager extends UnicastRemoteObject implements TempSensor
{
	public HashMap<String, Integer> Temp = new HashMap<>();
	
	public TempSensorManager() throws RemoteException 
	{
		super();
		
		Temp.put("Monday",32);
		Temp.put("Tuesday",31);
		Temp.put("Wednesday",33);
		Temp.put("Thursday",35);
		Temp.put("Friday",36);
		Temp.put("Saturday",33);
		Temp.put("Sunday",33);
	}
	
	public int getTemperature() throws RemoteException 
	{
		int temp = 0;
		Date date = new Date();   
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
		{
			temp = 32;
		}
		else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY)
		{
			temp = 31;
		}
		else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY)
		{
			temp = 33;
		}
		else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY)
		{
			temp = 35;
		}
		else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
		{
			temp = 36;
		}
		else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
		{
			temp = 33;
		}
		else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		{
			temp = 33;
		}
		else 
		{
			temp = 0;
		}
		
		return temp;
	}
	
	public double getAvgTemp()
	{
		double avg=0.0f;
		int intTemp = 0;
		for(Map.Entry temperature : Temp.entrySet())
		{
			intTemp += (int)temperature.getValue();
		}
		
		avg = (double)intTemp;
		
		avg = avg/7;
		
		return avg;
	}
}
