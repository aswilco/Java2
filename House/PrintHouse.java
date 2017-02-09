
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;

public class PrintHouse extends JFrame implements ActionListener {

//Create all GUI elements
//Panels
private JPanel inputPanel;
private JPanel outputPanel;
private JPanel mainPanel;
private JPanel buttonPanel;

//TextArea
private JTextArea houseData;

//TextField
private JTextField squareFeet;
private JTextField windowNumber;
private JTextField houseStyle;
private JTextField houseLocation;
private JTextField houseFloors;
private JTextField houseBathrooms;
private JTextField houseBedrooms;
private JTextField houseAddress;

//CheckBox
private JCheckBox houseBasement;
private JCheckBox houseGarage;
private JCheckBox houseLaundryRoom;

//RadioButtons and group
private JRadioButton buildHouse;
private JRadioButton checkHouse;
private ButtonGroup options;

//JButtons
private JButton execute;

//Labels
private JLabel inputLabelSquareFeet;
private JLabel inputLabelHouseLocation;
private JLabel inputLabelMembersInHouse;
private JLabel inputLabelHouseGarage;
private JLabel inputLabelHouseBasement;
private JLabel inputLabelHouseBedrooms;
private JLabel inputLabelHouseBathrooms;
private JLabel inputLabelHouseFloors;
private JLabel inputLabelHouseStyle;
private JLabel inputLabel;
private JLabel outputLabel;
private JLabel inputLabelWindowNumber;
private JLabel inputLabelHouseLaundryRoom;
private JLabel inputLabelHouseAddress;

//Create new listarray of Item type house
private ArrayList<House> houses = new ArrayList<House>();

//Create boolean for checked box ofr true/false house info	
private boolean isBasement;
private boolean isGarage;
private boolean isLaundryRoom;

public static int housesInNeighborhood;
public static int membersInNeighborhood;
    public PrintHouse() {
		super("House Info");
		setFrame(500, 500);
		buttonPanel = new JPanel();
		execute = new JButton("Execute");

	    	options = new ButtonGroup();
		buildHouse = new JRadioButton("Add House");
		checkHouse = new JRadioButton("Get House Stats");
		options.add(buildHouse);
		options.add(checkHouse);
	    	buttonPanel.add(buildHouse);
		buttonPanel.add(checkHouse);
		buttonPanel.add(execute);

		inputLabelHouseAddress = new JLabel("Address");
		houseAddress = new JTextField();

		inputLabelHouseLaundryRoom = new JLabel("Laundry Room? Yes/No");
		houseLaundryRoom = new JCheckBox();

		inputLabelHouseLocation = new JLabel("Location");
		houseLocation = new JTextField();

		inputLabelHouseGarage = new JLabel("Garage? Yes/No");
		houseGarage = new JCheckBox();

		inputLabelHouseBasement = new JLabel("Basement? Yes/No");
		houseBasement = new JCheckBox();

		inputLabelHouseBedrooms = new JLabel("How many Bedrooms?");
		houseBedrooms = new JTextField();

		inputLabelHouseBathrooms = new JLabel("How many Bathrooms?");
		houseBathrooms = new JTextField();

		inputLabelHouseFloors = new JLabel("How many Floors?");
		houseFloors = new JTextField();

		inputLabelHouseStyle = new JLabel("Style of House?");
		houseStyle = new JTextField();

		inputLabelWindowNumber = new JLabel("How many Windows?");
		windowNumber = new JTextField();

		inputLabelSquareFeet = new JLabel("Square Feet");
		squareFeet = new JTextField(5);

		houseData = new JTextArea();
		houseData.setLineWrap(true);
		houseData.setWrapStyleWord(true);
		houseData.setSize(300, 100);

		houseData.setBackground(Color.lightGray);
		houseData.setEditable(false);

		execute.addActionListener(this);
		outputPanel = new JPanel();
		outputLabel = new JLabel("House Info");
		outputPanel.add(outputLabel);
		outputPanel.add(houseData);
	    
		inputPanel = new JPanel();
	    
		mainPanel = new JPanel();
	    
		add(mainPanel);
		mainPanel.add(inputPanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(outputPanel);
		mainPanel.setLayout(new FlowLayout());
		inputLabel = new JLabel();

		inputPanel.setLayout(new GridLayout(0, 2));
		inputPanel.add(inputLabelHouseAddress);
		inputPanel.add(houseAddress);
		inputPanel.add(inputLabelHouseLocation);
		inputPanel.add(houseLocation);
		inputPanel.add(inputLabelSquareFeet);
		inputPanel.add(squareFeet);
		inputPanel.add(inputLabelHouseFloors);
		inputPanel.add(houseFloors);
		inputPanel.add(inputLabelHouseBedrooms);
		inputPanel.add(houseBedrooms);
		inputPanel.add(inputLabelHouseBathrooms);
		inputPanel.add(houseBathrooms);
		inputPanel.add(inputLabelHouseStyle);
		inputPanel.add(houseStyle);
		inputPanel.add(inputLabelWindowNumber);
		inputPanel.add(windowNumber);

		inputPanel.add(inputLabelHouseBasement);
		inputPanel.add(houseBasement);
		inputPanel.add(inputLabelHouseGarage);
		inputPanel.add(houseGarage);
		inputPanel.add(inputLabelHouseLaundryRoom);
		inputPanel.add(houseLaundryRoom);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent evt) {
		int x = 0;
		if (buildHouse.isSelected()) {
			if (houseBasement.isSelected()) {
				isBasement = true;
				}
			if(houseGarage.isSelected()) {
				isGarage = true;
			}
			if (houseLaundryRoom.isSelected()) {
				isLaundryRoom = true;
			}
			houses.add (new House(houseAddress.getText(), Integer.parseInt(squareFeet.getText()), Integer.parseInt(windowNumber.getText()),
			houseLocation.getText(), Integer.parseInt(houseBedrooms.getText()), Integer.parseInt(houseFloors.getText()),
			Integer.parseInt(houseBathrooms.getText()), houseStyle.getText(), isBasement, isGarage,
			isLaundryRoom));
			squareFeet.setText(" ");
			windowNumber.setText(" ");
			houseLocation.setText(" ");
			houseBedrooms.setText(" ");
			houseFloors.setText(" ");
			houseBathrooms.setText(" ");
			houseStyle.setText(" ");
			houseBasement.setText(" ");
			houseGarage.setText(" ");
			houseLaundryRoom.setText(" ");
			houseData.setText(houses.get(houses.size()-1).toString());
			houseData.revalidate();
			outputPanel.repaint();
			outputPanel.revalidate();
		}
		else if (checkHouse.isSelected()) {
			String search = houseAddress.getText();
			int searchListLength = houses.size();
			for (int i = 0; i < searchListLength; i++) {
				if (houses.get(i).getAddress().contains(search)) {
					houseData.setText(houses.get(i).toString());
				}
			}
		}
	}

    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Visible() {
        setVisible(true);
    }


    public static void main(String[] args) {

        String addLaundryRoom;


		PrintHouse house = new PrintHouse();
		house.Visible();
		house.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}
}





