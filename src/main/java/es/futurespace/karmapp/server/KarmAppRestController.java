package es.futurespace.karmapp.server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import es.futurespace.karmapp.domain.RegisterRequest;
import es.futurespace.karmapp.util.UsersUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class KarmAppRestController {
    private UsersUtil usersUtil = new UsersUtil();

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


}
