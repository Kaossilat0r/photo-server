insert into user (id, name) values (1, 'Alice');
insert into user (id, name) values (2, 'Bob');
insert into user (id, name) values (3, 'Carl');


insert into picture (fullurl, thumburl, user_id) values ('images/DSC_0194.JPG',            'images/DSC_0194_th.png'            , 1);
insert into picture (fullurl, thumburl, user_id) values ('images/DSC_0270.JPG',            'images/DSC_0270_th.png'            , 1);
insert into picture (fullurl, thumburl, user_id) values ('images/IMG_3797.JPG',            'images/IMG_3797_th.png'            , 1);
insert into picture (fullurl, thumburl, user_id) values ('images/IMG_3827.JPG',            'images/IMG_3827_th.png'            , 1);
insert into picture (fullurl, thumburl, user_id) values ('images/IMG_3842.JPG',            'images/IMG_3842_th.png'            , 1);
insert into picture (fullurl, thumburl, user_id) values ('images/IMG_3848.JPG',            'images/IMG_3848_th.png'            , 1);
insert into picture (fullurl, thumburl, user_id) values ('images/20141011_205644_5244.jpg','images/20141011_205644_5244_th.png', 1);
insert into picture (fullurl, thumburl, user_id) values ('images/20141011_205812_5245.jpg','images/20141011_205812_5245_th.png', 1);
insert into picture (fullurl, thumburl, user_id) values ('images/20141011_210304_5260.jpg','images/20141011_210304_5260_th.png', 1);
insert into picture (fullurl, thumburl, user_id) values ('images/20141011_213735_5309.jpg','images/20141011_213735_5309_th.png', 1);
insert into picture (fullurl, thumburl, user_id) values ('images/20141017_210214_6490.jpg','images/20141017_210214_6490_th.png', 1);
insert into picture (fullurl, thumburl, user_id) values ('images/20141017_213111_6633.jpg','images/20141017_213111_6633_th.png', 2);
insert into picture (fullurl, thumburl, user_id) values ('images/20141017_214013_6688.jpg','images/20141017_214013_6688_th.png', 2);
insert into picture (fullurl, thumburl, user_id) values ('images/20141017_214112_6702.jpg','images/20141017_214112_6702_th.png', 2);


insert into tag (id, name) values (1, "tag1");
insert into tag (id, name) values (2, "tag2");
insert into tag (id, name) values (3, "tag3");


insert into picture_tag (picture_id, tags_id) values (1,1);
insert into picture_tag (picture_id, tags_id) values (1,2);
insert into picture_tag (picture_id, tags_id) values (1,3);
insert into picture_tag (picture_id, tags_id) values (2,1);
insert into picture_tag (picture_id, tags_id) values (3,1);
insert into picture_tag (picture_id, tags_id) values (4,1);
insert into picture_tag (picture_id, tags_id) values (5,2);
insert into picture_tag (picture_id, tags_id) values (6,2);
insert into picture_tag (picture_id, tags_id) values (7,2);
insert into picture_tag (picture_id, tags_id) values (8,3);
insert into picture_tag (picture_id, tags_id) values (9,3);
