<#macro page>
<!DOCTYPE html>
<html lang="en">
   <title>Young Blog</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <style>
     body,
     h1,
     h2,
     h3,
     h4,
     h5 {
       font-family: "Raleway", sans-serif
     }
     @media (max-width: 500px){.w3-black{font-size:10px;}}
   </style>
<body class="w3-light-grey" style="font-size:18px;">
<#include "navbar.ftl">

  <div class="w3-content" style="max-width:1400px">

    <!-- Header -->
    <header class="w3-container w3-center w3-padding-32" style="padding-top: 80px!important;">
      <h1><b>YOUNG BLOG</b></h1>
      <p>Welcome to the blog for <span class="w3-tag">young and clever</span></p>
    </header>
<#nested>
   </div><br>
        <footer class="w3-content w3-padding-64 w3-text-grey w3-xlarge" style="max-width:100%">
          <div style="margin:20px">
            <a href="https://www.facebook.com/groups/267645804179728"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
            <a href="https://www.instagram.com/youngblogofprogrammres/"><i class="fa fa-instagram w3-hover-opacity"></i></a>
            <a href="https://www.linkedin.com/in/artem-romanenko-265b29174/"><i class="fa fa-linkedin w3-hover-opacity"></i></a>
            <a href="https://t.me/youngprogrammerblog"><i class="fa fa-telegram w3-hover-opacity"></i></a>
          </div>
          <!-- End footer -->
        </footer>

    <!-- END w3-content -->
  </div>
</body>
</html>
</#macro>
