create table messages1 (
    id bigserial not null
        constraint messages_pk
			primary key,
	src bigint not null,
	dst bigint not null,
	text varchar
);
