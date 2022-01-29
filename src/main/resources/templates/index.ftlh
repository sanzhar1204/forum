<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=["/js/all-topics.js"]>
<h1>Темы</h1>
<div class="row">
    <div class="col-12">
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">Идентификатор</th>
                <th scope="col">Название</th>
                <th scope="col">Автор</th>
                <th scope="col">Дата создания</th>
                <th scope="col">Количество комментариев</th>
            </tr>
            </thead>
            <tbody id="topicList">
            </tbody>
        </table>
    </div>
</div>
<nav class="navbar fixed-bottom" id="pagination">
</nav>
</@main.renderWith>