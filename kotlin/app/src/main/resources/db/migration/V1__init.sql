create table network
(
    id varchar(256) primary key
);

create table clique
(
    id         varchar(255) primary key,
    network_id varchar(255) not null,
    constraint fk_clique_network_id foreign key (network_id)
        references network (id)
        on delete cascade
);