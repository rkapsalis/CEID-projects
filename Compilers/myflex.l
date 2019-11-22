%{
    #include<stdio.h>
    #include "mybison.tab.h"
    char *strclone(char *str);
    int line_num = 1;
    
%}

DIGIT1to9 [1-9]
DIGIT [0-9]
DIGITS {DIGIT}+
INT {DIGIT}|{DIGIT1to9}{DIGITS}|-{DIGIT}|-{DIGIT1to9}{DIGITS}
FRAC [.]{DIGITS}
EXP {E}{DIGITS}
E [eE][+-]?
HEX_DIGIT [0-9a-f]
NUMBER {INT}|{INT}{FRAC}|{INT}{EXP}|{INT}{FRAC}{EXP}
UNESCAPEDCHAR [ -!#-\[\]-~]
ESCAPEDCHAR \\["\\bfnrt/]
UNICODECHAR \\u{HEX_DIGIT}{HEX_DIGIT}{HEX_DIGIT}{HEX_DIGIT}
CHAR {UNESCAPEDCHAR}|{ESCAPEDCHAR}|{UNICODECHAR}
CHARS {CHAR}+
DAY "Monday"|"Tuesday"|"Wednesday"|"Thursday"|"Friday"|"Saturday"|"Sunday"|"Mon"|"Tue"|"Wed"|"Thu"|"Fri"|"Sat"|"Sun"
MONTH "January"|"February"|"March"|"April"|"May"|"June"|"July"|"August"|"September"|"October"|"November"|"December"|"Jan"|"Feb"|"Mar"|"Apr"|"May"|"Jun"|"Jul"|"Aug"|"Sep"|"Oct"|"Nov"|"Dec"
YEAR {DIGIT}{DIGIT}{DIGIT}{DIGIT}
DATE 0[1-9]|1[0-9]|2[0-9]|3[0-1]
HOUR 0[0-9]|1[0-9]|2[0-3]
DBL_QUOTE ["]
TXT "text"
I_D "id"
USR "user"
NM "name"
S_M "screen_name"
LOC "location"
C_AT "created_at"
DESC "description"
ID_STR "id_str"
UR "url"
TRUNCATED "truncated"
DISPLAY "display_text_range"
EXTENDED "extended_tweet"
FULL "full_text"
ENTITIES "entities"
HASHTAGS "hashtags"
INDICES "indices"
COLON ":"
SPACE (\t|" "|\r)
CREATED_BODY {DAY}[" "]{MONTH}[" "]{DATE}[" "]{HOUR}[":"][0-5][0-9][":"][0-5][0-9][" "]{YEAR}
RETWEETED_STATUS "retweeted_status"
RT_1 "RT @"
RT_BODY {RT_1}{CHARS}
TWEET "tweet"

%%
{DBL_QUOTE}{CREATED_BODY}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return CREATED_BODY;
};
{DBL_QUOTE}{FULL}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return FULL;
};
{DBL_QUOTE}{EXTENDED}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return EXTENDED;
};

{DBL_QUOTE}{ENTITIES}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return ENTITIES;
};

{DBL_QUOTE}{HASHTAGS}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return HASHTAGS;
};

{DBL_QUOTE}{INDICES}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return INDICES;
};

{DBL_QUOTE}{TWEET}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return TWEET;
};

{DBL_QUOTE}{RETWEETED_STATUS}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return RETWEETED_STATUS;
};
{DBL_QUOTE}{NUMBER}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return ID_BODY;
};
{DBL_QUOTE}{TXT}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return TEXT;
};
{DBL_QUOTE}{I_D}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return ID;
};
{DBL_QUOTE}{USR}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return USER;
};
{DBL_QUOTE}{NM}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return NAME;
};
{DBL_QUOTE}{S_M}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return SCREEN_NAME;
};
{DBL_QUOTE}{LOC}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return LOCATION;
};
{DBL_QUOTE}{C_AT}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return CREATED_AT;
};
{DBL_QUOTE}{DESC}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return DESCRIPTION;
};
{DBL_QUOTE}{UR}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return URL;
};
{DBL_QUOTE}{ID_STR}{DBL_QUOTE} {
     yylval.string=strclone(yytext);
                    return ID_STR;
};
{DBL_QUOTE}{RT_BODY}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return RT_BODY;
};
{DBL_QUOTE}{TRUNCATED}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return TRUNCATED;
};
{DBL_QUOTE}{DISPLAY}{DBL_QUOTE} {
      yylval.string=strdup(yytext);
                 return DISPLAY;
};
[ \t]          ;
{DBL_QUOTE}{DBL_QUOTE} {return STRING;};
{DBL_QUOTE}{CHARS}{DBL_QUOTE} {
    yylval.string=strclone(yytext);
    return STRING;
};
{NUMBER} { 
    yylval.string=strclone(yytext);
    return NUMBER;
};
{DBL_QUOTE} {return DBL_QUOTE;};
"true" {
     yylval.string=strclone(yytext);
     return TRUE1;
};
{SPACE} {return SPACE;};
"false" {
     yylval.string=strclone(yytext);
    return FALSE1;
};
null {
    return null;
};
\{ {
    return CURLY_BRACKET_L;
};

\} {
    return CURLY_BRACKET_R;
};

\[ {
    return L_SQUARE_BRACKET;
};

\] {
    return R_SQUARE_BRACKET;
};

, {
    return COMMA;
};
{COLON} {
    return COLON;
};

{DAY}            {return DAY;};
{MONTH}          {return MONTH;};
{YEAR}           {return YEAR;};
{DATE}           {return DATE;};



\r\n                ++line_num; 
. {
    printf("Unexpected: %c\nExiting...\n",*yytext);
    exit(0);
}
return 0;
%%
char *strclone(char *str)
{
    int len = strlen(str);
    char *clone = (char *)malloc(sizeof(char)*(len+1));
    strcpy(clone,str);
    return clone;
}