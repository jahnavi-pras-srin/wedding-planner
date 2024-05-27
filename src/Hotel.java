import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Hotel {
    public String name;
    public String address;
    public String phone;
    public Date checkInTime;
    public Date checkOutTime;
    public TreeMap<Integer, Integer> countOfRoomsByOccupancy;

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", countOfRoomsByOccupancy=" + countOfRoomsByOccupancy +
                '}';
    }
}