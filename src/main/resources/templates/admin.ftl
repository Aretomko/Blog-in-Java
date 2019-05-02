<#import "parts/commonadmin.ftl" as c>

<@c.pageadmin>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/admin" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Front
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data" action="/addFront">
            <div class="form-group">
                <input type="text" class="form-control" name="heading" placeholder="Type in the new heading" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="status" placeholder="home - main page, tutorial - tutorial page,">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="technology" placeholder="java - java tutorial, sql - sql tutorial">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="orderNumber" placeholder="Type in the number of palace it should be displayed" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="shortDescription" placeholder="Type in the news short description">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="link" placeholder="Type in the your contact link">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list fronts as front>
    <div class="card my-3">
        <div class="m-2">
            <span>${front.heading}</span>
        </div>
        <#if front.status??>
        <div class="m-2">
            <span>${front.status}</span>
        </div>
        </#if>
        <div class="m-2">
            <span>${front.shortDescription}</span>
        </div>
        <div class="m-2">
            <span>${front.dateOfPosting}</span>
        </div>
        <div class="m-2">
            <a href="/showModules/${front.id}">Components</a>
        </div>
        <#if front.filename??>
        <div class="m-2">
            <img src="/static/uploads/${front.filename}" class="card-img-top">
         </div>
        <div class="m-2">
            <span>${front.filename}</span>
         </div>
        </#if>
        <div class="card-footer text-muted">
            <a href="/deleteFront/${front.id}"><p>Delete</p></a>
        </div>
    </div>
    <#else>
    No fronts
    </#list>
</div>
</@c.pageadmin>