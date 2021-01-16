package servlets;

import bean.Echart;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;
import service.Impl.ServiceImpl;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    Service service = new ServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Echart> list = service.getAll();
        //将list转换为json格式
        String json = JSONArray.fromObject(list).toString();
        System.out.println(json);
//        out.write("{\"data_pie\" : "+json+"}");
        out.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
