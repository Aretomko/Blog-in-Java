<#import "parts/common.ftl" as c>

<@c.page>

    <!-- Grid -->
    <div class="w3-row">

      <!-- Blog entries -->
      <div class="w3-col l8 s12" style="width:100%">
        <!-- Blog entry -->
        <#list fronts as front>
        <div class="w3-card-4 w3-margin w3-white">
          <img src="/static/uploads/${front.filename}" alt="Nature" style="width:100%">
          <div class="w3-container">
            <h3><b>${front.heading}</b></h3>
            <h5>Title description, <span class="w3-opacity">April 7, 2014</span></h5>
          </div>

          <div class="w3-container">
            <p>${front.shortDescription}</p>
            <div class="w3-row">
              <div class="w3-col m8 s12">
                  <form method="get" action="/tutorials/${front.technology}">
                    <p><button class="w3-button w3-padding-large w3-white w3-border"><b>READ MORE »</b></button></p>
                  </form>
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