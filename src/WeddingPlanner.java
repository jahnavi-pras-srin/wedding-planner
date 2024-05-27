import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

public class WeddingPlanner {

    public void manageGuests() {
    }

    //name, dateOfArrival, phone, address, dateOfLeaving, partyOf
    public List<Guest> readGuestsFromFile() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader("/tmp/guest-list.csv")).build();
        String [] nextLine;
        List<Guest> guests = new ArrayList<>();
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            Guest guest = new Guest();
            guest.name = nextLine[0];
            guest.dateOfArrival = Date.from(Instant.parse(nextLine[1]));
            guest.phone = nextLine[2];
            guest.address = nextLine[3];
            guest.dateOfLeaving = Date.from(Instant.parse(nextLine[4]));
            guest.partyOf = Integer.parseInt(nextLine[5]);
            guests.add(guest);
        }

        return guests;
    }


    //name, address, phone, check-in-time, check-out-time, occupancy => number of rooms 1:5#2:10
    public List<Hotel> readHotelsFromFile() throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader("/tmp/hotel-list.csv")).build();
        String [] nextLine;
        List<Hotel> hotels = new ArrayList<>();
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            Hotel hotel = new Hotel();
            hotel.name = nextLine[0];
            hotel.address = nextLine[1];
            hotel.phone = nextLine[2];
            hotel.checkInTime = Date.from(Instant.parse(nextLine[3]));
            hotel.checkOutTime = Date.from(Instant.parse(nextLine[4]));

            String occupancyNumberOfRooms = nextLine[5];
            String[] available = occupancyNumberOfRooms.split("#");

            TreeMap<Integer, Integer> countOfRoomsByOccupancy = new TreeMap<>();
            for (String roomConfig: available) {
                countOfRoomsByOccupancy.put(
                        Integer.parseInt(roomConfig.split(":")[0]),
                        Integer.parseInt(roomConfig.split(":")[1]));
            }
            hotel.countOfRoomsByOccupancy = countOfRoomsByOccupancy;
            hotels.add(hotel);
        }

        return hotels;
    }

    public void allocateGuestsToHotels() {

    }
}