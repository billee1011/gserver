--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`bk_account` DROP PRIMARY KEY;

DROP TABLE `game`.`bk_account`;

CREATE TABLE `game`.`bk_account` (
	`id` INT NOT NULL,
	`uid` INT,
	`account` BIGINT,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

