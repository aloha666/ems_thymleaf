create table t_user(
                       id varchar(40) primary key,
                       username varchar(40),
                       realname varchar(40),
                       password varchar(40),
                       sex varchar(8)
);

create table t_emp(
                      id varchar(40) primary key,
                      name varchar(40),
                      salary double(7,2),
                      workyear int(3),
                      bir date
)

