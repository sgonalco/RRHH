-- Departments
INSERT INTO DEPARTMENT (name, manager_id, created_at) VALUES
    ('Engineering', 1, '2024-01-10 09:00:00'),
    ('Marketing', 2, '2024-02-05 09:00:00'),
    ('Human Resources', 3, '2024-03-15 09:00:00');

-- Projects
INSERT INTO PROJECT (title, description, status, department_id, start_date, end_date) VALUES
    (
      'Website Redesign',
      'Redesign the company website with a modern UI.',
      'In Progress',
      1,
      '2025-01-15 09:00:00',
      '2025-06-30 17:00:00'
    ),
    (
      'Mobile App',
      'Develop the first version of the company mobile application.',
      'Planning',
      1,
      '2025-03-01 09:00:00',
      '2025-10-31 17:00:00'
    ),
    (
      'Summer Campaign',
      'Launch the annual summer marketing campaign.',
      'Completed',
      2,
      '2025-04-01 09:00:00',
      '2025-05-31 17:00:00'
    ),
    (
      'Social Media Strategy',
      'Increase brand engagement across social platforms.',
      'In Progress',
      2,
      '2025-06-01 09:00:00',
      '2025-12-31 17:00:00'
    ),
    (
      'Employee Onboarding',
      'Create a standardized onboarding process for new hires.',
      'Completed',
      3,
      '2025-02-01 09:00:00',
      '2025-03-15 17:00:00'
    ),
    (
      'Training Program',
      'Develop leadership and technical training sessions.',
      'Planning',
      3,
      '2025-08-01 09:00:00',
      '2025-11-30 17:00:00'
    );