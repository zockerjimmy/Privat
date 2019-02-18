CREATE TABLE IF NOT EXISTS resources(
 id int unsigned NOT NULL AUTO_INCREMENT,
 resource_name varchar(60) NOT NULL,
 resource_location varchar(60) NOT NULL,
 created datetime NOT NULL,
 PRIMARY KEY(id))
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;