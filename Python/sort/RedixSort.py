# -*- coding: utf-8 -*-
import math

def radixSort(array):
    m = max(array)
        
    time = 0
    while m > 0:
        m /= 10
        time = time + 1
        
    queue = [ [] for i in range(10)]
    
    for i in range(time):
        for j in range(len(array)):
            x = array[j] % int(math.pow(10, i + 1)) / int(math.pow(10, i))
            queue[x].append(array[j])
        count = 0
        for k in range(10):
            while len(queue[k]) > 0:
                array[count] = queue[k][0]
                del queue[k][0]
                count = count + 1
                
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：", array
radixSort(array)
print "排序后的数组是：", array
