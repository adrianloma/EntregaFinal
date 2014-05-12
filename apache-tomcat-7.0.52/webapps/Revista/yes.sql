
create database revista;
use revista;

CREATE TABLE Cuenta(
	idCuenta INT auto_increment NOT NULL,
	CName VARCHAR(15) NOT NULL,
	Telefono VARCHAR(20) NOT NULL,
	Tipo CHAR(1) NOT NULL,
	Direccion VARCHAR(30) NOT NULL,
	Login VARCHAR(30) NOT NULL,
	Password VARCHAR(30) NOT NULL,
	PRIMARY KEY(idCuenta)
);


CREATE TABLE Revista(
	idRevista INT NOT NULL,
	NombreRevista VARCHAR(20) NOT NULL, 
	PRIMARY KEY(idRevista)
);

CREATE TABLE Edicion(
	fechaEdi DATETIME NOT NULL, 
	idEdicion INT auto_increment NOT NULL,
	DescripcionEdi VARCHAR(40) NOT NULL,
	idRevista INT NOT NULL,
	PRIMARY KEY (idEdicion),
	FOREIGN KEY (idRevista) REFERENCES Revista(idRevista)
);

CREATE TABLE Eventos(
	fechaEvento DATETIME NOT NULL, 
	PublicadoPor INT NOT NULL,
	idEvento INT auto_increment NOT NULL,
	descripcionEvento VARCHAR(50) NOT NULL,
	temaEvento VARCHAR(50) NOT NULL,
	PRIMARY KEY (idEvento),
	FOREIGN KEY (PublicadoPor) REFERENCES Cuenta(idCuenta)
);



CREATE TABLE Pago (
	idPago INT auto_increment NOT NULL,
	precio FLOAT NOT NULL,
	descuento FLOAT NOT NULL,
	metodoPago VARCHAR(20) NOT NULL,
	PTotal FLOAT NOT NULL,
	FechaPago DATETIME NOT NULL, 
	idCuenta INT NOT NULL,
	PRIMARY KEY (idPago),
	FOREIGN KEY (idCuenta) REFERENCES Cuenta(idCuenta)
);

CREATE TABLE Articulo (
	idArticulo INT auto_increment NOT NULL,
	nombreArticulo VARCHAR(30) NOT NULL,
	idEdicion INT,
	status enum ('sugerido', 'seleccionado', 'publicado'),
	textoArticulo TEXT NOT NULL,
	abstracto TEXT NOT NULL,
	Autores VARCHAR(90) NOT NULL,
	PRIMARY KEY(idArticulo),
	FOREIGN KEY (idEdicion) REFERENCES Edicion(idEdicion)
);

/*   insert */


#CUENTA
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password)  VALUES('Juez1' ,'83633294','J', 'Hacienda, Arroyo 114', 'juez1', 'juez1');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez2', '83634771','J', 'Garza Sada, 3094', 'juez2', 'juez2');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez3', '83631228','J', 'Teresa, 339', 'juez3', 'juez3');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez4', '83633600','J', 'Zaragoza, 1336', 'juez4', 'juez4');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez5', '83633293','J', 'Hacienda, Arroyo 113', 'juez5', 'juez5');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez6', '83636894','J', 'Terora, Arroyo 111', 'juez6', 'juez6');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez7', '86233294','J', 'Hacienda, Jeronimo 115', 'juez7', 'juez7');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Juez8', '83634781','J', 'Muralla 204', 'juez8', 'juez8');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Editor', '83634781','E', 'Muralla 204', 'editor', 'editor');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Suscriptor1', '81234567','S', 'editorial 123', 'suscriptor1', 'suscriptor1');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Suscriptor2', '81234567','S', 'editorial 123', 'suscriptor2', 'suscriptor2');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Suscriptor3', '81234567','S', 'editorial 123', 'suscriptor3', 'suscriptor3');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Suscriptor4', '81234567','S', 'editorial 123', 'suscriptor4', 'suscriptor4');
INSERT INTO Cuenta (cName, telefono, Tipo, Direccion, Login, Password) VALUES('Suscriptor5', '81234567','S', 'editorial 123', 'suscriptor5', 'suscriptor5');








#Eventos
INSERT INTO Eventos (fechaEvento, PublicadoPor, descripcionEvento, temaEvento) VALUES('2009-09-10', 11,'Tecnologia Internacional', 'Ecommerce');
INSERT INTO Eventos (fechaEvento, PublicadoPor, descripcionEvento, temaEvento) VALUES('2011-09-10', 11,'Tecnologia Dispositivos', 'Android');
INSERT INTO Eventos (fechaEvento, PublicadoPor, descripcionEvento, temaEvento) VALUES('2013-09-10', 12,'Tecnologia Computacional', 'MAC vs Win');
INSERT INTO Eventos (fechaEvento, PublicadoPor, descripcionEvento, temaEvento) VALUES('2012-09-10', 13,'Tecnologia Algoritmica', 'Quicksort');
INSERT INTO Eventos (fechaEvento, PublicadoPor, descripcionEvento, temaEvento) VALUES('2010-09-10', 12,'Tecnologia Nacional', 'Grandes emprendedores');

#Revista
INSERT INTO Revista VALUES(01, 'Tecnologia Mileno');

#Edicion
INSERT INTO Edicion (fechaEdi, DescripcionEdi, idRevista)  VALUES('2011-09-10', 'Dispositivos Moviles',01);
INSERT INTO Edicion (fechaEdi, DescripcionEdi, idRevista) VALUES('2010-09-10','Redes',01);
INSERT INTO Edicion (fechaEdi, DescripcionEdi, idRevista) VALUES('2009-09-10','Sistemas operativos audaces',01);
INSERT INTO Edicion (fechaEdi, DescripcionEdi, idRevista) VALUES('2012-09-10', 'Algoritmos',01);

#Pago
INSERT INTO Pago (precio, descuento, metodoPago, PTotal, FechaPago, idCuenta) VALUES(100, 0.20,'tarjeta',80,'2011-10-11',10);
INSERT INTO Pago (precio, descuento, metodoPago, PTotal, FechaPago, idCuenta)  VALUES(200, 0.20,'cheque',160,'2011-10-11',11);
INSERT INTO Pago (precio, descuento, metodoPago, PTotal, FechaPago, idCuenta)  VALUES(100, 0.30,'cash',70,'2011-10-11',11);

#Articulo
INSERT INTO Articulo (nombreArticulo, idEdicion, status, textoArticulo, abstracto, Autores) VALUES('Internet de Hoy', 01,'sugerido','La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias La comida es el conjunto de sustancias','La comida representa la fuente de vida del humano','Jesus Arellano y Maria Prieto');

INSERT INTO Articulo (nombreArticulo, idEdicion, status, textoArticulo, abstracto, Autores)  VALUES('Dispositivos Altruistas', 02,'seleccionado','nunca vamos a los gatos, si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si que si, oh si que si, oh si que si, oh si que si, oh si que si, oh si nunca vamos a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a los gatos, si que si, oh si que si, oh si que si, oh si que si, oh si nunca vamos a los gatos, si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si que si, oh si nunca vamos a los gatos, si nunca vamos a los gatos, si que si, oh si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si que si, oh si que si, oh si que si, oh si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a los gatos, si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si nunca vamos a los gatos, si nunca vamos a los gatos, si que si, oh si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si que si, oh si que si, oh si que si, oh si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a los gatos, si que si, oh si que si, oh si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si que si, oh si nunca vamos a poder comer arroz adentro de mi casa porque soy alergico a los gatos, si nunca vamos a poder comer arroz','la tecnologia es muy importante','Aquiles Aprieto y Daniel Zamacona');

INSERT INTO Articulo (nombreArticulo, idEdicion, status, textoArticulo, abstracto, Autores)  VALUES('Laptops gigantes' , 03,'publicado','algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si que si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir a al escuela c omer autn con los amigos para poder hacer mejores amsitades entre todos nosotros o h si algun dia deberiamos de ir','no hay que ir a la escuela los viernes','Gerardo Gomez y Daniel Lugo');

INSERT INTO Articulo (nombreArticulo, idEdicion, status, textoArticulo, abstracto, Autores)  VALUES('Algoritmos Voraces', 04,'seleccionado','porque no mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de la mejor vamos a tu casa despues de la mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de la mejor vamos a tu casa despues de palacio de la mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de la mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de la mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de la mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de la mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de la mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de la mejor vamos a tu casa despues de palacio de hierro para pdoer er unas pleiculas de la mejor vamos a tu casa despues de la mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de la mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de palacio de la mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de palacio de palacio de palacio de la mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de palacio de la mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de palacio de palacio de la mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de la mejor manera posible porque no mejor vamos a tu casa despues de hierro para pdoer er unas pleiculas de palacio de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de la mejor vamos a tu casa despues de palacio de palacio de hierro para pdoer er unas pleiculas de hierro para pdoer er unas pleiculas de la mejor manera posible porque no mejor manera posible porque no mejor vamos a tu casa despues de palacio de la mejor vamos a tu casa de','La tecnologia avanza de manera rapida estos dias','Ivan Diaz y Squirtle');

INSERT INTO Articulo (nombreArticulo, idEdicion, status, textoArticulo, abstracto, Autores) VALUES('Gigantes de la computacion', 03,'sugerido','Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno. Me gusta estar en mi casa y hornear palomitas para er peliculas todo el dia sin problema alguno.','No puede ser posible que este muerto','Gabriel Ugarte y Pikachu');


CREATE TABLE Nota(
	idNota INT auto_increment NOT NULL,
	TEXTO TEXT NOT NULL,
	TITULO VARCHAR(20) NOT NULL,
	status enum ('escrita', 'publicada'),
	idEdicion INT,
	PRIMARY KEY(idNota),
	FOREIGN KEY(idEdicion) REFERENCES Edicion(idEdicion)
);
	
INSERT INTO Nota (TEXTO, TITULO) VALUES('Meeeep, meeep', 'Meep');
