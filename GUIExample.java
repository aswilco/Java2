import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author brunson
 */
public class GUIExample extends JFrame implements ActionListener {//Begin GUIExample class

     //GUI variables
    static final int WIDTH = 300, HEIGHT = 200;
    private int multBy2 = 0;
    private JPanel mathPanel;
    private JPanel buttonPanel;
    private JTextField inputField;
    private JTextField outputField;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JButton buttonDouble;


    //Default constructor
    GUIExample() {
        super("Double Your Number");
        setFrame(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        mathPanel = new JPanel();
        mathPanel.setLayout(new GridLayout(3, 2, 0, 5));

        //Create input label
        inputLabel = new JLabel("Enter Number:", JLabel.CENTER);

        //Create input field
        inputField  = new JTextField(10);

        //Add listener for input field
        inputField.addActionListener(this);

        //Create output label
        outputLabel = new JLabel("Answer:", JLabel.CENTER);

        //Create output field
        outputField  = new JTextField(10);
        outputField.setBackground(Color.lightGray);
        outputField.setEditable(false);


        //Add items to main panel
        mathPanel.add(inputLabel);
        mathPanel.add(outputLabel);
        mathPanel.add(inputField);
        mathPanel.add(outputField);
        add(mathPanel, BorderLayout.CENTER);
        //Create button and add button listener
        buttonDouble = new JButton("Double");
        buttonDouble.addActionListener(this);
        //Create button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Add button to button panel
        buttonPanel.add(buttonDouble);
        add(buttonPanel, BorderLayout.SOUTH);

        //Make GUI frame visible
        setVisible(true);

    }//End Default constructor



    @Override
    //This actionPerformed() method will perform a math action using input and output
    public void actionPerformed(ActionEvent evt) {//Begin actionPerformed method
        try {
            int input = Integer.parseInt(inputField.getText());
            multBy2 = input *2;
            inputField.setText("");
            outputField.setText(multBy2 + "");
        } catch (Exception e) {
            System.out.println("Exception: You must enter an integer!!");
            e.getMessage();
        }
    }//End actionPerformed method


    //This setFrame() method will set the GUI window size
    private void setFrame(int width, int height) {//Begin setFrame method
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//End setFrame method



    public static void main(String[] args) {//Begin main method
        //Create a GUIExample class object
        GUIExample test = new GUIExample();

    }//End main method
}//End GUIExample class
