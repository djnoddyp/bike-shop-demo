package pnodder.repositories;

import org.springframework.stereotype.Repository;
import pnodder.model.Resident;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ResidentRepository {

    private Map<Integer, Resident> residentMap = new HashMap<>();

    {
        Resident resident1 = new Resident();
        resident1.setName("Ricky");
        resident1.setAddress("1 Bonneview");

        Resident resident2 = new Resident();
        resident2.setName("Julian");
        resident2.setAddress("14 Dartmouth");

        Resident resident3 = new Resident();
        resident3.setName("Ray");
        resident3.setAddress("The dump");

        residentMap.put(111, resident1);
        residentMap.put(112, resident2);
        residentMap.put(113, resident3);
    }

    public String getResidentNameById(Integer id) {
        return residentMap.get(id).getName();
    }

    public void saveResident(Resident resident) {
        residentMap.put(114, resident);
    }

}
