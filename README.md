<h1 align="center">Demo project UI automation for <a href="https://rit-it.com/en/ ">rit-it.com</a></h1>

<p align="center">
<img title="mainPage" src="images/screens/mainPage.png">
</p>

<h3>Содержание:</h3>
____

0. [Технологии](#Технологии)
1. [Список проверок](#Список проверок) 
2. [Запуск тестов](#Запуск тестов) 
    1. [Локальный](#localLaunch)
    2. [Удаленный (Selenoide)](#remoteLaunch)
3. [Отчетность](#report)
   1. [Allure](#allureReport)
   2. [Telegram](#telegramReport)


<h3>Технологии<a name="#tech"></a></h3>
____
<p align="center">
<code><a href="https://www.java.com/"><img src="images/ico/Java.svg" width="50" height="50"  alt="Java"/></a></code>
<code><a href="https://junit.org/junit5/"><img src="images/ico/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a></code>
<code><a href="https://selenide.org/"><img src="images/ico/Selenide.svg" width="50" height="50"  alt="Selenide"/></a></code>
<code><a href="https://gradle.org/"><img src="images/ico/Gradle.svg" width="50" height="50"  alt="Gradle"/></a></code>
<code><a href="https://github.com/"><img src="images/ico/GitHub.svg" width="50" height="50"  alt="Github"/></a></code>
<code><a href="https://aerokube.com/selenoid/"><img src="images/ico/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a></code>
<code><a href="https://www.jenkins.io/"><img src="images/ico/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a></code>
<code><a href="https://github.com/allure-framework/allure2"><img src="images/ico/Allure.svg" width="50" height="50"  alt="Allure"/></a></code>


- Написано на <code><strong>Java</strong></code> <br />
- Протестировано с помощью <code><strong>jUnit</strong></code> и <code><strong>Selenide</strong></code> <br />
- Собрано <code><strong>Gradle</strong></code> <br />
- Хранится в <code><strong>GitHub</strong></code> <br />
- Запускается в <code><strong>Jenkins</strong></code> и <code><strong>Selenoide</strong></code> <br />
- Отчитывается в <code><strong>Allure</strong></code> и <code><strong>Telegram</strong></code> <br />

<h3>Список проверок<a name="#listOfTest"></a></h3>
____
- [x] Проверка смены локализации (Ru, En)
- [x] Проверка валидации input полей на примере поля e-mail
- [x] Проверка ссылок на социальные сети на примере VK
- [x] Проверка Hamburger Menu
- [x] Проверка Header Menu

<h3>Запуск тестов<a name="#testLaunch"></a></h3>
____
<h3>Локальный запуск всех тестов<a name="localLaunch"></a></h3>

```bash
gradle clean test
```
<h3>Удаленный запуск из Jenkins на Selenoide <a name="localLaunch"></a></h3>

```bash
clean 
test
-D"baseUrl=${BASED_URL}" 
-D"selenoideURL=${SELENOIDE_URL}" 
-D"resolution=${RESOLUTION}" 
-D"browser=${BROWSER}" 
-D"browserVersion=${BROWSER_VERSION}" 
```
<h4>Расшифровка</h4>
><code>clean</code> - удаление следов прошлых запусокв <br />
><code>test</code> - запуск всех тестов<br />
><code>${BASED_URL}"</code> - задает URL стенда<br />
><code>${SELENOIDE_URL}"</code> - задает URL селенойда <br />
><code>${RESOLUTION}"</code>  - задает разрешение браузера <br />
><code>${BROWSER}"</code> - выбор браузер <br />
><code>${BROWSER_VERSION}"</code> - выбор версии браузера <br /> 
