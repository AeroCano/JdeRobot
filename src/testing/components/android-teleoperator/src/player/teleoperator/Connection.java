package player.teleoperator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import jderobot.LaserPrx;
import jderobot.MotorsPrx;
import jderobot.Pose3DMotorsData;
import jderobot.Pose3DMotorsPrx;
import bica.*;

public final class Connection {
	
	public static void disconnect() {
		if(communicator != null)
			communicator.destroy();
	}
	
	public static void setCommunicator(Ice.Communicator c) {
		communicator = c;
	}
	
	public static void setHead(Pose3DMotorsPrx h) {
		hprx = h;
		Connection.initHead();
	}
	
	public static Pose3DMotorsPrx getHead() {
		return hprx;
	}
	
	public static void setMotors(MotorsPrx m) {
		mprx = m;
		Connection.initMotors();
	}
	
	public static MotorsPrx getMotors() {
		return mprx;
	}	
	
	public static void setConnected(boolean status) {
		connected = status;
	}
	
	public static void setUseNao(boolean status) {
		use_nao = status;
	}
	
	public static boolean isConnected() {
		return connected;
	}
	
	public static boolean isLaserAvailable() {
		return false;
	}
	
	public static void setV(float v)  {
		Connection.lock.lock();
		Connection.getMotors().setV(v);
		Connection.lock.unlock();
	}
	
	public static void setW(float w) {
		Connection.lock.lock();
		Connection.getMotors().setW(w);
		Connection.lock.unlock();
	}
	
	public static void setL(float l) {
		Connection.lock.lock();
		Connection.getMotors().setL(l);
		Connection.lock.unlock();
	}
	
	public static void setPan(float pan)  {
		Connection.lock.lock();
		if(use_nao) {
			Pose3DMotorsData data = new Pose3DMotorsData ();
			data.tilt = last_tilt;
			data.pan = pan;
			Connection.last_pan = pan;
			Connection.getHead().setPose3DMotorsData(data);
		}
		Connection.lock.unlock();
	}
	
	public static void setTilt(float tilt)  {
		Connection.lock.lock();
		if(use_nao) {
			Pose3DMotorsData data = new Pose3DMotorsData ();
			data.tilt = tilt;
			data.pan = last_pan;
			Connection.last_tilt = tilt;
			Connection.getHead().setPose3DMotorsData(data);
		}
		Connection.lock.unlock();
	}
	
	public static void initMotors() {
		Connection.lock.lock();
		Connection.getMotors().setV(0.0f);
		Connection.getMotors().setW(0.0f);
		Connection.getMotors().setL(0.0f);
		Connection.lock.unlock();		
	}
	
	public static void initHead() {
		Connection.lock.lock();
		Pose3DMotorsData data = new Pose3DMotorsData ();
		data.tilt = last_tilt;
		data.pan = last_pan;
		Connection.getHead().setPose3DMotorsData(data);
		Connection.lock.unlock();	
	}
	

	/*public static void sendThread() {
		// Create a thread to send the signal
		thread = new Thread(new Runnable() {
			public void run() {
				long ctime;
				boolean sendv = true;

				try {
					while (true) {
						
						if(Connection.isConnected()) {
							Connection.lock.lock();
							ctime = System.currentTimeMillis();
							
							if((ctime - ltime) > nsegs*1000) {
								if(sendv)
									Connection.getTeleoperator().setV(v);
								else{
									Connection.getTeleoperator().setW(w);
									Connection.getTeleoperator().setL(l);
								}
					
								sendv = !sendv;
								ltime = System.currentTimeMillis();
							}	
							Connection.lock.unlock();
						}

						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
				}
			}
		});

		thread.start();
	}
	
	private static float v;
	private static float w;
	private static float l;
	private static long ltime=0;
	private static long nsegs = 2;
	private static Thread thread;*/
		
	private static Lock lock = new ReentrantLock();
	private static Ice.Communicator communicator;

	private static boolean connected;

	private static MotorsPrx mprx;
	private static Pose3DMotorsPrx hprx;
	private static boolean use_nao = false;
	private static float last_pan = 0.0f;
	private static float last_tilt = 0.0f;
}
