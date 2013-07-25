# -*- coding: utf-8 -*-
def bubbleSort(array):
    tmp = 0
    n = len(array)
    for i in range(n - 1):
        for j in reversed(range(i, n)):
            if array[j] < array[j - 1]:
                tmp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = tmp
                
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：",array
bubbleSort(array)
print "排序后的数组是：",array
