# QueueProcessing

This project simulates the operating system’s selection of processes to send to the CPU. The operating system will select the next process from the of awaiting processes. Each process will require 1 or more the resources A, B and C. Some processes will require only B for example, while another might require A and B, yet another B and C. If the resource is available, the process can be started. If one or more of the resources are unavailable, then the process must wait one cycle. A process that is started will only use a resource for one cycle. A process can only start if all the previous processes have been started.  Here is a chart describing a possible scenario:
Starting process list with resources in ( ):  P1(A);P2(B); P3(B,C);P4(C);P5(A,B,C); P6(B,C) ;P7(A);P8(A);P9(B);P10(C) 

Total number of cycles needed: 6

Part A :  Read a one line from the Input file where the  line  has the format shown here: 
P1(A);P2(B); P3(B,C);P4(C);P5(A,B,C); P6(B,C) ;P7(A);P8(A);P9(B);P10(C)

Randomly generate a list of 20 processes. Start executing processes as before. Randomly select 1,2 or 3 resources (A,B,C) for each process. But at the end of each cycle (regardless of how many processes were run), add 2 more process to the end of the list with 1,2,3 random resources. Output the number of cycles needed to empty the list of processes, but if the list does not empty by cycle 1000, then output the number of processes left (length of the list). Output the length of the list of processes every 100th cycle to watch its growth:

Length of processes at cycle 100: 104
Length of processes at cycle 200: 107
Length of processes at cycle 300: 63
Length of processes at cycle 400: 139
