create table customer(
	id		varchar2(30) primary key,	-- 고객 아이디(pk)
	pwd		varchar2(30) not null,		-- 고객 비밀번호
	name	varchar2(30) not null,		-- 고객 이름
	phone	varchar2(50) not null,		-- 고객 전화번호
	email	varchar2(50) not null,		-- 고객 이메일
	regdate	date not null				-- 가입 일자
);

create table board(
	board_num	number primary key, 	-- 게시판 번호
	writer		varchar2(30) references customer(id) not null,	-- 고객 아이디(fk)
	title		varchar2(100) not null,	-- 글 제목
	category	varchar2(30) not null,	-- 글 카테고리
	content		clob,					-- 글 내용
	regdate		date not null			-- 글 작성일
);

create table board_comment(
	board_num	number primary key,
	writer		varchar2(30) references customer(id) not null,
	content		varchar2(500),
	target_id	varchar2(100),
	ref_group	number,
	comment_group number,
	regdate		date
);

create table hotel(
    hotel_id    number primary key,		-- 호텔 고유 번호(pk)
    city_id     number not null,		-- 도시 고유 번호(fk)
    hotel_name  varchar2(100) not null,	-- 호텔 이름
    hotel_phone varchar2(100) not null,	-- 호텔 전화번호
    numof_rooms number not null			-- 보유 객실 수
);

create table room(
    room_num    number primary key,		-- 객실 고유 번호(pk)
    hotel_id    number not null,		-- 호텔 고유 번호(fk)
    room_name   varchar2(20) not null,	-- 객실 이름
    room_charge number not null,		-- 객실 요금 
    avail_guest number not null,		-- 이용가능 인원
    smoking     char(2) not null,		-- 흡연가능여부(y/n)
    bath_amenity char(2) not null,		-- 세면용품 구비여부(y/n)
    wifi_free   char(2) not null		-- 무료 와이파이여부(y/n)
);

create table region(
    city_id     number primary key,		-- 도시 고유 번호(pk)
    city_name   varchar2(30) not null,	-- 도시 이름
    numof_hotel number not null			-- 해당 도시의 호텔 수
);

create table reservation(
    rv_num      number primary key,		-- 예약 번호(pk)
    rv_date     varchar2(30) not null,	-- 예약 일자
    cust_id     varchar2(30) not null,	-- 고객 아이디(fk)
    room_num    number  not null,		-- 객실 고유 번호(fk)
    checkin     varchar2(30) not null,	-- 체크인 시간
    checkout    varchar2(30) not null,	-- 체크아웃 시간
    amount      number not null,		-- 결제 요금 
    payment     varchar2(10) not null,	-- 결제 수단(cash/card)
    numof_rvcust number not null		-- 예약 인원
);

create table grade(
    room_grade  varchar2(20),			-- 객실 등급(cheap, popular, luxury)
    lowest      number,					-- 최저 금액
    highest     number					-- 최고 금액
);

ALTER TABLE hotel
ADD CONSTRAINT fk_city_id FOREIGN KEY(city_id)
REFERENCES region(city_id);

ALTER TABLE room
ADD CONSTRAINT fk_hotel_id FOREIGN KEY(hotel_id)
REFERENCES hotel(hotel_id);

ALTER TABLE reservation
ADD CONSTRAINT fk_cust_id FOREIGN KEY(cust_id)
REFERENCES customer(id);

ALTER TABLE reservation
ADD CONSTRAINT fk_room_num FOREIGN KEY(room_num)
REFERENCES room(room_num);

