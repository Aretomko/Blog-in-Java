<#import "parts/common.ftl" as c>

<@c.page>
    <!-- Grid -->
    <div class="w3-row">

      <!-- Blog entries -->
      <div class="w3-col l8 s12">
        <!-- Blog entry -->
        <#list fronts as front>
        <div class="w3-card-4 w3-margin w3-white">
          <img src="static/uploads/${front.filename}" alt="Nature" style="width:100%">
          <div class="w3-container">
            <h3><b>${front.heading}</b></h3>
            <h5><span class="w3-opacity">${front.dateOfPosting}</span></h5>
          </div>

          <div class="w3-container">
            <p>${front.shortDescription}</p>
            <div class="w3-row">
              <div class="w3-col m8 s12">
              <form method="get" action="/showTutorial/${front.id}">
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
      <div class="w3-col l4">
        <!-- About Card -->
        <div class="w3-card w3-margin w3-margin-top">
          <img src="/static/img/BBBCCCA5-3EE7-45EF-9B34-3B0DACBC339C.jpg" style="width:100%">
          <div class="w3-container w3-white">
            <h4><b>My Name</b></h4>
            <p>Just me, myself and I, exploring the universe of uknownment. I have a heart of love and a interest of
              lorem ipsum and mauris neque quam blog. I want to share my world with you.</p>
          </div>
        </div>
        <hr>

        <!-- Labels / tags -->
        <div class="w3-card w3-margin">
          <div class="w3-container w3-padding">
            <h4>Tags</h4>
          </div>
          <div class="w3-container w3-white">
              <p>
              <#list tags as tag>
                <a href="/findByTechnologyFromTeg/${tag}"><span class="w3-tag w3-black w3-margin-bottom">${tag}</span></a>
              </#list>
            </p>
          </div>
        </div>

        <!-- END Introduction Menu -->
      </div>

      <!-- END GRID -->


 </@c.page>