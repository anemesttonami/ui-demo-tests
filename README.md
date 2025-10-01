<div align="center">

# Проект UI автотестов для сайта RSTQB

<img src="images/ISTQB.svg" width="350">
</div>

> **RSTQB** —  это ISTQB в России.
> 
> **ISTQB** (International Software Testing Qualifications Board) — международная организация, занимающаяся разработкой и утверждением стандартов в области тестирования программного обеспечения.

---
## 📖 Содержание

- [🧪 Тест-кейсы](#тест-кейсы)
- [🚀 Запуск автотестов через терминал](#запуск-автотестов-через-терминал)
- [⚙️ Сборка Jenkins](#сборка-jenkins)
- [⚙️ Allure](#allure)

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

<a id="сборка-jenkins"></a>
## <img width="40" style="vertical-align:middle" src="images/jenkins.svg"> </a> Сборка в <a target="_blank" href="https://jenkins.autotests.cloud/"> Jenkins </a>
Jenkins job-а для запуска автотестов этого проекта располагается <a target="_blank" href="https://jenkins.autotests.cloud/job/C36-andreyalbaev-ui-21"> здесь </a>. Для запуска сборки необходимо нажать на <code>Build with parameters</code>, выбрать необходимые параметры и нажать кнопку <code>Build</code>.

### Параметры сборки в Jenkins:

- SELENOID_LOGIN
- SELENOID_PASS
- TESTS_TO_RUN (smoke/regress/test)
- ENV (окружение для выполнения тестов)
- BROWSER_VERSION
- BROWSER_SIZE

После выполнения сборки формируются <code>Allure Report</code> - HTML отчёт о прошедших тестах и тестовые прогоны в TMS <code>Allure TestOps</code>.
> ПОТОМ ТУТ ВСТАВИТЬ СКРИН
---
<a id="allure"></a>
## <img width="35" style="vertical-align:middle" src="images/allure.svg"> </a>  Allure
### Пример отчёта

<img src="images/allureReportExample.png" width="1500">


> ПОТОМ ТУТ ВСТАВИТЬ СКРИН






















### В проекте задействованы технологии

<div align="center">
  <img src="images/image.png" alt="See-DA-Sete" width="600">
  <br>
  <em>See-DA-Sete</em>
</div>


<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="images/java-logo.svg"></code>
  

</p>





<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" height="50" width="50"/>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/>

