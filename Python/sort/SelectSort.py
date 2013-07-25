# -*- coding: utf-8 -*-
def selectSort(array):
    length = len(array)
    for i in range(length - 1):
        k = i
        for j in range(i + 1, length):
            if array[j] < array[k]:
                k = j
        if k != i:
            tmp = array[i]
            array[i] = array[k]
            array[k] = tmp
            
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：", array
selectSort(array)
print "排序后的数组是：", array
