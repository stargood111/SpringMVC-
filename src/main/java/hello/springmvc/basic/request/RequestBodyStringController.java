package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-bodty-string-v1")
    public void requestBodtSring(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messagebody={}", messageBody);
        response.getWriter().write(("ok"));
    }
    @PostMapping("/request-bodty-string-v2")
    public void requestBodtSringV2(InputStream inputStream, Writer responseWriter) throws  IOException{

        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messagebody={}", messageBody);
        responseWriter.write(("ok"));
    }
    @PostMapping("/request-bodty-string-v3")
    public HttpEntity<String> requestBodtSringV3(HttpEntity<String> httpEntity) throws  IOException{
        //HttpEntity : HTTP header,body 정보를 편리하게 조회
        String messageBody = httpEntity.getBody();
        log.info("messagebody={}", messageBody);

        return new HttpEntity<>("OK");
    }
    @ResponseBody
    @PostMapping("/request-bodty-string-v4")
    public String requestBodtSringV4(@RequestBody String messageBody) throws  IOException{
        //HttpEntity : HTTP header,body 정보를 편리하게 조회
        log.info("messagebody={}", messageBody);

        return "ok";
    }
}
