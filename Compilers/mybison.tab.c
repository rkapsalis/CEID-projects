/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Bison implementation for Yacc-like parsers in C

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

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "3.0.2"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* Copy the first part of user declarations.  */
#line 1 "mybison.y" /* yacc.c:339  */

#include<stdio.h>
#include<stdlib.h>
#include <string.h>
#define YYDEBUG 1
extern int yylex();
extern int yyparse();
extern FILE *yyin;
extern int line_num; 
int data_type,hours,minutes,seconds;
int n = 0, *arr,q=0,j=0;
int elem_counter;
long input1;
int positive=0;
char input[500];
int check_text(int counter,char *in);
int check_time(int hour,int min,int sec);
void checkRTtext(char p22[],char p11[]);
char array[140];
char *sp;
char in3[500];
int checkmet=0;
long input2;
int checkID_STRmet=0;
int checkIDmet=0;
int last_element;
char txt_in[500];
char *cData;
int length;
typedef struct {
  long *array;
  size_t spaceUsed;
  size_t arraySize;
} Array;

Array mArray;
Array IDunique;
Array ID_STRunique;
void initArray(Array *pinakas, size_t initialSize);
void freeArray(Array *pinakas);
void insertArray(Array *pinakas, long element);
int uniqueNumber(Array arrayName,long inputNumber);

void yyerror(const char *s);

#line 112 "mybison.tab.c" /* yacc.c:339  */

# ifndef YY_NULLPTR
#  if defined __cplusplus && 201103L <= __cplusplus
#   define YY_NULLPTR nullptr
#  else
#   define YY_NULLPTR 0
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 1
#endif

/* In a future release of Bison, this section will be replaced
   by #include "mybison.tab.h".  */
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
#line 53 "mybison.y" /* yacc.c:355  */


        int integer;

        char *string;
        long long1;
	    float fp;


#line 205 "mybison.tab.c" /* yacc.c:355  */
};
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_MYBISON_TAB_H_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 220 "mybison.tab.c" /* yacc.c:358  */

#ifdef short
# undef short
#endif

#ifdef YYTYPE_UINT8
typedef YYTYPE_UINT8 yytype_uint8;
#else
typedef unsigned char yytype_uint8;
#endif

#ifdef YYTYPE_INT8
typedef YYTYPE_INT8 yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef YYTYPE_UINT16
typedef YYTYPE_UINT16 yytype_uint16;
#else
typedef unsigned short int yytype_uint16;
#endif

#ifdef YYTYPE_INT16
typedef YYTYPE_INT16 yytype_int16;
#else
typedef short int yytype_int16;
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif ! defined YYSIZE_T
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned int
# endif
#endif

#define YYSIZE_MAXIMUM ((YYSIZE_T) -1)

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

#ifndef YY_ATTRIBUTE
# if (defined __GNUC__                                               \
      && (2 < __GNUC__ || (__GNUC__ == 2 && 96 <= __GNUC_MINOR__)))  \
     || defined __SUNPRO_C && 0x5110 <= __SUNPRO_C
#  define YY_ATTRIBUTE(Spec) __attribute__(Spec)
# else
#  define YY_ATTRIBUTE(Spec) /* empty */
# endif
#endif

#ifndef YY_ATTRIBUTE_PURE
# define YY_ATTRIBUTE_PURE   YY_ATTRIBUTE ((__pure__))
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# define YY_ATTRIBUTE_UNUSED YY_ATTRIBUTE ((__unused__))
#endif

#if !defined _Noreturn \
     && (!defined __STDC_VERSION__ || __STDC_VERSION__ < 201112)
# if defined _MSC_VER && 1200 <= _MSC_VER
#  define _Noreturn __declspec (noreturn)
# else
#  define _Noreturn YY_ATTRIBUTE ((__noreturn__))
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

#if defined __GNUC__ && 407 <= __GNUC__ * 100 + __GNUC_MINOR__
/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN \
    _Pragma ("GCC diagnostic push") \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")\
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# define YY_IGNORE_MAYBE_UNINITIALIZED_END \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif


#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yytype_int16 yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (sizeof (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (sizeof (yytype_int16) + sizeof (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYSIZE_T yynewbytes;                                            \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * sizeof (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / sizeof (*yyptr);                          \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, (Count) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYSIZE_T yyi;                         \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  6
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   120

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  43
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  83
/* YYNRULES -- Number of rules.  */
#define YYNRULES  106
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  184

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   297

#define YYTRANSLATE(YYX)                                                \
  ((unsigned int) (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, without out-of-bounds checking.  */
static const yytype_uint8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint16 yyrline[] =
{
       0,   104,   104,   105,   105,   108,   113,   113,   117,   117,
     126,   126,   126,   126,   163,   163,   166,   167,   168,   169,
     170,   172,   173,   174,   175,   178,   178,   178,   178,   180,
     180,   180,   180,   182,   182,   182,   184,   184,   184,   184,
     186,   186,   186,   186,   188,   188,   189,   189,   189,   188,
     191,   192,   192,   192,   192,   194,   194,   194,   194,   196,
     197,   197,   199,   199,   199,   199,   199,   200,   200,   199,
     202,   202,   202,   212,   212,   213,   213,   214,   214,   215,
     215,   216,   216,   217,   212,   218,   218,   218,   218,   218,
     220,   220,   267,   267,   269,   270,   270,   281,   282,   283,
     284,   285,   286,   287,   290,   291,   292
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 1
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "TRUE1", "FALSE1", "null", "COMMA",
  "COLON", "CURLY_BRACKET_L", "CURLY_BRACKET_R", "L_SQUARE_BRACKET",
  "R_SQUARE_BRACKET", "TEXT", "DBL_QUOTE", "NUMBER", "STRING", "USER",
  "CREATED_AT", "ID_STR", "ENTITIES", "HASHTAGS", "EXTENDED", "FULL",
  "INDICES", "URL", "ID", "SCREEN_NAME", "NAME", "LOCATION", "TRUNCATED",
  "DISPLAY", "DESCRIPTION", "USER_MENTIONS", "CREATED_BODY", "DAY",
  "MONTH", "YEAR", "ID_BODY", "TWEET", "RETWEETED_STATUS", "RT_BODY",
  "DATE", "SPACE", "$accept", "json", "$@1", "object", "$@2", "elements",
  "$@3", "$@4", "$@5", "$@6", "$@7", "elem_names", "nested_object", "usr",
  "$@8", "$@9", "$@10", "retweeted", "$@11", "$@12", "$@13",
  "data_retweeted", "$@14", "$@15", "twt", "$@16", "$@17", "$@18",
  "ext_tweet", "$@19", "$@20", "$@21", "data_ext", "$@22", "$@23", "$@24",
  "$@25", "$@26", "hash_rule", "$@27", "$@28", "$@29", "hash_array",
  "$@30", "$@31", "$@32", "hash_body", "$@33", "hash_object", "$@34",
  "$@35", "$@36", "$@37", "$@38", "$@39", "$@40", "data_t", "$@41", "$@42",
  "data_u", "$@43", "$@44", "$@45", "$@46", "$@47", "$@48", "$@49", "$@50",
  "$@51", "$@52", "$@53", "$@54", "$@55", "$@56", "$@57", "noe", "$@58",
  "array", "$@59", "members", "$@60", "value", "data", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_uint16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297
};
# endif

#define YYPACT_NINF -122

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-122)))

#define YYTABLE_NINF -15

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int8 yypact[] =
{
       3,    28,    42,  -122,  -122,    -9,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,    24,    34,     3,     7,  -122,  -122,  -122,
      -9,    15,     2,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,    51,    52,    54,    55,    56,
       2,  -122,  -122,  -122,  -122,  -122,    38,  -122,     2,    43,
      57,    58,    59,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
       2,    31,    46,    60,    61,  -122,  -122,  -122,  -122,  -122,
      62,  -122,    53,  -122,  -122,    63,    67,    63,  -122,    68,
    -122,    63,  -122,    70,  -122,    71,  -122,    73,    10,  -122,
      65,  -122,    41,  -122,  -122,    64,  -122,    66,  -122,    53,
    -122,    74,  -122,  -122,    63,  -122,    75,    78,    76,  -122,
    -122,  -122,    77,    69,    80,  -122,  -122,    63,    13,    82,
    -122,  -122,  -122,  -122,    83,    72,  -122,  -122,    81,    63,
    -122,    86,    79,  -122,  -122,    84,    85,    87,  -122,  -122,
    -122,    63,    88,    91,  -122,  -122,    93,    89,  -122,    44,
    -122,  -122,    90,  -122,  -122,    63,  -122,    93,    94,    97,
    -122,  -122,  -122,    92,  -122,    99,  -122,    95,  -122,   101,
    -122,    77,   102,  -122
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       0,     6,     0,     2,     5,     0,     1,     3,    16,    17,
      18,    20,    19,     0,     0,     0,    10,     7,     8,     4,
       0,     0,     0,    11,    25,    40,    36,    29,    15,    21,
      23,    22,    24,   101,   102,   103,    92,   100,    99,    97,
      98,   104,   105,   106,     9,     0,     0,     0,     0,     0,
       0,    12,    26,    41,    37,    30,     0,    94,     0,     0,
       0,     0,     0,    95,    93,    13,    27,    42,    38,    31,
       0,     0,     0,     0,     0,    96,    73,    85,    28,    44,
       0,    70,     0,    33,    32,     0,     0,     0,    43,     0,
      39,     0,    90,     0,    86,     0,    71,     0,     0,    74,
       0,    45,     0,    34,    91,     0,    87,     0,    72,     0,
      75,     0,    46,    35,     0,    88,     0,     0,     0,    47,
      76,    89,     0,     0,     0,    77,    48,     0,     0,     0,
      50,    51,    49,    78,     0,     0,    52,    79,     0,     0,
      53,     0,     0,    80,    55,     0,     0,     0,    54,    81,
      56,     0,     0,     0,    57,    82,     0,     0,    62,     0,
      59,    83,     0,    60,    58,     0,    63,     0,     0,     0,
      61,    84,    64,     0,    65,     0,    66,     0,    67,     0,
      68,     0,     0,    69
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int8 yypgoto[] =
{
    -122,  -122,  -122,    19,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,    96,  -122,   -80,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,   -61,  -122,
    -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,  -122,
    -122,  -122,  -122,  -122,  -122,   -87,  -122,  -121,  -122,  -122,
    -122,    12,   -32
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int16 yydefgoto[] =
{
      -1,     2,    15,    41,     5,    13,    22,    20,    45,    58,
      21,    14,    28,    29,    46,    59,    71,    30,    49,    62,
      74,    84,    91,   109,    31,    48,    61,    73,    32,    47,
      60,    72,    80,    87,   107,   116,   122,   128,   132,   134,
     138,   142,   145,   147,   152,   156,   159,   167,   160,   162,
     169,   173,   175,   177,   179,   181,    82,    89,   102,    78,
      85,   105,   114,   123,   127,   135,   139,   146,   151,   157,
     165,    86,   100,   111,   118,    93,    98,    42,    50,    56,
      70,    43,    44
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int16 yytable[] =
{
      95,   124,    90,     8,    97,    33,    34,    35,     9,    10,
       1,     1,    36,    33,    34,    35,    37,    38,    57,     3,
      11,    12,   130,   -14,    37,    38,    65,   117,   -14,   113,
      16,    24,   131,    17,    19,    39,    25,     4,    75,    40,
     129,    18,     6,    39,    63,   -14,   -14,    40,     7,    64,
     163,    66,   141,    26,    27,   164,    76,    77,    51,    52,
     182,    53,    54,    55,   153,    67,    68,    69,    79,    24,
      92,    88,    81,    83,    94,    96,    99,   101,   168,   103,
     106,   108,   119,   115,   120,   121,   126,    36,   133,   140,
     136,   110,   143,   148,   150,   125,   112,   155,   154,   144,
     137,   158,   166,   171,   172,   176,   170,   174,   180,   149,
     104,   183,     0,     0,     0,     0,    23,     0,   178,     0,
     161
};

static const yytype_int16 yycheck[] =
{
      87,   122,    82,    12,    91,     3,     4,     5,    17,    18,
       8,     8,    10,     3,     4,     5,    14,    15,    50,     0,
      29,    30,     9,    16,    14,    15,    58,   114,    21,   109,
       6,    16,    19,     9,    15,    33,    21,     9,    70,    37,
     127,     7,     0,    33,     6,    38,    39,    37,     6,    11,
       6,     8,   139,    38,    39,    11,    25,    26,     7,     7,
     181,     7,     7,     7,   151,     8,     8,     8,    22,    16,
       7,     9,    12,    12,     7,     7,     6,     6,   165,     6,
      15,    40,     7,     9,     6,     9,     6,    10,     6,     8,
       7,    27,     6,     9,     7,    26,    30,     6,    10,    20,
      28,     8,    12,     9,     7,     6,   167,    15,     7,    24,
      98,     9,    -1,    -1,    -1,    -1,    20,    -1,    23,    -1,
      31
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,     8,    44,    46,     9,    47,     0,     6,    12,    17,
      18,    29,    30,    48,    54,    45,     6,     9,     7,    46,
      50,    53,    49,    54,    16,    21,    38,    39,    55,    56,
      60,    67,    71,     3,     4,     5,    10,    14,    15,    33,
      37,    46,   120,   124,   125,    51,    57,    72,    68,    61,
     121,     7,     7,     7,     7,     7,   122,   125,    52,    58,
      73,    69,    62,     6,    11,   125,     8,     8,     8,     8,
     123,    59,    74,    70,    63,   125,    25,    26,   102,    22,
      75,    12,    99,    12,    64,   103,   114,    76,     9,   100,
      56,    65,     7,   118,     7,   118,     7,   118,   119,     6,
     115,     6,   101,     6,   124,   104,    15,    77,    40,    66,
      27,   116,    30,    56,   105,     9,    78,   118,   117,     7,
       6,     9,    79,   106,   120,    26,     6,   107,    80,   118,
       9,    19,    81,     6,    82,   108,     7,    28,    83,   109,
       8,   118,    84,     6,    20,    85,   110,    86,     9,    24,
       7,   111,    87,   118,    10,     6,    88,   112,     8,    89,
      91,    31,    92,     6,    11,   113,    12,    90,   118,    93,
      91,     9,     7,    94,    15,    95,     6,    96,    23,    97,
       7,    98,   120,     9
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    43,    44,    45,    44,    46,    47,    46,    49,    48,
      50,    51,    52,    48,    53,    48,    54,    54,    54,    54,
      54,    55,    55,    55,    55,    57,    58,    59,    56,    61,
      62,    63,    60,    65,    66,    64,    68,    69,    70,    67,
      72,    73,    74,    71,    76,    77,    78,    79,    80,    75,
      81,    82,    83,    84,    81,    86,    87,    88,    85,    89,
      90,    89,    92,    93,    94,    95,    96,    97,    98,    91,
     100,   101,    99,   103,   104,   105,   106,   107,   108,   109,
     110,   111,   112,   113,   102,   114,   115,   116,   117,   102,
     119,   118,   121,   120,   122,   123,   122,   124,   124,   124,
     124,   124,   124,   124,   125,   125,   125
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,     0,     4,     2,     0,     4,     0,     4,
       0,     0,     0,     8,     0,     4,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     0,     0,     0,     7,     0,
       0,     0,     7,     0,     0,     6,     0,     0,     0,     8,
       0,     0,     0,     8,     0,     0,     0,     0,     0,    13,
       1,     0,     0,     0,     8,     0,     0,     0,     8,     1,
       0,     4,     0,     0,     0,     0,     0,     0,     0,    16,
       0,     0,     5,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,    29,     0,     0,     0,     0,     9,
       0,     3,     0,     4,     1,     0,     4,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1
};


#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)
#define YYEMPTY         (-2)
#define YYEOF           0

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                  \
do                                                              \
  if (yychar == YYEMPTY)                                        \
    {                                                           \
      yychar = (Token);                                         \
      yylval = (Value);                                         \
      YYPOPSTACK (yylen);                                       \
      yystate = *yyssp;                                         \
      goto yybackup;                                            \
    }                                                           \
  else                                                          \
    {                                                           \
      yyerror (YY_("syntax error: cannot back up")); \
      YYERROR;                                                  \
    }                                                           \
while (0)

/* Error token number */
#define YYTERROR        1
#define YYERRCODE       256



/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)

/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


# define YY_SYMBOL_PRINT(Title, Type, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Type, Value); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*----------------------------------------.
| Print this symbol's value on YYOUTPUT.  |
`----------------------------------------*/

static void
yy_symbol_value_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
{
  FILE *yyo = yyoutput;
  YYUSE (yyo);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyoutput, yytoknum[yytype], *yyvaluep);
# endif
  YYUSE (yytype);
}


/*--------------------------------.
| Print this symbol on YYOUTPUT.  |
`--------------------------------*/

static void
yy_symbol_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
{
  YYFPRINTF (yyoutput, "%s %s (",
             yytype < YYNTOKENS ? "token" : "nterm", yytname[yytype]);

  yy_symbol_value_print (yyoutput, yytype, yyvaluep);
  YYFPRINTF (yyoutput, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yytype_int16 *yybottom, yytype_int16 *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yytype_int16 *yyssp, YYSTYPE *yyvsp, int yyrule)
{
  unsigned long int yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %lu):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       yystos[yyssp[yyi + 1 - yynrhs]],
                       &(yyvsp[(yyi + 1) - (yynrhs)])
                                              );
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen strlen
#  else
/* Return the length of YYSTR.  */
static YYSIZE_T
yystrlen (const char *yystr)
{
  YYSIZE_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
static char *
yystpcpy (char *yydest, const char *yysrc)
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYSIZE_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYSIZE_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
        switch (*++yyp)
          {
          case '\'':
          case ',':
            goto do_not_strip_quotes;

          case '\\':
            if (*++yyp != '\\')
              goto do_not_strip_quotes;
            /* Fall through.  */
          default:
            if (yyres)
              yyres[yyn] = *yyp;
            yyn++;
            break;

          case '"':
            if (yyres)
              yyres[yyn] = '\0';
            return yyn;
          }
    do_not_strip_quotes: ;
    }

  if (! yyres)
    return yystrlen (yystr);

  return yystpcpy (yyres, yystr) - yyres;
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYSIZE_T *yymsg_alloc, char **yymsg,
                yytype_int16 *yyssp, int yytoken)
{
  YYSIZE_T yysize0 = yytnamerr (YY_NULLPTR, yytname[yytoken]);
  YYSIZE_T yysize = yysize0;
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULLPTR;
  /* Arguments of yyformat. */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Number of reported tokens (one for the "unexpected", one per
     "expected"). */
  int yycount = 0;

  /* There are many possibilities here to consider:
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[*yyssp];
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYSIZE_T yysize1 = yysize + yytnamerr (YY_NULLPTR, yytname[yyx]);
                  if (! (yysize <= yysize1
                         && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
                    return 2;
                  yysize = yysize1;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    YYSIZE_T yysize1 = yysize + yystrlen (yyformat);
    if (! (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
      return 2;
    yysize = yysize1;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          yyp++;
          yyformat++;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep)
{
  YYUSE (yyvaluep);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}




/* The lookahead symbol.  */
int yychar;

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval;
/* Number of syntax errors so far.  */
int yynerrs;


/*----------.
| yyparse.  |
`----------*/

int
yyparse (void)
{
    int yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       'yyss': related to states.
       'yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yytype_int16 yyssa[YYINITDEPTH];
    yytype_int16 *yyss;
    yytype_int16 *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYSIZE_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYSIZE_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;

/*------------------------------------------------------------.
| yynewstate -- Push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
 yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;

 yysetstate:
  *yyssp = yystate;

  if (yyss + yystacksize - 1 <= yyssp)
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYSIZE_T yysize = yyssp - yyss + 1;

#ifdef yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        YYSTYPE *yyvs1 = yyvs;
        yytype_int16 *yyss1 = yyss;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * sizeof (*yyssp),
                    &yyvs1, yysize * sizeof (*yyvsp),
                    &yystacksize);

        yyss = yyss1;
        yyvs = yyvs1;
      }
#else /* no yyoverflow */
# ifndef YYSTACK_RELOCATE
      goto yyexhaustedlab;
# else
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yytype_int16 *yyss1 = yyss;
        union yyalloc *yyptr =
          (union yyalloc *) YYSTACK_ALLOC (YYSTACK_BYTES (yystacksize));
        if (! yyptr)
          goto yyexhaustedlab;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif
#endif /* no yyoverflow */

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YYDPRINTF ((stderr, "Stack size increased to %lu\n",
                  (unsigned long int) yystacksize));

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }

  YYDPRINTF ((stderr, "Entering state %d\n", yystate));

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;

/*-----------.
| yybackup.  |
`-----------*/
yybackup:

  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = yylex ();
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);

  /* Discard the shifted token.  */
  yychar = YYEMPTY;

  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- Do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
        case 3:
#line 105 "mybison.y" /* yacc.c:1646  */
    {printf(",\n");}
#line 1433 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 5:
#line 108 "mybison.y" /* yacc.c:1646  */
    {

    printf("{}");

  }
#line 1443 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 6:
#line 113 "mybison.y" /* yacc.c:1646  */
    {printf("{\n");}
#line 1449 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 7:
#line 113 "mybison.y" /* yacc.c:1646  */
    {printf("\n}");}
#line 1455 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 8:
#line 117 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1461 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 9:
#line 117 "mybison.y" /* yacc.c:1646  */
    {if(data_type==10){

                                                                  printf("%s",input);}
								else{
                                                                    printf("Error!");

								}								

								}
#line 1475 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 10:
#line 126 "mybison.y" /* yacc.c:1646  */
    {printf(",\n");}
#line 1481 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 11:
#line 126 "mybison.y" /* yacc.c:1646  */
    {}
#line 1487 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 12:
#line 126 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1493 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 13:
#line 126 "mybison.y" /* yacc.c:1646  */
    {if(elem_counter==0){
                                                                  if(check_text(elem_counter,input)==1 && data_type==0){
                                                                   strcpy(txt_in,input);
                                                                   printf("%s",input);

					                        }
                                                                else{printf("Error!Text is too long or wrong data type.");
                                                                     exit(1);
                                                                }
                                                                }
                                                                else if (elem_counter==2){
                                                                        if(checkID_STRmet==0){
                                                                            initArray(&ID_STRunique, 1); 
                                                                            checkID_STRmet++;
                                                                        }
                                                                        
                                                                       if(data_type==30 && uniqueNumber(ID_STRunique,input2)==111){
                                                                               printf("%s",input); }
                                                                        else{ printf("Error!ID is not unique or wrong data type."); exit(1); }
                                                                }
                                                                else if(elem_counter==12){
                                                                         printf("%d",data_type);
                                                                     if(last_element<140 && data_type==2){
                                                                        printf("Error!Tweet is less than 140 characters.");
                                                                          exit(1);
                                                                    }else if (last_element>=140 && data_type==2){
                                                                         printf("\"true\"");
                                                                     }
                                                                    else if(last_element>=140 && data_type==3){
                                                                         printf("Error!Tweet is not less than 140 characters.");
                                                                         exit(1);
                                                                    }else if (last_element<140 && data_type==3){
                                                                       printf("\"false\"");
                                                                     }
                                                                }
							        }
#line 1534 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 14:
#line 163 "mybison.y" /* yacc.c:1646  */
    {printf(",\n");}
#line 1540 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 16:
#line 166 "mybison.y" /* yacc.c:1646  */
    {elem_counter=0;printf("\t\"text\"");}
#line 1546 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 17:
#line 167 "mybison.y" /* yacc.c:1646  */
    {elem_counter=16;printf("\t\"created_at\"");}
#line 1552 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 18:
#line 168 "mybison.y" /* yacc.c:1646  */
    {elem_counter=2;printf("\t\"id_str\"");}
#line 1558 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 19:
#line 169 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"display_text_range\"");elem_counter=17;}
#line 1564 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 20:
#line 170 "mybison.y" /* yacc.c:1646  */
    {elem_counter=12;printf("\t\"truncated\"");}
#line 1570 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 21:
#line 172 "mybison.y" /* yacc.c:1646  */
    {}
#line 1576 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 22:
#line 173 "mybison.y" /* yacc.c:1646  */
    {}
#line 1582 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 23:
#line 174 "mybison.y" /* yacc.c:1646  */
    {}
#line 1588 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 24:
#line 175 "mybison.y" /* yacc.c:1646  */
    {}
#line 1594 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 25:
#line 178 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"user\"");}
#line 1600 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 26:
#line 178 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1606 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 27:
#line 178 "mybison.y" /* yacc.c:1646  */
    {printf("{\n\t");}
#line 1612 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 29:
#line 180 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"retweeted_status\"");}
#line 1618 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 30:
#line 180 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1624 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 31:
#line 180 "mybison.y" /* yacc.c:1646  */
    {printf("{\n\t");}
#line 1630 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 32:
#line 180 "mybison.y" /* yacc.c:1646  */
    {}
#line 1636 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 33:
#line 182 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"text\""); elem_counter=9;}
#line 1642 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 34:
#line 182 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1648 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 36:
#line 184 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"tweet\"");}
#line 1654 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 37:
#line 184 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1660 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 38:
#line 184 "mybison.y" /* yacc.c:1646  */
    {printf("{");}
#line 1666 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 40:
#line 186 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"extended_tweet\"");}
#line 1672 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 41:
#line 186 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1678 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 42:
#line 186 "mybison.y" /* yacc.c:1646  */
    {printf("{\n\t");}
#line 1684 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 43:
#line 186 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t}");}
#line 1690 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 44:
#line 188 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"full_text\""); elem_counter=16;}
#line 1696 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 45:
#line 188 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1702 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 46:
#line 189 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"display_text_range\"");elem_counter=15;}
#line 1708 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 47:
#line 189 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1714 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 48:
#line 189 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1720 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 50:
#line 191 "mybison.y" /* yacc.c:1646  */
    {printf("}");}
#line 1726 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 51:
#line 192 "mybison.y" /* yacc.c:1646  */
    {printf("\t\"entities\"");}
#line 1732 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 52:
#line 192 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1738 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 53:
#line 192 "mybison.y" /* yacc.c:1646  */
    {printf("{\n\t");}
#line 1744 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 54:
#line 192 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t     }");}
#line 1750 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 55:
#line 194 "mybison.y" /* yacc.c:1646  */
    {printf("\t\t\"hashtags\"");}
#line 1756 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 56:
#line 194 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1762 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 57:
#line 194 "mybison.y" /* yacc.c:1646  */
    {printf("[");}
#line 1768 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 58:
#line 194 "mybison.y" /* yacc.c:1646  */
    {printf("]");}
#line 1774 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 60:
#line 197 "mybison.y" /* yacc.c:1646  */
    {printf(",");}
#line 1780 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 62:
#line 199 "mybison.y" /* yacc.c:1646  */
    {printf("{\n\t");}
#line 1786 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 63:
#line 199 "mybison.y" /* yacc.c:1646  */
    {printf("\t\t\t\"text\"");}
#line 1792 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 64:
#line 199 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1798 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 65:
#line 199 "mybison.y" /* yacc.c:1646  */
    {printf("%s",(yyvsp[0].string));}
#line 1804 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 66:
#line 199 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1810 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 67:
#line 200 "mybison.y" /* yacc.c:1646  */
    {printf("\t\t\t\"indices\"");}
#line 1816 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 68:
#line 200 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1822 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 69:
#line 200 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t\t\t}");}
#line 1828 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 70:
#line 202 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t\t\"text\""); elem_counter=11;}
#line 1834 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 71:
#line 202 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1840 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 72:
#line 202 "mybison.y" /* yacc.c:1646  */
    {int x=strlen((yyvsp[0].string));
                                                                                char p1[x];
                                                                                char *tmp=(yyvsp[0].string);
                                                                                strcpy(p1,tmp);
                                                                                char p2[x];
                                                                                checkRTtext(p1,p2);
                                                                                char *fml=&p2[0];
                                                                                if(strcmp(cData,p2)==0){printf("%s,\n\t",(yyvsp[0].string));} else{printf("error,");}
                                                                                }
#line 1854 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 73:
#line 212 "mybison.y" /* yacc.c:1646  */
    {elem_counter=3; printf("\t\"id\"");}
#line 1860 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 74:
#line 212 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1866 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 75:
#line 213 "mybison.y" /* yacc.c:1646  */
    {elem_counter=4; printf("\t\"name\"");}
#line 1872 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 76:
#line 213 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1878 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 77:
#line 214 "mybison.y" /* yacc.c:1646  */
    {elem_counter=5; printf("\t\"screen_name\"");}
#line 1884 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 78:
#line 214 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1890 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 79:
#line 215 "mybison.y" /* yacc.c:1646  */
    {elem_counter=6; printf("\t\"location\"");}
#line 1896 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 80:
#line 215 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1902 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 81:
#line 216 "mybison.y" /* yacc.c:1646  */
    {elem_counter=7; printf("\t\"url\"");}
#line 1908 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 82:
#line 216 "mybison.y" /* yacc.c:1646  */
    {printf(",\n\t");}
#line 1914 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 83:
#line 217 "mybison.y" /* yacc.c:1646  */
    {elem_counter=8; printf("\t\"description\"");}
#line 1920 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 84:
#line 217 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t }");}
#line 1926 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 85:
#line 218 "mybison.y" /* yacc.c:1646  */
    {elem_counter=10; printf("\t\t\"screen_name\"");}
#line 1932 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 86:
#line 218 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1938 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 87:
#line 218 "mybison.y" /* yacc.c:1646  */
    {printf("%s",(yyvsp[0].string));}
#line 1944 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 88:
#line 218 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t\t }");}
#line 1950 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 89:
#line 218 "mybison.y" /* yacc.c:1646  */
    {printf("\n\t }");}
#line 1956 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 90:
#line 220 "mybison.y" /* yacc.c:1646  */
    {printf(":");}
#line 1962 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 91:
#line 220 "mybison.y" /* yacc.c:1646  */
    {if(elem_counter==3){
                                    if(data_type==1 && positive==1)
				       {
                                    if(checkIDmet==0){initArray(&IDunique, 1); checkIDmet++;}
				    if(uniqueNumber(IDunique,input1)==111) 
				    {printf("%ld",input1);
                                    } 
				    else{ printf("An error occurred!");}
				       }}
                  else{
                                 if(elem_counter==9){
				    if(strcmp(txt_in,input)==0){
				      printf("%s",input);
				    }
                                   else{
                                       printf("Another error occurred!");
                                       exit(1);
                                    }

                                  }
                                else if(elem_counter==4){
                                  length=strlen(input) + 1;
                                  printf("%s",input);
                                  cData = (char*)malloc(length * sizeof(char));                                 
                                  strncpy(cData,&input[1],length-3);
                                 
                                    }
                                else if(elem_counter==16){
                                   if(check_text(elem_counter,input)==1 && data_type==0){
                                    printf("%s",input); }

                                 }
                                
                                  else{if(data_type==0){
		                         printf("%s",input);
		                       }
		                       else{
		                         printf("Error!Unexpected data type");
		                         exit(1);
                                       }
			         }



                  }
                  }
#line 2013 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 92:
#line 267 "mybison.y" /* yacc.c:1646  */
    {printf("[");}
#line 2019 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 93:
#line 267 "mybison.y" /* yacc.c:1646  */
    {printf("]");}
#line 2025 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 94:
#line 269 "mybison.y" /* yacc.c:1646  */
    {printf("%s",input); q=0; if(checkmet==0){initArray(&mArray, 1); checkmet++;} insertArray(&mArray,input1); q++;}
#line 2031 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 95:
#line 270 "mybison.y" /* yacc.c:1646  */
    {printf(",");}
#line 2037 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 96:
#line 270 "mybison.y" /* yacc.c:1646  */
    {if(elem_counter==17){
	                                    if(checkmet==0){initArray(&mArray, 1); checkmet++;} 
										insertArray(&mArray,input1);
										last_element=mArray.array[q];										
										q++;
                                                                                printf("%ld",input1);	
                                                        }                                      
								   else{
									   printf("%ld",input1);
									   }}
#line 2052 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 97:
#line 281 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)=(yyvsp[0].string); data_type=10; strcpy(input,(yyvsp[0].string));}
#line 2058 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 98:
#line 282 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)=(yyvsp[0].string); data_type=30; strncpy(in3, (yyvsp[0].string)+1, strlen((yyvsp[0].string))-1); input2=strtol(in3,NULL,10); strcpy(input,(yyvsp[0].string));}
#line 2064 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 99:
#line 283 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)=(yyvsp[0].string); data_type=0; strcpy(input,(yyvsp[0].string));}
#line 2070 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 100:
#line 284 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)=(yyvsp[0].string); input1=strtol((yyvsp[0].string),NULL,10); data_type=1; if(input1>0){positive=1;}else{positive=0;}strcpy(input,(yyvsp[0].string));}
#line 2076 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 101:
#line 285 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)=(yyvsp[0].string); data_type=2; strcpy(input,(yyvsp[0].string));}
#line 2082 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 102:
#line 286 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)="false"; data_type=3; strcpy(input,(yyvsp[0].string));}
#line 2088 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 103:
#line 287 "mybison.y" /* yacc.c:1646  */
    {(yyval.string)="null"; strcpy(input,(yyvsp[0].string));}
#line 2094 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 104:
#line 290 "mybison.y" /* yacc.c:1646  */
    {;}
#line 2100 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 105:
#line 291 "mybison.y" /* yacc.c:1646  */
    {;}
#line 2106 "mybison.tab.c" /* yacc.c:1646  */
    break;

  case 106:
#line 292 "mybison.y" /* yacc.c:1646  */
    {}
#line 2112 "mybison.tab.c" /* yacc.c:1646  */
    break;


#line 2116 "mybison.tab.c" /* yacc.c:1646  */
      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */

  yyn = yyr1[yyn];

  yystate = yypgoto[yyn - YYNTOKENS] + *yyssp;
  if (0 <= yystate && yystate <= YYLAST && yycheck[yystate] == *yyssp)
    yystate = yytable[yystate];
  else
    yystate = yydefgoto[yyn - YYNTOKENS];

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = (char *) YYSTACK_ALLOC (yymsg_alloc);
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= YYEOF)
        {
          /* Return failure if at end of input.  */
          if (yychar == YYEOF)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:

  /* Pacify compilers like GCC when the user code never invokes
     YYERROR and the label yyerrorlab therefore never appears in user
     code.  */
  if (/*CONSTCOND*/ 0)
     goto yyerrorlab;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYTERROR;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  yystos[yystate], yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;

/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;

#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif

yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  yystos[*yyssp], yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  return yyresult;
}
#line 297 "mybison.y" /* yacc.c:1906  */


int check_time(int hour,int min,int sec){
  if(0<=hour<24 && 0<=min<=59 && 0<=sec<=59){
       return 1;
  }
  else{
        return 15;
  }

}
int check_text(int counter,char *in){
int i;
if(counter==0){
   if(strlen(in)>140)
   {
   return 15;
   }
   else{
	   return 1;
   }
}
else if(counter==16){
 if(strlen(in)>260)
   {
   return 15;
   }
   else
   {
    return 1;
   }
}
}

void initArray(Array *pinakas, size_t initialSize) {
  pinakas->array = (long *)malloc(initialSize * sizeof(long));
  pinakas->spaceUsed = 0;
  pinakas->arraySize = initialSize;
}

void insertArray(Array *pinakas, long element) { 
  if (pinakas->spaceUsed == pinakas->arraySize) {
    pinakas->arraySize =pinakas->arraySize+1;//increase size by one
    pinakas->array = (long *)realloc(pinakas->array, pinakas->arraySize * sizeof(long));
  }
  pinakas->array[pinakas->spaceUsed++] = element;
}

void freeArray(Array *pinakas) {
  free(pinakas->array);
  pinakas->array = NULL;
  pinakas->spaceUsed = pinakas->arraySize = 0;
}

void checkRTtext(char p22[],char p11[]){
int a,c;
int d=0;
int e=1;
int i=0, k=0;
int f=0;
int g=0;
int j=0;

while (*(p22+i)!='\0'){
if(*(p22+i)=='@'){a=i; if(f==0){g=a; f=1;}}
i++;}

while (*(p22+k)!='\0'){
if(*(p22+k)==':'){if(k>g && d==0){c=k-1; d=1;}}
k++;}

for(j=0; j<(c-g+1); j++){
   if(j==(c-g)){
    *(p11+j)='\0';
   e++;
  }
  else{ *(p11+j)=*(p22+(g+e)); 
    e++;
  }
}
}
int uniqueNumber(Array arrayName,long inputNumber){
     int checkUnique=0;
     int keli = 0;
      
        for (keli = 0; keli <=arrayName.arraySize; keli++)
         {
           
	   if(arrayName.array[keli]==inputNumber)
	    {
               checkUnique=1;
             }
           }
        if(checkUnique==0)
        {
          insertArray(&arrayName, inputNumber);
          j++; 
          return 111;
        }
       else{ return 666;}
}


int main(int argc, char **argv)

{
  

   yyin = fopen("input_1.txt", "r");

   printf("\n");

   do{

   yyparse();
   

   }while (!feof(yyin));
   
   printf("\n");
 
  freeArray(&mArray);
   freeArray(&IDunique);
  freeArray(&ID_STRunique);
    return 0;

}



void yyerror(const char *s) {

  printf("EEK, parse error! On Line %d  Message: %s", line_num,s );  

  exit(1);

}
