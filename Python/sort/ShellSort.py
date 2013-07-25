# -*- coding: utf-8 -*-
def shellSort(array):
    j = 0
    tmp = 0
    gap = len(array) / 2
    
    while gap > 0:
        for i in range(gap, len(array)):
            tmp = array[i]
            j = i - gap
            while j >= 0 and tmp < array[j]:
                array[j + gap] = array[j]
                j = j - gap
            array[j + gap] = tmp
        gap = gap / 2
        
array = [49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12,
        64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51]

print "排序前的数组是：", array
shellSort(array)
print "排序后的数组是：", array      