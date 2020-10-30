import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel fLabel;
  JLabel cLabel;

  JTextField fConverted;
  JTextField cConverted;

  JButton fahrenheitToCelciusBtn;
  JButton celciusToFahrenheitBtn;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);

    //initialize the labels
    fLabel = new JLabel("Degrees Fahrenheit");
    cLabel = new JLabel("Degrees Celcius");

    //set location and bounds
    fLabel.setBounds(50,25,150,25);
    cLabel.setBounds(50,60,150,25);

    //initialize the text fields
    fConverted = new JTextField();
    cConverted = new JTextField();

    //set location and bounds
    fConverted.setBounds(210,25,80,25);
    cConverted.setBounds(210,60,80,25);

    //initialize the buttons
    fahrenheitToCelciusBtn = new JButton("F->C");
    celciusToFahrenheitBtn = new JButton("C->F");

    //add an action listener to the buttons 
    fahrenheitToCelciusBtn.addActionListener(this);
    celciusToFahrenheitBtn.addActionListener(this);

    //set the action command on the buttons
    fahrenheitToCelciusBtn.setActionCommand("f->c");
    celciusToFahrenheitBtn.setActionCommand("c->f");

    //set location and bounds
    fahrenheitToCelciusBtn.setBounds(300,25,100,25);
    celciusToFahrenheitBtn.setBounds(300,60,100,25);

    //add the buttons to the MainPanel
    mainPanel.add(fahrenheitToCelciusBtn);
    mainPanel.add(celciusToFahrenheitBtn);

    //add the text fields to the mainPanel
    mainPanel.add(fConverted);
    mainPanel.add(cConverted);

    //add the labels to the mainPanel
    mainPanel.add(fLabel);
    mainPanel.add(cLabel);

    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("f->c")){
      //get the text from the fahrenheit text box
      String firstText = fConverted.getText();
      
      //change the string into an integer
      int f = Integer.parseInt(firstText);
      
      //convert fahrenheit to celcius
      cConverted.setText("" + ((f - 32) * 5/9));
    }else if(command.equals("c->f")){
      //get the text from the celcius text box
      String secondText = cConverted.getText();
      
      //change the string into an integer
      int c = Integer.parseInt(secondText);
     
      //convert celcius to fahrenheit
      fConverted.setText("" + ((c * 9/5) + 32));
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
