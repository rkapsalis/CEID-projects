/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2013 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

#ifndef YY_YY_MYBISON_TAB_H_INCLUDED
# define YY_YY_MYBISON_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 1
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    TRUE1 = 258,
    FALSE1 = 259,
    null = 260,
    COMMA = 261,
    COLON = 262,
    CURLY_BRACKET_L = 263,
    CURLY_BRACKET_R = 264,
    L_SQUARE_BRACKET = 265,
    R_SQUARE_BRACKET = 266,
    TEXT = 267,
    DBL_QUOTE = 268,
    NUMBER = 269,
    STRING = 270,
    USER = 271,
    CREATED_AT = 272,
    ID_STR = 273,
    ENTITIES = 274,
    HASHTAGS = 275,
    EXTENDED = 276,
    FULL = 277,
    INDICES = 278,
    URL = 279,
    ID = 280,
    SCREEN_NAME = 281,
    NAME = 282,
    LOCATION = 283,
    TRUNCATED = 284,
    DISPLAY = 285,
    DESCRIPTION = 286,
    USER_MENTIONS = 287,
    CREATED_BODY = 288,
    DAY = 289,
    MONTH = 290,
    YEAR = 291,
    ID_BODY = 292,
    TWEET = 293,
    RETWEETED_STATUS = 294,
    RT_BODY = 295,
    DATE = 296,
    SPACE = 297
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef union YYSTYPE YYSTYPE;
union YYSTYPE
{
#line 53 "mybison.y" /* yacc.c:1909  */


        int integer;

        char *string;
        long long1;
	    float fp;


#line 107 "mybison.tab.h" /* yacc.c:1909  */
};
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_MYBISON_TAB_H_INCLUDED  */
