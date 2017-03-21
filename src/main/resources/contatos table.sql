CREATE TABLE `agenda`.`contatos` 
( `id` BIGINT NOT NULL AUTO_INCREMENT , 
`nome` VARCHAR(256) NOT NULL , 
`telefone` VARCHAR(256) NOT NULL , 
`celular` VARCHAR(256) NULL , 
`endereco` VARCHAR(256) NULL , 
PRIMARY KEY (`id`)) ENGINE = InnoDB;