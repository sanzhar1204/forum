<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=[]>
<div class="card cart-container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8 cart">
            <div class="title">
                <div class="row">
                    <div class="col">
                        <h4><b>Заказ с номером ${order.id}</b></h4>
                    </div>
                </div>
            </div>
            <#list order.items as orderItem>
            <div id="cart-item-container">
                <div class="row border-top border-bottom">
                    <div class="row main align-items-center">
                        <div class="col-2"><img class="img-fluid" src="${orderItem.item.imagePath}"></div>
                        <div class="col">
                            <div class="row text-muted">${orderItem.item.name}</div>
                        </div>
                        <div class="col">
                            <a href="#" class="border cart-item-count">${orderItem.count}</a>
                        </div>
                        <div class="col">${orderItem.item.price} Тг.
                        </div>
                    </div>
                </div>
            </div>
            </#list>
        </div>
    </div>
</div>
</@main.renderWith>