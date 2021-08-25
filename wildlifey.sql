--
-- PostgreSQL database dump
--

-- Dumped from database version 12.8 (Ubuntu 12.8-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.8 (Ubuntu 12.8-0ubuntu0.20.04.1)

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
-- Name: animals; Type: TABLE; Schema: public; Owner: moringa
--

CREATE TABLE public.animals (
    id integer NOT NULL,
    name character varying,
    strange boolean,
    health character varying,
    age character varying
);


ALTER TABLE public.animals OWNER TO moringa;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: moringa
--

CREATE SEQUENCE public.animals_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animals_id_seq OWNER TO moringa;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: moringa
--

ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;


--
-- Name: ranger; Type: TABLE; Schema: public; Owner: moringa
--

CREATE TABLE public.ranger (
    id integer NOT NULL,
    name character varying,
    contact integer,
    badgenumber integer
);


ALTER TABLE public.ranger OWNER TO moringa;

--
-- Name: ranger_id_seq; Type: SEQUENCE; Schema: public; Owner: moringa
--

CREATE SEQUENCE public.ranger_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ranger_id_seq OWNER TO moringa;

--
-- Name: ranger_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: moringa
--

ALTER SEQUENCE public.ranger_id_seq OWNED BY public.ranger.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: moringa
--

CREATE TABLE public.sightings (
    id integer NOT NULL,
    animalname character varying,
    sightlocation character varying,
    ranger character varying,
    spotted timestamp without time zone
);


ALTER TABLE public.sightings OWNER TO moringa;

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: moringa
--

CREATE SEQUENCE public.sightings_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sightings_id_seq OWNER TO moringa;

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: moringa
--

ALTER SEQUENCE public.sightings_id_seq OWNED BY public.sightings.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: moringa
--

ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);


--
-- Name: ranger id; Type: DEFAULT; Schema: public; Owner: moringa
--

ALTER TABLE ONLY public.ranger ALTER COLUMN id SET DEFAULT nextval('public.ranger_id_seq'::regclass);


--
-- Name: sightings id; Type: DEFAULT; Schema: public; Owner: moringa
--

ALTER TABLE ONLY public.sightings ALTER COLUMN id SET DEFAULT nextval('public.sightings_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: moringa
--

COPY public.animals (id, name, strange, health, age) FROM stdin;
\.


--
-- Data for Name: ranger; Type: TABLE DATA; Schema: public; Owner: moringa
--

COPY public.ranger (id, name, contact, badgenumber) FROM stdin;
\.


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: moringa
--

COPY public.sightings (id, animalname, sightlocation, ranger, spotted) FROM stdin;
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: moringa
--

SELECT pg_catalog.setval('public.animals_id_seq', 35, true);


--
-- Name: ranger_id_seq; Type: SEQUENCE SET; Schema: public; Owner: moringa
--

SELECT pg_catalog.setval('public.ranger_id_seq', 1, false);


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: moringa
--

SELECT pg_catalog.setval('public.sightings_id_seq', 36, true);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: moringa
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: ranger ranger_pkey; Type: CONSTRAINT; Schema: public; Owner: moringa
--

ALTER TABLE ONLY public.ranger
    ADD CONSTRAINT ranger_pkey PRIMARY KEY (id);


--
-- Name: sightings sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: moringa
--

ALTER TABLE ONLY public.sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

