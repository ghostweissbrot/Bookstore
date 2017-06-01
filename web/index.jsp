<%--
  Created by IntelliJ IDEA.
  User: smint
  Date: 31.05.17
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dauelsberg</title>


</head>

<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.4.0/css/bulma.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<nav class="nav has-shadow">
    <div class="container">
        <div class="nav-left">
            <a class="nav-item" href="index.html">
                <img src="https://cdn.genialokal.de/chameleon/mediapool/thumbs/f/cf/Logo-Dauelsberg-jpg_1140x390-ID10683-1279968186f75eebd8fbfe3e14922fc0.jpg"
                     style="width:200%" alt="Bulma logo">
            </a>
            <a href="index.html" class="nav-item is-tab is-hidden-mobile is-active">Startseite</a>
            <a href="categories" class="nav-item is-tab is-hidden-mobile">Kategorien</a>
            <a href="stoebern.html" class="nav-item is-tab is-hidden-mobile">St&ouml;bern</a>
        </div>
        <span class="nav-toggle">
		      <span></span>
		      <span></span>
		      <span></span>
		    </span>
        <div class="nav-right nav-menu">F
            <a class="nav-item is-tab is-hidden-tablet is-active">Startseite</a>
            <a class="nav-item is-tab is-hidden-tablet">Kategorien</a>
            <a class="nav-item is-tab is-hidden-tablet">St&ouml;</a>

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
                Willkommen im Dauelsberg Buch-Shop!
            </h1>
        </div>
    </div>
</section>

<div class="container">
    <section class="section">
        <div class="container">
            <h1 class="title">Bestseller</h1>
            <div style="overflow-x:auto;">

                <table>
                    <tr>
                        <th><a href="verblendung.html"> <img
                                src="https://www.randomhouse.de/content/edition/covervoila_hires/Larsson_SVerblendung_160798.jpg"
                                width="200" height="200"></a></th>
                        <th><a href="blackout.html"><img
                                src="https://upload.wikimedia.org/wikipedia/commons/7/78/Blackout_%28Marc_Elsberg%2C_2012%29.jpg"
                                width="200" height="200"></a></th>
                        <th><a href="lordoftherings.html"><img
                                src="https://www.klett-cotta.de/media/1/9783608960891.jpg"
                                width="200" height="200"></a></th>
                        <th><a href="phantom.html"><img
                                src="https://images-na.ssl-images-amazon.com/images/I/811j6HA9XdL.jpg"
                                width="200px" height="200px"></a></th>
                        <th><a href="nos.html"><img
                                src="https://s-media-cache-ak0.pinimg.com/736x/af/15/a2/af15a2b8d05b7915ed03a9f7b094d831.jpg"
                                width="200px" height="200px"></a></th>
                    </tr>
                </table>
            </div>
            <a><br></a>

            <h1 class="title">Neuheiten</h1>
            <div style="overflow-x:auto;">

                <table>
                    <tr>
                        <th><a href="phantom.html"><img
                                src="https://images-na.ssl-images-amazon.com/images/I/811j6HA9XdL.jpg"
                                width="200px" height="200px"></a></th>
                        <th><a href="nos.html"><img
                                src="https://s-media-cache-ak0.pinimg.com/736x/af/15/a2/af15a2b8d05b7915ed03a9f7b094d831.jpg"
                                width="200px" height="200px"></a></th>
                        <th><a href="blackout.html"><img
                                src="https://upload.wikimedia.org/wikipedia/commons/7/78/Blackout_%28Marc_Elsberg%2C_2012%29.jpg"
                                width="200" height="200"></a></th>
                        <th><a href="lordoftherings.html"><img
                                src="https://www.klett-cotta.de/media/1/9783608960891.jpg"
                                width="200" height="200"></a></th>
                        <th><a href="verblendung.html"> <img
                                src="https://www.randomhouse.de/content/edition/covervoila_hires/Larsson_SVerblendung_160798.jpg"
                                width="200" height="200"></a></th>
                    </tr>
                </table>
            </div>
        </div>
    </section>
</div>
<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">
            <p>
                <strong> <a href="impressum.html">Impressum</a></strong>

            </p>
            <p>
                <a class="icon" href="index.html">
                    <i class="fa fa-github"></i>
                </a>
            </p>
        </div>
    </div>
</footer>
</body>

</html>

