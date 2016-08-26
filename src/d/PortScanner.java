package d;
 
public class PortScanner {
	
    public static void main(String[] args) {
    	String start_host = "40.4.0.";
//    	String start_host = "123.202.0.";
//    	String end_host;
    	
    	/**
    	 * example...
    	 * 
    	 * thread  0           1           2           ...  255
    	 * 0       40.4.0.0    40.4.1.0    40.4.2.0    ...  40.4.255.0
    	 * 1       40.4.0.1    40.4.1.1    40.4.2.1    ...  40.4.255.1
    	 * 2       40.4.0.2    40.4.1.2    40.4.2.2    ...  40.4.255.2
    	 * ...     ...         ...         ...         ...  ...
    	 * 255     40.4.0.255  40.4.1.255  40.4.2.255  ...  40.4.255.255
    	 * 
    	 */
    	
        for(int i=0;i<256;i++)  //Open 256 threads
        {
        	String host = start_host + i;
        	H h = new H(host);
        	Thread t = new Thread(h);
        	t.start();
        }
    }
}
