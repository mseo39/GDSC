package hello.request.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@Controller
public class RequestController {
    @ResponseBody //http 바디에 직접 노출
    /*@ResponseBody: 클라이언트가 보내는 http요청 본문을 java 오브젝트로 변환하는 것입니다.
    http 요청 본문 데이터는 spring에서 제공하는 httpmessageconvert를 통해 타입에 맞는 객체로 변환됩니다
    @RequestMapping: 우리는 특정 url로 요청을 보내면 controller에서 어떠한 방식으로 처리할지 정의를 한다.
    이때 들어온 요청을 특정 메서드와 매핑하기 위해 사용하는 것
    */
    @RequestMapping("/request-param-v0")
    public String requestParamV1(@RequestParam("username") String username, @RequestParam("age") int age) {
        log.info("username={},age={}",username , age);

        return "ok";
    }
    /* 위 코드의 역할
    * http://localhost:8080/request-param-v0?username=GDSC&age=30
    * 쿼리스트링의 형태로 데이터 전달, @ResponseBody를 사용하여 응답 값을 http body에 직접 노출
    * */


    //  @RequestMapping메서드를 지정하지 않으면 디폴트값으로 get,post 등 모두 지원
    //  controller를 통해서 결과를 렌더링 한 후 클라이언트에게 view를 응답한다
    @RequestMapping("/request-param-v1")
    public String requestParam(@RequestParam String username, @RequestParam int age) {

        log.info("username={},age={}",username , age);

        return "html-form";
    }
    /* 위 코드의 역할
    *  http://localhost:8080/request-param-v1?username=%EC%9D%B4%ED%9B%88%EC%9D%BC&age=20
    * 똑같은 형식이지만 데이터를 렌더링한 후 view를 통한 응답
    * */


    // html/form형식을 통한 전달
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String modelAttributeV1(@ModelAttribute UserData userData) {
        log.info("username={},age={}",userData.getUsername(),userData.getAge());

        return "ok";
    }
/* 위 코드의 역할
*  http://localhost:8080/basic/hello-form.html
* */


    @ResponseBody
    @PostMapping("/request-body-json-v0")
    public String requestBodyJsonV3(@RequestBody UserData userData) throws IOException {  // http 메세지 컨버터가 원하는 문자나 객체로 변환해준다.

        log.info("username={},age={}",userData.getUsername(),userData.getAge());

        return "ok";

    }

    @ResponseBody // 응답에도 적용된다.
    @PostMapping("/request-body-json-v1")
    public UserData requestBodyJsonV5(@RequestBody UserData userData) throws IOException {

        log.info("username={},age={}",userData.getUsername(),userData.getAge());

        return userData;

    }


    @Data
    static class UserData{
        private String username;
        private int age;

    }
}
