"use strict";

window.onload = refreshAllTopics();

function refreshAllTopics(){
    $('#pagination').pagination({
        dataSource: `/api/topics?sort=createdAt,desc`,
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
function refreshAllElements(topics){
    let topicList = $('#topicList');
    topicList.empty();
    for (var i = 0; i < topics.length; i++) {
        topicList.append(createTopicElement(topics[i]));
    }
}

function createTopicElement(topincInfo){
    let topicElement = $.parseHTML(`<tr><th scope="row"><a href="/topics/${topincInfo.topic.id}">${topincInfo.topic.id}</a></th><td><a href="/topics/${topincInfo.topic.id}">${topincInfo.topic.name}</td></a><td><a href="/topics/${topincInfo.topic.id}">${topincInfo.topic.createdBy.email}</a></td><td><a href="/topics/${topincInfo.topic.id}">${topincInfo.topic.createdAt}</a></td><td><a href="/topics/${topincInfo.topic.id}">${topincInfo.commentsCount}</a></td></tr>`);
    return topicElement;
}