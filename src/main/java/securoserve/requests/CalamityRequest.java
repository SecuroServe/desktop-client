package securoserve.requests;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import securoserve.api.interfaces.ConfirmationMessage;
import securoserve.api.interfaces.ICalamity;
import securoserve.library.Calamity;
import securoserve.library.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guillaimejanssen on 03/04/2017.
 */
public class CalamityRequest implements ICalamity {

    private static final String REQUEST_PREFIX = "http://localhost:8080";

    private static final String GET_ALL = "/allcalamities";
    private static final String GET_CALAMITY_BY_ID = "/calamitybyid?token={token}&id={id}";

    private static final String POST_ADD_CALAMITY_ASSIGNEE = "/addcalamityassignee?token={token}&" +
            "calamityid={calamityid}&" +
            "userid={userid}";
    private static final String POST_ADD_CALAMITY = "/addcalamity?token={token}&" +
            "title={title}&" +
            "message={message}&" +
            "location={location}&" +
            "confirmed={confirmed}&" +
            "closed={closed}";

    private static final String UPDATE_CALAMITY = "/updatecalamity?token={token}&" +
            "id={id}&" +
            "name={name}&" +
            "description={description}&" +
            "location={location}";

    private static final String DELETE_CALAMITY = "/deletecalamity?token={token}&id={id}";
    private static final String DELETE_CALAMITY_ASSIGNEE = "/deletecalamityassignee?token={token}&" +
            "calamityid={calamityid}&" +
            "userid={userid}";

    RestTemplate restTemplate;

    public CalamityRequest() {
        restTemplate = new RestTemplate();
    }

    @Override
    public List<Calamity> allCalamity() {
        Calamity[] calamities = restTemplate.getForObject(REQUEST_PREFIX + GET_ALL, Calamity[].class);
        List<Calamity> returnValue = new ArrayList<>();

        for (Calamity c : calamities) {
            returnValue.add(c);
        }

        return returnValue;
    }

    @Override
    public Calamity calamityById(@RequestParam("token") String token, @RequestParam("id") int id) {
        return restTemplate.getForObject(REQUEST_PREFIX + GET_CALAMITY_BY_ID, Calamity.class, token, id);
    }

    @Override
    public ConfirmationMessage addCalamity(String s, String s1, String s2, Location location, boolean b, boolean b1) {
        return null;
    }

    @Override
    public ConfirmationMessage updateCalamity(String token, int id, String name, String description, Location location, boolean isConfirmed, boolean isClosed) {
        return null;
    }

    @Override
    public ConfirmationMessage deleteCalamity(String s, int i) {
        return null;
    }

    @Override
    public ConfirmationMessage addCalamityAssignee(String s, int i, int i1) {
        return null;
    }

    @Override
    public ConfirmationMessage deleteCalamityAssignee(String s, int i, int i1) {
        return null;
    }
}
