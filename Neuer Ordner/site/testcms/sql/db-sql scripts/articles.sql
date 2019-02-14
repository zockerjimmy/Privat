CREATE TABLE IF NOT EXISTS articles(
 id int unsigned NOT NULL AUTO_INCREMENT,
 article_id int unsigned NOT NULL,
 title varchar(600) NOT NULL,
 articletext TEXT NOT NULL,
 created datetime NOT NULL,
 resource_id int unsigned NOT NULL,
 PRIMARY KEY(id,article_id), UNIQUE (article_id),
 FOREIGN KEY(resource_id)
 REFERENCES resources(resource_id))
ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_german1_ci;

