package CustomProjects.CarRentalApplication;

public class Reservation {
    String companyName;
    int numDays;
    int numWeeks;
    int numMonths;

    public Reservation(String compName, int nDays, int nWeeks, int nMonths) {
        companyName = compName;
        numDays = nDays;
        numWeeks = nWeeks;
        numMonths = nMonths;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getNumDays() {
        return numDays;
    }

    public int getNumWeeks() {
        return numWeeks;
    }

    public int getNumMonths() {
        return numMonths;
    }
}
