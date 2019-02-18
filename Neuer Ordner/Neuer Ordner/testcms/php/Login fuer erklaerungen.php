?>
<!DOCTYPE html> 
<html> 
<head>
  <title>Login</title>    
</head> 
<body>
 
<?php 
if(isset($errorMessage)) {
    echo $errorMessage;
}
?>
 
<form action="?login=1" method="post">
username:<br>
<input type="username" size="40" maxlength="250" name="username"><br><br>
 
password:<br>
<input type="password" size="40"  maxlength="250" name="password"><br>
 
<input type="submit" value="Abschicken">
</form> 
</body>
</html>

<?php 
session_start();
//Verbindung aufbauen
$pdo = new PDO('mysql:host=localhost;dbname=testcms', 'root', '');
 
if(isset($_GET['login'])) {
	//eingegebene userdaten abspeichern
    $username = $_POST['username'];
    $password = $_POST['password'];
    
	//prepare gibt die auszuführende sql syntax an
    $statement = $pdo->prepare("SELECT * FROM users WHERE username = :username");
	//execute führt sql syntax aus
    $statement->execute(array('username' => $username));
	//user bekommt die ergebnisse
    $user = $statement->fetch();
        
    //user existiert (username wurde gefunden) und passwort stimmt überein
    if ($user !== false && ($password == $user['password'])) {
		//gib userid weiter und leite weiter
        $_SESSION['userid'] = $user['id'];
		die('Login erfolgreich. Weiter zu <a href="Index.php">internen Bereich</a>');
    } else {
        $errorMessage = "E-Mail oder Passwort war ungültig<br>";
    }
}
