package socketserverrfood;

import Exception.ValueOutOfRange;
import Frames.Table;
import Models.ContainerCans;
import Models.ReadingDogFood;
import Models.Device;
import Models.ReadingDuckFood;
import exception.RecordNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import Models.ErrorLog;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SocketServerRfood extends Thread
{
    // object declaration
    ServerSocket ss;
    Socket s;
    InputStreamReader isr;
    BufferedReader br;
    PrintStream ps;
    DataOutputStream pw = null;
    int receivePort;                // port to receive  from
    boolean threadRunning = true;   // flag to terminate thread

    
    SocketServerRfood(int receivePort)    // constructor to receive datagrams on port receivePort
    {
        this.receivePort = receivePort;
    }
    
    public void stopTCPserver() { threadRunning = false; }

    public void run()                // thread run method, receives and buffers datagrams
    {
        Socket socket = null;
        int frame = 0;
        Table t = new Table();
        t.show();
        while (threadRunning)
        {
            try
            {
                String idMac = "";
                System.out.println("TCP  server starting: IP address " + InetAddress.getLocalHost().toString() + " port " + receivePort );
                ss = new ServerSocket(receivePort);
                int status = 0;
                String response = "Message received"; // response to client
                socket = ss.accept(); // Wait for client to connect.
                System.out.println("Client connect from IP address " + socket.getInetAddress()
                                  + " port " + socket.getPort());

                isr = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(isr); // buffered reader
                String data = br.readLine(); // read data

                pw = new DataOutputStream(socket.getOutputStream());

                try
                {
                    if (data != null)
                    {
                        // decode json
                        try
                        {
                            JSONObject JSONdata = new JSONObject(data);
                            idMac = JSONdata.getString("id");
                            String date = JSONdata.getString("da");
                            String time = JSONdata.getString("ti");
                            double value = JSONdata.getDouble("val");
                            double aValue = JSONdata.getDouble("aVal");
                            int cans = JSONdata.getInt("cans");
                            int aCans = JSONdata.getInt("aCans");
                            int dod = JSONdata.getInt("dod");
                            Device d = new Device(idMac);
                            ContainerCans c = new ContainerCans(date, d, cans, time, aCans);
                            int quantity = 0;
                            int lastCant = 0;
                            String dogOrDuck = "Filling Both";
                            if(cans == 0 && value == 0)
                            {
                               ReadingDogFood rdog = new ReadingDogFood(date, d, aValue, time, value);
                               rdog.add();
                               ReadingDuckFood rduck = new ReadingDuckFood(date, d, aValue, time, value);
                               rduck.add();  
                               c.add(0, 0);

                               dogOrDuck = "Filling Both";
                            }
                            else if(dod == 1)
                            {
                                ReadingDuckFood r = new ReadingDuckFood(date, d, aValue, time, value);
                                r.add();

                                quantity = c.getLastTotalCans();
                                lastCant = quantity + cans;
                                System.out.println("Last cant " + lastCant + ", quantity " + quantity);
                                c.add(cans, lastCant);

                                dogOrDuck = "Duck Food";
                            }
                            else if (dod == 2)
                            {
                                ReadingDogFood r = new ReadingDogFood(date, d, aValue, time, value);
                                r.add();
                                quantity = c.getLastTotalCans();
                                lastCant = quantity + cans;
                                System.out.println("Last cant " + lastCant + ", quantity " + quantity);
                                c.add(cans, lastCant);

                                dogOrDuck = "Dog Food";
                            }

                            String[] row = new String[8];

                            row[0] = idMac;
                            row[1] = date;
                            row[2] = time;
                            row[3] = Integer.toString(cans);
                            row[4] = Double.toString(aValue);                        
                            row[5] = dogOrDuck;
                            row[6] = Double.toString(value);
                            row[7] = "Ok";

                            t.add(row);

                            quantity = d.getTotalLifeCans();
                            lastCant = cans + quantity;
                            d.setTotalLifeCans(lastCant);
                            d.edit();
                        }
                        catch (ValueOutOfRange e)
                        {
                            String[] row = new String[8];

                            row[0] = idMac;
                            row[1] = "N/A";
                            row[2] = "N/A";
                            row[3] = "N/A";
                            row[4] = "N/A";
                            row[5] = "N/A";
                            row[6] = "N/A";
                            row[7] = e.getMessage() + "from " + idMac;

                            Date date = Calendar.getInstance().getTime();  
                            ErrorLog el = new ErrorLog(date, 1, (e.getMessage() + "from " + idMac));
                            el.add();
                            status = 4;
                            response = e.getMessage();
                        }
                        catch (RecordNotFoundException e)
                        {
                            String[] row = new String[8];

                            row[0] = idMac;
                            row[1] = "N/A";
                            row[2] = "N/A";
                            row[3] = "N/A";
                            row[4] = "N/A";
                            row[5] = "N/A";
                            row[6] = "N/A";
                            row[7] = e.getMessage() + "from " + idMac;

                            Date date = Calendar.getInstance().getTime();  
                            ErrorLog el = new ErrorLog(date, 2, (e.getMessage() + "from " + idMac));
                            el.add();
                            status = 3;
                            response = e.getMessage();
                        }
                        catch (JSONException e)
                        {
                            String[] row = new String[8];

                            row[0] = idMac;
                            row[1] = "N/A";
                            row[2] = "N/A";
                            row[3] = "N/A";
                            row[4] = "N/A";
                            row[5] = "N/A";
                            row[6] = "N/A";
                            row[7] = e.getMessage() + "from " + idMac;

                            t.add(row);

                            Date date = Calendar.getInstance().getTime();  
                            ErrorLog el = new ErrorLog(date, 0, (e.getMessage() + "from " + idMac));
                            el.add();
                            status = 2;
                            response = "Invalid JSON format";
                        }
                    }
                    else
                    {
                        status = 1;
                        response = "Data not received";
                    }
                    pw.flush();
                    ss.close(); //esto no se para que sirve ni se por que esta ahi pero lo dejo por si las moscas
                }
                catch (Exception ex) 
                {
                    System.out.println(ex.getMessage());
                }
            } catch (IOException ex) 
            {
                System.out.println("Si sale esto valio madre");
            }
        }
    }
        
    public static void main(String[] args)
    {
        int receivePort=28001;//999;//20000;                                 // port to receive datagrams on
        SocketServerRfood frameInput = new SocketServerRfood(receivePort);    // create server to receive messages
        frameInput.start();                                   // and start it
        System.out.println("ready to receive from socket " + receivePort);
    }   
}
