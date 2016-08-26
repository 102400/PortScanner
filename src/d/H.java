package d;

import java.io.IOException;
import java.net.Socket;

public class H implements Runnable {
	
	private String host;
	private int port = 80;
	private int timeOut = 3000;
	
	private boolean go = true;
	
	public H(String host)
	{
		this.host = host;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(go)
		{
			if(scan(host, port, timeOut))
			{
	            System.out.println(host + ":" + 80);
	        }
			else
			{
//	        	System.out.println("X "+host);
	        }
			host = addIP(host);
		}
	}
	
	public boolean scan(String host, int port, int timeOut) {
        boolean flag = false;
        Socket socket = null;
        try {
            socket = new Socket(host,port);
            socket.setSoTimeout(timeOut);
            flag = true;
        } catch (IOException e) {
            // e.printStackTrace();
        } finally{
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
            }
        }
        return flag;
    }
	
	public String addIP(String host)
    {
    	String[] temp = host.split("\\.");
		int temp_c = Integer.valueOf(temp[2]);
		temp_c++;
		temp[2] = String.valueOf(temp_c);
		if(temp_c==256)
		{
			go = false;
//			try
//			{
//				throw new Exception("Out of range");
//			}
//			catch(Exception e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
    	String r = "";
    	for(int i=0;i<temp.length;i++)
    	{
    		if(i!=3)
    		{
    			r = r + temp[i] + ".";
    		}
    		else
    		{
    			r = r + temp[i];
    		}
    	}
    	
    	return r;
    }

}
