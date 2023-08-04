package CustomProjects.CarRentalApplication;

public class Vehicle {
    //MPG = miles per gallon
    // VIN = vehicle identification number

    int Vin;
    int MilePG;
    String Make;
    String Model;
    Reservation reserve;



    public Vehicle(int mpg, String make, String model) {
        MilePG = mpg;
        Make = make;
        Model = model;
        reserve = null;
    }

    public int getVin() {
        return Vin;
    }

    public int getMilePG() {
        return MilePG;
    }

    public String getMake() {
        return Make;
    }


    public String getModel() {
        return Model;
    }


    public void createReservation(String CompName, int numDays, int numWeeks, int numMonths){
        reserve = new Reservation(CompName,numDays, numWeeks, numMonths);
    }

    public boolean isReserved(Vehicle[] vehicles, Reservation[] reserve){
        return !(reserve == null);
    }

    public String toString(){
        if (reserve == null){
            return getMake() + " " + getModel() + " " + getVin() + "Is not reserved";}
        else{
            return getMake() + " " + getModel() + " " + getVin() + "Is reserved";}
    }

}

