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
</head>
<body class="light-grey">
    <div class="container-fluid">
    <div class="row">
        <div  class="col-sm-2"></div>
        <div class="col-sm-8 text-center">
            <div class="card">

              <h5 class="card-header info-color white-text text-center py-4">
                <strong>Add question</strong>
              </h5>

              <!--Card content-->
              <div class="card-body px-lg-5 pt-0">

                <!-- Form -->
                <form class="text-center" style="color: #4285f4;" enctype="multipart/form-data" method="POST" action="addQuestion">

                  <!-- Email -->
                  <div class="md-form">
                    <input type="text" id="materialLoginFormQuestion" placeholder="Question" class="form-control" name="question"  required>
                    <label for="materialLoginFormQuestion"></label>
                  </div>
                      <select class="mdb-select colorful-select dropdown-primary" id="select-input" onchange="displayOptions()">
                        <option value="" disabled selected>Number of options</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                    </select>
                    <div class="md-form" id="option1">
                        <input type="text" placeholder="option1" class="form-control" name="option1"  required>
                        <label for="option1"></label>
                  </div>
                  <div class="md-form" id="option2">
                        <input type="text" placeholder="option2" class="form-control" name="option2"  required>
                        <label for="option2"></label>
                  </div>
                  <div class="md-form" id="option3">
                        <input type="text" placeholder="option3" class="form-control" name="option3"  required>
                        <label for="option3"></label>
                  </div>
                  <div class="md-form" id="option4">
                        <input type="text" placeholder="option4" class="form-control" name="option4"  required>
                        <label for="option4"></label>
                  </div>
                  <div class="md-form" id="option5">
                        <input type="text" placeholder="option5" class="form-control" name="option5"  required>
                        <label for="option5"></label>
                  </div>
                  <div class="md-form" id="option6">
                        <input type="text" placeholder="option6" class="form-control" name="option6"  required>
                        <label for="option6"></label>
                  </div>
                  <div class="md-form" id="option7">
                        <input type="text" placeholder="option7" class="form-control" name="option7"  required>
                        <label for="option7"></label>
                  </div>
                  <div class="md-form" id="option8">
                        <input type="text" placeholder="option8" class="form-control" name="option8"  required>
                        <label for="option8"></label>
                  </div>
                  <div class="md-form" id="answer">
                        <input type="text" placeholder="Answer" class="form-control" name="question"  required>
                        <label for="answer"></label>
                  </div>
                <label class="btn-bs-file btn btn-info">
                Browse question image
                <input type="file" name="image" accept="image/*/>
            </label>
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