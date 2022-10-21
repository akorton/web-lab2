<%@ page import="com.example.demo.Results" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Second lab</title>
    <style>

        body{
            margin: 0px;
        }

        .header {
            padding-top: 10px;
            padding-bottom: 10px;
            font-size: 30px;
            color: yellow;
            background-color: black;
            font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 50px;
            gap: 10px;
        }

        .content {
            display: flex;
            justify-content: space-between;
            gap: 20px;
            margin-bottom: 100px;
        }
        .content #canvas {
            width: 500px;
            height: 500px;
        }
        .content, .input{
            padding-left: 20%;
        }

        .input {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            justify-content: space-between;
            gap: 10px;
            font-size: 20px;
        }
        table{
            overflow-y:scroll;
            height:500px;
            display:block;
        }

    </style>
</head>
<body>
<div>
    <div class="header">
        <div>Кортыш Андрей Олегович</div> <div>группа P32151 Вариант 19080</div>
    </div>
    <div class="content">
        <canvas id="canvas"></canvas>
            <table align="center" cellpadding="5" cellspacing="10" border="2">
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
    </div>
    <div class="input">
        <div class="x">
                <span>Изменение X: </span>
                <select name="x" form="data" id="x_select">
                    <option value="-2">-2</option>
                    <option value="-1.5">-1.5</option>
                    <option value="-1">-1</option>
                    <option value="-0.5">-0.5</option>
                    <option value="0" selected>0</option>
                    <option value="0.5">0.5</option>
                    <option value="1">1</option>
                    <option value="1.5">1.5</option>
                    <option value="2">2</option>
                </select>
        </div>
        <div>
            <span>Изменение Y: </span><input type="text" form="data" id="y" name="y" value="0">
        </div>
        <div>
                <span>Изменение R: </span>
                <input type="radio" checked="true" name="r" id="r1" form="data" value="1"><label for="r1">1</label>
                <input type="radio" name="r" id="r2" form="data" value="1.5"><label for="r2">1.5</label>
                <input type="radio" name="r" id="r3" form="data" value="2"><label for="r3">2</label>
                <input type="radio" name="r" id="r4" form="data" value="2.5"><label for="r4">2.5</label>
                <input type="radio" name="r" id="r5" form="data" value="3"><label for="r5">3</label>
        </div>
        <div>
            <button type="submit" form="data" id="submit">Submit</button>
        </div>
    </div>
    <div class="footer"></div>
</div>
<form id="data" method="get" action="controller" target="_blank"></form>
</body>
<script src="/lab2/js/jquery-3.6.1.min.js"></script>
<script src="/lab2/js/script.js"></script>
</html>
