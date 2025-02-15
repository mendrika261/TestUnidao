DROP TABLE IF EXISTS region;

CREATE TABLE region (
                        region_id
                            primary key ,
                        region_description character varying(60) NOT NULL,
                        region_name character varying(60) NOT NULL
);

CREATE TABLE territorie (
                            territory_id serial primary key,
                            territory_description character varying(60) NOT NULL,
                            region_id integer NOT NULL references region(region_id)
);
