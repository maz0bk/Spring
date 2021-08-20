package main.java.ru.gb.web.application;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productServlet", urlPatterns = "/product_list")
public class ProductServlet extends HttpServlet {
    private List<Product> productList;

    @Override
    public void init() {
        productList = new ArrayList<>();
        for (int i =0;i<10;i++){
            productList.add(new Product(i,"Product"+i, 1.00*(i+i*3)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
        resp.setContentType("text/html");


        PrintWriter out = resp.getWriter();
        out.println("<html>" +
                    "<head>"+
                    "<meta charset=\"utf-8\">"+
                    "<title>Product table</title>"+
                        "</head>" +
                        "<body>"
                    );
        out.println("<table border=\"1\">");
        out.println("<caption>Product table</caption>");
        out.println("<tr> <th>ID</th> <th>Name</th> <th>Price</th> </tr>");
        out.println("<tr>");

        for (Product p:productList) {
            out.println("<tr>");
            out.println("<td>"+ p.getId()+"</td>");
            out.println("<td>"+ p.getName()+"</td>");
            out.println("<td>"+ p.getCost()+"</td>");
            out.println("</tr>");
        }

        out.println("</table>");

        out.println("</body></html>");
    }
    @Override
    public void destroy() {
    }
}
