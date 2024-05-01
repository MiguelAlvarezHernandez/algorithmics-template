import Helper
import math

def prim(fileName):
    weight = Helper.triangularMatrixFromFile(fileName)
    numNodes = len(weight[0])
    U = []
    W = 0
    totalCost= 0
    visited = []
    counter = 0
    fromNode = 0
    for a in range(numNodes):
        visited.append(False)
    while len(U) != numNodes -1:
        U.append(W)
        visited[W] = True
        min = 10000
        for node in U:
            for column in range (len(weight[node])):
                if not(visited[column]):
                    if((weight[node][column] < min and weight[node][column] > 0) or (weight[column][node] < min and weight[column][node] > 0)):
                        min = max(weight[node][column], weight[column][node])
                        fromNode = node
                        W = column 
        
        visited[W] = True
        totalCost += min
        counter+=1
        print(f"ARISTA NUMERO {counter} : DESDE NODO {fromNode} HASTA NODO {W} *** COSTE = {min}")
    print("Total optimum cost = " + str(totalCost))
'''
Does the same but without printing, just for testing purposes
'''
def prim2(matrix):
    weight = matrix
    numNodes = len(weight[0])
    U = []
    W = 0
    costs = ""
    totalCost= 0
    visited = []
    counter = 0
    fromNode = 0
    for a in range(numNodes):
        visited.append(False)
    while len(U) != numNodes -1:
        U.append(W)
        visited[W] = True
        min = 10000
        for node in U:
            for column in range (len(weight[node])):
                if not(visited[column]):
                    if((weight[node][column] < min and weight[node][column] > 0) or (weight[column][node] < min and weight[column][node] > 0)):
                        min = max(weight[node][column], weight[column][node])
                        fromNode = node
                        W = column 
        visited[W] = True
        totalCost += min
        counter+=1
        
prim("graph8.txt")
