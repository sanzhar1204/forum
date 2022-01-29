<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=["/js/topic.js"]>
<script type="text/javascript">
    let topicId = ${topic.id};

</script>
<h1>${topic.id} - ${topic.name} - ${topic.createdBy.email} - ${topic.createdAt}</h1>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="row modal-content">
            <div class="modal-header">
                <div class="title">
                    <div class="row">
                        <div class="col">
                            <h4><b>Добавить комментарий</b></h4>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-body">
                <form action="/comments" method="post">
                    <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                           value="${(_csrf.token)!'--no-token--'}"/>
                    <input type="hidden" value="${topic.id}" name="topicId"/>
                    <label for="content">Комментарий:</label>
                    <input id="content" type="text" name="content"><br/>
                    </#if>
                <button type="submit" id="save-comment-button" class="btn btn-primary" data-toggle="modal"
                        data-target="#exampleModal">Комментировать
                </button>
                <button type="reset" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal">Закрыть
                </button>
                </form>

            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-12">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Автор</th>
                <th scope="col">Дата создания</th>
                <th scope="col">Комментарий</th>
                <th scope="col">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"
                            id="comment-topic-button">Ответить</button>
                </th>
            </tr>
            </thead>
            <tbody id="commentList">
            </tbody>
        </table>
    </div>
</div>
<nav class="navbar fixed-bottom" id="pagination">
</nav>
</@main.renderWith>