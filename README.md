# QueueProcessing 

## Project Overview
This project simulates how an operating system selects and manages processes to send to the CPU based on resource availability. The simulation models real-world scheduling constraints, ensuring processes only execute when the required resources are available. Processes are dynamically added and managed, making this a complex and realistic representation of queue processing in an operating system.

## Key Features
1. **Process Management**:
   - Each process is associated with 1, 2, or 3 required resources (A, B, C).
   - Processes execute only if all required resources are available.
   - Processes must execute in the order they appear in the queue.

2. **Resource Constraints**:
   - Resources are assigned to processes for one cycle and are released at the end of the cycle.
   - If a process cannot start due to unavailable resources, it waits until the next cycle.

3. **Dynamic Queue**:
   - The system dynamically adds two new processes at the end of the queue at the end of each cycle.
   - New processes are assigned random resource requirements (A, B, C).

4. **Simulation**:
   - Processes are executed until the queue is empty or the simulation reaches 1,000 cycles.
   - The program tracks and outputs the length of the queue every 100 cycles to analyze growth.

## Objectives
The primary goals of this project are:
- To simulate process scheduling with resource constraints in a queue-based system.
- To understand how dynamic process generation impacts the system's performance.
- To develop a robust simulation that provides meaningful metrics for analysis.

## Implementation Details
1. **Input**:
   - The program reads an input file with a single line representing an initial queue of processes and their required resources.
   - Example input: `P1(A);P2(B);P3(B,C);P4(C);P5(A,B,C);P6(B,C);P7(A);P8(A);P9(B);P10(C)`

2. **Process Execution**:
   - The program simulates process execution in cycles:
     - Each cycle, the system checks if the next process in the queue can be started based on resource availability.
     - If all required resources are available, the process executes and releases the resources at the end of the cycle.
     - If resources are unavailable, the process waits, and other processes in the queue are checked.

3. **Dynamic Queue Growth**:
   - At the end of each cycle, two new processes with random resource requirements (A, B, or C) are added to the queue.

4. **Output**:
   - The total number of cycles needed to empty the queue.
   - If the queue does not empty by cycle 1,000, the program outputs the number of processes left in the queue.
   - The length of the queue is output every 100 cycles to monitor its growth.

5. **Metrics Example**:
   ```
   Length of processes at cycle 100: 104
   Length of processes at cycle 200: 107
   Length of processes at cycle 300: 63
   Length of processes at cycle 400: 139
   ```

6. **Termination**:
   - The simulation terminates either when the queue is empty or after 1,000 cycles, providing a summary of the results.

## Challenges Addressed
- **Resource Allocation**:
  - The program efficiently manages shared resources among competing processes.
- **Queue Management**:
  - The dynamic nature of the queue tests the system's ability to handle continuous growth and execution constraints.
- **Cycle Efficiency**:
  - The simulation optimizes execution by ensuring processes only proceed when resources are available.

## How to Run
1. Provide an input file containing the initial queue of processes in the specified format.
2. Compile and execute the program using a Java IDE or terminal.
3. The program outputs:
   - The total cycles required to empty the queue (if possible).
   - The number of processes remaining if the queue does not empty by cycle 1,000.
   - Queue lengths at 100-cycle intervals.

## Example Results
- Total Cycles: 985
- Queue Empty: Yes
- Metrics:
  ```
  Length of processes at cycle 100: 104
  Length of processes at cycle 200: 107
  Length of processes at cycle 300: 63
  Length of processes at cycle 400: 139
  ```

## Notes
- Processes are represented in a queue, and their required resources are stored as attributes.
- The system ensures fair scheduling, processing requests in the order they arrive.
- Random generation of resources for new processes introduces variability, allowing for dynamic and realistic testing.

This project offers a deep dive into resource-constrained scheduling and queue management, key concepts in operating system design.
