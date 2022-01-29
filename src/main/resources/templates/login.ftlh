<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[]>
    <h1>Login</h1>
    <form action="/users/login" method="post">
        <div>
            <#if error!false>
                <p style="color:red">Неверные имя пользователя или пароль !</p>
            </#if>
        </div>

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <label for="email">Email:</label>
        <input id="email" type="text" name="username" value="${(form.email)!''}"><br/>
        <label for="password">Password:</label>
        <input id="password" type="password" name="password"><br/>
        <input type="submit" value="Login">
    </form>
</@main.renderWith>