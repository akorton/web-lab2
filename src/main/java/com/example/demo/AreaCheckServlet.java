package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> query = parseQuerystring(req.getQueryString());
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        try{
            float x = Float.parseFloat(query.get("x"));
            float y = Float.parseFloat(query.get("y"));
            float r = Float.parseFloat(query.get("r"));
            boolean checkResult = CheckUtil.check(x, y, r);

        } catch (NumberFormatException | NullPointerException e) {
            writer.write("Invalid arguments.");
        } finally {
            writer.write("</body>");
            writer.write("</html>");
        }
    }

    public static Map<String, String> parseQuerystring(String queryString) {
        Map<String, String> map = new HashMap<String, String>();
        if ((queryString == null) || (queryString.equals(""))) {
            return map;
        }
        String[] params = queryString.split("&");
        for (String param : params) {
            try {
                String[] keyValuePair = param.split("=", 2);
                String name = URLDecoder.decode(keyValuePair[0], "UTF-8");
                if (name.equals("")) {
                    continue;
                }
                String value = keyValuePair.length > 1 ? URLDecoder.decode(
                        keyValuePair[1], "UTF-8") : "";
                map.put(name, value);
            } catch (UnsupportedEncodingException e) {
                // ignore this parameter if it can't be decoded
            }
        }
        return map;
    }
}
