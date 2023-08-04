package CustomProjects.CarRentalApplication;

public class Car extends Vehicle{
    double DailyCost;
    double WeeklyCost;
    double MonthlyCost;
    int NumSeats;

    public Car(int mpg, String make, String model, int numSeats) {
        super(mpg, make, model);
        NumSeats = numSeats;
    }

    public double getDailyCost() {
        return DailyCost;
    }

    public double getWeeklyCost() {
        return WeeklyCost;
    }

    public double getMonthlyCost() {
        return MonthlyCost;
    }

    public int getNumSeats() {
        return NumSeats;
    }

    public void setDailyCost(double dailyCost) {
        DailyCost = 24.95;
    }

    public void setWeeklyCost(double weeklyCost) {
        WeeklyCost = 149.95;
    }

    public void setMonthlyCost(double monthlyCost) {
        MonthlyCost = 514.95;
    }

    public void setNumSeats(int numSeats) {
        NumSeats = numSeats;
    }
}
