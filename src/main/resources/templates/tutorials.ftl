<#import "parts/common.ftl" as c>

<@c.page>

    <!-- Grid -->
    <div class="w3-row">

      <!-- Blog entries -->
      <div class="w3-col l8 s12" style="width:100%">
        <!-- Blog entry -->
        <#list fronts as front>
        <div class="w3-card-4 w3-margin w3-white">
          <#if front.filename??>
            <img src="/static/uploads/${front.filename}" alt="Nature" style="width:100%">
          </#if>
          <div class="w3-container">
            <h3><b>${front.heading}</b></h3>
            <h5><span class="w3-opacity">${front.dateOfPosting}</span></h5>
          </div>

          <div class="w3-container">
            <p>${front.shortDescription}</p>
            <div class="w3-row">
              <div class="w3-col m8 s12">
                  <#if front.link??>
                  <form method="get" action="${front.link}">
                    <p><button class="w3-button w3-padding-large w3-white w3-border"><b>SUBSCRIBE »</b></button></p>
                  </form>
                  <#else>
                  <form method="get" action="/showTutorial/${front.id}">
                    <p><button class="w3-button w3-padding-large w3-white w3-border"><b>READ MORE »</b></button></p>
                  </form>
                  </#if>
              </div>
            </div>
          </div>
        </div>
        <hr>
        </#list>
        <!-- END BLOG ENTRIES -->
      </div>

      <!-- Introduction menu -->


      <!-- END GRID -->
 </@c.page>