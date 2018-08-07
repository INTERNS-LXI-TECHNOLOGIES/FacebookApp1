<!DOCTYPE html>
<head>
  <title>DisplayAll</title>
 
    <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <!-- Bootstrap core CSS -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
  </head>
  <body>

<!-- Material form login -->
<div class="col-sm-6"></div>
     <div class="col-sm-4">
<div class="card">
      
      

  <h5 class="card-header info-color white-text text-center py-4">
    <strong>Sign in</strong>
  </h5>

  <!--Card content-->
  <div class="card-body px-lg-5 pt-0">

    <!-- Form -->
    <form class="text-center" style="color: #757575;" action="j_security_check" method=post>

      <!-- username -->
      <div class="md-form">

        <input type="text" id="materialLoginForm" class="form-control" placeholder="UserName" name="j_username" required>
        
      </div>

      <!-- Password -->

      <div class="md-form">

        <input type="password" id="materialLoginFormPassword" class="form-control" placeholder="Password" name="j_password" required>
        
      </div>

      <div class="d-flex justify-content-around">
        <div>
          <!-- Remember me -->
          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="materialLoginFormRemember">
            <label class="form-check-label" for="materialLoginFormRemember">Remember me</label>
          </div>
        </div>
        <div>
          <!-- Forgot password -->
          <a href="">Forgot password?</a>
        </div>
      </div>

      <!-- Sign in button -->
      <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>

      <!-- Register -->
      <p>Not a member?
        <a href="">Register</a>
      </p>

    </form>
    <!-- Form -->

  </div>

</div>
</div>
<!-- Material form login -->
</body>
</html>