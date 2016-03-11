--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `game`.`bk_recharge` DROP PRIMARY KEY;

DROP TABLE `game`.`bk_recharge`;

CREATE TABLE `game`.`bk_recharge` (
	`id` INT NOT NULL,
	`uid` INT,
	`account` BIGINT,
	`muid` INT,
	`rmb` DECIMAL(10 , 2),
	`lastdate` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

