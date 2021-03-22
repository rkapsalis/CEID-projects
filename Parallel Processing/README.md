# Parallel implementation of Ramer–Douglas–Peucker algorithm
A serial implementation of the Ramer – Douglas – Peucker algorithm written in C++ is given. Our goal was to create a set of parallel implementations of the algorithm and compare them in terms of their performance.
1) Static assignment of workload to for loop (**static.cpp**)

    You are prompted to parallel the Ramer–Douglas–Peucker algorithm to the multiple polygrams contained in the AllPolylines list that need to be processed. Take for example a case in which the AllPolylines list contains 100 polygons and that 4 threads have been created in the program you will implement. The first parallelism logic you should follow is for each thread to take on a static assignment simplification for 100/4 = 25 consecutive polygons in the AllPolylines list. Each thread will then run the Ramer–Douglas–Peucker algorithm serially for each polyline it has processed.
  - What OpenMP instructions should you use to implement this approach?
  - Timer the execution time of each thread separately. What do you notice about these times?
2) Dynamic assignment of workload in a for loop for (**dynamic.cpp**)

   Follow the same logic as the previous question, but this time the parallelism you need to follow is for each thread to take on a dynamic assignment way to simplify a set of polygons. Each thread will then run the Ramer–Douglas–Peucker algorithm serially for each polyline it has processed.
  - What OpenMP instructions should you use to implement this approach?
  - Which parameters of these instructions should be determined experimentally in order to give the best possible execution time of the application?
  - Timer the execution time of each thread separately. What do you notice about these times and compared to the first question?
 
3) Parallelization using tasks (**task1.cpp**)

   When the longest distance of a point from the line defined by the first and last point of the polyline is greater than a certain value, then two new, smaller polylines are created and the algorithm is repeated retrospectively, for each of the new polylines.
Implement a parallel version of the algorithm so that when a polyline is split into two smaller ones, a new task will be created for the first one, while the second one will be processed by the current task.
- What OpenMP instructions should you use to implement this approach?<br />
You should pay close attention to creating the list that stores the simplified polyline.

4) Parallelization using tasks (**task2.cpp**)

   Implement a parallel version of the algorithm so that when a polyline is split into two smaller ones, a new task will be created for both new polygons.
- What OpenMP instructions should you use to implement this approach?
- What do you notice about the execution time of the application, especially in relation to the previous approaches? What is the cause of this phenomenon? How do you think it can be improved?<br />
You should pay close attention to creating the list that will store the simplified polyline. 
## Authors
* Stylianos Vazaios
* Romanos Kapsalis
* Panagiotis Stavropoulos
* Zisis-Stylianos Tramparis
