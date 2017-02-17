import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.io.*;

public class Compute extends JFrame {

  static JFrame frame;

  private JPanel contentPane;
  private JPanel methodPanel;
  private JPanel inputPanel;
  private JPanel buttonPanel;
  private JPanel outputPanel;

  private JLabel nLabel;
  private JTextField n;
  private JLabel resultLabel;
  private JTextField result;
  private JLabel efficiencyLabel;
  private JTextField efficiency;

  private JButton compute;

  private JRadioButton iterative;
  private JRadioButton recursive;
  private ButtonGroup method;
  
  private BufferedWriter fileOutput;
  
  private int i;
  
  private WindowListener adapter;
  
  private String answer;

	public void setVisible() {
		setVisible(true);
	}
	
private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


  public Compute() {
     
    
    frame = new JFrame("Iterative vs Recursive");
    frame.setSize(300,300);
	frame.setLocationRelativeTo(null);
	contentPane = new JPanel();
	methodPanel = new JPanel();
	inputPanel = new JPanel();
	buttonPanel = new JPanel();
	outputPanel = new JPanel();
	
	nLabel = new JLabel("Enter an Integer:");
    n = new JTextField();
    n.setColumns(10);
    inputPanel.add(nLabel);
    inputPanel.add(n);
    
    resultLabel = new JLabel("Result is:");
    result = new JTextField();
    result.setEditable(false);
    result.setBackground(Color.lightGray);
    result.setColumns(15);
    efficiencyLabel = new JLabel("Efficiency of Operation:");
    efficiency = new JTextField();
    efficiency.setEditable(false);
    efficiency.setBackground(Color.lightGray);
    efficiency.setColumns(15);
    outputPanel.add(resultLabel);
    outputPanel.add(result);
    outputPanel.add(efficiencyLabel);
    outputPanel.add(efficiency);
    outputPanel.setLayout(new GridLayout(0, 1));

    iterative = new JRadioButton("Iterative Method");
    recursive = new JRadioButton("Recursive Method");
    method = new ButtonGroup();
    methodPanel.add(iterative);
    methodPanel.add(recursive);

    method.add(iterative);
    method.add(recursive);

      compute = new JButton( new AbstractAction("Compute") {
       public void actionPerformed(ActionEvent e) {
		 Sequence.efficiency = 0;
         if (iterative.isSelected()) {
			 answer = String.valueOf(Sequence.computeIterative(Integer.parseInt(n.getText())));
			 result.setText(answer);
         }
         else if (recursive.isSelected()) {
			 Sequence.computeRecursive(Integer.parseInt(n.getText()));
			 answer = String.valueOf(Sequence.computeRecursive(Integer.parseInt(n.getText())));
			 result.setText(answer);
         }
   			 efficiency.setText(String.valueOf(Sequence.GetEfficiency()));

	 }
		});
		
		buttonPanel.add(compute);
		
 contentPane.add(methodPanel);
 contentPane.add(inputPanel);
 contentPane.add(buttonPanel);
 contentPane.add(outputPanel);
frame.add(contentPane);
 
	frame.getContentPane();
	frame.setVisible(true);

	frame.addWindowListener(new WindowAdapter () {
		public void windowClosing(WindowEvent e) {
		System.out.println("Please Wait...Calculating Effiiency");
		File file = new File("Efficiency.csv");
		try {
				fileOutput = new BufferedWriter(new FileWriter("Efficiency.csv"));
			}
			catch (IOException v) {
				System.out.println("File Does Not Exist");
			}
		
		for (i=0; i <= 10; i++){
			try {
			Sequence.computeIterative(i);
			fileOutput.write(String.valueOf(i));
			fileOutput.write( "," );
			fileOutput.write(String.valueOf(Sequence.GetEfficiency()));
			fileOutput.write( ",");
			Sequence.computeRecursive(i);
			fileOutput.write(String.valueOf(Sequence.GetEfficiency()));
			fileOutput.newLine();
			fileOutput.flush();

			}
		catch (IOException c) {
			System.out.println("File Does Not Exist");
		}
		}
		System.out.println("Closing");
		System.exit(0);		
	}
});
	
	
   
}
public static void main(String[] args) {

        Compute computer = new Compute();
        computer.setVisible();
        //computer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


