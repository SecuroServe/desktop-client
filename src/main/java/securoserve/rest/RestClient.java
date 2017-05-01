package securoserve.rest;

import com.google.gson.Gson;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import securoserve.api.interfaces.ConfirmationMessage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class RestClient {

    private RestTemplate rest;

    public RestClient() {
        this.rest = new RestTemplate();
    }

    public ConfirmationMessage request(String baseUrl, RequestType requestType, MultiValueMap<String, Object> parameters) {
        switch (requestType) {
            case POST:

                return post(baseUrl, parameters);

            case GET:
                return get(generateUrl(baseUrl, parameters));

            case PUT:
                return put(baseUrl, generateParameterJSON(parameters));

            case DELETE:
                return delete(baseUrl, generateParameterJSON(parameters));

            default:
                return new ConfirmationMessage(ConfirmationMessage.StatusType.ERROR, "Request error.", null);
        }
    }

    public String generateParameterJSON(MultiValueMap<String, Object> parameters) {
        return new Gson().toJson(parameters);
    }

    public String generateUrl(String baseUrl, MultiValueMap<String, Object> parameters) {

        StringBuilder sb = new StringBuilder();
        sb.append(baseUrl).append("?");

        parameters.forEach((k, v) -> {
            sb.append(k).append("=").append(v.get(0)).append("&");
        });

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    public ConfirmationMessage get(String uri) {
        return rest.getForObject(uri, ConfirmationMessage.class);
    }

    public ConfirmationMessage post(String uri, MultiValueMap<String, Object> parameters) {
        return rest.postForObject(uri, parameters, ConfirmationMessage.class);
    }

    public ConfirmationMessage put(String uri, String json) {
        throw new NotImplementedException();
    }

    public ConfirmationMessage delete(String uri, String json) {
        throw new NotImplementedException();
    }

    public enum RequestType {
        POST,
        GET,
        PUT,
        DELETE
    }
}