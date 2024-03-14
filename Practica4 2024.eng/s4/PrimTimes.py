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
import Prim
from time import time


def main():
    pass

if __name__ == '__main__':
    n = 256

    for casos in range(7):
        t1 = time()
        graph = Helper.triangularMatrixRandomIntegers(n,100,999)
        complete_graph = Prim.complete_graph_from_triangular(graph)
        mst = Prim.prim_algorithm_optimized(complete_graph)
        #Prim.print_mst(mst)
        t2 = time()
        print("n =", n, "***", "time =", int(1000*(t2-t1)), "milliseconds)")
        #print(primes)
        n = n*2
