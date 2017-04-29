package securoserve.requests;

import securoserve.api.enums.BuildingType;
import securoserve.api.interfaces.ConfirmationMessage;
import securoserve.api.interfaces.ICalamity;
import securoserve.library.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guillaimejanssen on 29/04/2017.
 */
public class CalamityRequestTest implements ICalamity {

    Location l = new Location(3.6f, 3.6f, 3.6f);
    Date date = new Date(System.currentTimeMillis());

    Building building_1 = new Building(1, l, BuildingType.FIRE_DEPARTMENT, "Brandweer Kazerne Eindhoven");
    Building building_2 = new Building(2, l, BuildingType.HOSPITAL, "Ziekenhuis Eindhoven");

    User henk = new User(1, null, null, building_1, "Henk", "henkdeman@gmail.com", "Eindhoven", "abcdefghijklmnop");

    Calamity calamity_1 = new Calamity(1, l, henk, true, false, date, "Aanslag TU Eindhoven", "In het Hoofdgebouw van de TU in eindhoven zijn bommen ontploft. Het gaat om een spijkerbom. Veel gewonden waarbij waarschijnlijk ook doden. Dit is nog niet bevestigd.");

    User piet = new User(2, null, calamity_1, building_2, "Piet", "pietertje007@gmail.com", "Helmond", "xyzdoenooknogmee");

    @Override
    public List<Calamity> allCalamity() {
        List<Calamity> calamities = new ArrayList<>();
        calamities.add(calamity_1);
        return calamities;
    }

    @Override
    public Calamity calamityById(String token, int id) {
        return null;
    }

    @Override
    public ConfirmationMessage addCalamity(String token, String title, String message, Location location, boolean isConfirmed, boolean isClosed) {
        return null;
    }

    @Override
    public ConfirmationMessage updateCalamity(String token, int id, String name, String description, Location location, boolean isConfirmed, boolean isClosed) {
        return null;
    }

    @Override
    public ConfirmationMessage deleteCalamity(String token, int id) {
        return null;
    }

    @Override
    public ConfirmationMessage addCalamityAssignee(String token, int calamityId, int userId) {
        return null;
    }

    @Override
    public ConfirmationMessage deleteCalamityAssignee(String token, int calamityId, int userId) {
        return null;
    }
}
