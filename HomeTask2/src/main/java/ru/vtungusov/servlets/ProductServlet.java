package ru.vtungusov.servlets;

import ru.vtungusov.models.Product;
import ru.vtungusov.reposotories.ProductRepository;
import ru.vtungusov.reposotories.ProductRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private ProductRepository products = new ProductRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isRequest = reqExist(req);
        boolean correctArgs = true;
        if (isRequest) {
            try {
                formHandler(req);
            } catch (IllegalStateException e) {
                correctArgs = false;
            }
        }
        List<Product> productList = this.products.findAll();
        Writer writer = resp.getWriter();
        writer.write("<div><form method=\"get\" action=\"/HomeTask2_war/products\">" +
                "<label>Name:" +
                "<input type=\"text\" name=\"name\"><br />" +
                "</label>" +
                "<label>Price:" +
                "<input type=\"text\" name=\"price\"><br />" +
                "</label>" +
                "<label>Amount:" +
                "<input type=\"text\" name=\"amount\"><br />" +
                "</label>" +
                "<button type=\"submit\">Add new product</button>" +
                "</form></div>");
        if (isRequest) {
            if (correctArgs) {
                writer.write("<h3> <p style=\"color:green\">New product was added</p></h3>");
            } else {
                writer.write("<h3> <p style=\"color:red\">Incorrect data!</p></h3>");
            }
        }
        writer.write("<h2>All products:</h2>" +
                "<table>" +
                " <tr>" +
                "<th>Name</th>" +
                "<th>Price</th>" +
                "<th>Amount</th>" +
                "</tr>");
        for (Product product : productList) {
            writer.write("<tr>" +
                    "<td>" + product.getName() + "</td>" +
                    "<td>" + product.getPrice() + "</td>" +
                    "<td>" + product.getAmount() + "</td>" +
                    "</tr>");
        }
        writer.write("</table>");
    }

    private void formHandler(HttpServletRequest req) throws IllegalStateException {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");
        if (name.equals(""))
            throw new IllegalStateException();
        try {
            this.products.save(new Product(name, Integer.parseInt(price), Integer.parseInt(amount)));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

    private boolean reqExist(HttpServletRequest req) {
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");

        return name != null && price != null && amount != null;
    }
}
