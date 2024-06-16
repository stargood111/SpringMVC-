package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void reqeustParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age ={}",username,age);

        response.getWriter().write("ok");
    }
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge)
    {
        log.info("username={}, age ={}",memberName,memberAge);
        return"ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV3(String username, int age) //Form name과 맞춰야함 @RequestParam이 없을 겨우 과한 생략의 느낌이 있음
    {
        log.info("username={}, age ={}",username,age);
        return"ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //required 기본 true
            @RequestParam(required = false) Integer age) //파라미터 필수
    {
        log.info("username={}, age ={}",username,age);
        return"ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, //파라미터가 없을 경우 기본 값 설정
                @RequestParam(required = false, defaultValue = "-1") int age) //파라미터가 없을 경우 기본 값 설정
    {
        log.info("username={}, age ={}",username,age);
        return"ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String,Object> paramMap) {
        log.info("username={}, age ={}",paramMap.get("username"),paramMap.get("age"));
        return"ok";
    }
    @RequestMapping("/request-param-map2")
    public String requestParamMultiValueMap(@RequestParam MultiValueMap<String,Object> paramMap) {

        log.info("username={}, age ={}",paramMap.get("username"),paramMap.get("age"));
        return"ok";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age ={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {//        ModelAttribute 생략
//        String, int, Integer 같은 단순 타입 = @RequestParam 으로 mapping
//        나머지 arument resolver 같이 지정타입은 @ModelAttribute 으로 mapping
        log.info("username={}, age ={}",helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}

