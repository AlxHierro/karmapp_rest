package es.futurespace.karmapp.server;

import location.indataDN;
import location.karmapp_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.futurespace.karmapp.domain.RegisterRequest;
import es.futurespace.karmapp.util.UsersUtil;


@RestController
@RequestMapping("/api")
public class KarmAppRestController {
    private UsersUtil usersUtil = new UsersUtil();

    @Autowired
    private EventManager e;
    
    @RequestMapping(value = "/register", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity greeting(@RequestParam(value="mail") String mail,@RequestBody RegisterRequest request) {
        String result;
        //TODO: comprobar si existe usuario
        result = usersUtil.saveUser(mail,request);

        BodyBuilder responseBodyBuilder;
        if (result.compareToIgnoreCase("ok")==0){
            responseBodyBuilder = ResponseEntity.ok();
            responseBodyBuilder.contentType(MediaType.TEXT_HTML);
            return responseBodyBuilder.body("ok!");

        }else{
            responseBodyBuilder = ResponseEntity.status(500);
            responseBodyBuilder.contentType(MediaType.TEXT_HTML);
            return responseBodyBuilder.body("error");
        }

    }


    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public ResponseEntity isRegistered(@RequestParam(value="mail") String mail) throws Exception {
        BodyBuilder responseBodyBuilder;

        if (usersUtil.isRegistered(mail)){
            responseBodyBuilder = ResponseEntity.ok();
            responseBodyBuilder.contentType(MediaType.TEXT_HTML);
            return responseBodyBuilder.body("ok!");

        }else{
            responseBodyBuilder = ResponseEntity.status(500);
            responseBodyBuilder.contentType(MediaType.TEXT_HTML);
            return responseBodyBuilder.body("error");
        }
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public karmapp_data process(@RequestBody indataDN data) {
    	return e.getLocationManager().execute(data);
    }
}
