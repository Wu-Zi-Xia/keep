ALTER TABLE plan_progress
modify COLUMN start_planID bigint(20) not null;
ALTER TABLE plan_progress
    modify COLUMN current_state bigint(20) not null ;
ALTER TABLE plan_progress
    modify COLUMN end_planID bigint(20) not null ;
