CREATE TABLE IF NOT EXISTS users(
 id int unsigned NOT NULL AUTO_INCREMENT,
 username varchar(60) NOT NULL,
 password varchar(60) NOT NULL,
 created datetime NOT NULL,
 PRIMARY KEY(id))
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

INSERT INTO users (id, username, password, created)
VALUE (1, 'Admin', 'admin', Now()),
	  (2, 'guest', '1234', Now());
	  
	  
	  
	  
	  
	  
	  
	  
	  
<?php/*
$pdo = new PDO('mysql:host=localhost;dbname=testcms', 'root', '');

$sql = "SELECT * FROM users";
foreach ($pdo->query($sql) as $row)
{
	echo $row['username']."<br/>";
	echo $row['password']."<br/><br/>";
}*/
?>