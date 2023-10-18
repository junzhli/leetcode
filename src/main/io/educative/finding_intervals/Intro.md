Introduction

Interval problems typically involve a list of intervals, each represented by a start and end time/position. The goals are typically detecting or merging overlapping intervals.

These questions are often asked by FANNG. They are quite simple to explain but tricky to get right. The most important concept is how to find the overlap of two intervals.
Fundamental concepts
1. Determine if there’s an overlap between two intervals:

First let’s think in the opposite direction, how would the intervals look like if they do NOT overlap?

End time of the first interval has to be earlier than the start time of the second interval.


|-----|  
x1    x2

|-----|  
y1    y2

i.e. x2 < y1 or y2 < x1

So the overlapping condition is the opposite

Not (x2 < y1 or y2 < x1)



2. Finding the overlap

The key formula here is the overlap of two interval is given by [max(x1, y1), min(x2, y2)].

Note that we can also answer question query #1 by comparing max(x1, y1) <= min(x2, y2).

As we will see in the examples, solving an interval problem becomes much easier if we can find the overlap.


3. Sort by start time

It’s very common to sort the intervals by start time as pre-processing for interval problems. We will see this in Merge Intervals.
Problems:

    Merge Intervals
    Insert Interval

Footnote:

For formula #1, If we want to go one-step further, we can reduce it by DeMorgan’s Law (Not (A or B) == Not A and Not B). This is equivalent to Not (x2 < y1) and Not (y2 < x1) which is equivalent to x2 >= y1 and y2 >= x1.



Does my problem match this pattern?

    Yes, if both of these conditions are fulfilled:
        The input data is an array of intervals.
        The problem requires dealing with overlapping intervals, either to find their intersection, their union, or the gaps between them. This may be required as the final goal, or as an intermediate step in the computation of intervals.
    No, if either of these conditions is fulfilled:
        The order of the intervals in the result is not significant.
        The input list of intervals is not sorted. In such a situation, we would prefer to use some other technique to efficiently solve the problem.

Real-world problems

Many problems in the real world use the merge intervals pattern. Let’s look at some examples.

    Display busy schedule: Display the busy hours of a user to other users without revealing the individual meeting slots in a calendar.

    Schedule a new meeting: Add a new meeting to the tentative meeting schedule of a user in such a way that no two meetings overlap each other.

    Task scheduling in operating systems (OS): Schedule tasks for the OS based on task priority and the free slots in the machine’s processing schedule.

