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

        table {
            width: 100%;
            height: 100vh;
            font-size: 20px;
        }

        .header td {
            text-align: center;
            padding-top: 10px;
            padding-bottom: 10px;
            font-size: 30px;
            color: yellow;
            background-color: black;
            font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
        }

        .header {
            width: 100%;
            height: 15%;
        }
        .header td p{
            margin: 0;
            margin-bottom: 20px;
        }

        .content {
            width: 100%;
            height: 50%;
        }

        .input-el {
            width: 100%;
            height: 7%;
        }

        .footer {
            height: 14%;
        }

        .input-el td, td#submit {
            padding-left: 20%;

        }
        .content td{
            text-align: center;
        }

        .x button {
            border-radius: 50%;
            padding: 10px;
            width: 40px;
            border-style: solid;
            border-color: black;
            font-size: 15px;
        }
        .content #canvas {
            width: 500px;
            height: 500px;
        }

    </style>
</head>
<body>
<table>
    <tr class="header">
        <td colspan="2"><p>Кортыш Андрей Олегович</p> <span>группа P32151</span> <span>Вариант 1908</span></td>
    </tr>
    <tr class="content">
        <td><canvas id="canvas"></canvas></td>
    </tr>
    <tr class="input-el x">
        <td>
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
        </td>
    </tr>
    <tr class="input-el">
        <td><span>Изменение Y: </span><input type="text" form="data" id="y" name="y" value="0"></td>
    </tr>
    <tr class="input-el">
        <td>
            <span>Изменение R: </span>
            <input type="radio" checked="true" name="r" id="r1" form="data" value="1"><label for="r1">1</label>
            <input type="radio" name="r" id="r2" form="data" value="1.5"><label for="r2">1.5</label>
            <input type="radio" name="r" id="r3" form="data" value="2"><label for="r3">2</label>
            <input type="radio" name="r" id="r4" form="data" value="2.5"><label for="r4">2.5</label>
            <input type="radio" name="r" id="r5" form="data" value="3"><label for="r5">3</label>
        </td>
    </tr>
    <tr>
        <td id="submit">
            <button type="submit" form="data">Submit</button>
        </td>
    </tr>
    <tr class="footer"></tr>
</table>
<form id="data" method="get" action="controller" target="_blank"></form>
</body>
<script src="/lab2/js/script.js"></script>
</html>
