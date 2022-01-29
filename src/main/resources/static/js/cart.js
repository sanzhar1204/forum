refreshCartFromServer();

function refreshCartFromServer(){
    $.get('/api/carts', function(data) {
        refreshAllCartItemsElements(data);
    }).fail(function(response) {
        if  (response.status == 401) {
            writeInsteadOfCartElements('Что бы пользоваться корзиной, вам необходимо авторизоваться');
        } else {
            writeInsteadOfCartElements('Произошла временная ошибка работы сервера, попробуй позже');
        }
    });
}

function writeInsteadOfCartElements(text){
     let itemsList = $('#cart-item-container');
     itemsList.empty();
     itemsList.text(text);
}

function refreshAllCartItemsElements(cartItems){
    let itemsList = $('#cart-item-container');
    itemsList.empty();
    for (var i = 0; i < cartItems.length; i++) {
        itemsList.append(createCartItemElement(cartItems[i]));
    }
    if (cartItems.length > 0){
        $('#order-button').show();
    } else {
        $('#order-button').hide();
    }
}

function createCartItemElement(cartItem){
    let cartElement = $.parseHTML(`<div class="row border-top border-bottom"><div class="row main align-items-center"><div class="col-2"><img class="img-fluid" src="${cartItem.item.imagePath}"></div><div class="col"><div class="row text-muted">${cartItem.item.name}</div></div><div class="col"> <a href="#" class="cart-decrease-item-count">-</a><a href="#" class="border cart-item-count">${cartItem.count}</a><a class="cart-increase-item-count" href="#">+</a> </div><div class="col">${cartItem.item.price} Тг. <a href = "#" class="delete"><span>&#10005;</span></div></a></div></div>`);
    let token = $("meta[name='_csrf_token']").attr("content");

    $(cartElement).find('.cart-decrease-item-count').click(function() {
       let newCartItemCount = cartItem.count - 1;
       $.ajax({
           url: `/api/carts?itemId=${cartItem.item.id}&newCount=${newCartItemCount}`,
           headers: {
               'X-CSRF-TOKEN': token,
           },
           method: 'POST',
           dataType: 'json',
           success: function(data){
                refreshAllCartItemsElements(data);
           }
         });
    });

      $(cartElement).find('.cart-increase-item-count').click(function() {
          let newCartItemCount = cartItem.count + 1;
          $.ajax({
              url: `/api/carts?itemId=${cartItem.item.id}&newCount=${newCartItemCount}`,
              headers: {
                  'X-CSRF-TOKEN': token,
              },
              method: 'POST',
              dataType: 'json',
              success: function(data){
                   refreshAllCartItemsElements(data);
              }
            });
       });

      $(cartElement).find('.delete').click(function() {
          $.ajax({
              url: `/api/carts?itemId=${cartItem.item.id}&newCount=0`,
              headers: {
                  'X-CSRF-TOKEN': token,
              },
              method: 'POST',
              dataType: 'json',
              success: function(data){
                   refreshAllCartItemsElements(data);
              }
            });
       });

    return cartElement;
}