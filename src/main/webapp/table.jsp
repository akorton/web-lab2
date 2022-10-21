<%@ page import="com.example.demo.Results" %>
<%@ page contentType="text/html; UTF-8" %>
<html>
    <head>
        <style>
            #back{
                display: flex;
                justify-content: flex-end;
                padding-top: 20px;
                margin-bottom: 30px;
            }
            #back button{
                font-size: 20px;
            }
        </style>
    </head>
    <body>
    <div id="back"><button onclick="redirectToMainPage()">Back</button></div>
    <table align="center" cellpadding="5" cellspacing="10" border="2" width="100%">
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Result</th>
        </tr>
        <% for (Results.CheckResult checkResult: Results.getResults()){%>
        <tr>
            <td><%=checkResult.getX()%></td>
            <td><%=checkResult.getY()%></td>
            <td><%=checkResult.getR()%></td>
            <td><%=checkResult.getIn()%></td>
        </tr>
        <%}%>
    </table>
    </body>
</html>
<script>let redirectToMainPage = ()=>{
    let hrefArray = window.location.href.split('/');
    let newArray = [...hrefArray.splice(0, hrefArray.indexOf('lab2')+1), 'controller'];
            window.location.href = newArray.join("/");
    }
</script>