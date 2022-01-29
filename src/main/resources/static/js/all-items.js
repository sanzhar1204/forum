"use strict";

window.onload = init;

function init() {
   refreshItemsWithFilters();
    $("#filter-form").submit(function(e){
      e.preventDefault();
      refreshItemsWithFilters();
    });
}

function refreshItemsWithFilters(){
    $('#pagination').pagination({
        dataSource: `/api/items?${buildParamsFromFilterForm()}`,
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

function buildParamsFromFilterForm(){
    let params = '';
    $('#filter-form input, #filter-form select').each(
        function(index){
            var input = $(this);
            if(input.val() != "" && input.val() != undefined){
                if (params.length > 1){
                    params = params + '&';
                }
                params = params + `${this.id}=${input.val()}`;
            }
        }
    );

   return params;
}


function refreshAllElements(items){
    let itemsList = $('#itemList');
    itemsList.empty();
    for (var i = 0; i < items.length; i++) {
        itemsList.append(createItemElement(items[i]));
    }
}

function createItemElement(item){
    let itemElement = $.parseHTML(`<div class="item col-3"><div class="card"><img class="card-img-top" src="${item.imagePath}" alt="Card image cap"><div class="card-body"><h5 class="card-title">${item.name}</h5><p class="card-text">Price: ${item.price}</p><p class="card-text">Category: ${item.category}</p><a href="#" class="btn btn-primary add-to-cart">Add to cart</a></div></div></div>`);

    let token = $("meta[name='_csrf_token']").attr("content");
    $(itemElement).find('.add-to-cart').click(function() {
        $.ajax({
            url: `/api/carts/add?itemId=${item.id}`,
            headers: {
               'X-CSRF-TOKEN': token,
            },
            method: 'POST',
            dataType: 'json',
            success: function(data){
                alert('Добавлено');
                refreshCartFromServer();
            }
        });
    });

    return itemElement;
}