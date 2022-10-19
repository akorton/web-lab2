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

        .input-el td, td#reset {
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
    <tr class="input-el x" id="x_buttons">
        <td>
            <span>Изменение X: </span>
            <input type="button" value="-4">
            <input type="button" value="-3">
            <input type="button" value="-2">
            <input type="button" value="-1">
            <input type="button" value="0">
            <input type="button" value="1">
            <input type="button" value="2">
            <input type="button" value="3">
            <input type="button" value="4">
        </td>
    </tr>
    <tr class="input-el">
        <td><span>Изменение Y: </span><input type="text" form="data" id="y" name="y" value="0"></td>
    </tr>
    <tr class="input-el">
        <td>
            <span>Изменение R: </span>
            <input type="radio" checked="true" name="radius" id="r1" form="data" value="1"><label for="r1">1</label>
            <input type="radio" name="radius" id="r2" form="data" value="1.5"><label for="r2">1.5</label>
            <input type="radio" name="radius" id="r3" form="data" value="2"><label for="r3">2</label>
            <input type="radio" name="radius" id="r4" form="data" value="2.5"><label for="r4">2.5</label>
            <input type="radio" name="radius" id="r5" form="data" value="3"><label for="r5">3</label>
        </td>
    </tr>
    <tr>
        <td id="reset">
            <button type="submit" name="reset" value="reset" form="reset_form">Reset</button>
            <button type="submit" form="data">Submit</button>
        </td>
    </tr>
    <tr class="footer"></tr>
</table>
<form id="data" method="get" action="server.php" target="_blank"></form>
<form method="post" action="server.php" target="_blank" id="reset_form"></form>
</body>
<script src="js/script.js"></script>
</html>
