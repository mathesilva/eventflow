CREATE TABLE events (
    id UUID PRIMARY KEY,

    titulo VARCHAR(255) NOT NULL,

    descricao TEXT NOT NULL,

    location VARCHAR(255) NOT NULL,

    event_date TIMESTAMP NOT NULL,

    total_tickets INTEGER NOT NULL,

    disponiveis_tickets INTEGER NOT NULL,

    status VARCHAR(30) NOT NULL,

    organizer_id UUID NOT NULL,

    created_at TIMESTAMP NOT NULL,

    updated_at TIMESTAMP NOT NULL
);

CREATE INDEX idx_events_event_date
    ON events(event_date);

CREATE INDEX idx_events_organizer_id
    ON events(organizer_id);

CREATE INDEX idx_events_status
    ON events(status);