create table editor_MessageSource (
	key_ VARCHAR(255) not null,
	locale VARCHAR(20) not null,
	value TEXT null,
	bundle VARCHAR(75) null,
	primary key (key_, locale)
);