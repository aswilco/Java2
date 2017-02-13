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
  
  
  public Compute() {
    super("Project 3");
    setFrame(300, 500);
    
    n = new JTextField("Enter an Integer:n");
    
    result = new JTextField("Result is:");
    efficiency = new JTextField("Efficiency of Operation:");
    
    iterative = new JRadioButton("Iterative Method");
    recursive = new JRadioButton("Recursive Method");
    
    method.add(iterative);
    method.add(recursive);
    
      compute = new JButton( new AbstractAction("Compute") {
       public void actionPerformed(ActionEvent e) {
         n = Integer.parseInt(n.getText());
         if (iterative.isSelected()) {
          result.setText(computeIterative(n)); 
         }
         else if (recursive.isSelected()) {
           result.setText(computeRecursive(n));
         }
         

}
