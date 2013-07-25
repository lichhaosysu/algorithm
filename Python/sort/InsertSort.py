# -*- coding: utf-8 -*-
def insertSort(array):
    j = 0
    tmp = 0
    for i in range(1, len(array)):
        j = i - 1
        tmp = array[i]
        while j >= 0 and tmp < array[j]:
            array[j + 1] = array[j]
            j = j - 1
        array[j + 1] = tmp
        
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：", array
insertSort(array)
print "排序后的数组是：", array        
