package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    /**
     * 기본 요청
     * 모든 HTTP 메서드를 허용
     */
    @RequestMapping({"/hello-basic", "/hello-go"})
    public String helloBasic() {
        log.info("helloBasic");
        return "hello";
    }

    /**
     * 편리한 축약 어노테이션
     */
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 어노테이션 내의 파라미터는 생략이 가능하다.
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return data;
    }

    /**
     * PathVariable 다중 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mapping path userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * 쿼리 파라미터에 "mode"를 키로 하는 값이 있어야 호출이 된다.
     * 아예 쿼리 파라미터가 없으면 404를 응답한다.
     * 쿼리 파라미터가 있다고 해도 값이 다르다면 400을 응답한다.
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더 조건을 걸기
     * 헤더에 mode라는 키가 있어야 한다.
     * 그 외에는 위의 query parameter mapping과 같다.
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mapping header");
        return "ok";
    }

    /**
     * Content-type 헤더 기반 매핑 Media-Type
     */
    @PostMapping(value="/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingOnsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반으로 매핑한다.
     */
    @PostMapping(value="/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
