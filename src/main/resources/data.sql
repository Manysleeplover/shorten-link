create table shorten_link.link (
       id bigserial not null,
        outer_link varchar(255),
        src_link varchar(255),
        created_at timestamp
    )