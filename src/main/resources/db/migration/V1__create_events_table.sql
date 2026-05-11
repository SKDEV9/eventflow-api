CREATE table events(

    id BIGSERIAL primary key,

    name varchar(50) not null,
    description varchar(150) not null,
    location varchar(100) not null,

    event_date TIMESTAMP not null,

    total_tickets INTEGER not null,
    available_tickets INTEGER not null,

    price decimal(10,2) not null,

    status varchar(30) not null,

    created_at TIMESTAMP with time zone not null default CURRENT_TIMESTAMP,
    updated_at TIMESTAMP with time zone not null default CURRENT_TIMESTAMP,

    CONSTRAINT chk_events_total_tickets_non_negative
        CHECK (total_tickets >= 0),

    CONSTRAINT chk_events_available_tickets_non_negative
        CHECK (available_tickets >= 0),

    CONSTRAINT chk_events_price_non_negative
        CHECK (price >= 0),

    CONSTRAINT chk_events_available_tickets_lte_total_tickets
        CHECK (available_tickets <= total_tickets)

);