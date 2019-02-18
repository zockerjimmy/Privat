CREATE TABLE IF NOT EXISTS articles(
 id int unsigned NOT NULL AUTO_INCREMENT,
 title varchar(600) NOT NULL,
 articletext TEXT NOT NULL,
 created datetime NOT NULL,
 resource_id int unsigned NOT NULL,
 PRIMARY KEY(id),
 FOREIGN KEY(resource_id)
 REFERENCES resources(id))
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

CREATE TABLE IF NOT EXISTS articles(
 id int unsigned NOT NULL AUTO_INCREMENT,
 title varchar(600) NOT NULL,
 articletext TEXT NOT NULL,
 created datetime NOT NULL,
 PRIMARY KEY(id))
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;