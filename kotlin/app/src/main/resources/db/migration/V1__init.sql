create table network
(
    id varchar(256) primary key
);

create table clique
(
    id         varchar(256) primary key,
    network_id varchar(256) not null,
    constraint fk_clique_network_id foreign key (network_id)
        references network (id)
        on delete cascade
);

create table member
(
    id        varchar(256) primary key,
    clique_id varchar(256) not null,
    constraint fk_member_clique_id foreign key (clique_id)
        references clique (id)
        on delete cascade
);