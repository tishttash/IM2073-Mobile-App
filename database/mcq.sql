create database if not exists MCQ;

USE MCQ;

drop table if exists questionnaire;

CREATE table questionnaire (
 id     int,
 question  varchar(150),
    choice1 varchar(150),
    choice2 varchar(150),
    choice3 varchar(150),
    choice4 varchar(150),
 answer char, 
 qtyselect int,
 primary key (id)
);

insert into questionnaire values (
	1,
    'How long can the Emperor Penguin stay underwater?',
    '5 minutes',
    '10 minutes',
    '20 minutes',
    '40 minutes',
    '3',
    0
);

insert into questionnaire values (
	2,
    'What is a group of penguins called on land?',
    'Puddle',
    'Faculty',
    'Raft',
    'Waddle',
    '4',
    0
);

insert into questionnaire values (
	3,
    'How many eggs does a typical female duck lay?',
    '6 to 12',
    '4 to 6',
    '2 to 4',
    '1 to 3',
    '1',
    0
);

insert into questionnaire values (
	4,
    'How many species of ducks are there?',
    '100',
    '150',
    '200',
    '250',
    '2',
    0
);

insert into questionnaire values (
	5,
    'Which duck usually incubates the eggs?',
    'Male Duck',
    'Female Duck',
    'Male Duck at Night',
    'Female and Male Duck',
    '2',
    0
);

insert into questionnaire values (
	6,
    'Which of these is commonly used as the collective name for a flock of flamingos?',
    'Flamboyance',
    'School',
    'Murder',
    'Bevy',
    '1',
    0
);

insert into questionnaire values (
	7,
    'Why are flamingos pink?',
    'Due to sunburn',
    'They’re just born like that',
    'Due to the food the food they eat',
    'They’re not pink',
    '3',
    0
);

insert into questionnaire values (
	8,
    'How many times can a hummingbird flap its wings per second?',
    '20 times',
    '40 times',
    '80 times',
    '160 times',
    '3',
    0
);

insert into questionnaire values (
	9,
    'How often do hummingbirds feed?',
    'Every 10 minutes',
    'Every 20 minutes',
    'Every 30 minutes',
    'Every 40 minutes',
    '1',
    0
);

insert into questionnaire values (
	10,
    'What are baby swans called?',
    'Eyas',
    'Puffling',
    'Cygnets',
    'Babies',
    '3',
    0
);

create table if not exists counter (
	qtyselect1 int,
    qtyselect2 int,
    qtyselect3 int,
    qtyselect4 int
);

insert into counter values (
	0,
    0,
    0,
    0
);

