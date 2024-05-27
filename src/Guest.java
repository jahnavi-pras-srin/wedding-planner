import java.util.Date;

public class Guest {
    public String name;
    public Date dateOfArrival;
    public String phone;
    public String address;
    public Date dateOfLeaving;
    public int partyOf;

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", dateOfArrival=" + dateOfArrival +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dateOfLeaving=" + dateOfLeaving +
                ", partyOf=" + partyOf +
                '}';
    }
}