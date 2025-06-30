Problem Description
Given:
An undirected tree with A nodes and A - 1 edges.
Arrays B[] and C[] define the edges: each edge connects B[i] and C[i].
An array D[] where D[i] represents the value of node i + 1.
🎯 Objective
Build the tree structure using an adjacency list.
Perform a Breadth-First Search (BFS) starting from node 1 (root).
Create a level map: group node values (from D[]) based on their level in the tree.
Calculate the maximum depth (height) of the tree.

🪜 Algorithm Steps

✅ Step 1: Build the Tree (Adjacency List)
Initialize a list of lists: List<List<Integer>> tree = new ArrayList<>();
For each edge (B[i], C[i]), add both connections:
tree.get(B[i]).add(C[i]);
tree.get(C[i]).add(B[i]);

✅ Step 2: Initialize BFS
Use a Queue<int[]> to perform BFS from the root:
Each element is [node, level]
Track visited nodes with a boolean[] visited
Initialize a Map<Integer, List<Integer>> levelMap to group node values by level
Set maxDepth = 0

✅ Step 3: Perform BFS Traversal
While the queue is not empty:
Pop node and level from the queue
Add D[node - 1] to levelMap.get(level)
Update maxDepth = Math.max(maxDepth, level)
For each unvisited neighbor:
Mark it visited
Enqueue with level + 1

✅ Step 4: Output
levelMap will contain all node values grouped by level
maxDepth gives the maximum depth (0-indexed) of the tree

📦 Example
Input:
A = 4
B = [1, 1, 2]
C = [2, 3, 4]
D = [10, 20, 30, 40]
Tree:

markdown
Copy
Edit
       1
      / \
     2   3
    /
   4
Level Map:

{
  0: [10],     // Level 0 → Node 1
  1: [20, 30], // Level 1 → Nodes 2, 3
  2: [40]      // Level 2 → Node 4
}
Maximum Depth: 2

🛠️ Time & Space Complexity
Time Complexity: O(A) → Each node and edge is processed once

Space Complexity: O(A) → For adjacency list, level map, and queue
