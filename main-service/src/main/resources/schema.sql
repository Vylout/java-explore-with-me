CREATE TABLE IF NOT EXISTS categories (
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS users (
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    email VARCHAR(254) UNIQUE NOT NULL,
    name  varchar(250) NOT NULL
);


CREATE TABLE IF NOT EXISTS locations (
    id  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    lat REAL UNIQUE NOT NULL,
    lon REAL UNIQUE NOT NULL
);

create table IF NOT EXISTS events (
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    annotation         VARCHAR(2000) NOT NULL,
    category_id        BIGINT REFERENCES categories (id) NOT NULL,
    created_on         TIMESTAMP NOT NULL,
    description        VARCHAR(7000) NOT NULL,
    event_date         TIMESTAMP NOT NULL,
    initiator_id       BIGINT REFERENCES users (id) NOT NULL,
    location_id        BIGINT REFERENCES locations (id) NOT NULL,
    paid               BOOLEAN NOT NULL,
    participant_limit  INTEGER NOT NULL,
    published_on       TIMESTAMP,
    request_moderation BOOLEAN NOT NULL,
    state              VARCHAR(255) NOT NULL,
    title              VARCHAR(120) NOT NULL
);

CREATE TABLE IF NOT EXISTS requests (
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    created      TIMESTAMP NOT NULL,
    event_id     BIGINT REFERENCES events (id),
    requester_id BIGINT REFERENCES users (id),
    status       VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS compilations (
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    pinned BOOLEAN NOT NULL,
    title  VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS compilations_events (
    event_id       BIGINT REFERENCES events (id),
    compilation_id BIGINT REFERENCES compilations (id),
    PRIMARY KEY (event_id, compilation_id)
);