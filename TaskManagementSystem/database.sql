SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE public.note (
    id integer NOT NULL,
    note text,
    task_id integer,
    user_id integer
);

ALTER TABLE public.note OWNER TO postgres;

CREATE SEQUENCE public.note_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.note_id_seq OWNER TO postgres;

ALTER SEQUENCE public.note_id_seq OWNED BY public.note.id;

CREATE TABLE public.role_data (
    id integer NOT NULL,
    role_name character varying(250)
);

ALTER TABLE public.role_data OWNER TO postgres;

CREATE SEQUENCE public.role_data_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.role_data_id_seq OWNER TO postgres;

ALTER SEQUENCE public.role_data_id_seq OWNED BY public.role_data.id;

CREATE TABLE public.task (
    id integer NOT NULL,
    task_name character varying(250),
    task_priority integer,
    task_status_id integer,
    user_id integer,
    author character varying(250),
    contractor character varying(250)
);

ALTER TABLE public.task OWNER TO postgres;

CREATE SEQUENCE public.task_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.task_id_seq OWNER TO postgres;

ALTER SEQUENCE public.task_id_seq OWNED BY public.task.id;

CREATE TABLE public.task_status (
    id integer NOT NULL,
    status character varying(255)
);

ALTER TABLE public.task_status OWNER TO postgres;

CREATE SEQUENCE public.task_status_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.task_status_id_seq OWNER TO postgres;

ALTER SEQUENCE public.task_status_id_seq OWNED BY public.task_status.id;

CREATE TABLE public.user_data (
    id integer NOT NULL,
    email character varying(250),
    password character varying(250),
    role_id integer
);

ALTER TABLE public.user_data OWNER TO postgres;

CREATE SEQUENCE public.user_data_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.user_data_id_seq OWNER TO postgres;

ALTER SEQUENCE public.user_data_id_seq OWNED BY public.user_data.id;

ALTER TABLE ONLY public.note ALTER COLUMN id SET DEFAULT nextval('public.note_id_seq'::regclass);

ALTER TABLE ONLY public.role_data ALTER COLUMN id SET DEFAULT nextval('public.role_data_id_seq'::regclass);

ALTER TABLE ONLY public.task ALTER COLUMN id SET DEFAULT nextval('public.task_id_seq'::regclass);

ALTER TABLE ONLY public.task_status ALTER COLUMN id SET DEFAULT nextval('public.task_status_id_seq'::regclass);

ALTER TABLE ONLY public.user_data ALTER COLUMN id SET DEFAULT nextval('public.user_data_id_seq'::regclass);

INSERT INTO public.note (id, note, task_id, user_id) VALUES (1, 'be careful', 1, 63);
INSERT INTO public.note (id, note, task_id, user_id) VALUES (2, 'extend the contract', 2, 64);

INSERT INTO public.role_data (id, role_name) VALUES (2, 'USER');
INSERT INTO public.role_data (id, role_name) VALUES (1, 'ADMIN');

INSERT INTO public.task (id, task_name, task_priority, task_status_id, user_id, author, contractor) VALUES (2, 'approve the scheme
', 8, 2, 63, 'Tom', 'Bob');
INSERT INTO public.task (id, task_name, task_priority, task_status_id, user_id, author, contractor) VALUES (1, 'meeting with team', 9, 1, 64, 'Sam', 'Ann');

INSERT INTO public.task_status (id, status) VALUES (1, 'in waiting');
INSERT INTO public.task_status (id, status) VALUES (2, 'in progress');
INSERT INTO public.task_status (id, status) VALUES (3, 'completed');

INSERT INTO public.user_data (id, email, password, role_id) VALUES (63, 'test@yandex.ru', '$2a$10$sZN3lbWVJwiG3vuushdZnuwoaJ9fUUPzK63vl2.2s6mBBrJKOaMgW', 2);
INSERT INTO public.user_data (id, email, password, role_id) VALUES (64, 'admin', 'admin', 1);

SELECT pg_catalog.setval('public.note_id_seq', 49, true);

SELECT pg_catalog.setval('public.role_data_id_seq', 4, true);

SELECT pg_catalog.setval('public.task_id_seq', 42, true);

SELECT pg_catalog.setval('public.task_status_id_seq', 3, true);

SELECT pg_catalog.setval('public.user_data_id_seq', 66, true);

ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.role_data
    ADD CONSTRAINT role_data_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.task_status
    ADD CONSTRAINT task_status_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.user_data
    ADD CONSTRAINT user_data_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.user_data
    ADD CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES public.role_data(id) NOT VALID;

ALTER TABLE ONLY public.note
    ADD CONSTRAINT task_id FOREIGN KEY (task_id) REFERENCES public.task(id) NOT VALID;

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_status_id FOREIGN KEY (task_status_id) REFERENCES public.task_status(id) NOT VALID;

ALTER TABLE ONLY public.note
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.user_data(id) NOT VALID;

ALTER TABLE ONLY public.task
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.user_data(id) NOT VALID;
