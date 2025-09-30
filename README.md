<div align="center">

# Проект UI автотестов для сайта RSTQB

<img src="images/ISTQB.svg" alt="See-DA-Sete" width="350">
</div>

> **RSTQB** —  это ISTQB в России.
> 
> **ISTQB** (International Software Testing Qualifications Board) — международная организация, занимающаяся разработкой и утверждением стандартов в области тестирования программного обеспечения.

---
## 📖 Содержание

- [🧪 Тест-кейсы](#тест-кейсы)
- [🚀 Запуск автотестов через терминал](#запуск-автотестов-через-терминал)

___
<a id="тест-кейсы"></a>
## 🧪 Тест-кейсы

### Главная страница
 - ✅ Проверка видимости логотипа.
 - ✅ Кнопка "Поиск" перебрасывает на страницу "Расписание экзаменов".
 - ✅ Поиск по дате работает.

### Страница "Материалы ISTQB®"
 - ✅ PDF скачивается, соответствующий текст в PDF присутствует.

### Страница "Расписание экзаменов"
- ✅ Поиск по комбинации фильтров "город" и "уровень" возможен.
- ✅ Кнопка перехода на следущющую страницу.
- ✅ Фильтр и его поля видны.


___
<a id="запуск-автотестов-через-терминал"></a>
## 🚀 Запуск автотестов через терминал

### Запустить все тесты локально 

```bash
  ./gradlew clean test
```
Также есть возможность вместо **test** указать **smoke** или **regress** и запустятся соответствующие тесты 🤖


### Запустить все тесты удалённо (на selenoid сервере)

```bash
  ./gradlew clean -DselenoidLogin={LOGIN} -DselenoidPass={PASS} test
```

Вместо {LOGIN} и {PASS} необходимо подставить креды от selenoid.

### Получить Allure отчёт

```bash
  ./gradlew allureServe
```

после запуска команды в консоли появится ссылка, останется на неё нажать, чтобы открыть отчёт.
___




### В проекте задействованы технологии

<div align="center">
  <img src="images/image.png" alt="See-DA-Sete" width="600">
  <br>
  <em>See-DA-Sete</em>
</div>


<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="images/java-logo.svg"></code>
  <code><img width="5%" title="Selenide" src="images/selenide-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="images/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="images/gradle-logo.svg "></code>
  <code><img width="5%" title="JUnit5" src="images/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="images/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="images/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="images/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="images/jenkins-logo.svg"></code>
<!--   <code><img width="5%" title="Jira" src="images/jira-logo.svg"></code> -->
  <code><img width="5%" title="Telegram" src="images/Telegram.svg"></code>

</p>





<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" height="50" width="50"/>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>

