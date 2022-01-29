<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[]>
    <h1>Создание темы</h1>
    <form action="/topics" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <label for="topic">Тема:</label>
        <input id="topic" type="text" name="topicName"><br/>
        <input type="submit" value="Создать тему">
    </form>
</@main.renderWith>