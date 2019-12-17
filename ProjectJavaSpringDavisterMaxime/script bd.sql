create table chemin_traverse_localite(
    id integer primary key auto_increment,
	pays nvarchar(25) not null,
    localite nvarchar(25) not null,
    code_postal integer not null
);
create table chemin_traverse_utilisateur(
    id integer primary key auto_increment,
    
    username nvarchar(50) unique not null,
    password nvarchar(60) not null,
    non_expired boolean not null,
    non_locked boolean not null,
    credential_non_expired boolean not null,
    enabled boolean not null,
    
    maison int not null,
    sexe char not null,
    rue varchar(50) not null,
    numero integer not null,
    telephonne varchar(15) unique not null,
    mail varchar(255) unique not null,
    patronus varchar(25) 
);
create table chemin_traverse_commande(
    numero integer primary key Auto_increment,
    date date not null,
    foreign key (utilisateur) references chemin_traverse_utilisateur(id)
);
create table chemin_traverse_ligne(
	quantite integer not null,
    prix_unitaire decimal(11,2) not null,
    commande integer not null,
    
    foreign key (commande) references chemin_traverse_commande(numero)
);
create table chemin_traverse_produit(
    id integer primary key auto_increment,
    stock integer not null,
    prix_unitaire decimal(11,2) not null,
    image nvarchar(255)
);
create table chemin_traverse_langue(
    id integer primary key auto_increment,
    code_langue varchar(25) not null
);
create table chemin_traverse_traduction(
	nom nvarchar(255) not null,
    description text not null,
    langue integer not null,
    produit integer not null,
    
    foreign key (langue) references chemin_traverse_langue(id),
    foreign key (produit) references chemin_traverse_produit(id)
);

