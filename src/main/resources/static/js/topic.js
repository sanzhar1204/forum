"use strict";

window.onload = refreshComments();

function refreshComments(){
    $('#pagination').pagination({
        dataSource: `/api/comments?topicId=${topicId}&sort=createdAt,asc`,
        locator: 'content',
        totalNumberLocator: function(response) {
            return response.totalElements;
        },
        alias: {
            pageNumber: 'page',
            pageSize: 'size',
        },
        className: 'paginationjs-big',
        callback: function(data, pagination) {
            refreshAllElements(data);
        }
    })
}
function refreshAllElements(comments){
    let commentList = $('#commentList');
    commentList.empty();
    for (var i = 0; i < comments.length; i++) {
        commentList.append(createCommentElement(comments[i]));
    }
}

function createCommentElement(comment){
    let topicElement = $.parseHTML(`<tr><th scope="row">${comment.createdBy.email}</th><td>${comment.createdAt}</td><td>${comment.content}</td></tr>`);
    return topicElement;
}