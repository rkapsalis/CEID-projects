#!/bin/bash
if [[ $# -eq 0 ]] ; then    # αν εκτελειται χωρις καμια παράμετρο εκτυπώνει τα ΑΜ μας, οπως ζητειται
  echo "1056289-1054284"
  exit 0
fi

countn=0             #αρχικοποίηση μεταβλητών οι οποιες μας βοηθούν να διαχωρίσουμε τις περιπτώσεις όπου ο αριθμός των arguments είναι ιδιος
countl=0
countA=0
countB=0
counts=0
counte=0
number=$#
for ARGS in "$@"; do  #η getopts που χρησιμοποιούμε παρακάτω δεν υποστηρίζει long options οπότε τα βαφτιζουμε short
shift
        case "$ARGS" in
                "--socialmedia") set -- "$@" "-s" ;;
                "--born-since") set -- "$@" "-b" ;;
                "--born-until") set -- "$@" "-u" ;;
                "--firstnames") set -- "$@" "-n" ;;
                "--lastnames") set -- "$@" "-l" ;;
                "--edit") set -- "$@" "-e"  ;;
                "-id") set -- "$@" "-i" ;;
                *) set -- "$@" "$ARGS"
                
        esac
done
#shift $(($OPTIND+3))

while getopts 'b:u:f:i:nlse' flag; do                                       #επανάληψη η οποία εξετάζει ποια arguments δινει ο χρηστης και εκτελει τις αναλογες ενεργειες, με χρηση της getopts 
        case "${flag}" in
                 f) FILE=${OPTARG}                
                     ;;
                 e)if [[ "$1" -eq "-e" ]] && [[ "$5" -eq "-f" ]]; then      #για να μπορουν οι παραμετροι να δινονται με οποιαδηποτε σειρα,αυτη ειναι η περιπτωση που πρωτα δινεται το edit
                   first=$2                                                 #η getopts δεν υποστηρίζει πανω απο 1 παράμετρο για ένα options, οπότε τοποθετούμε τις παραμετρους σε 3 μετβλητες
                   second=$3
                   third=$4
                   shift $(($OPTIND+1))                                     #κανουμε shift για να μπορουμε μετα να παρουμε το αρχειο
                   counte=$((counte + 1))                                   #η αυξηση του count,οπως και των υπολοιπων παρακατω,εξηγειται στις if's παρακατω οπου και χρησιμοποιουνται
                   fi                  
                   ;;
                b) dateA=${OPTARG}                             
                   countA=$((countA + 1))
                    ;;
                u) dateB=${OPTARG}
                   countB=$((countB + 1))
                    ;;
                i) ID=${OPTARG} ;;
                n) countn=$((countn + 1)) ;;
                l) countl=$((countl + 1)) ;;
                s) counts=$((counts + 1)) ;;
                
                  
        esac
done
if [[ counte -eq 0 ]]; then        #αν συναντησει πρωτα τo file έχει πάρει το path του αρχειου απο την επαναληψη πάνω ωστόσο, δεν ηταν εφικτο το διαβασμα των παραμετρων της edit μεσα στην επανάληψη
shift $(($OPTIND-1))               #το shift χρησιμεύει ωστε να παρει τις παραμέτρους που μας ενδιαφέρουν
first=$1
second=$2
third=$3
fi
#στις if εκτελειται η ενέργεια που ζητειται καθε φορα, αναλογα με τα arguments που εχουν δωθει, για να ξεχωρισουμε τις περιπτωσεις οπου έχουμε ιδιο αριθμο arguments αλλα
#εκτελειται διαφορετικη ενέργεια, χρησιμοποιοιούμε τις μεταβλητές count οι οποίες ειναι ισες με 1 οταν η επανάληψη που εκτελειται πιο πανω συναντησει το συγκεκριμενο option
if [[ "$number" -eq 6 ]] && [[ "$countB" -eq 1 ]]; then     #για παραδειγμα το countB εδω χρησιμευει για να καταλαβουμε ποτε δίνεται το η εντολη με το born-until και born-since και ποτε η εντολη με το edit
  awk -F"|" -v a="$dateA" -v b="$dateB" '  ($5>a && $5<b) { print } ' $FILE   #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη με options born-since και born-until
  exit 1
elif [[ "$number" -eq 6 ]] && [[ "$countB" -eq 0 ]]; then
  awk -F"|" -v x="$first" -v y="$second" -v z="$third" 'BEGIN {OFS="|"} /^[^#]/ { $y = ($1 == x ? z : $y) } 1' $FILE   #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη με option edit
  #echo "$FILE $first $second $third"
  exit 1
elif [[ "$number" -eq 4 ]]; then
  if [[ "$countA" -eq 1 ]]; then
   awk -F"|" -v a="$dateA" ' ($5>a) { print } ' $FILE     #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη με μονο option το born-since, και το f φυσικα
   exit 1
  elif [[ "$countB" -eq 1 ]]; then
   awk -F"|" -v b="$dateB" '  ($5<b) { print } ' $FILE     #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη με μονο option το born-until, και το f φυσικα
   exit 1
  else
   awk -F"|" -v d="$ID" '/^[^#]/  $1 ~ d { print $2, $3, $5 }' $FILE     #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη που περιεχει το option id
   exit 1
  fi
elif [[ "$number" -eq 3 ]] && [[ "$countn" -eq 1 ]]; then
  awk -F"|" ' !x[$3]++ { print $3 }' $FILE | sort                        #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη που περιεχει το option firstnames
  exit 1
elif [[ "$number" -eq 3 ]] && [[ "$countl" -ne 0 ]]; then
  awk -F"|" ' !x[$2]++ { print $2 }' $FILE | sort                        #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη που περιεχει το option lastnames
  exit 1
elif [[ "$number" -eq 3 ]] && [[ "$counts" -ne 0 ]]; then
awk -F"|" '/^[^#]/ {print $9} ' $FILE | sort | uniq -c | sort -nr        #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη που περιεχει το option socialmedia
 exit 1
else 
awk -F"|" '/^[^#]/ { print }' $FILE                                      #εκτελεση της ζητουμενης λειτουργιας οταν δινεται η εντολη που περιεχει μονο το option f
exit 1
fi
