CREATE TABLE "EMPLOYEES" (
	"ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"NAME" VARCHAR(25) NOT NULL,
	"FIRSTNAME" VARCHAR(25) NOT NULL,
	"HOME_PHONE" VARCHAR(10) NOT NULL,
	"MOBILE_PHONE" VARCHAR(10) NOT NULL,
	"WORK_PHONE" VARCHAR(10) NOT NULL,
	"ADDRESS" VARCHAR(150) NOT NULL,
	"POSTAL_CODE" VARCHAR(5) NOT NULL,
	"CITY" VARCHAR(25) NOT NULL,
	"EMAIL" VARCHAR(25) NOT NULL,
	PRIMARY KEY (ID)
);

CREATE TABLE "LISTUSERS" (
	"ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"LOGIN" VARCHAR(25) NOT NULL,
	"PASSWORD" VARCHAR(25) NOT NULL,
	PRIMARY KEY (ID)
);

INSERT INTO EMPLOYEES(NAME,FIRSTNAME,HOME_PHONE,MOBILE_PHONE,WORK_PHONE,ADDRESS,POSTAL_CODE,CITY,EMAIL) VALUES
('Dairien','Vincent','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Laba','vdairien@gmail.com'),
('Gendron','Lou','0123459867','0645213265','0698765432','1 rue Noirmoutier','61200','Ici','jgendron@gmail.com'),
('Smith','Will','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Pluloin','wsmith@gmail.com'),
('Fattar','Ayman','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Nonla','afattar@gmail.com'),
('Merran','Leo','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Agoch','lmerran@gmail.com'),
('Dujardin','Jean','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Rekul','jdujardin@gmail.com'),
('Jenveu','Enquore','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Adrouate','ejenveu@gmail.com'),
('Touhjour','Plusse','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Encorunpeu','ptouhjour@gmail.com'),
('Anne','Cheval','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Presk','canne²@gmail.com'),
('Clavier','Christian','0123456789','0612345678','0698765432','1 rue Noirmoutier','61200','Hariver','cclavier@gmail.com');

INSERT INTO LISTUSERS(LOGIN,PASSWORD) VALUES
('admin','admin');
