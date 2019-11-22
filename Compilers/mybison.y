%{
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
%}

%debug

%error-verbose

%union 

{

        int integer;

        char *string;
        long long1;
	    float fp;

}


%token <string> TRUE1 FALSE1 null
%token COMMA
%token COLON
%token CURLY_BRACKET_L CURLY_BRACKET_R L_SQUARE_BRACKET R_SQUARE_BRACKET
%token TEXT
%token <string> DBL_QUOTE
%token <string> NUMBER
%token <string> STRING
%token USER 
%token CREATED_AT
%token ID_STR
%token ENTITIES
%token HASHTAGS
%token EXTENDED
%token FULL
%token INDICES
%token URL
%token ID
%token SCREEN_NAME
%token NAME
%token LOCATION
%token TRUNCATED
%token DISPLAY
%token DESCRIPTION
%token USER_MENTIONS
%token <string> CREATED_BODY
%token <string> DAY
%token <string> MONTH
%token <integer> YEAR
%token <string> ID_BODY
%token <string> TWEET
%token <string> RETWEETED_STATUS
%token <string> RT_BODY
%token <integer> DATE
%token <string> SPACE
%type <string> nested_object
%type <string> elem_names

%%

json: object
|json COMMA {printf(",\n");} object
;

object: CURLY_BRACKET_L CURLY_BRACKET_R {

    printf("{}");

  }
|CURLY_BRACKET_L {printf("{\n");} elements CURLY_BRACKET_R {printf("\n}");}
;


elements:elem_names COLON {printf(":");} data{if(data_type==10){

                                                                  printf("%s",input);}
								else{
                                                                    printf("Error!");

								}								

								}
|elements COMMA {printf(",\n");} elem_names{} COLON {printf(":");} data{if(elem_counter==0){
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

|elements COMMA {printf(",\n");} nested_object 
;

elem_names:TEXT{elem_counter=0;printf("\t\"text\"");} 
|CREATED_AT {elem_counter=16;printf("\t\"created_at\"");}
|ID_STR{elem_counter=2;printf("\t\"id_str\"");}
|DISPLAY{printf("\t\"display_text_range\"");elem_counter=17;}
|TRUNCATED{elem_counter=12;printf("\t\"truncated\"");}; 

nested_object: usr{}
|twt{};
|retweeted{}
|ext_tweet{}
;

usr: USER{printf("\t\"user\"");} COLON {printf(":");} CURLY_BRACKET_L{printf("{\n\t");} data_u;

retweeted: RETWEETED_STATUS {printf("\t\"retweeted_status\"");} COLON {printf(":");} CURLY_BRACKET_L{printf("{\n\t");} data_retweeted{};

data_retweeted: TEXT{printf("\t\"text\""); elem_counter=9;} noe COMMA{printf(",\n\t");} usr

twt: TWEET{printf("\t\"tweet\"");} COLON {printf(":");} CURLY_BRACKET_L{printf("{");} data_t usr

ext_tweet: EXTENDED{printf("\t\"extended_tweet\"");} COLON {printf(":");} CURLY_BRACKET_L{printf("{\n\t");} data_ext CURLY_BRACKET_R {printf("\n\t}");}

data_ext: FULL{printf("\t\"full_text\""); elem_counter=16;} noe COMMA {printf(",\n\t");}
DISPLAY {printf("\t\"display_text_range\"");elem_counter=15;} COLON {printf(":");} array COMMA{printf(",\n\t");} hash_rule

hash_rule: CURLY_BRACKET_R {printf("}");}
|ENTITIES{printf("\t\"entities\"");} COLON {printf(":");} CURLY_BRACKET_L{printf("{\n\t");} hash_array CURLY_BRACKET_R {printf("\n\t     }");}    

hash_array: HASHTAGS{printf("\t\t\"hashtags\"");} COLON {printf(":");} L_SQUARE_BRACKET{printf("[");} hash_body R_SQUARE_BRACKET {printf("]");};

hash_body: hash_object
|hash_body COMMA {printf(",");} hash_object

hash_object: CURLY_BRACKET_L{printf("{\n\t");} TEXT{printf("\t\t\t\"text\"");} COLON {printf(":");} STRING{printf("%s",$7);} COMMA {printf(",\n\t");}
INDICES{printf("\t\t\t\"indices\"");} COLON {printf(":");} array CURLY_BRACKET_R {printf("\n\t\t\t}");}

data_t: TEXT{printf("\n\t\t\"text\""); elem_counter=11;} COLON {printf(":");} RT_BODY{int x=strlen($5);
                                                                                char p1[x];
                                                                                char *tmp=$5;
                                                                                strcpy(p1,tmp);
                                                                                char p2[x];
                                                                                checkRTtext(p1,p2);
                                                                                char *fml=&p2[0];
                                                                                if(strcmp(cData,p2)==0){printf("%s,\n\t",$5);} else{printf("error,");}
                                                                                };

data_u: ID {elem_counter=3; printf("\t\"id\"");} noe COMMA {printf(",\n\t");}
NAME {elem_counter=4; printf("\t\"name\"");} noe COMMA {printf(",\n\t");}
SCREEN_NAME {elem_counter=5; printf("\t\"screen_name\"");} noe COMMA {printf(",\n\t");}
LOCATION {elem_counter=6; printf("\t\"location\"");} noe COMMA {printf(",\n\t");}
URL {elem_counter=7; printf("\t\"url\"");} noe COMMA {printf(",\n\t");}
DESCRIPTION {elem_counter=8; printf("\t\"description\"");} noe CURLY_BRACKET_R {printf("\n\t }");}
|SCREEN_NAME {elem_counter=10; printf("\t\t\"screen_name\"");} COLON {printf(":");} STRING {printf("%s",$5);} CURLY_BRACKET_R {printf("\n\t\t }");} CURLY_BRACKET_R {printf("\n\t }");};

noe: COLON{printf(":");} value {if(elem_counter==3){
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

array: L_SQUARE_BRACKET{printf("[");} members R_SQUARE_BRACKET {printf("]");};

members: data {printf("%s",input); q=0; if(checkmet==0){initArray(&mArray, 1); checkmet++;} insertArray(&mArray,input1); q++;}
|members COMMA {printf(",");} data{if(elem_counter==17){
	                                    if(checkmet==0){initArray(&mArray, 1); checkmet++;} 
										insertArray(&mArray,input1);
										last_element=mArray.array[q];										
										q++;
                                                                                printf("%ld",input1);	
                                                        }                                      
								   else{
									   printf("%ld",input1);
									   }};
                           
value: CREATED_BODY{$<string>$=$1; data_type=10; strcpy(input,$<string>1);} 
|ID_BODY{$<string>$=$1; data_type=30; strncpy(in3, $1+1, strlen($1)-1); input2=strtol(in3,NULL,10); strcpy(input,$<string>1);}
|STRING {$<string>$=$1; data_type=0; strcpy(input,$<string>1);}
|NUMBER {$<string>$=$1; input1=strtol($1,NULL,10); data_type=1; if(input1>0){positive=1;}else{positive=0;}strcpy(input,$<string>1);}
|TRUE1 {$<string>$=$1; data_type=2; strcpy(input,$<string>1);}
|FALSE1 {$<string>$="false"; data_type=3; strcpy(input,$<string>1);}
|null {$<string>$="null"; strcpy(input,$<string>1);}
;

data: object {;}
| array {;}
| value {}
;



%%

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
