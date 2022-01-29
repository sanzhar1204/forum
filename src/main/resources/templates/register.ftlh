<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[]>
    <h1>Register</h1>
    <div>
        <#if errors?? >
            <p>Входные данные с ошибками!</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
        </#if>
    </div>
    <form action="/users/register" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <label for="email">Email:</label>
        <input id="email" type="text" name="email" value="${(form.email)!''}"><br/>
        <label for="password">Password:</label>
        <input id="password" type="password" name="password"><br/>
        <input type="submit" value="Register">
    </form>
</@main.renderWith>