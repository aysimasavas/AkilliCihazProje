--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

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

--
-- Name: Kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Kullanici" (
    id integer NOT NULL,
    "userName" character varying(100),
    password character varying(50)
);


ALTER TABLE public."Kullanici" OWNER TO postgres;

--
-- Name: Sogutucu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Sogutucu" (
    id integer,
    sicaklik double precision,
    "isOpen" boolean
);


ALTER TABLE public."Sogutucu" OWNER TO postgres;

--
-- Data for Name: Kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Kullanici" VALUES (0, 'ayse', '1234');


--
-- Data for Name: Sogutucu; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Sogutucu" VALUES (NULL, NULL, false);
INSERT INTO public."Sogutucu" VALUES (NULL, NULL, true);
INSERT INTO public."Sogutucu" VALUES (1, 31, false);


--
-- Name: Kullanici Kullanici_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanici"
    ADD CONSTRAINT "Kullanici_pkey" PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

