package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);   // 컨트롤러에서 뷰로 이동할 때 사용한다.

        requestDispatcher.forward(request, response);   // 뷰에서 요청과 응답을 지역변수로 호출할 수 있다.


    }
}
