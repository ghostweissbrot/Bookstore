<%@ page import="backend.Database" %>
<%@ page import="java.util.Map" %>
<%@ page import="backend.Category" %><%--
  Created by IntelliJ IDEA.
  User: smint
  Date: 31.05.17
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kategorien</title>


</head>

<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.0/css/bulma.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<%
    Database db = Database.getInstance();
    //db.load();
%>

<nav class="nav has-shadow">
    <div class="container">
        <div class="nav-left">
            <a class="nav-item" href="index.html">
                <img src="https://cdn.genialokal.de/chameleon/mediapool/thumbs/f/cf/Logo-Dauelsberg-jpg_1140x390-ID10683-1279968186f75eebd8fbfe3e14922fc0.jpg"
                     style="width:200%" alt="Bulma logo" href="index.html">
            </a>
            <a href="index.html" class="nav-item is-tab is-hidden-mobile">Startseite</a>
            <a href="categories.html" class="nav-item is-tab is-hidden-mobile is-active">Kategorien</a>
            <a href="stoebern.html" class="nav-item is-tab is-hidden-mobile">St&ouml;bern</a>
        </div>
        <span class="nav-toggle">
		      <span></span>
		      <span></span>
		      <span></span>
		    </span>
        <div class="nav-right nav-menu">
            <a class="nav-item is-tab is-hidden-tablet">Startseite</a>
            <a class="nav-item is-tab is-hidden-tablet is-active">Kategorien</a>
            <a class="nav-item is-tab is-hidden-tablet">Angebote</a>

            <p class="nav-item is-tab has-icon">
                <input class="input" type="text" placeholder="Suche nach..">
                <a href="stoebern.html">
                    <button class="button">
                        Suche
                    </button>
                </a>
            </p>


            <a class="nav-item is-tab" href="shoppingcart.html">
                <figure class="image is-16x16" style="margin-right: 8px;">
                    <img src="http://www.kingbutton.de/generator/images/warenkorb.png">
                </figure>
                Warenkorb
            </a>
            <!-- <a class="nav-item is-tab">Log out</a> -->
        </div>
    </div>
</nav>

<section class="hero is-primary">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
                Kategorien
            </h1>
        </div>
    </div>
</section>
<h1></h1>
<div class="container is-fluid">
    <div class="columns">
        <div class="column is-2">
            <aside class="menu">
                <p class="menu-label">
                    St&Ouml;bern
                </p>
                <ul class="menu-list">
                    <li><a href="stoebern.html">&Uuml;bersicht</a></li>
                    <li><a>Bestseller</a></li>
                    <li><a>Neu</a></li>
                </ul>
                <p class="menu-label">
                    <a href="categories.html">Kategorien</a>
                </p>
                <ul class="menu-list">
                    <%
                        for (Map.Entry<String, Category> entry : db.getCategorys().entrySet()) {%>
                            <li><a href="<%entry.getKey();%>.html"><%entry.getValue().getName();%></a></li>
                           <%}%>
                </ul>
            </aside>
        </div>
        <div class="column">
            <div class="container is-fluid">
                <div class="column"></div>
                <div class="columns is-multiline">
                    <div class="column is-2">
                        <div class="card has-text-centered">
                            <div class="card-image">
                                <a href="krimis.html"><img
                                        src="https://www.randomhouse.de/content/edition/covervoila_hires/Larsson_SVerblendung_160798.jpg"
                                        width="200" height="200"></a>
                            </div>
                            <div class="card-content"><a href="krimis.html" class="title">Krimis</a></div>
                        </div>
                    </div>
                    <div class="column is-2">
                        <div class="card has-text-centered">
                            <div class="card-image">
                                <a href="romane.html"><img
                                        src="https://images-na.ssl-images-amazon.com/images/I/811j6HA9XdL.jpg"
                                        width="200" height="200"></a>
                            </div>
                            <div class="card-content"><a href="romane.html" class="title">Romane</a></div>
                        </div>
                    </div>
                    <div class="column is-2">
                        <div class="card has-text-centered">
                            <div class="card-image">
                                <a href="fantasy.html"><img
                                        src="https://www.klett-cotta.de/media/1/9783608960891.jpg"
                                        width="200" height="200"></a>
                            </div>
                            <div class="card-content"><a href="fantasy.html" class="title">Fantasy</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

</body>

</html>

