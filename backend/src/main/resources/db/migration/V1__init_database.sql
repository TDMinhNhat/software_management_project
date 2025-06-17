create table UserRole
(
    id         bigint auto_increment primary key,
    role_name  nvarchar(50) not null unique,
    status     bit          not null default 1,
    created_at timestamp    not null default current_timestamp
);

create table TypeSoftware
(
    id          bigint auto_increment primary key,
    type_name   nvarchar(50) not null unique,
    description nvarchar(500),
    status      bit          not null default 1,
    created_at  timestamp    not null default current_timestamp
);

create table HashTag
(
    id          bigint auto_increment primary key,
    tag_name    nvarchar(50) not null unique,
    description nvarchar(500),
    status      bit          not null default 1,
    created_at  timestamp    not null default current_timestamp
);

create table User
(
    id           bigint auto_increment primary key,
    uuid         char(36)                                 not null unique,
    first_name   nvarchar(50)                             not null,
    last_name    nvarchar(50)                             not null,
    sex          bit                                      not null,
    birth_date   date                                     not null,
    phone_number nvarchar(20)                             not null unique,
    address      nvarchar(500),
    username     nvarchar(50)                             not null unique,
    email        nvarchar(200)                            not null unique,
    password     nvarchar(200)                            not null,
    role_id      bigint                                   not null,
    created_at   timestamp                                not null default current_timestamp,
    updated_at   timestamp                                not null default current_timestamp on update current_timestamp,
    status       enum ('ACTIVE', 'BLOCK_TEMP', 'DELETED') not null default 'ACTIVE',
    foreign key (role_id) references UserRole (id) on delete cascade on update cascade
);

create table Software
(
    id           bigint auto_increment primary key,
    soft_id      nvarchar(50)   not null unique,
    title        nvarchar(200)  not null,
    description  nvarchar(1000) not null,
    storage_name nvarchar(200)  not null unique,
    soft_type_id bigint         not null,
    author_id    bigint         not null,
    price        decimal(10, 2) not null default 100.00,
    created_at   timestamp      not null default current_timestamp,
    updated_at   timestamp      not null default current_timestamp on update current_timestamp,
    status       bit            not null default 1,
    foreign key (soft_type_id) references TypeSoftware (id) on delete cascade on update cascade,
    foreign key (author_id) references User (id) on delete cascade on update cascade
);

create table `Order`
(
    id         bigint auto_increment primary key,
    cust_id    bigint                                    not null,
    soft_id    bigint                                    not null,
    order_date timestamp                                 not null default current_timestamp,
    status     enum ('PENDING', 'COMPLETED', 'CANCELED') not null default 'PENDING',
    foreign key (cust_id) references User (id) on delete cascade on update cascade,
    foreign key (soft_id) references Software (id) on delete cascade on update cascade
);

create table SoftwareHashTag
(
    soft_id    bigint    not null,
    tag_id     bigint    not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp on update current_timestamp,
    status     bit       not null default 1,
    primary key (soft_id, tag_id),
    foreign key (soft_id) references Software (id) on delete cascade on update cascade,
    foreign key (tag_id) references HashTag (id) on delete cascade on update cascade
);
