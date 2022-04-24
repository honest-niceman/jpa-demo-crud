INSERT INTO projects (name, start_date, manager_id)
VALUES ('Maniculus', NOW(), 0);
INSERT INTO task (project_id, assignee_id, start_date, name)
VALUES (0, 0, NOW(), 'Structural Plan');
INSERT INTO task (project_id, assignee_id, name)
VALUES (0, 1, 'Features Design');