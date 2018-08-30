<!DOCTYPE html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <title>add user</title>
</head>



<body class="light-grey">
    <div class="container-fluid">
    <div class="row">
        <div  class="col-sm-2"></div>
        <div class="col-sm-8 text-center">
            <div class="card">

              <h5 class="card-header info-color white-text text-center py-4">
                <strong>Add User</strong>
              </h5>

              <!--Card content-->
              <div class="card-body px-lg-5 pt-0">

                <!-- Form -->
                <form class="text-center" style="color: #4285f4;" enctype="multipart/form-data" method="POST" action="addUser">

                  <!-- Email -->
                  <div class="md-form">
                    <input type="text" id="materialLoginFormQuestion" placeholder="username" class="form-control" name="username"  required>
                    <label for="materialLoginFormQuestion"></label>
                  </div>

                  <div class="md-form">
                    <input type="password" id="materialLoginFormQuestion" placeholder="password" class="form-control" name="password"  required>
                    <label for="materialLoginFormQuestion"></label>
                  </div>

                  <div class="md-form">
                    <input type="text" id="materialLoginFormQuestion" placeholder="role" class="form-control" name="role"  required>
                    <label for="materialLoginFormQuestion"></label>
                  </div>
                     
                  <!-- Sign in button -->
                  <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Add question</button>
                </form>
                <!-- Form -->

              </div>

            </div>
            <!-- Material form login -->
        </div>
    </div>
    </div>
    <script src="js/admin.js"></script>
</body>

