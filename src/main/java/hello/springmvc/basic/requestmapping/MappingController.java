package hello.springmvc.basic.requestmapping;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic (){

        log.info("hellobasic");
        return "ok";
    }
    @RequestMapping(value = "/mapiing-get-v1",method = RequestMethod.GET)
    public String mappingGetV1 (){

        log.info("mappingGetV1");
        return "ok";
    }
    @GetMapping("/mapping/{userId}") //경로변수 @PathVariable
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mapping Path userId={}", data);
        return "ok";
    }
//   @GetMapping("/mapping/{userId}") //경로변수 생략 변수와 경로파라티머명과 변수이름 맞추기
//    public String mappingPath2(@PathVariable String userId){
//        log.info("mapping Path userId={}", userId);
//        return "ok";
//    }
//    @GetMapping("/mapping/users/{userId}/orders/{orderId}") //PathVariable 다중사용
//    public String mappingPath3(@PathVariable String userId, @PathVariable String orderId){
//        log.info("mapping Path userId={}, orderId ={}",  userId, orderId);
//        return "ok";
//    }
    @GetMapping(value = "/mapping-param", params = "mode-debug") //http://localhost:8080/mapping-param?mode-debug로 호출
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }
    @PostMapping(value = "/mapping-consume", consumes = "application/json") //Headers에 Content-type application/json 이여야함
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    @PostMapping(value = "/mapping-produces", produces = MediaType.TEXT_HTML_VALUE) //Headers에 Accept text/html 이여야함 ""-> MediaTy pe변경
    public String mappingProduces(){
        log.info("mappingproduces");
        return "ok";
    }
}
