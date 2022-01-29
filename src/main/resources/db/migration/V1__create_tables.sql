CREATE TABLE public.users (
    id SERIAL PRIMARY KEY,
    email CHARACTER VARYING(255),
    password CHARACTER VARYING(255),
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    role varchar(128) NOT NULL default 'USER'
);

CREATE TABLE public.topics (
    id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(255) NOT NULL,
    creator_id INTEGER,
    created_at TIMESTAMP,
    CONSTRAINT "fk_topic_creator"
        FOREIGN KEY ("creator_id")
        REFERENCES "users"("id")
);

CREATE TABLE public.comments (
    id SERIAL PRIMARY KEY,
    content CHARACTER VARYING(2048) NOT NULL,
    creator_id INTEGER,
    created_at TIMESTAMP,
    topic_Id INTEGER,
    CONSTRAINT "fk_comment_creator"
        FOREIGN KEY ("creator_id")
        REFERENCES "users"("id"),
    CONSTRAINT "fk_comment_topic"
        FOREIGN KEY ("topic_id")
        REFERENCES "topics"("id")
);