create table editor_MessageSource (
	key_ STRING not null,
	locale VARCHAR(75) not null,
	value STRING null,
	bundle VARCHAR(75) null,
	primary key (key_, locale)
);