--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.4
-- Dumped by pg_dump version 9.2.4
-- Started on 2013-12-20 18:23:16

SET statement_timeout = 0;
SET client_encoding = 'WIN1251';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 169 (class 1259 OID 24621)
-- Name: roles; Type: TABLE; Schema: public; Owner: pavel; Tablespace: 
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.roles OWNER TO pavel;

--
-- TOC entry 170 (class 1259 OID 24627)
-- Name: users; Type: TABLE; Schema: public; Owner: pavel; Tablespace: 
--

CREATE TABLE users (
    code integer NOT NULL,
    name character varying,
    phone integer,
    birth date,
    codrol integer,
    login character varying(255),
    password character varying(255),
    enabled smallint DEFAULT 1 NOT NULL
);


ALTER TABLE public.users OWNER TO pavel;

--
-- TOC entry 1930 (class 0 OID 24621)
-- Dependencies: 169
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: pavel
--

COPY roles (id, name) FROM stdin;
2	USER
1	ADMIN
\.


--
-- TOC entry 1931 (class 0 OID 24627)
-- Dependencies: 170
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pavel
--

COPY users (code, name, phone, birth, codrol, login, password, enabled) FROM stdin;
12	www	6661	0003-02-19	1	\N	\N	1
11	vvv	555555221	0019-02-03	2	\N	\N	1
10	ivan	5555555	0019-02-03	2	user	password	1
\.


--
-- TOC entry 1928 (class 2606 OID 24634)
-- Name: codigo; Type: CONSTRAINT; Schema: public; Owner: pavel; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT codigo PRIMARY KEY (code);


--
-- TOC entry 1926 (class 2606 OID 24636)
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: pavel; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1929 (class 2606 OID 24639)
-- Name: codrol; Type: FK CONSTRAINT; Schema: public; Owner: pavel
--

ALTER TABLE ONLY users
    ADD CONSTRAINT codrol FOREIGN KEY (codrol) REFERENCES roles(id);


-- Completed on 2013-12-20 18:23:17

--
-- PostgreSQL database dump complete
--

