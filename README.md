<h1 align="center">Демопроект UI автоматизации на примере <a href="https://rit-it.com/en/ ">rit-it.com</a></h1>

<p align="center">
<img src="images/screens/mainPage.png">
</p>

<h3>Содержание:</h3>


0. [Технологии](#tech)
1. [Список проверок](#listOFTest)
2. [Запуск тестов](#testLaunch)
    1. [Локальный](#localLaunch)
    2. [Удаленный (Jenkins + Selenoide)](#remoteLaunch)
3. [Отчетность](#report)
   1. [Allure](#allureReport)
   2. [Telegram](#telegramReport)


<h3 id="tech">Технологии</h3>
<hr>
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

<h3 id="listOFTest">Список проверок</h3>
<hr>

- [x] Проверка смены локализации (Ru, En) <br />
- [x] Проверка валидации input полей на примере поля e-mail <br />
- [x] Проверка ссылок на социальные сети на примере VK <br />
- [x] Проверка Hamburger Menu <br />
- [x] Проверка Header Menu <br />

<h3 id="testLaunch">Запуск тестов</h3>
<hr />

<h4 id="localLaunch">Локальный запуск</h4>

Запуск тестов:
```bash
gradle clean test
```
Получение отчета:
```bash
gradle allureServe
```
<h4 id="remoteLaunch">Удаленный запуск из Jenkins на Selenoide </h4>
1. Выбираем сборку с параметрами
   <img src="images/screens/withParam.png">
2. Задаем параметры и запускаем
   <img src="images/screens/configPNG.png">
3. Смотрим отчет
   <img src="images/screens/reportPNG.png">

Таска для запуска:
```bash
clean 
test
-D"baseUrl=${BASED_URL}" 
-D"selenoideURL=${SELENOIDE_URL}" 
-D"resolution=${RESOLUTION}" 
-D"browser=${BROWSER}" 
-D"browserVersion=${BROWSER_VERSION}" 
```
Расшифровка
><code>clean</code> - удаление следов прошлых запусокв <br />
><code>test</code> - запуск всех тестов<br />
><code>${BASED_URL}"</code> - задает URL стенда<br />
><code>${SELENOIDE_URL}"</code> - задает URL селенойда <br />
><code>${RESOLUTION}"</code>  - задает разрешение браузера <br />
><code>${BROWSER}"</code> - выбор браузер <br />
><code>${BROWSER_VERSION}"</code> - выбор версии браузера <br /> 





