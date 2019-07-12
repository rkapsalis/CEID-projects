from sklearn.metrics.pairwise import cosine_similarity
from sklearn.feature_extraction.text import CountVectorizer
import pandas as pd
from nltk.corpus import stopwords
import numpy as np
import scipy.special
import sys

#stopWords = stopwords.words('english') #έγιναν πειράματα και με την αφαίρεση των stopwords τα οποία έδιναν στις περισσότερες
                                        # περιπτώσεις μικρότερα ποσοστά ομοιότητας, βρίσκεται σε σχόλιο καθώς δεν ζητείται απο την εκφώνηση
print("Please give the number of documents: ")  #ο χρήστης καλείται να δώσει τον αριθμό των αρχείων
n=int(input())
arr=[]

for i in range(n):  #τα περιεχόμενα των αρχείων τοποθετούνται σε έναν πίνακα
       print("Please give the exact filepath: ")  #ο χρήστης καλείται να δώσει τα ακριβή filepath των αρχείων
       file = input()
       file_object=open(file, "r", encoding="utf-8")
       arr.append(file_object.read().splitlines())
       arr[i] = ",".join(arr[i])
count_vectorizer = CountVectorizer() #με χρήση του countVectorizer φτιάχνουμε ένα μητρώο το οποίο περιέχει ,για κάθε κείμενο
                                     # που έχει δοθεί τα διανύσματα όρων-δηλαδή τον πίνακα με τις λέξεις όπως και στην εκφώνηση
count_matrix_train = count_vectorizer.fit_transform(arr)
doc_term_matrix = count_matrix_train.todense()
doc_names = []
for j in range (n):
   doc_names.append("doc%d" % (j+1))
simil = cosine_similarity(count_matrix_train, count_matrix_train) #υπολογίζουμε την ομοιότητα συνημιτόνου. δίνοντας ως όρισμα το μητρώο των όρων
                                                                  # που έχουμε δημιουργήσει,υπολογίζεται η ομοιότητα συνημιτόνου για κάθε ζευγάρι

df1 = pd.DataFrame(simil, columns=doc_names, index=doc_names) #δημιουργούμε έναν πίνακα στον οποίο τοποθετούμε τις τιμές ομοιότητας,
                                                              # βάζοντας ως ονόματα στηλών και γραμμών τα ονόματα των αρχείων (doc1,doc2,..,docn)

print("cosine similarity table")
print(df1)
simil[np.diag_indices_from(simil)] = 0.0  #μηδεν τα στοιχεια της διαγωνίου, δηλαδή οι ομοιότητες των κειμένων με τον εαυτό τους
df2 = pd.DataFrame(simil, columns=doc_names, index=doc_names)
print("Please give the k for the top-k most similar documents: ")
k = int(input())
while(scipy.special.binom(n, 2)<=k):   #γίνεται έλεγχος  για το αν το k είναι < (Ν¦2)
    print("k is too big. Do you want to try again? Press y for yes and n for no")
    str=input()
    if (str=="n"):
        sys.exit(0)
    else:
        print("Please give the k for the top-k most similar documents: ")
        k = int(input())
simil[np.tril_indices_from(simil,-1)] = 0  #θέτουμε 0 όσα στοιχεία είναι κάτω από την διαγώνιο καθώς το μητρώο είναι
                                           # συμμετρικό και θέλουμε να πάρουμε ζευγάρια κειμένων μόνο μια φορά (πχ το doc1 με το doc2,
                                           # προφανώς έχει ίδια τιμή με το doc2 με το doc1, οπότε κρατάω μόνο την μια τιμή
indices = (-simil).argpartition(k, axis=None)[:k]  #υπολογίζονται οι k μεγαλύτερες τιμές ομοιότητας
m,g = np.unravel_index(indices, simil.shape)       #αποθηκεύονται οι θέσεις στις οποίες βρίσκονται
print("Top%d" %(k), "most similar documents are: ")
for p in range(len(m)):
     print("Doc%d" %(m[p] + 1), "with Doc%d" %(g[p] + 1))      #εκτυπώνονται τα top-k most similar documents
