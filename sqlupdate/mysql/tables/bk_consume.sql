--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`bk_consume` DROP PRIMARY KEY;

DROP TABLE `game`.`bk_consume`;

CREATE TABLE `game`.`bk_consume` (
	`id` INT NOT NULL,
	`uid` INT,
	`deskId` INT,
	`gid` INT,
	`account` BIGINT,
	`lastdate` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP',
	`remark` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

