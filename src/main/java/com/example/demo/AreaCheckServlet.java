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
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        try{
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
            List<Results.CheckResult> results = Results.getResults();
            writer.write("<table align=\"center\" cellpadding=\"5\" cellspacing=\"10\" border=\"2\" width=\"100%\">");
            writer.write(" <tr>\n" +
                    "                <td colspan=\"4\" align=\"right\"><button onclick=\"redirectToMainPage()\">Back</button></td>\n" +
                    "            </tr>");
            writer.write("<tr><th>X</th><th>Y</th><th>R</th><th>Result</th></tr>");
            for (Results.CheckResult currentResult: results){
                float curX = currentResult.getX();
                float curY = currentResult.getY();
                float curR = currentResult.getR();
                boolean curResult = currentResult.getIn();
                writer.write(String.format("<tr><td>%f</td><td>%f</td><td>%f</td><td>%s</td></tr>", curX, curY, curR, curResult));
            }
            writer.write("</table>");
        } catch (NumberFormatException | NullPointerException e) {
            writer.write("Invalid arguments.");
        } finally {
            writer.write("</body>");
            writer.write("</html>");
            writer.write("<script>let redirectToMainPage = ()=>{\n" +
                    "let hrefArray = window.location.href.split('/');\n" +
                    "let newArray = [...hrefArray.splice(0, hrefArray.indexOf('lab2')+1), 'controller'];" +
                    "        window.location.href = newArray.join(\"/\");\n" +
                    "    }</script>");
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
