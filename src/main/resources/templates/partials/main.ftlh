<#macro renderWith title="Welcome to TechShop! Your one stop shop to purchase item!" scripts=[] styles=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <meta name="_csrf_token" content="${_csrf.token}"/>

        <title>${title}</title>

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="/js/cart.js"></script>
        <script type="text/javascript" src="https://pagination.js.org/dist/2.1.5/pagination.min.js"></script>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="/css/pagination.css">
        <link rel="stylesheet" href="/css/main.css">
        <link rel="stylesheet" href="/css/cart.css">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog">
        <div class="card cart-container modal-dialog" role="document">
            <div class="row modal-content">
                <div class="cart">
                    <div class="title">
                        <div class="row">
                            <div class="col">
                                <h4><b>Shopping Cart</b></h4>
                            </div>
                        </div>
                    </div>
                    <div id="cart-item-container">
                    </div>
                    <div class="back-to-shop" ><a href="#" data-dismiss="modal">&leftarrow;<span class="text-muted">Back to shop</span></a></div>
                    <div id="order-container"></div>
                    <form action="/orders" method="post">
                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <button type="submit" id="order-button" class="btn btn-primary hide" style="display: none;" >Оформить заказ</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#" id="cart-button"  data-toggle="modal" data-target="#exampleModal"><i class="fas fa-shopping-cart fa-2x"></i></a>
        <a class="navbar-brand ml-auto" href="/users/login">Вход</a>
        <a class="navbar-brand" href="/users/register">Регистрация</a>
        <form action="/logout" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <button class="navbar-brand btn btn-link" type="submit">Выйти </button>
        </form>
    </nav>

    <div class="container-fluid">
        <#nested>
    </div>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>

</#macro>