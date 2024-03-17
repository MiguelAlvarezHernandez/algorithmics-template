#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      uo295368
#
# Created:     14/03/2024
# Copyright:   (c) uo295368 2024
# Licence:     <your licence>
#-------------------------------------------------------------------------------
import Helper

def complete_graph_from_triangular(m):
    """Convert a triangular matrix to a complete graph representation."""
    n = len(m)
    for i in range(n):
        for j in range(i+1, n):
            m[j][i] = m[i][j]
    return m

#n^3
def prim_algorithm(graph):
    """Implements Prim's algorithm on a given graph represented as a complete matrix."""
    n = len(graph)
    visited_node = [False] * n     #array of booleans to know if the nodes are visited or not
    num_edges = 0                   #counter of the nodes visited
    visited_node[0] = True
    mst_edges = []                  #mst = minimun spanning tree

    while num_edges < n - 1:
        minimum = float('inf')  #maximun
        x = 0                   #origin node
        y = 0                   #destination node
        for i in range(n):
            if visited_node[i]:
                for j in range(n):
                    if not visited_node[j] : #and graph[i][j]   #if it is not visited
                        if minimum > graph[i][j]:    #if the weight is lower change
                            minimum = graph[i][j]
                            x = i
                            y = j
        mst_edges.append((x, y, graph[x][y]))   #add the source and destination nodes and the weight
        visited_node[y] = True      #now the selected node is visited
        num_edges += 1               #increment counter

    return mst_edges


def print_mst(mst):
    """Prints the edges and total cost of the MST."""
    #total_cost = sum([edge[2] for edge in mst])
    #print("Total Cost of MST:", total_cost)
    for edge in mst:
        print(f"Edge from {edge[0]} to {edge[1]} with weight {edge[2]}")

def main(filename):
    graph = Helper.triangularMatrixFromFile(filename)
    complete_graph = complete_graph_from_triangular(graph)
    mst = prim_algorithm(complete_graph)
    print_mst(mst)

if __name__ == "__main__":
    filename = input("Enter the filename: ")
    main(filename)


def prim_algorithm_optimized(graph):
    """Implementación optimizada del algoritmo de Prim con complejidad O(n^2)."""
    n = len(graph)
    visited_node = [False] * n              # array of booleans to know if the nodes are visited or not
    min_weight = [float('inf')] * n     # Array to store the minimun cost to reach a node
    parent = [-1] * n                   # Array to store the source node with the minimun cost to reach the searched node

    min_weight[0] = 0                   # Array to know the costs of the spanning tree

    for _ in range(n):
        # Find the node with the minimun weight to start with
        u = min_weight.index(min(min_weight[i] for i in range(n) if not visited_node[i]))
        visited_node[u] = True              #now the selected node is visited

        # Upload the matrices of information parent and weight
        for v in range(n):
            if 0 < graph[u][v] < min_weight[v] and not visited_node[v]:
                parent[v] = u
                min_weight[v] = graph[u][v]

    # Construct the result with the matrixes of weights and parents and the index which is the destination node
    mst_edges = []
    for i in range(1, n):
        mst_edges.append((parent[i], i, graph[parent[i]][i]))

    return mst_edges