<#import "parts/commonadmin.ftl" as c>

<@c.pageadmin>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Module
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data" action="/addNewModule/${id}">
            <div class="form-group">
               <input type="checkbox" name="isText"/>isText
            </div>
           <div class="form-group">
               <input type="checkbox" name="isImage"/>isImage
            </div>
           <div class="form-group">
               <input type="checkbox" name="isCode"/>isCode
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="text" placeholder="Text" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="orderNumber" placeholder="Order number">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list modules as module>
    <div class="card my-3">
        <#if module.text>
        <div class="m-2">
            <span>Is text</span>
        </div>
        </#if>
        <#if module.image>
        <div class="m-2">
            <span>Is image</span>
        </div>
        </#if>
        <#if module.code>
        <div class="m-2">
            <span>Is code</span>
        </div>
        </#if>
        <div class="m-2">
            <span>Order number: ${module.orderNumber}</span>
        </div>
        <div class="m-2">
            <span>${module.shortText}</span>
        </div>
        <#if module.filename??>
        <div class="m-2">
            <span>${module.filename}</span>
        </div>
        </#if>
        <div class="card-footer text-muted">
            <a href="/deleteModule/${module.id}"><p>Delete</p></a>
        </div>
    </div>
    <#else>
    No modules
    </#list>
</div>
</@c.pageadmin>