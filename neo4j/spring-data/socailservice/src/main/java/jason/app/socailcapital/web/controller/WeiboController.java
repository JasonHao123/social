package jason.app.socailcapital.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.SinaWeiboApi20;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weibo/")
public class WeiboController {
    private static final Token EMPTY_TOKEN = null;
    String apiKey = "4042557792";
    String apiSecret = "2cd52a9a7c36f9dcdb25236dc45d381a";
    
    private static final String PROTECTED_RESOURCE_URL = "https://api.weibo.com/2/account/get_uid.json";
    OAuthService service = new ServiceBuilder()
    .provider(SinaWeiboApi20.class)
    .apiKey(apiKey)
    .apiSecret(apiSecret)
    .callback("http://socialcapital.sinaapp.com:8080/socailcapital/spring/weibo/callback")
    .build();

    @RequestMapping(method=RequestMethod.GET,value="auth")
    public void authWeibo(HttpServletRequest request,HttpServletResponse resp) throws IOException {
       
       
        String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
        resp.sendRedirect(authorizationUrl);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="callback")
    public String authWeiboCallback(HttpServletRequest req,HttpServletResponse resp,@RequestParam("code") String code) throws IOException {
        Verifier verifier = new Verifier(code);
        System.out.println();

        // Trade the Request Token and Verifier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();
        
     // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println("Got it! Lets see what we found...");
        System.out.println();
        System.out.println(response.getCode());
        System.out.println(response.getBody());

        System.out.println();
        System.out.println("Thats it man! Go and build something awesome with Scribe! :)");

        return "redirect:/";
    }
    
    
}
