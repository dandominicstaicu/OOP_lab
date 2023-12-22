package lab09.builder;
import java.util.ArrayList;

class House {

    // TODO: write optional and mandatory facilities to have in a house
    private String location;
    private int numFloors;
    private int numRooms;
    private boolean pool;
    private String securityCompany;
    private boolean appliances;
    private boolean solarPanels;


    // TODO: complete the private constructor
    private House(HouseBuilder builder) {
        location = builder.location;
        numFloors = builder.numFloors;
        numRooms = builder.numRooms;
        pool = builder.pool;
        securityCompany = builder.securityCompany;
        appliances = builder.appliances;
        solarPanels = builder.solarPanels;
    }

    static class HouseBuilder {

        private String location;
        private int numFloors;
        private int numRooms;
        private boolean pool;
        private String securityCompany;
        private boolean appliances;
        private boolean solarPanels;


        // TODO: complete the house builder constructor only with the mandatory facilities
        public HouseBuilder(final String location, final int numFloors, final int numRooms) {
            this.location = location;
            this.numFloors = numFloors;
            this.numRooms = numRooms;
        }

        // TODO: add the optional facilities in a builder design
        public HouseBuilder pool(final boolean pool) {
            this.pool = pool;
            return this;
        }

        public HouseBuilder securityCompany(final String securityCompany) {
            this.securityCompany = securityCompany;
            return this;
        }

        public HouseBuilder appliances(final boolean appliances) {
            this.appliances = appliances;
            return this;
        }

        public HouseBuilder solarPanels(final boolean solarPanels) {
            this.solarPanels = solarPanels;
            return this;
        }

        public House build() {
            return new House(this);
        }

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public String getSecurityCompany() {
        return securityCompany;
    }

    public void setSecurityCompany(String securityCompany) {
        this.securityCompany = securityCompany;
    }

    public boolean isAppliances() {
        return appliances;
    }

    public void setAppliances(boolean appliances) {
        this.appliances = appliances;
    }

    public boolean isSolarPanels() {
        return solarPanels;
    }

    public void setSolarPanels(boolean solarPanels) {
        this.solarPanels = solarPanels;
    }

    @Override
    public String toString() {
        return "location : "  + location + "\n" +
                "number of floors : " + numFloors + "\n" +
                "number of rooms : " + numRooms + "\n" +
                "pool : " + pool + "\n" +
                "security company: " + securityCompany + "\n" +
                "appliances : " + appliances + "\n" +
                "solar panels : " + solarPanels + "\n";
    }
}

class Main {
    private static String spacerSymbols = new String(new char[40]).replace("\0", "-");

    public static void main(String[] args) {
        String spacerSymbols = new String(new char[40]).replace("\0", "-");

        House house = new House.HouseBuilder("Piata Unirii", 3, 10)
                .pool(true)
                .securityCompany("POO_Security")
                .build();

        printOutputSpacerFor("testHouse");
        testHouse(house);
    }

    private static void printOutputSpacerFor(String test) {
        System.out.println(spacerSymbols + test + spacerSymbols);
    }

    private static void testHouse(House house) {
        System.out.println(house.getLocation());
        System.out.println(house.getNumFloors());
        System.out.println(house.getNumRooms());
        System.out.println(house.isPool());
        System.out.println(house.getSecurityCompany());
        System.out.println(house.isAppliances());
        System.out.println(house.isSolarPanels());
    }
}