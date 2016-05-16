--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

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
-- Name: jupiter; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE jupiter (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE jupiter OWNER TO "Guest";

--
-- Name: jupiter_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE jupiter_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE jupiter_id_seq OWNER TO "Guest";

--
-- Name: jupiter_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE jupiter_id_seq OWNED BY jupiter.id;


--
-- Name: mars; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE mars (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE mars OWNER TO "Guest";

--
-- Name: mars_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE mars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mars_id_seq OWNER TO "Guest";

--
-- Name: mars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE mars_id_seq OWNED BY mars.id;


--
-- Name: mercury; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE mercury (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE mercury OWNER TO "Guest";

--
-- Name: mercury_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE mercury_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE mercury_id_seq OWNER TO "Guest";

--
-- Name: mercury_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE mercury_id_seq OWNED BY mercury.id;


--
-- Name: neptune; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE neptune (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE neptune OWNER TO "Guest";

--
-- Name: neptune_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE neptune_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE neptune_id_seq OWNER TO "Guest";

--
-- Name: neptune_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE neptune_id_seq OWNED BY neptune.id;


--
-- Name: pluto; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE pluto (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE pluto OWNER TO "Guest";

--
-- Name: pluto_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE pluto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pluto_id_seq OWNER TO "Guest";

--
-- Name: pluto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE pluto_id_seq OWNED BY pluto.id;


--
-- Name: saturn; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE saturn (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE saturn OWNER TO "Guest";

--
-- Name: saturn_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE saturn_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE saturn_id_seq OWNER TO "Guest";

--
-- Name: saturn_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE saturn_id_seq OWNED BY saturn.id;


--
-- Name: uranus; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE uranus (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE uranus OWNER TO "Guest";

--
-- Name: uranus_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE uranus_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE uranus_id_seq OWNER TO "Guest";

--
-- Name: uranus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE uranus_id_seq OWNED BY uranus.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying,
    email character varying,
    telephone character varying,
    latitude numeric,
    longitude numeric,
    user_time character varying
);


ALTER TABLE users OWNER TO "Guest";

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO "Guest";

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: venus; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE venus (
    id integer NOT NULL,
    date_time character varying,
    azimuth numeric,
    elevation numeric
);


ALTER TABLE venus OWNER TO "Guest";

--
-- Name: venus_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE venus_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE venus_id_seq OWNER TO "Guest";

--
-- Name: venus_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE venus_id_seq OWNED BY venus.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY jupiter ALTER COLUMN id SET DEFAULT nextval('jupiter_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY mars ALTER COLUMN id SET DEFAULT nextval('mars_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY mercury ALTER COLUMN id SET DEFAULT nextval('mercury_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY neptune ALTER COLUMN id SET DEFAULT nextval('neptune_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY pluto ALTER COLUMN id SET DEFAULT nextval('pluto_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY saturn ALTER COLUMN id SET DEFAULT nextval('saturn_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY uranus ALTER COLUMN id SET DEFAULT nextval('uranus_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY venus ALTER COLUMN id SET DEFAULT nextval('venus_id_seq'::regclass);


--
-- Data for Name: jupiter; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY jupiter (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: jupiter_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('jupiter_id_seq', 1, false);


--
-- Data for Name: mars; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY mars (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: mars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('mars_id_seq', 1, false);


--
-- Data for Name: mercury; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY mercury (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: mercury_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('mercury_id_seq', 1, false);


--
-- Data for Name: neptune; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY neptune (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: neptune_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('neptune_id_seq', 1, false);


--
-- Data for Name: pluto; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY pluto (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: pluto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('pluto_id_seq', 1, false);


--
-- Data for Name: saturn; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY saturn (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: saturn_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('saturn_id_seq', 1, false);


--
-- Data for Name: uranus; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY uranus (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: uranus_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('uranus_id_seq', 1, false);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY users (id, name, email, telephone, latitude, longitude, user_time) FROM stdin;
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- Data for Name: venus; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY venus (id, date_time, azimuth, elevation) FROM stdin;
\.


--
-- Name: venus_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('venus_id_seq', 1, false);


--
-- Name: jupiter_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY jupiter
    ADD CONSTRAINT jupiter_pkey PRIMARY KEY (id);


--
-- Name: mars_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY mars
    ADD CONSTRAINT mars_pkey PRIMARY KEY (id);


--
-- Name: mercury_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY mercury
    ADD CONSTRAINT mercury_pkey PRIMARY KEY (id);


--
-- Name: neptune_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY neptune
    ADD CONSTRAINT neptune_pkey PRIMARY KEY (id);


--
-- Name: pluto_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY pluto
    ADD CONSTRAINT pluto_pkey PRIMARY KEY (id);


--
-- Name: saturn_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY saturn
    ADD CONSTRAINT saturn_pkey PRIMARY KEY (id);


--
-- Name: uranus_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY uranus
    ADD CONSTRAINT uranus_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: venus_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY venus
    ADD CONSTRAINT venus_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

