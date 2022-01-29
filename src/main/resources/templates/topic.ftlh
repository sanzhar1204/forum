<#import "partials/main.ftlh" as main>

<@main.renderWith scriptsBefore=["/js/topic.js"]>
<h1>${topic.id} - ${topic.name} - ${topic.createdBy.email} - ${topic.createdAt}</h1>
<div class="row">
    <div class="col-12">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Автор</th>
                <th scope="col">Дата создания</th>
                <th scope="col">Комментарий</th>
            </tr>
            </thead>
            <tbody id="commentList">
            </tbody>
        </table>
    </div>
</div>
<nav class="navbar fixed-bottom" id="pagination">
</nav>
<script type="text/javascript">
    refreshComments(${topic.id});
</script>
</@main.renderWith>