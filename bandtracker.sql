--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: band_venue; Type: TABLE; Schema: public; Owner: MW
--

CREATE TABLE band_venue (
    id integer NOT NULL,
    band_id integer,
    venue_id integer
);


ALTER TABLE band_venue OWNER TO "MW";

--
-- Name: band_venue_id_seq; Type: SEQUENCE; Schema: public; Owner: MW
--

CREATE SEQUENCE band_venue_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE band_venue_id_seq OWNER TO "MW";

--
-- Name: band_venue_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: MW
--

ALTER SEQUENCE band_venue_id_seq OWNED BY band_venue.id;


--
-- Name: bands; Type: TABLE; Schema: public; Owner: MW
--

CREATE TABLE bands (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE bands OWNER TO "MW";

--
-- Name: bands_id_seq; Type: SEQUENCE; Schema: public; Owner: MW
--

CREATE SEQUENCE bands_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bands_id_seq OWNER TO "MW";

--
-- Name: bands_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: MW
--

ALTER SEQUENCE bands_id_seq OWNED BY bands.id;


--
-- Name: venues; Type: TABLE; Schema: public; Owner: MW
--

CREATE TABLE venues (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE venues OWNER TO "MW";

--
-- Name: venues_id_seq; Type: SEQUENCE; Schema: public; Owner: MW
--

CREATE SEQUENCE venues_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE venues_id_seq OWNER TO "MW";

--
-- Name: venues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: MW
--

ALTER SEQUENCE venues_id_seq OWNED BY venues.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: MW
--

ALTER TABLE ONLY band_venue ALTER COLUMN id SET DEFAULT nextval('band_venue_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: MW
--

ALTER TABLE ONLY bands ALTER COLUMN id SET DEFAULT nextval('bands_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: MW
--

ALTER TABLE ONLY venues ALTER COLUMN id SET DEFAULT nextval('venues_id_seq'::regclass);


--
-- Data for Name: band_venue; Type: TABLE DATA; Schema: public; Owner: MW
--

COPY band_venue (id, band_id, venue_id) FROM stdin;
\.


--
-- Name: band_venue_id_seq; Type: SEQUENCE SET; Schema: public; Owner: MW
--

SELECT pg_catalog.setval('band_venue_id_seq', 1, false);


--
-- Data for Name: bands; Type: TABLE DATA; Schema: public; Owner: MW
--

COPY bands (id, name) FROM stdin;
\.


--
-- Name: bands_id_seq; Type: SEQUENCE SET; Schema: public; Owner: MW
--

SELECT pg_catalog.setval('bands_id_seq', 1, false);


--
-- Data for Name: venues; Type: TABLE DATA; Schema: public; Owner: MW
--

COPY venues (id, name) FROM stdin;
\.


--
-- Name: venues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: MW
--

SELECT pg_catalog.setval('venues_id_seq', 1, false);


--
-- Name: band_venue_pkey; Type: CONSTRAINT; Schema: public; Owner: MW
--

ALTER TABLE ONLY band_venue
    ADD CONSTRAINT band_venue_pkey PRIMARY KEY (id);


--
-- Name: bands_pkey; Type: CONSTRAINT; Schema: public; Owner: MW
--

ALTER TABLE ONLY bands
    ADD CONSTRAINT bands_pkey PRIMARY KEY (id);


--
-- Name: venues_pkey; Type: CONSTRAINT; Schema: public; Owner: MW
--

ALTER TABLE ONLY venues
    ADD CONSTRAINT venues_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: MW
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "MW";
GRANT ALL ON SCHEMA public TO "MW";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

