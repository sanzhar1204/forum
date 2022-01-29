<#import "partials/main.ftlh" as main>

<@main.renderWith scripts=["/js/all-items.js"]>
<div class="row">
    <div class="col-9">
        <div class="row" id="itemList">
        </div>
    </div>
    <div class="col-3 filter-form-container">
        <form id="filter-form">
            <div class="form-group row">
                <label for="name" class="col-12 col-form-label">Название</label>
                <div class="col-12">
                    <input type="text" class="form-control" id="name" placeholder="Название">
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-12  col-form-label">Описание</label>
                <div class="col-12 ">
                    <input type="text" class="form-control" id="description" placeholder="Описание">
                </div>
            </div>
            <div class="form-group row">
                <label for="count" class="col-12  col-form-label">Количество</label>
                <div class="col-12 ">
                    <input type="text" class="form-control" id="count" placeholder="Количество">
                </div>
            </div>
            <div class="form-group row">
                <label for="fromPrice" class="col-12 col-form-label">Цена от</label>
                <div class="col-12">
                    <input type="text" class="form-control" id="fromPrice" placeholder="Цена от">
                </div>
            </div>
            <div class="form-group row">
                <label for="toPrice" class="col-12 col-form-label">Цена до</label>
                <div class="col-12">
                    <input type="text" class="form-control" id="toPrice" placeholder="Цена до">
                </div>
            </div>
            <div class="form-group row">
                <label for="category" class="col-12  col-form-label">Категория</label>
                <select class="col-12 form-select" id="category">
                    <option selected disabled>Выберите категорию</option>
                    <option value="MOBILE_PHONE">MOBILE_PHONE</option>
                    <option value="LAPTOP">LAPTOP</option>
                    <option value="DESKTOP">DESKTOP</option>
                    <option value="STORAGE_DEVICES">STORAGE_DEVICES</option>
                    <option value="COMPUTER_NETWORKING">COMPUTER_NETWORKING</option>
                    <option value="PHOTO_VIDEO">PHOTO_VIDEO</option>
                </select>
            </div>
            <div class="form-group row">
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Применить фильтер</button>
                </div>
            </div>
        </form>
    </div>
</div>
<nav class="navbar fixed-bottom" id="pagination">
</nav>
</@main.renderWith>