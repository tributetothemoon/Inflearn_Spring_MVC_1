package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);   // 컨트롤러에서 뷰로 이동할 때 사용한다.

        requestDispatcher.forward(request, response);   // 뷰에서 요청과 응답을 지역변수로 호출할 수 있다.
    }
}
