from time import time
import Helper
import Prim

maxN = 65536
n = 256
while(n < 65536):
    matrix = Helper.triangularMatrixRandomIntegers(n,1,999)
    t1 = time()
    Prim.prim2(matrix)
    t2 = time()
    print(f"Size: {n} - Time: {(t2-t1)*1000}")
    n *= 2
