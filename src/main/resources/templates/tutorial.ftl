<#import "parts/common.ftl" as c>

<@c.page>

        <!-- Grid -->
        <div class="w3-row">

          <!-- Blog entries -->
          <div class="w3-col l8 s12" style="width:100%">
            <!-- Blog entry -->
            <div class="w3-card-4 w3-margin w3-white">
              <div class="w3-container">
                <h1><b>${heading}</b></h1>
                <h5><span class="w3-opacity">${date}</span></h5>
              </div>
              <#list modules as module>
                    <#if module.text>
                       <div class="w3-container" style="margin-top:20px;margin-bottom:20px">
                            <p>${module.shortText}</p>
                       </div>
                    </#if>
                    <#if module.image>
                    <div class="w3-container" style="margin-top:20px;margin-bottom:20px">
                        <img src="/static/uploads/${module.filename}" alt="Nature" style="width:100%">
                    </div>
                    </#if>
                    <#if module.code>
                    <div class="w3-container" style="margin-top:20px;margin-bottom:20px">
                        <div class="w3-container w3-light-grey" style="padding:60px 16px" id="contact">
                            ${module.shortText}
                        </div>
                    </div>
                    </#if>
                </#list>
                <div class="w3-row">
                  <div class="w3-col m8 s12" style="margin:20px">
                     <form method="get" action="/showNextTutorial/${nextOrderNumber}/${technology}/${status}">
                        <p><button class="w3-button w3-padding-large w3-white w3-border"><b>NEXT »</b></button></p>
                     </form>
                  </div>
                </div>
              </div>
            </div>
            <hr>

            <!-- END BLOG ENTRIES -->

          <!-- END GRID -->

</@c.page>