-- view
create definer = root@localhost view movie_schedule as
select `m`.`id`                                                   AS `id`,
       `m`.`name`                                                 AS `name`,
       `m`.`length`                                               AS `length`,
       `s`.`start_time`                                           AS `start_time`,
       (select (`s`.`start_time` + interval `m`.`length` minute)) AS `end_time`
from (`cinema`.`session` `s`
         join `cinema`.`movie` `m` on ((`m`.`id` = `s`.`movie_id`)));


-- task1
select m1.name, m1.start_time, m1.end_time,
       m2.name, m2.start_time, m2.length
from movie_schedule m1
         inner join movie_schedule m2
                    on (m1.id not in (m2.id)
                        and m2.start_time between m1.start_time and m1.end_time)
order by m1.start_time;

-- task2
select m1.name, m1.end_time, m2.name, m2.start_time, (DATEDIFF(m2.start_time, m1.end_time)) as dur
from movie_schedule m1
         inner join movie_schedule m2
                    on (m1.id not in (m2.id)
                        and DATEDIFF(m2.start_time, m1.end_time) > 30)
order by dur;