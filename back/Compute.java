import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.*;

public class Compute extends JFrame {

  static JFrame frame;

  private JPanel mainPanel;

  private JTextField n;
  private JTextField result;
  private JTextField efficiency;

  private JButton compute;

  private JRadioButton iterative;
  private JRadioButton recursive;
  private ButtonGroup method;
  
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
    super("Project 3");
    setFrame(300, 500);

	mainPanel = new JPanel();

    n = new JTextField("Enter an Integer:n");

    result = new JTextField("Result is:");
    result.setEditable(false);
    result.setBackground(Color.lightGray);
    efficiency = new JTextField("Efficiency of Operation:");
    efficiency.setEditable(false);
    efficiency.setBackground(Color.lightGray);

    iterative = new JRadioButton("Iterative Method");
    recursive = new JRadioButton("Recursive Method");
    method = new ButtonGroup();

    method.add(iterative);
    method.add(recursive);

      compute = new JButton( new AbstractAction("Compute") {
       public void actionPerformed(ActionEvent e) {
         if (iterative.isSelected()) {
			 answer = String.valueOf(Sequence.computeIterative(Integer.parseInt(n.getText())));
			 result.setText(answer);
         }
         else if (recursive.isSelected()) {
			 Sequence.computeRecursive(Integer.parseInt(n.getText()));
			 answer = String.valueOf(Sequence.computeRecursive(Integer.parseInt(n.getText())));
			 result.setText(answer);

         }
	 }
 });

    mainPanel.add(iterative);
    mainPanel.add(recursive);
    mainPanel.add(n);
    mainPanel.add(compute);
    mainPanel.add(result);
    mainPanel.add(efficiency);
    add(mainPanel);
}
public static void main(String[] args) {

        Compute computer = new Compute();
        computer.setVisible();
        computer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


