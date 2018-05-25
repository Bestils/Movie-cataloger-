<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="Styles/main.css" />



</head>
<body>
<div id="display-area" class="waiting">
    <h2>Firebase-enabled Tic Tac Toe</h2>
    <div id="other-player">
        Send the other player this link to play, and click link below to wait on the other player:<br>
        </div>
    <div id="your-move">Your move! Click a square to place your piece.</div>
    <div id="their-move">Waiting for other player to move...</div>
    <div id="you-won">You won this game!</div>
    <div id="you-lost">You lost this game.</div>
    <div id="board">
        <div class="t l cell" id="0"></div>
        <div class="t c cell" id="1"></div>
        <div class="t r cell" id="2"></div>
        <div class="m l cell" id="3"></div>
        <div class="m c cell" id="4"></div>
        <div class="m r cell" id="5"></div>
        <div class="b l cell" id="6"></div>
        <div class="b c cell" id="7"></div>
        <div class="b r cell" id="8"></div>
    </div>
    <div id="this-game" float="top">
        Quick link to this game: <span id="this-game-link"><a href="<%= request.getAttribute("game_link") %>"><%= request.getAttribute("game_link") %></a></span>
    </div>
</div>
</body>
</html>