CREATE TABLE S_AUTHORITY_USER (
ID INT NOT NULL AUTO_INCREMENT
, CODE VARCHAR(100) NOT NULL
, NICK_NAME VARCHAR(255) NOT NULL
, PASSWORD VARCHAR(30) NOT NULL
, ROLE_CODE VARCHAR(100) NOT NULL
, UNIQUE UQ_S_AUTHORITY_USER_1 (CODE)
, PRIMARY KEY (ID)
, CONSTRAINT FK_S_AUTHORITY_USER_1 FOREIGN KEY (ROLE_CODE)
REFERENCES S_AUTHORITY_ROLE (CODE)
);

CREATE TABLE S_AUTHORITY_ROLE (
ID INT NOT NULL
, NAME VARCHAR(255) NOT NULL
, CODE VARCHAR(100) NOT NULL
, UNIQUE UQ_S_AUTHORITY_ROLE_1 (CODE)
, PRIMARY KEY (ID)
);

CREATE TABLE S_AUTHORITY_RESOURCE (
ID INT NOT NULL
, RTYPE INT NOT NULL
, CODE VARCHAR(100) NOT NULL
, UNIQUE UQ_S_AUTHORITY_RESOURCE_1 (RTYPE, CODE)
, PRIMARY KEY (ID)
);

CREATE TABLE S_AUTHORITY_ROLE_RESOURCE (
ROLE_ID INT NOT NULL
, RESOURCE_ID INT NOT NULL
, PRIMARY KEY (ROLE_ID, RESOURCE_ID)
, CONSTRAINT FK_S_AUTHORITY_ROLE_RESOURCE_1 FOREIGN KEY (RESOURCE_ID)
REFERENCES S_AUTHORITY_RESOURCE (ID)
, CONSTRAINT FK_S_AUTHORITY_ROLE_RESOURCE_2 FOREIGN KEY (ROLE_ID)
REFERENCES S_AUTHORITY_ROLE (ID)
);

CREATE TABLE S_MENU_MENU (
ID INT NOT NULL AUTO_INCREMENT
, CODE VARCHAR(100) NOT NULL
, LABEL VARCHAR(200) NOT NULL
, ICON VARCHAR(200) 
, OUTCOME VARCHAR(200)
, IS_ITEM BOOLEAN NOT NULL
, UNIQUE UQ_S_MENU_MENU_1 (CODE)
, PRIMARY KEY (ID)
);

CREATE TABLE S_MENU_MENUNODE (
ID INT NOT NULL AUTO_INCREMENT
, CODE VARCHAR(100) NOT NULL
, MENU_CODE VARCHAR(100) NOT NULL
, BTM_NODE BOOLEAN NOT NULL
, HEAD_NODE BOOLEAN NOT NULL
, PARENT_CODE VARCHAR(100) 
, UNIQUE UQ_S_MENU_MENUNODE_1 (CODE)
, CONSTRAINT FK_S_MENU_MENUNODE_1 FOREIGN KEY (MENU_CODE)
REFERENCES S_MENU_MENU (CODE)
, CONSTRAINT FK_S_MENU_MENUNODE_2 FOREIGN KEY (PARENT_CODE)
REFERENCES S_MENU_MENUNODE (CODE)
);

CREATE TABLE S_MENU_MENUNODE_RELATION (
PARENT_CODE VARCHAR(100) NOT NULL
, CHILD_CODE VARCHAR(100) NOT NULL
, UNIQUE UQ_S_MENU_MENUNODE_RELATION_1 (CHILD_CODE)
, PRIMARY KEY (PARENT_CODE, CHILD_CODE)
, CONSTRAINT FK_S_MENU_MENUNODE_RELATION_1 FOREIGN KEY (PARENT_CODE)
REFERENCES S_MENU_MENUNODE (CODE)
, CONSTRAINT FK_S_MENU_MENUNODE_RELATION_2 FOREIGN KEY (CHILD_CODE)
REFERENCES S_MENU_MENUNODE (CODE)
);
