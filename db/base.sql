--
-- PostgreSQL database dump
--

-- Started on 2013-09-02 00:30:54

SET statement_timeout = 0;
SET client_encoding = 'WIN1251';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 140 (class 1259 OID 16386)
-- Dependencies: 3
-- Name: data; Type: TABLE; Schema: public; Owner: pavel; Tablespace: 
--

CREATE TABLE data (
    id integer NOT NULL,
    login character varying,
    password character varying,
    code integer
);


ALTER TABLE public.data OWNER TO pavel;

--
-- TOC entry 141 (class 1259 OID 16392)
-- Dependencies: 3
-- Name: roles; Type: TABLE; Schema: public; Owner: pavel; Tablespace: 
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.roles OWNER TO pavel;

--
-- TOC entry 142 (class 1259 OID 16398)
-- Dependencies: 3
-- Name: users; Type: TABLE; Schema: public; Owner: pavel; Tablespace: 
--

CREATE TABLE users (
    code integer NOT NULL,
    name character varying,
    phone integer,
    birth date,
    codrol integer
);


ALTER TABLE public.users OWNER TO pavel;

--
-- TOC entry 1788 (class 0 OID 16386)
-- Dependencies: 140
-- Data for Name: data; Type: TABLE DATA; Schema: public; Owner: pavel
--

INSERT INTO data (id, login, password, code) VALUES (1, 'user', 'password', 10);


--
-- TOC entry 1789 (class 0 OID 16392)
-- Dependencies: 141
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: pavel
--

INSERT INTO roles (id, name) VALUES (1, 'admin');
INSERT INTO roles (id, name) VALUES (2, 'user');


--
-- TOC entry 1790 (class 0 OID 16398)
-- Dependencies: 142
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: pavel
--

INSERT INTO users (code, name, phone, birth, codrol) VALUES (10, 'ivan', 5555555, '0019-02-03', 1);


--
-- TOC entry 1785 (class 2606 OID 16405)
-- Dependencies: 142 142
-- Name: codigo; Type: CONSTRAINT; Schema: public; Owner: pavel; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT codigo PRIMARY KEY (code);


--
-- TOC entry 1783 (class 2606 OID 16407)
-- Dependencies: 141 141
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: pavel; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1781 (class 2606 OID 16426)
-- Dependencies: 140 140
-- Name: p_id; Type: CONSTRAINT; Schema: public; Owner: pavel; Tablespace: 
--

ALTER TABLE ONLY data
    ADD CONSTRAINT p_id PRIMARY KEY (id);


--
-- TOC entry 1787 (class 2606 OID 16410)
-- Dependencies: 141 142 1782
-- Name: codrol; Type: FK CONSTRAINT; Schema: public; Owner: pavel
--

ALTER TABLE ONLY users
    ADD CONSTRAINT codrol FOREIGN KEY (codrol) REFERENCES roles(id);


--
-- TOC entry 1786 (class 2606 OID 16420)
-- Dependencies: 142 140 1784
-- Name: fk_code; Type: FK CONSTRAINT; Schema: public; Owner: pavel
--

ALTER TABLE ONLY data
    ADD CONSTRAINT fk_code FOREIGN KEY (code) REFERENCES users(code);


--
-- TOC entry 1794 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: Павел
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "Павел";
GRANT ALL ON SCHEMA public TO "Павел";
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-09-02 00:30:55

--
-- PostgreSQL database dump complete
--

