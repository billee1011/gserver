--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`wx_user` DROP PRIMARY KEY;

DROP TABLE `game`.`wx_user`;

CREATE TABLE `game`.`wx_user` (
	`id` INT NOT NULL,
	`wxcode` VARCHAR(100),
	`wxnick` VARCHAR(255),
	`remark` VARCHAR(255),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

