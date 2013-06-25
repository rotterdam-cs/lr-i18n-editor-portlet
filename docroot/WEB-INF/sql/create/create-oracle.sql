drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;



create index IX_EE40F8CC on editor_MessageSource (bundle);
create index IX_57BC1CAA on editor_MessageSource (key_);
create index IX_784255F8 on editor_MessageSource (key_, locale);
create index IX_5DE2996E on editor_MessageSource (key_, locale, bundle);



quit