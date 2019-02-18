<?php
session_start();
if(!isset($_SESSION['userid'])) {
    die('Bitte zuerst <a href="login.php">einloggen</a>');
}
 
//Abfrage der Nutzer ID vom Login
$userid = $_SESSION['userid'];
 
echo "Hallo User: ".$userid;
?>
<br/><br/><br/><br/>
<form action="?logout=1" method="post">
<input type="submit" value="Logout">
</form> 


<?php
if(isset($_GET['logout'])) {
	session_start();
	session_destroy();

 header("Location: Login.php");
  exit();
}
?>