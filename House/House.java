import java.io.IOException;

public class House extends Building{

    /*Declare House Variables*/
    private int bedrooms;
    private int floors;
    public int houseMembers;

    private double bathrooms;

    private String style;
    private String address;

    private boolean basement;
    private boolean garage;
    private boolean laundryRoom;

    //Default No argument Constructor
    public House() {
		super();
        bedrooms = 2;
        floors = 1;
        bathrooms = 1.5;
        style = "rancher";
        basement = false;
        garage = false;
        laundryRoom = false;
        houseMembers = 1;

    }

    public House(String address, int squareFeet, int numWindows, String location, int bedrooms, int floors, double bathrooms,
            String style, boolean basement, boolean garage, boolean laundryRoom) {
		super(squareFeet, numWindows, location);
        this.bedrooms = bedrooms;
        this.floors = floors;
        this.bathrooms = bathrooms;
        this.style = style;
        this.basement = basement;
        this.garage = garage;
        this.laundryRoom = laundryRoom;
        this.houseMembers = houseMembers;
        this.address = address;
        PrintHouse.membersInNeighborhood = this.houseMembers + PrintHouse.membersInNeighborhood;
        ++PrintHouse.housesInNeighborhood;

    }


    /*toString Methog*/
    public String toString() {
        return "Address:" + address
				+ ", Location:" + super.location
                + ", Bedrooms:" + bedrooms
                + ", Floors:" + floors
                + ", Bathrooms:" + bathrooms
                + ", Style:" + style
                + ", Basement:" + basement
                + ", Garage:" + garage
                + ", Laundry Room:" + laundryRoom;
    }

    void newLaundryRoom(String addLaundryRoom) throws IOException{
            if (addLaundryRoom.equalsIgnoreCase("yes")) {
            laundryRoom = true;
		}
            else if (addLaundryRoom.equalsIgnoreCase("no")) {
            laundryRoom = false;
		}
            else {
				throw new IOException();
			}
        }

    public String getAddress() {
		return address;
		}
	}



