package securoserve.requests;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import securoserve.api.interfaces.ConfirmationMessage;
import securoserve.api.interfaces.ICalamity;
import securoserve.library.Calamity;
import securoserve.library.Location;
import securoserve.rest.RestClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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
    RestClient restClient;

    public CalamityRequest(){
        restTemplate = new RestTemplate();
        restClient = new RestClient();
    }

    @Override
    public ConfirmationMessage allCalamity() {
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        return restClient.request(REQUEST_PREFIX + GET_ALL, RestClient.RequestType.GET, parameters);
    }

    @Override
    public ConfirmationMessage calamityById(@RequestParam("token") String token, @RequestParam("id") int id) {
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("token", token);
        parameters.add("id", id);
        return restClient.request(REQUEST_PREFIX + GET_CALAMITY_BY_ID, RestClient.RequestType.GET, parameters);
    }

    @Override
    public ConfirmationMessage addCalamity(String s, String s1, String s2,
                                           double latitude,
                                           double longitude,
                                           double radius , boolean b, boolean b1) {
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
