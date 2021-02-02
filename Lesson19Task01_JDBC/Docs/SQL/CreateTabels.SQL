---- Postgres v13 ----
---- SQL Create tables DB Shop ---- 


CREATE TABLE public."Users"
	("ID" SERIAL, 
 	"Name" VARCHAR(100),  
    "Login" VARCHAR(100),
    "Phone" VARCHAR(100),
    "ID_Adress" INTEGER
    );
    
CREATE TABLE public."Product"
	("ID" SERIAL, 
 	"Name" VARCHAR(100),  
    "Price" INTEGER,
    "Description" VARCHAR(500)
    );  
    
CREATE TABLE public."Orders"
	("ID" SERIAL, 
 	"ID_User" INTEGER,  
    "Delivery" SMALLINT,
    "SUM" INTEGER,
     Status SMALLINT
    );  
        
    
  