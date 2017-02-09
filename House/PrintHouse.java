
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.util.ArrayList;

public class PrintHouse extends JFrame implements ActionListener {

private JPanel inputPanel;
private JPanel outputPanel;
private JPanel mainPanel;
private JPanel buttonPanel;

private JTextArea houseData;

private JTextField squareFeet;
private JTextField windowNumber;
private JTextField houseStyle;
private JTextField houseLocation;
private JTextField houseFloors;
private JTextField houseBathrooms;
private JTextField houseBedrooms;
private JTextField houseAddress;

private JCheckBox houseBasement;
private JCheckBox houseGarage;
private JCheckBox houseLaundryRoom;

private JRadioButton buildHouse;
private JRadioButton checkHouse;
private ButtonGroup options;


private JButton execute;
private JButton exit;

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

private ArrayList<House> houses = new ArrayList<House>();

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

		exit = new JButton( new AbstractAction("close") {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});

		options = new ButtonGroup();

		buildHouse = new JRadioButton("Add House");
		checkHouse = new JRadioButton("Get House Stats");
		options.add(buildHouse);
		options.add(checkHouse);

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

		buttonPanel.add(buildHouse);
		buttonPanel.add(checkHouse);
		buttonPanel.add(execute);
		buttonPanel.add(exit);
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





