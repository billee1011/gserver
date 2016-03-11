--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`gg_table` DROP PRIMARY KEY;

DROP TABLE `game`.`gg_table`;

CREATE TABLE `game`.`gg_table` (
	`id` INT NOT NULL,
	`euid` INT,
	`suid` INT,
	`wuid` INT,
	`nuid` INT,
	`gid` INT,
	`createtime` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

