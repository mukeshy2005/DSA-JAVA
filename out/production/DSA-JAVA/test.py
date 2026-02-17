import multiprocessing
import math

def stress():
    n = 10**7
    count = 0
    for i in range(2, n):
        prime = True
        r = int(math.sqrt(i))
        for j in range(2, r+1):
            if i % j == 0:
                prime = False
                break
        if prime:
            count += 1
    return count

if __name__ == "__main__":
    processes = []
    for _ in range(multiprocessing.cpu_count()):
        p = multiprocessing.Process(target=stress)
        processes.append(p)
        p.start()

    for p in processes:
        p.join()
