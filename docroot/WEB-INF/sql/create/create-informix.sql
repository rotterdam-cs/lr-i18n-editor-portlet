database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;




create index IX_EE40F8CC on editor_MessageSource (bundle);
create index IX_57BC1CAA on editor_MessageSource (key_);
create index IX_784255F8 on editor_MessageSource (key_, locale);
create index IX_5DE2996E on editor_MessageSource (key_, locale, bundle);


