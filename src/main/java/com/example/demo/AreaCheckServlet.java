package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> query = parseQuerystring(req.getQueryString());
        log(String.format("New request with this query params: %s", req.getQueryString()));
        try{
            if (query.get("x").length() > 10 || query.get("y").length() > 10 || query.get("r").length() > 10){
                String trimmedX = query.get("x").substring(0, Math.min(10, query.get("x").length()));
                String trimmedY = query.get("y").substring(0, Math.min(10, query.get("y").length()));
                String trimmedR = query.get("r").substring(0, Math.min(10, query.get("r").length()));
                resp.sendRedirect(String.format("/lab2/controller?x=%s&y=%s&r=%s", trimmedX, trimmedY, trimmedR));
                return;
            }
            float x = Float.parseFloat(query.get("x"));
            float y = Float.parseFloat(query.get("y"));
            float r = Float.parseFloat(query.get("r"));
            boolean result = CheckUtil.check(x, y, r);
            Results.CheckResult checkResult = new Results.CheckResult();
            checkResult.setIn(result);
            checkResult.setR(r);
            checkResult.setX(x);
            checkResult.setY(y);
            Results.addCheckResult(checkResult);
            req.getRequestDispatcher("table.jsp").forward(req, resp);
        } catch (NumberFormatException | NullPointerException e) {

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
