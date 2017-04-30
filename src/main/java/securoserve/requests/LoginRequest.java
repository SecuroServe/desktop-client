package securoserve.requests;

import org.springframework.web.client.RestTemplate;
import securoserve.api.interfaces.ConfirmationMessage;
import securoserve.api.interfaces.ILogin;

/**
 * Created by guillaimejanssen on 30/04/2017.
 */
public class LoginRequest implements ILogin {

    private static final String REQUEST_PREFIX = "http://localhost:8080";

    private static final String LOGIN = "/login?username={username}&password={password}";

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public ConfirmationMessage login(String username, String password) {
        return restTemplate.getForObject(REQUEST_PREFIX + LOGIN, ConfirmationMessage.class, username, password);
    }
}
