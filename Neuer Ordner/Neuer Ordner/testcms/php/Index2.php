<?php
session_start();
if(!isset($_SESSION['userid'])) {
    die('Bitte zuerst <a href="login.php">einloggen</a>');
}

//------------------------------------------------Logout----------------------------
	if(isset($_GET['logout'])) {
		session_start();
		session_destroy();
		header("Location: Login.php");
		 exit();
	}

//------------------------------------------------Upload----------------------------

	if(isset($_GET['upload']))
	{
		$error = false;
		$target_dir = "../resources/images/";
		$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
		$target_name = basename($_FILES["fileToUpload"]["name"]);
		$uploadOk = 1;
		$imageFileType = strtolower(pathinfo($target_file, PATHINFO_EXTENSION));
		if(isset($_POST["submit"])){
			$check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
			if($check !== false) {
				$uploadOk = 1;
			} else {
				echo "File is not an image.";
				$uploadOk = 0;
			}
		}
		// Check if file already exists
		if (file_exists($target_file)) {
			echo "Sorry, file already exists.";
			$uploadOk = 0;
		}
		// Check if $uploadOk is set to 0 by an error
		if ($uploadOk == 0) {
			echo "Sorry, your file was not uploaded.";
			$error = true;
		// if everything is ok, try to upload file
		} else {
			if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
				echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
			} else {
				echo "Sorry, there was an error uploading your file.";
			}
		}
	}
	if(isset($_GET['upload']) && $error !== true) 
	{
		$pdo = new PDO('mysql:host=localhost;dbname=testcms', 'root', '');
		$statement = $pdo->prepare("INSERT INTO resources (resource_name, resource_location, created) VALUES (:name, :location, Now())");
		$result = $statement->execute(array('name' => $target_name, 'location' => $target_dir));
		/*if($result){
			echo "erfolg";}*/	
	}

//------------------------------------------------Save Article----------------------------
	if(isset($_GET['save']))
	{
	$error = false;
	$uploadOk = 1;
	$texttosave = htmlentities($_POST['editor1']);
	$title = "test";
	//$res_id = Null;

	$pdo = new PDO('mysql:host=localhost;dbname=testcms', 'root', '');

	$statement = $pdo->prepare("INSERT INTO articles (title, articletext, created) VALUES (:title, :articletext, Now())");
	//$statement = $pdo->prepare("INSERT INTO articles (title, articletext, created, resource_id) VALUES(:title,'".mysql_real_escape_string($texttosave)."', :resource_id, Now())");
	//$result = $statement->execute(array('title' => $title, 'resource_id' => $res_id));
	$result = $statement->execute(array('title' => $title, 'articletext' => $texttosave));
	if($result){
		echo "erfolg";}
	else echo "nope";
	}
?>

<!---------------------------------------------------HTML---------------------------->
<!DOCTYPE html>
<html lang="de">
<!---------------------------------------------------Upload---------------------------->
	<form action="?upload=1" method="post" enctype="multipart/form-data">
		Select file to upload:
		<input type="file" name="fileToUpload" id="fileToUpload">
		<input type="submit" value="Upload" name="submit">
	</form>

	<br/>
<!---------------------------------------------------Article---------------------------->

    <head>
        <meta charset="utf-8">
        <script src="../ckeditor/ckeditor.js"></script>
    </head>
    <body>
        <form action="?save=1" method="post">
            <textarea name="editor1" id="editor1" rows="10" cols="80"></textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace('editor1');
            </script>
			<input type="submit" value="Speichern">
        </form>
    </body>


	<br/><br/><br/><br/>
<!---------------------------------------------------Logout---------------------------->
	<form action="?logout=1" method="post">
		<input type="submit" value="Logout">
	</form> 
</html>
