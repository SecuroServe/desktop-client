package securoserve.requests;

import api.ConfirmationMessage;
import api.ICalamity;
import library.Calamity;
import library.Location;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.InputStream;
import java.util.List;

/**
 * Created by guillaimejanssen on 03/04/2017.
 */
public class CalamityRequest implements ICalamity {

    HttpPost post;

    public CalamityRequest(){
        post = new HttpPost("http://localhost:8080");
    }

    @Override
    public List<Calamity> allCalamity() {
        return null;
    }

    @Override
    public Calamity calamityById(@RequestParam("token") String s, @RequestParam("id") int i) {
        return null;
    }

    @Override
    public ConfirmationMessage addCalamity(@RequestParam("token") String s, @RequestParam("name") String s1, @RequestParam("description") String s2, @RequestParam("location") Location location) {
        return null;
    }

    @Override
    public ConfirmationMessage updateCalamity(@RequestParam("token") String s, @RequestParam("id") int i, @RequestParam("name") String s1, @RequestParam("description") String s2, @RequestParam("location") Location location) {
        return null;
    }
}
