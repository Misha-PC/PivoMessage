import javax.swing.*;
import javax.accessibility.AccessibleContext;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PivoWindow extends JFrame {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 50020;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    //Gui
    private JTextField jtfMessage;
    private JTextField jtfName;
    private JTextArea jtaTextAreaMessage;
    //name
    private String clientName = "Pevas";
    public String getClientName() {
        return this.clientName;
    }

    public PivoWindow() {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        }catch(IOException e) {
            e.printStackTrace();
        }

        //create GUI

        setBounds(600, 300, 600, 500);
        setTitle(clientName);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jtaTextAreaMessage = new JTextArea();
        jtaTextAreaMessage.setEditable(false);
        jtaTextAreaMessage.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jtaTextAreaMessage);
        add(jsp, BorderLayout.CENTER);

        //Lable
        JLabel jlNumberOfClients =  new JLabel("Chelebos count:");
        add(jlNumberOfClients, BorderLayout.NORTH);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(jlNumberOfClients, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Send >");

    }

}
