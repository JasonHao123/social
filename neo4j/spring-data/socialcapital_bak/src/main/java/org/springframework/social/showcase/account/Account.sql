create table Account (id identity,
						username varchar unique,
						password varchar not null,
						firstName varchar not null, 
						lastName varchar not null,
						primary key (id));
						
create table Friend (userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	primary key (userId, providerId, providerUserId));
create unique index FriendRank on UserConnection(userId, providerId, rank);