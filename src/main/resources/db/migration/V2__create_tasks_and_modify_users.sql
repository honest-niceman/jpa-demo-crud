CREATE TABLE task
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    project_id  BIGINT,
    assignee_id BIGINT,
    end_date    TIMESTAMP WITHOUT TIME ZONE,
    start_date  TIMESTAMP WITHOUT TIME ZONE,
    name        VARCHAR(255),
    CONSTRAINT pk_task PRIMARY KEY (id)
);

ALTER TABLE users
    ADD email VARCHAR(255);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_ASSIGNEE FOREIGN KEY (assignee_id) REFERENCES users (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_PROJECT FOREIGN KEY (project_id) REFERENCES projects (id);